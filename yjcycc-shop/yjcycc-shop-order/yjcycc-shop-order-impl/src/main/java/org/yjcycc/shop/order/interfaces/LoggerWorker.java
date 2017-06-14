package org.yjcycc.shop.order.interfaces;

public interface LoggerWorker {

	void info(String text);
	void warn(String text);
	void debug(String text);
	void error(String text);
	void error(Throwable e, String... message);
	
}
