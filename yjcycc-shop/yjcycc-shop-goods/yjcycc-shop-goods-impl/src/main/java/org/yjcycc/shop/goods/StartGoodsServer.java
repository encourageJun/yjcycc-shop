package org.yjcycc.shop.goods;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yjcycc.shop.common.tools.config.SystemConfig;
import org.yjcycc.shop.common.tools.config.ToolsConfig;
import org.yjcycc.shop.goods.zk.server.GoodsServer;

public class StartGoodsServer {

	private static Logger logger = Logger.getLogger(StartGoodsServer.class);
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = null;
		try {
			logger.info("Lanch GoodsServer...  classpath:/spring/spring-goods-context.xml");
			ctx = new ClassPathXmlApplicationContext("classpath:/spring/spring-goods-context.xml");
			ctx.start();
			
			GoodsServer goodsServer = ctx.getBean(GoodsServer.class);
			
			if(goodsServer.isRunning()){
				//不管是不是主节点  都需要往zookeeper 节点树声明一下自身：创建一个节点！
				boolean flag = goodsServer.createTreeNode();
				
				logger.info("创建节点, 结果：" + flag);
				if(flag == false){
					logger.error("GoodsServer 创建ZK节点失败，请检查配置。导致此失败的原因是 1.ZK无法连接 ;2.ZK上已存在相关节点 ;3.ZK操作权限受限");
					logger.error("\n\n############################## GoodsServer Failed launch:##############################");
					ctx.close();
					return ;
				}
			} else {
				logger.error("GoodsServer not started well, please check GoodsServer config");
				logger.error("\n\n############################## GoodsServer Failed launch:##############################" );
				ctx.close();
				return ;
			} 
			
			logger.info("\n\n############################## GoodsServer started:##############################");
			logger.info("\n\n############################## " + goodsServer.getUsingIpPort());	
		} catch (Exception e) {
			logger.error("\n\n############################## GoodsServer Failed launch:##############################", e);
			return;
		}
		
		logger.info("@@@@ Using ZooKeeper url : " + ToolsConfig.getInstance().getZookeeperConnUrl());
		logger.info("@@@@ Current Enviroment  : " + SystemConfig.getEnviroment());
		
		synchronized (StartGoodsServer.class) {
			while (true) {
				try {
					StartGoodsServer.class.wait();
				} catch (InterruptedException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}
	
}
