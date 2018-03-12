package org.yjcycc.shop.houtai.web.controller;

import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yjcycc.shop.common.entity.Goods;
import org.yjcycc.shop.goods.service.GoodsService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

	private Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/list")
	public Object list(HttpServletRequest request) {
		logger.info("start.");
		
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
