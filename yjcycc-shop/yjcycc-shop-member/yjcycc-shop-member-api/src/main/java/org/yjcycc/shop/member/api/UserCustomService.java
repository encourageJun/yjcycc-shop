package org.yjcycc.shop.member.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.yjcycc.shop.common.entity.UserCustom;

public interface UserCustomService extends Remote {

	UserCustom getById(String customId) throws RemoteException;
	
}
