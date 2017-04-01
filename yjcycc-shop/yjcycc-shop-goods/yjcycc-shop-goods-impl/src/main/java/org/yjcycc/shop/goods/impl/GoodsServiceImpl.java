package org.yjcycc.shop.goods.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjcycc.shop.goods.entity.Goods;
import org.yjcycc.shop.goods.mapper.GoodsMapper;
import org.yjcycc.shop.goods.service.GoodsService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public Page<Goods> findPager(String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		
		PageHelper.startPage(1, 1);
		List<Goods> goodsList = goodsMapper.findPager(map);
		
		if (goodsList == null) {
			return null;
		}
		
		return (Page<Goods>)goodsList;
	}

	
	
}
