package org.yjcycc.shop.goods.service;

import org.yjcycc.shop.goods.entity.Goods;

import com.github.pagehelper.Page;

public interface GoodsService {

	public Page<Goods> findPager(String name);
	
}
