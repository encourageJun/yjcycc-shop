package org.yjcycc.shop.order.log;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yjcycc.shop.common.constant.LogPrefixConstant;
import org.yjcycc.shop.common.utils.LogUtil;
import org.yjcycc.shop.order.interfaces.LoggerWorker;

@Component
@Qualifier("OrderLogger")
public class OrderLogger implements LoggerWorker {
	private Logger logger;
	
	public OrderLogger() {
		logger = LogUtil.getInstance(LogPrefixConstant.YJCYCC_SHOP_ORDER);
	}

	@Override
	public void info(String text) {
		logger.info(text);
	}

	@Override
	public void warn(String text) {
		logger.warn(text);
	}

	@Override
	public void debug(String text) {
		logger.debug(text);
	}

	@Override
	public void error(String text) {
		logger.error(text);
	}

	@Override
	public void error(Throwable e, String... message) {
		logger.error(message, e);
	}

}
