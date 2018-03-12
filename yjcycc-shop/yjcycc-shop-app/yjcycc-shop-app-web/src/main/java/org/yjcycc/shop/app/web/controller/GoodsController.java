package org.yjcycc.shop.app.web.controller;

import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yjcycc.shop.common.entity.Goods;
import org.yjcycc.shop.goods.service.GoodsService;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

	private Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/list")
	public Object list(HttpServletRequest request) {
		logger.info("start.");

		Properties pro = new Properties();
		
        try {
        	String goodsName = request.getParameter("goodsName");
        	pro.setProperty("params: goodsName-", goodsName);

        	logger.info("goodsName: " + goodsName);
	        Page<Goods> pager = goodsService.findPager(goodsName);
	        for (Goods goods : pager) {
	        	System.out.println(goods.getName());
	        	pro.setProperty("goods.name: ", goods.getName());
	        }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return pro;
	}
	
}
