package org.yjcycc.shop.order.core;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

/**
 * 下单适配器，所有下单业务总入口
 * @author Yangjun
 *
 */
@Component
public class OrderAddAdapter {

	/**
	 * 下单具体实现
	 * @author Yangjun
	 *
	 */
	class OrderAddHandler implements Runnable {

		@Override
		public void run() {
			
		}
		
	}
	
	private static final int WORKOR_QUEUE_MAX_NUM = 200;
	private static ThreadPoolExecutor exePool;
	
	static {		
		exePool = new ThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors() * 2, 
				Runtime.getRuntime().availableProcessors() * 4, 
				20, 
				TimeUnit.SECONDS, 
				new LinkedBlockingQueue<Runnable>(WORKOR_QUEUE_MAX_NUM));
	}
	
	/**
	 * 下单系统繁忙
	 * @return
	 */
	public boolean isBusy() {
		return exePool.getPoolSize() >= WORKOR_QUEUE_MAX_NUM;
	}
	
	/**
	 * 下单
	 * @return true 成功，false 加入抢单失败
	 */
	public boolean add(Long orderId, Long driverId, Date insertTime) {
		if(isBusy()) {
			return false;
		}
		
		exePool.execute(new OrderAddHandler());
		
		return true;
	}
	
}
