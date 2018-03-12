package org.yjcycc.shop.goods.mapper;

import org.yjcycc.shop.common.entity.GoodsCategory;

import java.util.List;
import java.util.Map;

public interface GoodsCategoryMapper {

	int save(GoodsCategory goodsCategory);
	
	GoodsCategory findById(String id);
	
	List<GoodsCategory> findPager(Map<String, Object> map);
	
}
