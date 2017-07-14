package org.yjcycc.shop.goods.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjcycc.shop.common.entity.GoodsCartItem;
import org.yjcycc.shop.goods.dto.GoodsCartItemDTO;
import org.yjcycc.shop.goods.mapper.GoodsCartItemMapper;
import org.yjcycc.shop.goods.service.GoodsCartItemService;

@Service("goodsCartItemService")
public class GoodsCartItemServiceImpl implements GoodsCartItemService {
	
	@Autowired
	private GoodsCartItemMapper goodsCartItemMapper;

	@Override
	public List<GoodsCartItemDTO> getGoodsCartItemList(String customerId) throws RemoteException {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("customerId", customerId);
		List<GoodsCartItemDTO> list = goodsCartItemMapper.findPager(map);
		
		return list;
	}
	
	@Override
	public void delete(String cartItemIds) throws RemoteException {
		StringBuffer sb = new StringBuffer();
		String[] ids = cartItemIds.split(",");
		for (String id : ids) {
			sb.append("'").append(id).append("'").append(",");
		}
		cartItemIds = sb.substring(0, sb.length() - 1);
		
		goodsCartItemMapper.delete(cartItemIds);
	}
	
	@Override
	public void updateQuantity(String cartItemId, Integer quantity) throws RemoteException {
		goodsCartItemMapper.updateQuantity(cartItemId, quantity);
	}
	
	@Override
	public void save(GoodsCartItem goodsCartItem) throws RemoteException {
		goodsCartItemMapper.save(goodsCartItem);
	}
	
}
