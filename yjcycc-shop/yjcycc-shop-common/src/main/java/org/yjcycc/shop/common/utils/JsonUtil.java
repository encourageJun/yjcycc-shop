package org.yjcycc.shop.common.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

/**
 * @description JSON实用类
 * @author biao
 * @date 2016年6月4日
 */
public class JsonUtil {
	
	private final static ObjectMapper MAPPER = new ObjectMapper();
	
	static {
		MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}
	
	/**
	 * @description Bean对象转Json字符串
	 * @param bean
	 * @return
	 */
	public static String toJson(Object bean) {
		try {
			//MAPPER.setSerializationInclusion(Include.NON_EMPTY);
			return MAPPER.writeValueAsString(bean);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * @description Json字符串转Bean对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(String json, Class<T> clazz) {
		try {
			return MAPPER.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * @description Json字符串转Bean列表
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> toList(String json, Class<T> clazz) {
		try {
			return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
