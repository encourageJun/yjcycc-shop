package org.yjcycc.shop.member.web.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yjcycc.shop.member.api.UserCustomService;

@RestController
@RequestMapping(value = "/user/custom")
public class UserCustomController {
	
	@Autowired
	private UserCustomService userCustomService;

	@RequestMapping(value = "/get")
	public Object getCustomInfo(HttpServletRequest request) {
		
		try {
			userCustomService.getById("start");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
