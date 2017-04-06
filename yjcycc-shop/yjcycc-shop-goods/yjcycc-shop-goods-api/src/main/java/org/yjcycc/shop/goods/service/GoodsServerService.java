package org.yjcycc.shop.goods.service;

import org.yjcycc.shop.common.conf.UsingIpPort;

public interface GoodsServerService {

	UsingIpPort getUsingIpPort();
	 

	boolean isRunning();
	
	
	/**
	 * 创建Zookeeper 节点树， 
	 */
	public boolean createTreeNode();
	
}
