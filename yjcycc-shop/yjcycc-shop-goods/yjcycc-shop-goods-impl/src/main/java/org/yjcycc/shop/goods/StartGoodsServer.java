package org.yjcycc.shop.goods;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yjcycc.shop.goods.server.GoodsServer;

public class StartGoodsServer {

	private static Logger logger = Logger.getLogger(StartGoodsServer.class);
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = null;
		try {
			
			ctx = new ClassPathXmlApplicationContext("classpath:/spring/spring-goods-context.xml");
			ctx.start();

			GoodsServer server = (GoodsServer)ctx.getBean(GoodsServer.class.getSimpleName());
			if (server.isRunning()) {
				// 往zookeeper 节点树声明一下自身：创建一个临时节点！
				boolean flag = server.createTreeNode();
				logger.info("创建节点：结果：" + flag);
			} else {
				logger.error("GoodsServer not started well, please check GoodsServer config");
				return;
			}

			logger.info("\n\n############################## Goods Server started:##############################");
			logger.info("\n\n############################## " + server.getUsingIpPort());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"\n\n############################## GPS Server Failed launch:##############################",
					e);
			return;
		}
		synchronized (StartGoodsServer.class) {
			while (true) {
				try {
					StartGoodsServer.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
