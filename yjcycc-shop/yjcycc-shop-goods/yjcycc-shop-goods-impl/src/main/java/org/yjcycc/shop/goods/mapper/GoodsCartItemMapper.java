package org.yjcycc.shop.goods.mapper;

import org.apache.ibatis.annotations.Param;
import org.yjcycc.shop.common.entity.GoodsCartItem;
import org.yjcycc.shop.goods.dto.GoodsCartItemDTO;

import java.util.List;
import java.util.Map;

public interface GoodsCartItemMapper {
	
	void save(GoodsCartItem goodsCartItem);
	
	GoodsCartItemDTO findById(String cartItemId);
	
	List<GoodsCartItemDTO> findPager(Map<String,Object> map);
	
	void delete(String cartItemIds);
	
	void updateQuantity(@Param("cartItemId")String cartItemId, @Param("quantity")Integer quantity);

}
