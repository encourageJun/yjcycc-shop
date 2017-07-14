package org.yjcycc.shop.order.impl;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
import org.yjcycc.shop.common.entity.Order;
import org.yjcycc.shop.order.api.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Override
	public void add(Order order) throws RemoteException {
		
		
		
	}

}
