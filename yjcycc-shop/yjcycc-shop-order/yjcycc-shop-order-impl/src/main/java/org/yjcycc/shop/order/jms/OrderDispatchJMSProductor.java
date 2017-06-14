package org.yjcycc.shop.order.jms;

import javax.jms.Connection;

import org.springframework.stereotype.Component;
import org.yjcycc.shop.common.jms.AbstractJMSProductor;
import org.yjcycc.shop.common.jms.JMSConfig;
import org.yjcycc.shop.common.jms.JMSConnFactory;

/**
 * 下单生产者
 * @author HeQiang
 *
 */
@Component
public class OrderDispatchJMSProductor extends AbstractJMSProductor {
	
	@Override
	public String getQueueName() {
		return JMSConfig.ORDER_DISPATCH_QUEUE_NAME;
	}

	@Override
	public Connection getConnection() {
		return JMSConnFactory.getInstance().getConnection();
	}

}
