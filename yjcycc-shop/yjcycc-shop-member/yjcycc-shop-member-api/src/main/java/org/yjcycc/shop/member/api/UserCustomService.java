package org.yjcycc.shop.member.api;

import org.yjcycc.shop.common.entity.UserCustom;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserCustomService extends Remote {

	UserCustom getById(String customId) throws RemoteException;
	
}
