package org.yjcycc.shop.common.jms;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.context.Lifecycle;

/**
 * JMS 消费者
 * @author HeQiang
 *
 */
public abstract class AbstractJMSConsumer implements Lifecycle, Runnable{	
	private boolean isRun;
	private Connection conn;
	private MessageConsumer consumer;
	private Session sess;
	
	protected Session getSession(Connection conn) throws JMSException {
		return conn.createSession(false, Session.AUTO_ACKNOWLEDGE);		
	}
	
	@Override
	public void run() {
		start();
	}
	
	protected abstract void onReceiving(Serializable messageOject);
	public abstract String getQueueName();
	public abstract Connection getConnection();	

	@Override
	public boolean isRunning() {
		return isRun;
	}

	@Override
	public void start() {
		isRun = true;
		conn = getConnection();		
		try {
			conn.start();
			sess = getSession(conn);
			Destination dest = sess.createQueue(getQueueName());
			consumer = sess.createConsumer(dest);
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {					
					try {
						ObjectMessage msg = (ObjectMessage)message;						
						onReceiving(msg.getObject());
					} catch (JMSException e) {
						e.printStackTrace();
					}					
				}});
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		isRun = false;
		
		try {
			conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	
}
