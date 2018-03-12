package org.yjcycc.shop.order.api;

import org.yjcycc.shop.common.entity.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OrderService extends Remote {

	void add(Order order) throws RemoteException;
	
}
