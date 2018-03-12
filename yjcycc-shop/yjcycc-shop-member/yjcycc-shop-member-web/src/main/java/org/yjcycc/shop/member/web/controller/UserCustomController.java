package org.yjcycc.shop.member.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yjcycc.shop.member.api.UserCustomService;

import javax.servlet.http.HttpServletRequest;
import java.rmi.RemoteException;

@RestController
@RequestMapping(value = "/user/custom")
public class UserCustomController {
	
	@Autowired
	private UserCustomService userCustomService;

	@RequestMapping(value = "/get")
	public Object getCustomInfo(HttpServletRequest request) {
		
		try {
			userCustomService.getById(request.getParameter("customId"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
