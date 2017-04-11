package org.yjcycc.shop.houtai.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yjcycc.shop.goods.client.GoodsClient;
import org.yjcycc.shop.goods.entity.Goods;
import org.yjcycc.shop.goods.service.GoodsService;

import com.github.pagehelper.Page;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

	private Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@RequestMapping(value = "/list")
	public Object list(HttpServletRequest request) {
		logger.info("start.");
		
		GoodsService goodsService = (GoodsService) GoodsClient.getRemoteService("GoodsService");
        
        try {
	        Page<Goods> pager = goodsService.findPager("aa");
	        for (Goods goods : pager) {
	        	System.out.println(goods.getName());
	        }
	        System.out.println(pager.getEndRow());
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return null;
	}
	
}
