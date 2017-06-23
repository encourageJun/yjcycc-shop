package org.yjcycc.shop.order;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yjcycc.shop.order.server.OrderServer;

public class StartOrderServer {

	private static Logger logger = Logger.getLogger(StartOrderServer.class);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = null;
		try {
			
			ctx = new ClassPathXmlApplicationContext("classpath:/spring/spring-order-context.xml");
			ctx.start();

			OrderServer server = ctx.getBean(OrderServer.class);
			if (server.isRunning()) {
				// 往zookeeper 节点树声明一下自身：创建一个临时节点！
				boolean flag = server.createTreeNode();
				logger.info("创建节点：结果：" + flag);
			} else {
				logger.error("OrderServer not started well, please check OrderServer config");
				return;
			}

			logger.info("\n\n############################## Order Server started:##############################");
			logger.info("\n\n############################## " + server.getUsingIpPort());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"\n\n############################## Order Server Failed launch:##############################",
					e);
			return;
		}
		synchronized (StartOrderServer.class) {
			while (true) {
				try {
					StartOrderServer.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
