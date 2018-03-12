package org.yjcycc.shop.common.jms;

import org.springframework.context.Lifecycle;

import javax.jms.*;
import java.io.Serializable;

/**
 * JMS 生产者
 * @author HeQiang
 *
 */
public abstract class AbstractJMSProductor implements Lifecycle {
	private Connection conn;
	private MessageProducer prod;
	private Session sess;
	private boolean isRun;
	
	protected Session getSession(Connection conn) throws JMSException {
		return conn.createSession(false, Session.AUTO_ACKNOWLEDGE);		
	}
	
	public void send(Serializable msg) {		
		try {
			ObjectMessage message = sess.createObjectMessage(msg);			
			prod.send(message);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public abstract String getQueueName();
	public abstract Connection getConnection();

	@Override
	public boolean isRunning() {
		return isRun;
	}

	@Override
	public void start() {		
		conn = getConnection();	
		
		try {
			conn.start();
			
			sess = getSession(conn);
			Destination dest = sess.createQueue(getQueueName());
			prod = sess.createProducer(dest);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		isRun = true;
	}

	@Override
	public void stop() {	
		try {
			conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		isRun = false;
	}	
}
