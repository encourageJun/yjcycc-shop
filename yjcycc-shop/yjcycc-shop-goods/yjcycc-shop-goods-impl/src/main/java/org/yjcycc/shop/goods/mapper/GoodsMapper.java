package org.yjcycc.shop.goods.mapper;

import org.yjcycc.shop.common.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {

	public List<Goods> findPager(Map<String,Object> map);
	
	public Goods findById(String id);
	
}
