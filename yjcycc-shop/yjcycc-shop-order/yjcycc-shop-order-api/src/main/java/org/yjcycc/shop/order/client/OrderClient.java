package org.yjcycc.shop.order.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yjcycc.shop.common.rmi.UsingIpPort;


/**
 * RMI服务的客户端，用于获取远程服务；<br>
 * 适用于 所有 实现了Remote接口的service ，<br>
 * main 方法中有样例供参考
 * @author Rosun
 *
 */
public class OrderClient {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderClient.class);
	/**
	 * 客户端用法举例
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			 
//			logger.info("---------------------");
//
//			for(int i=0;i<10;i++){
//				try{
//					GpsCollectService service = (GpsCollectService) GpsClient.getRemoteService("GpsCollectService"); 
//					String xx = service.hello("luoshan"); 
//					System.out.println("xx="+xx);
//					Thread.sleep(100);
//				}catch(Exception ex){
//					ex.printStackTrace();
//				}
//			}
//			logger.info("---------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
 
//	public static void testSave(DriverDaoService driverDaoService) {
//		String driverId = "1520";
//		Double lat = 0d;
//		Double lng = 0d;
//		Date time = new Date();
//		try {
//			driverDaoService.saveDriverGPSPosition(driverId, lat, lng, time);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("end testSave");
//	}
	
	
	/**
	 * 获取远程服务；适用于RMI接口暴露的所有服务；可以当作本地方法一样访问
	 * @param serviceName
	 * @return
	 */
	public static Object getRemoteService (String serviceName){
		
		try {
			//负载均衡 //简单轮询，无路由！
			UsingIpPort uip = OrderZookeeperClient.getInstance().getOneLivingIpPort();
			if(uip == null){
				try{
					List<UsingIpPort>  list = OrderZookeeperClient.readTreeStat();
					if(list != null && list.size() > 0){
						logger.info("本次RMI调用失败，下次调用会ok，请重试.");
						OrderZookeeperClient.getInstance().updateIpPorts(list);
					}else{
						logger.warn("重试后仍然没有找到活着的节点.");
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
				throw new IllegalStateException("GpsComZookeeperClient拿不到一个活着的节点信息:" );
			}
			int port = uip.getPort();
			String serverIp = uip.getIp();
			logger.debug("getOneLivingIpPort() --->  serverIp="+serverIp + ",port="+port);
			Registry registry = LocateRegistry.getRegistry(serverIp,port); 
			Object service =  registry.lookup(serviceName); 
			if(service == null){
				throw new IllegalArgumentException("service name not exist:" + serviceName);
			}
			return service;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("service not ready:" + serviceName ,e);
		}
	} 
}
