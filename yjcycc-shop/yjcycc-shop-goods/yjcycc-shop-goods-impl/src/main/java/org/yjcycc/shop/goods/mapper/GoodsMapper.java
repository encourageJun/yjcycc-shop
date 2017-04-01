package org.yjcycc.shop.goods.mapper;

import java.util.List;
import java.util.Map;

import org.yjcycc.shop.goods.entity.Goods;

public interface GoodsMapper {

	public List<Goods> findPager(Map<String,Object> map);
	
}
