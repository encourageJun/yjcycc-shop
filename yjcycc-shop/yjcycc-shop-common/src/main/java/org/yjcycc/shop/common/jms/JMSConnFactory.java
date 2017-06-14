package org.yjcycc.shop.common.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConnFactory {
	private static JMSConnFactory instance;
	private static Connection connection;
	
	private JMSConnFactory() {
	}
	
	public Connection getConnection() {
		if(connection == null) {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					JMSConfig.USERNAME, JMSConfig.PASSWORD, JMSConfig.JMS_BROKER_URL); 
			
	        try {
				connection = connectionFactory.createConnection();
			} catch (JMSException e) {
				e.printStackTrace();
			}  
		}
        return connection;
	}
	
	public static JMSConnFactory getInstance() {
		if(instance == null) {
			instance = new JMSConnFactory();
		}
		return instance;
	}
}
