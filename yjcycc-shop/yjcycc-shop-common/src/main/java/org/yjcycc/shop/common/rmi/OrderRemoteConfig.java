package org.yjcycc.shop.common.rmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 远程服务的配置管理信息；包括RMI服务/JPush极光APP相关参数
 * 
 * @author Rosun
 *
 */
public class OrderRemoteConfig {

	private static Logger logger = LoggerFactory.getLogger(OrderRemoteConfig.class);

	private static final OrderRemoteConfig instance = new OrderRemoteConfig();

	private static final String CONFIG_FILE = "order.rmi.properties";

	public static final String BASE_PATH = "/yycycc/shop/order";// 节点路径

	public static final int MAX_NODES = 2;

	// RMI server engine
	private String serverIp0;

	// RMI port engine
	private int port0;

	// RMI server engine
	private String serverIp1;

	// RMI port engine
	private int port1;

	// RMI server engine
	private String serverIp2;

	// RMI port engine
	private int port2;

	// RMI server engine
	private String serverIp3;

	// RMI port engine
	private int port3;

	/**
	 * 是否使用某个自定的配置来启动，多节点分多主机部署时需要；单主机时不要配置。
	 */
	private String specifyIpPortIndex;

	/** 初始化 */
	private OrderRemoteConfig() {
		try {
			Properties prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE));
			String dotenv = "." + SystemConfig.getEnviroment();

			specifyIpPortIndex = prop.getProperty("rmi.server.specify.index" + dotenv);
			serverIp0 = prop.getProperty("rmi.server.ip.0" + dotenv);
			port0 = Integer.parseInt(prop.getProperty("rmi.server.port.0" + dotenv));
			serverIp1 = prop.getProperty("rmi.server.ip.1" + dotenv);
			port1 = Integer.parseInt(prop.getProperty("rmi.server.port.1" + dotenv));
			serverIp2 = prop.getProperty("rmi.server.ip.2" + dotenv);
			port2 = Integer.parseInt(prop.getProperty("rmi.server.port.2" + dotenv));
			serverIp3 = prop.getProperty("rmi.server.ip.3" + dotenv);
			port3 = Integer.parseInt(prop.getProperty("rmi.server.port.3" + dotenv));

			logger.info("#######################################");
			logger.info("#### prop:" + prop);
			logger.info("#######################################");

			logger.info(">>>>>>>>>>>>>>>>> env:" + dotenv);
			logger.info(">>>>>>>>>>>>>>>>> server ip0:" + serverIp0 + " server ip1:" + serverIp1 + " server ip2:"
					+ serverIp2 + " server ip3:" + serverIp3);
			logger.info(
					">>>>>>>>>>>>>>>>> port0:" + port0 + " port1:" + port1 + "  port2:" + port2 + "  port3:" + port3);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("RemoteConfig 配置异常：", ex);
		}
	}

	public static final OrderRemoteConfig getInstance() {
		return instance;
	}

	public int getPort1() {
		return port1;
	}

	public String getServerIp1() {
		return serverIp1;
	}

	public int getPort2() {
		return port2;
	}

	public String getServerIp2() {
		return serverIp2;
	}

	public String getServerIp0() {
		return serverIp0;
	}

	public void setServerIp0(String serverIp0) {
		this.serverIp0 = serverIp0;
	}

	public int getPort0() {
		return port0;
	}

	public void setPort0(int port0) {
		this.port0 = port0;
	}

	public String getServerIp3() {
		return serverIp3;
	}

	public void setServerIp3(String serverIp3) {
		this.serverIp3 = serverIp3;
	}

	public int getPort3() {
		return port3;
	}

	public void setPort3(int port3) {
		this.port3 = port3;
	}

	/**
	 * 是否使用某个自定的配置来启动，多节点分多主机部署时需要；单主机时不要配置。
	 * 
	 * @return
	 */
	public String getSpecifyIpPortIndex() {
		return specifyIpPortIndex;
	}

}
