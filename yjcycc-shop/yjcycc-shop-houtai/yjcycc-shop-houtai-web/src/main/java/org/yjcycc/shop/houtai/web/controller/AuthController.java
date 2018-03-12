package org.yjcycc.shop.houtai.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@RequestMapping(value = "/info")
	public Object info(HttpServletRequest request) {
		
		return null;
	}
	
}
