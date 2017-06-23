package org.yjcycc.shop.common.interfaces;

import org.yjcycc.shop.common.rmi.UsingIpPort;

public interface BaseServerService {

	UsingIpPort getUsingIpPort();
	 

	boolean isRunning();
	
	
	/**
	 * 创建Zookeeper 节点树， 
	 */
	public boolean createTreeNode();
	
}
