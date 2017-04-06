package org.yjcycc.shop.houtai.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

	private Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@RequestMapping(value = "/list")
	public Object list(HttpServletRequest request) {
		logger.info("start.");
		
		
		
		return null;
	}
	
}
