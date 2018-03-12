package org.yjcycc.shop.member.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @description 登录鉴权拦截器
 * @author biao
 * @date 2016年6月2日
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger LOG = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String ip = this.getRemoteHost(request);
		//String ipWhiteList = PropertiesUtil.getString(WebConstant.IP_WHITE_LIST);
//		if (!ipWhiteList.contains(ip)) {
//			LOG.info("Request RemoteAddr：" + ip);
//			throw new PermissionException("没有权限访问接口");
//		}
		if (request.getRequestURI().startsWith("/api/"))
		LOG.info("[" + ip + "]接口链接：" + request.getRequestURI() + "，请求参数 ：" + this.reqParamsHandle(request));
		return true;
	}
	
	public String getRemoteHost(javax.servlet.http.HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	/**
	 * @description 封装请求参数
	 * @param request
	 * @return
	 */
	private Map<String, String> reqParamsHandle(HttpServletRequest request) {
		Map<String, String> resultMap = new HashMap<String, String>();
		Map<String, String[]> reqParams = request.getParameterMap();
		for (String key : reqParams.keySet()) {
			resultMap.put(key, getValue(reqParams.get(key)));
		}
		return resultMap;
	}

	/**
	 * @description 获取对象字符串值
	 * @param tmpVal
	 * @return
	 */
	private String getValue(Object tmpVal) {
		String value = "";
		if (tmpVal == null)
			return value;
		if (tmpVal instanceof String[]) {
			String[] val_arr = (String[]) tmpVal;
			for (String val : val_arr)
				value = val + ",";
			value = value.replaceAll(",$", "");
		} else 
			value = tmpVal.toString();
		return value;
	}
	
}
