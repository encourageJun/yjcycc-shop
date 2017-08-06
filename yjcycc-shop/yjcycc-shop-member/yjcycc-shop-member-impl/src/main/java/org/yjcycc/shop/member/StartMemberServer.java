package org.yjcycc.shop.member;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartMemberServer {

	private static Logger logger = Logger.getLogger(StartMemberServer.class);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = null;
		try {
			
			ctx = new ClassPathXmlApplicationContext("classpath:/spring/spring-member-context.xml");
			ctx.start();
			
			logger.info("dubbo service begin to start");
	        try {
	            System.in.read();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

			logger.info("\n\n############################## Goods Server started:##############################");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"\n\n############################## GPS Server Failed launch:##############################",
					e);
			return;
		}
		/*synchronized (StartGoodsServer.class) {
			while (true) {
				try {
					StartGoodsServer.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
	
}
