package org.yjcycc.shop.goods.service;

import com.github.pagehelper.Page;
import org.yjcycc.shop.common.entity.Goods;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GoodsService extends Remote {

	public Page<Goods> findPager(String name) throws RemoteException;
	
}
