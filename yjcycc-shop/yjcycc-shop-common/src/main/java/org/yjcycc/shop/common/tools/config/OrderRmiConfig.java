package org.yjcycc.shop.common.tools.config;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 远程服务的配置管理信息；包括RMI服务/JPush极光APP相关参数
 * 
 */
public class OrderRmiConfig {

	private static Logger logger = Logger.getLogger(OrderRmiConfig.class);

	private static final OrderRmiConfig instance = new OrderRmiConfig();

	private static final String CONFIG_FILE = "order.rmi.properties";

	public static final int MAX_NODES = 2;

	/**
	 * 是否使用某个自定的配置来启动，多节点分多主机部署时需要；单主机时不要配置。
	 */
	private String specifyIpPortIndex;

	/**
	 * RMI port engine
	 */
	private int port0;

	/**
	 * RMI port engine
	 */
	private int port1;

	/**
	 * RMI port engine
	 */
	private int port2;

	/** 初始化 */
	private OrderRmiConfig() {
		try {
			Properties prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE));
			String dotenv = "." + SystemConfig.getEnviroment();

			specifyIpPortIndex = prop.getProperty("rmi.server.specify.index" + dotenv);
			port0 = Integer.parseInt(prop.getProperty("rmi.server.port.0" + dotenv));
			port1 = Integer.parseInt(prop.getProperty("rmi.server.port.1" + dotenv));
			port2 = Integer.parseInt(prop.getProperty("rmi.server.port.2" + dotenv));

			logger.info("#######################################");
			logger.info("#### prop:" + prop);
			logger.info("#######################################");

			logger.info(">>>>>>>>>>>>>>>>> env:" + dotenv);
			logger.info(">>>>>>>>>>>>>>>>> port0:" + port0 + " port1:" + port1 + "  port2:" + port2);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("RemoteConfig 配置异常：", ex);
		}
	}

	public static final OrderRmiConfig getInstance() {
		return instance;
	}

	/**
	 * 是否使用某个自定的配置来启动，多节点分多主机部署时需要；单主机时不要配置。
	 * 
	 * @return
	 */
	public String getSpecifyIpPortIndex() {
		return specifyIpPortIndex;
	}

	public void setSpecifyIpPortIndex(String specifyIpPortIndex) {
		this.specifyIpPortIndex = specifyIpPortIndex;
	}

	public int getPort0() {
		return port0;
	}

	public void setPort0(int port0) {
		this.port0 = port0;
	}

	public int getPort1() {
		return port1;
	}

	public void setPort1(int port1) {
		this.port1 = port1;
	}

	public int getPort2() {
		return port2;
	}

	public void setPort2(int port2) {
		this.port2 = port2;
	}

}
