package org.yjcycc.shop.common.utils;

import org.apache.log4j.Logger;

public class LogUtil {

	public static Logger getInstance(String logPrefix) {
		return Logger.getLogger(logPrefix);
	}
	
	public static Logger getInstance() {
		return Logger.getLogger(LogUtil.class);
	}
	
}
