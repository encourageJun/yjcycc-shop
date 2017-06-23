package org.yjcycc.shop.order.mapper;

import java.util.Map;

import org.yjcycc.shop.common.entity.Order;

import com.github.pagehelper.Page;

public interface OrderMapper {

	void save(Order order);
	
	Order findById(String id);
	
	Page<Order> findPager(Map<String,Object> map);
	
}
