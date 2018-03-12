package org.yjcycc.shop.common.mapper;

public interface MyBatisBaseMapper<T> {

	T get(String id);
	
	int insert(T entity);
	
	int update(T entity);
	
	int delete(T entity);
	
}
