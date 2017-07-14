package org.yjcycc.shop.goods.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.yjcycc.shop.common.entity.GoodsCartItem;
import org.yjcycc.shop.goods.dto.GoodsCartItemDTO;

public interface GoodsCartItemService extends Remote {

	/**
	 * 根据用户id查购物车列表
	 * @param customerId
	 * @return
	 * @throws RemoteException
	 */
	List<GoodsCartItemDTO> getGoodsCartItemList(String customerId) throws RemoteException;
	
	/**
	 * 批量删除购物车项
	 * @param cartItemIds
	 * @throws RemoteException
	 */
	void delete(String cartItemIds) throws RemoteException;
	
	/**
	 * 修改购物车商品数量
	 * @param cartItemId
	 * @param quantity
	 * @throws RemoteException
	 */
	void updateQuantity(String cartItemId, Integer quantity) throws RemoteException;
	
	/**
	 * 加入购物车
	 * @param goodsCartItem
	 * @throws RemoteException
	 */
	void save(GoodsCartItem goodsCartItem) throws RemoteException;
	
}
