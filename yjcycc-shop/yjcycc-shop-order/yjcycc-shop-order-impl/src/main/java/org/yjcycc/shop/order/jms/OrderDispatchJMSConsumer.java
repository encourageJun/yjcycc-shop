package org.yjcycc.shop.order.jms;

import java.io.Serializable;

import javax.jms.Connection;

import org.springframework.stereotype.Component;
import org.yjcycc.shop.common.jms.AbstractJMSConsumer;
import org.yjcycc.shop.common.jms.JMSConfig;
import org.yjcycc.shop.common.jms.JMSConnFactory;


/**
 * 下单消费者
 * @author HeQiang
 *
 */
@Component
public class OrderDispatchJMSConsumer extends AbstractJMSConsumer {
	
	@Override
	protected void onReceiving(Serializable messageOject) {
		
	}

	@Override
	public String getQueueName() {
		return JMSConfig.ORDER_DISPATCH_QUEUE_NAME;
	}

	@Override
	public Connection getConnection() {
		return JMSConnFactory.getInstance().getConnection();
	}

}
