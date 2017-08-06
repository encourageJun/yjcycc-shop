package org.yjcycc.shop.member.impl;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
import org.yjcycc.shop.common.entity.UserCustom;
import org.yjcycc.shop.member.api.UserCustomService;

@Service("userCustomService")
public class UserCustomServiceImpl implements UserCustomService {

	@Override
	public UserCustom getById(String customId) throws RemoteException {
		
		System.out.println(customId);
		
		return null;
	}

}
