package org.yjcycc.shop.goods.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.yjcycc.shop.common.entity.Goods;

import com.github.pagehelper.Page;

public interface GoodsService extends Remote {

	public Page<Goods> findPager(String name) throws RemoteException;
	
}
