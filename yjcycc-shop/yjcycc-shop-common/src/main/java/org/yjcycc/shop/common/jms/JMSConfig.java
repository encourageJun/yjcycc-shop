package org.yjcycc.shop.common.jms;

import org.apache.activemq.ActiveMQConnection;
import org.yjcycc.shop.common.rmi.RemoteConfig;

/**
 * JMS 配置文件
 * @author HeQiang
 *
 */
public class JMSConfig {
	
	public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;// 默认连接用户名
	
	public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;// 默认连接密码
	
	public static final String JMS_BROKER_URL = RemoteConfig.getInstance().getJmsBrokerUrl();
	
	public final static String ORDER_DISPATCH_QUEUE_NAME="ORDER_DISPATCH";
	
}
