package org.yjcycc.shop.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjcycc.shop.common.entity.UserCustom;
import org.yjcycc.shop.member.api.UserCustomService;
import org.yjcycc.shop.member.mapper.UserCustomMapper;

import java.rmi.RemoteException;

@Service("userCustomService")
public class UserCustomServiceImpl implements UserCustomService {
	
	@Autowired
	private UserCustomMapper userCustomMapper;

	@Override
	public UserCustom getById(String customId) throws RemoteException {
		
		System.out.println(customId);
		
		return userCustomMapper.findById(customId);
	}

}
