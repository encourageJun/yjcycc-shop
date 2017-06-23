package org.yjcycc.shop.order.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.yjcycc.shop.common.entity.Order;

public interface OrderService extends Remote {

	void add(Order order) throws RemoteException;
	
}
