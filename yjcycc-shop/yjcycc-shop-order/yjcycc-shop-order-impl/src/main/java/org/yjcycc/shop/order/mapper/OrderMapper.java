package org.yjcycc.shop.order.mapper;

import com.github.pagehelper.Page;
import org.yjcycc.shop.common.entity.Order;

import java.util.Map;

public interface OrderMapper {

	void save(Order order);
	
	Order findById(String id);
	
	Page<Order> findPager(Map<String,Object> map);
	
}
