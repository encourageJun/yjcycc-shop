package org.yjcycc.shop.common.rmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.Properties;

public class RemoteConfig {

	private static Logger logger = LoggerFactory.getLogger(RemoteConfig.class);

	private static final RemoteConfig instance = new RemoteConfig();

	private static final String RMI_CONFIG_FILE = "rmi.properties";

	public static Charset charset = Charset.forName("utf-8");

	public static final String NAME_SPACE = "zk/" + SystemConfig.getEnviroment();

	// JMS 服务链接
	private String jmsBrokerUrl;

	// Zookeeper 集群 服务链接
	private String zookeeperConnUrl;

	// 极光app key
	private String jpushAppkey;
	// 极光app secret
	private String jpushSecret;

	private String mongoUsername;
	private String mongoPassword;
	private String mongoServerIp;
	private int mongoServerPort;
	
	/** 初始化 */
	private RemoteConfig() {
		try {
			Properties prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(RMI_CONFIG_FILE));
			String dotenv = "." + SystemConfig.getEnviroment();

			jmsBrokerUrl = (prop.getProperty("rmi.jms.broker.url" + dotenv));

			zookeeperConnUrl = prop.getProperty("rmi.zookeeper" + dotenv);

			this.jpushAppkey = prop.getProperty("jpush.app.key" + dotenv);
			this.jpushSecret = prop.getProperty("jpush.secret" + dotenv);

			setMongoUsername(prop.getProperty("mongo.username" + dotenv));
			setMongoPassword(prop.getProperty("mongo.password" + dotenv));
			setMongoServerIp(prop.getProperty("mongo.server.ip" + dotenv));
			setMongoServerPort(Integer.parseInt(prop.getProperty("mongo.server.port" + dotenv)));

			logger.info(">>>>>>>>>>>>>>>>> jmsBrokerUrl:" + jmsBrokerUrl);
			logger.info(">>>>>>>>>>>>>>>>> zookeeperConnUrl:" + zookeeperConnUrl);
			logger.info(">>>>>>>>>>>>>>>>> mongo:ip=" + getMongoServerIp() + ", port=" + getMongoServerPort()
					+ ", username=" + getMongoUsername() + ", password=" + getMongoPassword());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("RemoteConfig 配置异常：", e);
		}
	}
	
	public static final RemoteConfig getInstance() {
		return instance;
	}

	public String getJmsBrokerUrl() {
		return jmsBrokerUrl;
	}

	public void setJmsBrokerUrl(String jmsBrokerUrl) {
		this.jmsBrokerUrl = jmsBrokerUrl;
	}

	public String getZookeeperConnUrl() {
		return zookeeperConnUrl;
	}

	public void setZookeeperConnUrl(String zookeeperConnUrl) {
		this.zookeeperConnUrl = zookeeperConnUrl;
	}

	public String getJpushAppkey() {
		return jpushAppkey;
	}

	public void setJpushAppkey(String jpushAppkey) {
		this.jpushAppkey = jpushAppkey;
	}

	public String getJpushSecret() {
		return jpushSecret;
	}

	public void setJpushSecret(String jpushSecret) {
		this.jpushSecret = jpushSecret;
	}

	public String getMongoUsername() {
		return mongoUsername;
	}

	public void setMongoUsername(String mongoUsername) {
		this.mongoUsername = mongoUsername;
	}

	public String getMongoPassword() {
		return mongoPassword;
	}

	public void setMongoPassword(String mongoPassword) {
		this.mongoPassword = mongoPassword;
	}

	public String getMongoServerIp() {
		return mongoServerIp;
	}

	public void setMongoServerIp(String mongoServerIp) {
		this.mongoServerIp = mongoServerIp;
	}

	public int getMongoServerPort() {
		return mongoServerPort;
	}

	public void setMongoServerPort(int mongoServerPort) {
		this.mongoServerPort = mongoServerPort;
	}

}
