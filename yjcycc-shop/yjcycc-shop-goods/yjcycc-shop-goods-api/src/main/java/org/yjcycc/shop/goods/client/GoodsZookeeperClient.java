package org.yjcycc.shop.goods.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.log4j.Logger;
import org.apache.zookeeper.data.Stat;
import org.yjcycc.shop.common.rmi.GoodsRemoteConfig;
import org.yjcycc.shop.common.rmi.RemoteConfig;
import org.yjcycc.shop.common.rmi.UsingIpPort;
import org.yjcycc.shop.common.util.JsonUtil;



/**
 * @author Rosun
 * 
 *         GPS计算服务客户端
 *
 */
public class GoodsZookeeperClient {

	private static Logger logger = Logger.getLogger(GoodsZookeeperClient.class);

	private CuratorFramework zkTools;

	// 轮询指针
	private int pointer = 0;
	private List<UsingIpPort> ipPorts = new ArrayList<UsingIpPort>();

	/**
	 * 在注册监听器的时候，如果传入此参数，当事件触发时，逻辑由线程池处理
	 */
	private ExecutorService pool = null;

	private PathChildrenCache childrenCache;

	private GoodsZookeeperClient() {
		synchronized (ipPorts) {
			boolean result = createTreeNodeObserver();
			if (result) {
				//为解决第一次异步通知事件延迟的问题，尝试等待2秒
				try {
					Thread.sleep(2000);
					//如果这里不等待两秒，则第一次调用Client.getRemoteService 时拿不到活着的节点。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return;
			} else {
				logger.error("创建监听器 操作失败 ！请检查相关资源是否正确配置及其启动状态是否OK；");
				throw new RuntimeException("创建监听器 操作失败 ！");
			}
		}
		
	}

	private static final GoodsZookeeperClient instance = new GoodsZookeeperClient();

	public static GoodsZookeeperClient getInstance() {
		return instance;
	}

	/**
	 * 轮询获取一个活着的节点，负载均衡
	 * 
	 * @return
	 */
	public UsingIpPort getOneLivingIpPort() {
		int count = ipPorts.size();
		if (count == 0) {
			logger.warn("没有活着的节点了，请检查 GpsComZookeeperClient");
			return null;
		}
		UsingIpPort target = ipPorts.get(pointer % count);
		pointer++;
		if (pointer == 9999) {
			pointer = 0;
		}
		return target;
	}
	
	
	/**
	 * 更新ipPorts
	 * @param list
	 */
	public void updateIpPorts(List<UsingIpPort>  list){
		logger.info("updateIpPorts ,list.size="+list.size());
		this.ipPorts = list;
	}
	
	/**
	 * 读取节点信息 （非新建客户端）
	 * 
	 * @return
	 */
	public static List<UsingIpPort> readTreeStat() {
		CuratorFramework client = null;
		List<UsingIpPort> tmpIpPorts = new ArrayList<>();
		try {
			String connString = RemoteConfig.getInstance().getZookeeperConnUrl();
			client = createZookeeperClient(connString);
			client.start();
			Stat stat = client.checkExists().forPath(GoodsRemoteConfig.BASE_PATH_SHOP_GOODS);
			if(stat == null || stat.getNumChildren() == 0){
				logger.warn("没有子节点");
				return tmpIpPorts;
			}
			int children = stat.getNumChildren();
			logger.info("readTreeStat >>> getNumChildren=" + children + ",stat=" + stat);
			List<String> paths;
			try {
				paths = client.getChildren().forPath(GoodsRemoteConfig.BASE_PATH_SHOP_GOODS);
				for (String p : paths) {
					logger.info("loadNodes>> p=" + p);
					String d = new String(client.getData().forPath(GoodsRemoteConfig.BASE_PATH_SHOP_GOODS + "/" + p),
							RemoteConfig.charset);
					logger.info("loadNodes>> d=" + d);
					if (isboolIp(d)) {
						logger.warn("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
						logger.warn("ignored get data ：" + GoodsRemoteConfig.BASE_PATH_SHOP_GOODS + "/" + p + ",d=" + d);
						logger.warn("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n");
						continue;
					}
					tmpIpPorts.add(JsonUtil.toBean(d, UsingIpPort.class));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(client != null){
				client.close();
			}
			
		}
		for(UsingIpPort uip :tmpIpPorts) {
			logger.info(">>> " + uip);
		}
		return tmpIpPorts;
	}

	public void stop() {
		try {
			if (this.zkTools != null) {
				this.zkTools.close();
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		if (pool != null) {
			pool.shutdown();
		}
		if (childrenCache != null) {
			try {
				childrenCache.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static CuratorFramework createZookeeperClient(String connString) {
		return CuratorFrameworkFactory.builder().connectString(connString).sessionTimeoutMs(5000)
				.connectionTimeoutMs(3000).namespace(RemoteConfig.NAME_SPACE).retryPolicy(new RetryNTimes(5, 1000))
				.connectionTimeoutMs(30000).build();
	}

	/** * 判断是否为合法IP * @return the ip */
	public static boolean isboolIp(String ipAddress) {
		String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();
	}

	/**
	 * 从节点树 读取所有的活着的节点的信息。。。。。
	 * 
	 * @return
	 */
	private int loadNodes() {
		ipPorts.clear();
		List<String> paths;
		try {
			paths = this.zkTools.getChildren().forPath(GoodsRemoteConfig.BASE_PATH_SHOP_GOODS);
			for (String p : paths) {
				logger.info("loadNodes>> p=" + p);
				String d = new String(this.zkTools.getData().forPath(GoodsRemoteConfig.BASE_PATH_SHOP_GOODS + "/" + p),
						RemoteConfig.charset);
				logger.info("loadNodes>> d=" + d);
				if (isboolIp(d)) {
					logger.warn("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					logger.warn("ignored get data ：" + GoodsRemoteConfig.BASE_PATH_SHOP_GOODS + "/" + p + ",d=" + d);
					logger.warn("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n");
					continue;
				}
				ipPorts.add(JsonUtil.toBean(d, UsingIpPort.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipPorts.size();
	}

	/**
	 * 创建观察者 观察节点变化
	 * 
	 * @return
	 */
	private boolean createTreeNodeObserver() {
		// 注册监听 检查节点数据变化
		try {
			pool = Executors.newFixedThreadPool(1);
			String connString = RemoteConfig.getInstance().getZookeeperConnUrl();
			this.zkTools = createZookeeperClient(connString);
			this.zkTools.start();

			// 初始化的时候加载一次节点数据情况；
			int x = loadNodes();
			logger.info("/初始化的时候加载一次节点数据情况，存活节点数目：" + x + ",存活节点信息：" + this.ipPorts);

			/**
			 * 监听子节点的变化情况
			 */
			childrenCache = new PathChildrenCache(this.zkTools, GoodsRemoteConfig.BASE_PATH_SHOP_GOODS, true);
			childrenCache.start(StartMode.POST_INITIALIZED_EVENT);
			childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
				@Override
				public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
					switch (event.getType()) {
					case CHILD_ADDED:
						logger.info("CHILD_ADDED: " + event.getData().getPath());
						loadNodes();
						break;
					case CHILD_REMOVED:

						logger.info("CHILD_REMOVED: " + event.getData().getPath());
						int count = loadNodes();
						if (count == 0) {
							logger.info("//FIXME  luoshan  通知所有节点挂掉了");
							logger.info("//FIXME  luoshan  通知所有节点挂掉了");
						}
						break;
					case CHILD_UPDATED:
						logger.info("CHILD_UPDATED: " + event.getData().getPath());
						break;
					default:
						break;
					}
				}
			}, pool);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
