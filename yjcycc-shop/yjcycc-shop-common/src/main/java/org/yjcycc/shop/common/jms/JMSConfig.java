package org.yjcycc.shop.common.jms;

import org.apache.activemq.ActiveMQConnection;
import org.yjcycc.shop.common.tools.config.ToolsConfig;

/**
 * JMS 配置文件
 * @author HeQiang
 *
 */
public class JMSConfig {
	
	public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;// 默认连接用户名
	
	public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;// 默认连接密码
	
	public static final String JMS_BROKER_URL = ToolsConfig.getInstance().getActivemqJmsBrokerUrl();
	
	public final static String ORDER_DISPATCH_QUEUE_NAME="ORDER_DISPATCH";
	
}
