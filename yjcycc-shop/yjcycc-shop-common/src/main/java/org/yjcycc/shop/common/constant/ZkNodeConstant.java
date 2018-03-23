package org.yjcycc.shop.common.constant;

import java.nio.charset.Charset;

import org.yjcycc.shop.common.tools.config.SystemConfig;

public class ZkNodeConstant {

	public static Charset CHARSET = Charset.forName("utf-8");
	
	public static final String NAME_SPACE = "yjcycc/shop/" + SystemConfig.getEnviroment(); 

	public static final String BASE_ORDER_PATH = "/order"; 
	
	public static final String BASE_GOODS_PATH = "/goods";
	
}
