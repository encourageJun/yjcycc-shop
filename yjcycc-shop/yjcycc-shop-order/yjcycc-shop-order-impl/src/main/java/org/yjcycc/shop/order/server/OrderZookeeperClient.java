package org.yjcycc.shop.order.server;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.RetryNTimes;
import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;
import org.yjcycc.shop.common.rmi.OrderRemoteConfig;
import org.yjcycc.shop.common.rmi.RemoteConfig;
import org.yjcycc.shop.common.rmi.UsingIpPort;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/**
 * @author Rosun zk客户端和zk服务器间主要可能存在下面几种异常情况：<br>
 *         1.
 *         短暂失去连接：此时客户端检测到与服务端的连接已经断开，但是服务端维护的客户端session尚未过期，之后客户端和服务端重新建立了连接；
 *         当客户端重新连接后，由于session没有过期，zookeeper能够保证连接恢复后保持正常服务。 <br>
 *         2. 失去连接时间很长：此时服务器相对于客户端的session已经过期了，
 *         与先前session相关的watcher和ephemeral的路径和数据都会消失；当Curator重新创建了与zk的连接后，
 *         会获取到session expired异常，Curator会销毁先前的session，并且会创建一个新的session，需要注意的是，
 *         与之前session相关的watcher和ephemeral类型的路径和数据在新的session中也不会存在，
 *         需要开发者在CuratorFramework.getConnectionStateListenable().addListener()
 *         中添加状态监听事件，对ConnectionState.LOST事件进行监听，当session过期后，使得之前的session状态得以恢复。
 *         对于ephemeral类型，在客户端应该保持数据的状态，以便及时恢复。 <br>
 *         3. 客户端重新启动：不论先前的zk
 *         session是否已经过期，都需要重新创建临时节点、添加数据和watch事件，先前的session也会在稍后的一段时间内过期。 <br>
 *         4. Zk服务器重新启动：由于zk将session信息存放到了硬盘上，因此重启后，先前未过期的session仍然存在，在zk服务器启动后，
 *         客户端与zk服务器创建新的连接，并使用先前的session，与1相同。 <br>
 *         5. 需要注意的是，当session过期了，在session过期期间另外的客户端修改了zk的值，那么这个修改在客户端重新连接到zk上时，
 *         zk客户端不会接收到这个修改的watch事件（尽管添加了watch），如果需要严格的watch逻辑，
 *         就需要在curator的状态监控中添加逻辑。<br>
 * 
 * 
 *
 */
@Component
public class OrderZookeeperClient {
	
	private static Logger logger = Logger.getLogger(OrderZookeeperClient.class);
	
	
	private transient boolean isRun = false; 

	private UsingIpPort usingIpPort = null;

	private CuratorFramework zkTools;
	

	
	/**
	 * 在注册监听器的时候，如果传入此参数，当事件触发时，逻辑由线程池处理
	 */
	private ExecutorService pool = null;
	
	private PathChildrenCache childrenCache ;


	@PreDestroy
	public void stop() {
		try{
			if(this.zkTools != null){
				this.zkTools.close();
			}
		}catch(Exception ex){
			logger.error(ex.getMessage(),ex);
		}
		
		if(pool != null){
			pool.shutdown();
		}
		if(childrenCache != null){
			try {
				childrenCache.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		isRun = false;
	}

	public boolean isRunning() {
		return isRun;
	}

	/**
	 * 创建Zookeeper 客户端  并创建临时树节点
	 * @param usingIpPort
	 * @return
	 */
	public boolean createTreeNode(UsingIpPort usingIpPort) {
		this.usingIpPort = usingIpPort;
		if (this.usingIpPort == null) {
			throw new IllegalStateException("ERROR ! parameter usingIpPort not setted yet!");
		}
		String connString = RemoteConfig.getInstance().getZookeeperConnUrl();
		logger.info("开始链接Zookeeper咯~        usingIpPort="+this.usingIpPort.toString() + ",Zookeeper connString="+connString);
		
		
		final byte[] data = this.usingIpPort.toString().getBytes(RemoteConfig.charset);// 节点值

		//创建客户端
		zkTools = createZookeeperClient(connString);

		zkTools.start();
		logger.info("zkTools.start ok !   zkTools="+ zkTools );
		try {
			Stat exist = zkTools.checkExists().forPath(OrderRemoteConfig.BASE_PATH);
			if(exist == null){
				logger.info("------  第一次构建basepath:" + OrderRemoteConfig.BASE_PATH);
				zkTools.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
				.withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath(OrderRemoteConfig.BASE_PATH);
			}
		
			String dataPath = OrderRemoteConfig.BASE_PATH +"/"+ this.usingIpPort.getIndex();
			// 创建节点路径
			zkTools.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
					.withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath(dataPath);
			
			logger.info("\n\n\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 对树路径节点赋值 start");
			logger.info("%%%%%%%%%    dataPath=" + dataPath + " @namespace="+zkTools.getNamespace());
			logger.info("%%%%%%%%%    data=" + new String(data));
			// 对路径节点赋值
			zkTools.setData().forPath(dataPath, data);
			logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 对树路径节点赋值 end");
		} catch (Exception e) {
			e.printStackTrace();
			isRun = false;
		}
		isRun = true;
		logger.info(" OrderZookeeperClient start >>> " + isRun);
	
		return this.isRun;
	}

	private CuratorFramework createZookeeperClient(String connString) {
		return CuratorFrameworkFactory.builder().connectString(connString)
		.sessionTimeoutMs(5000)
		.connectionTimeoutMs(3000)
		.namespace(RemoteConfig.NAME_SPACE).retryPolicy(new RetryNTimes(5, 1000)).connectionTimeoutMs(30000).build();
	}

	 

}
