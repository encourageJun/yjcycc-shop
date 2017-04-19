package org.yjcycc.shop.goods.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;
import org.yjcycc.shop.common.rmi.GoodsRemoteConfig;
import org.yjcycc.shop.common.rmi.UsingIpPort;
import org.yjcycc.shop.goods.service.GoodsServerService;
import org.yjcycc.shop.goods.service.GoodsService;

@Component
public class GoodsServer implements Lifecycle,ApplicationContextAware,InitializingBean,GoodsServerService{

	
	private static ApplicationContext appContext = null;
	
	private static Logger logger = Logger.getLogger(GoodsServer.class);
	
	private UsingIpPort using  = null;
	
	/**
	 * 获取Spring 上下文
	 * @return
	 */
	public static  ApplicationContext getApplicationContext(){
		return appContext;
	}	
	
	/**
	 * @throws RemoteException
	 * @throws ExportException
	 */
	private void registRMIService(int index) throws RemoteException ,ExportException {
		String serverIp = null;
		int port = 0;
		if(index == 0){
			//如果是重试模式，加载第2套配置
			serverIp = GoodsRemoteConfig.getInstance().getServerIp0();
			port = GoodsRemoteConfig.getInstance().getPort0();
		}else if(index == 1){
			//如果非重试模式，加载第1套配置
			serverIp = GoodsRemoteConfig.getInstance().getServerIp1();
			port = GoodsRemoteConfig.getInstance().getPort1();
		} else if(index == 2){
			//如果非重试模式，加载第1套配置
			serverIp = GoodsRemoteConfig.getInstance().getServerIp2();
			port = GoodsRemoteConfig.getInstance().getPort2();
		} else{
			throw new IllegalArgumentException("只支持0，1，2，3，共4套配置！不支持：" + index);
		}
		
		System.setProperty("java.rmi.server.hostname" , serverIp);
		logger.info("Engine server is registing ... " + serverIp + ",port:"+ port);
		Registry registry = LocateRegistry.createRegistry(port);

 

		Remote impl10 = (Remote) appContext.getBean(GoodsService.class);  
		GoodsService goodsService = (GoodsService) UnicastRemoteObject.exportObject(impl10, 0);
		// Bind the remote object's stub in the registry
		registry.rebind("GoodsService", goodsService);
		
		
		logger.info("server is ready! server ip=" + serverIp +  ",port:"+ port);
		using = new UsingIpPort(serverIp, port,index);
	}

	
	/* (non-Javadoc)
	 * @see com.ihavecar.rmi.server.EngineServerService#getUsingIpPort()
	 */
	@Override
	public UsingIpPort getUsingIpPort(){
		return using;
	}
	
	 
	
	private transient boolean isRun = false; 
	
	/* (non-Javadoc)
	 * @see com.ihavecar.rmi.server.EngineServerService#isRunning()
	 */
	@Override
	public boolean isRunning() {
		return isRun;
	}


	
	
	
	@Override
	@PostConstruct
	public void start() {
		/**
		 * 是否使用某个自定的配置来启动，多节点分多主机部署时需要；单主机时不要配置。
		 */
		String specifyIpPortIndex = GoodsRemoteConfig.getInstance().getSpecifyIpPortIndex();
		if(specifyIpPortIndex == null || "".equals(specifyIpPortIndex.trim())){
			//按照升序 读取配置文件 启动。。。。
			for(int index = 0; index < GoodsRemoteConfig.MAX_NODES;index ++){
				try {
					registRMIService(index);
					isRun = true;
					logger.info("EngineServer "+index+" started ok!");
					return ;
				} catch(ExportException e0){
					logger.error(e0);
					e0.printStackTrace();
					isRun = false;
				} catch (RemoteException e3) {
					logger.error(e3);
					e3.printStackTrace();
					isRun = false;
				}
			}
			logger.error("GisGpsServer 启动遇到问题，3套配置没有一套有效的.....");
		}else{
			logger.info("系统配置 指定按照第 ["+specifyIpPortIndex+"] 套配置来启动：");
			try {
				int index = Integer.parseInt(specifyIpPortIndex);
				registRMIService(index);
				isRun = true;
				logger.info("GisGpsServer "+index+" started ok!");
				return ;
			} catch(ExportException e0){
				isRun = false;
			} catch (RemoteException e3) {
				logger.error(e3);
				e3.printStackTrace();
				isRun = false;
			}
		}
	}



	@Override
	@PreDestroy
	public void stop() {
		isRun = false;
	}



	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		appContext = arg0;
	}



	@Override
	public void afterPropertiesSet() throws Exception {
		if(appContext == null){
			logger.error("appContext not awared...... error");
		}
	}


	
	@Autowired
	private GoodsZookeeperClient zkClient;
	

	/**
	 * 创建Zookeeper 节点树， 
	 */
	public boolean createTreeNode() {
		return zkClient.createTreeNode(using);
	}
	
}
