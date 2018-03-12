package org.yjcycc.shop.goods.dto;

import org.apache.ibatis.type.Alias;
import org.yjcycc.shop.common.entity.GoodsCartItem;

@Alias("goodsCartItemDTO")
public class GoodsCartItemDTO extends GoodsCartItem {

	private static final long serialVersionUID = -771249294379080303L;
	
	private String goodsName; // 商品名称
	private Double goodsPrice; // 商品价格
	private Integer isPreSale; // 是否预售
	private Integer remainingStock; // 剩余库存

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getRemainingStock() {
		return remainingStock;
	}

	public void setRemainingStock(Integer remainingStock) {
		this.remainingStock = remainingStock;
	}

	public Integer getIsPreSale() {
		return isPreSale;
	}

	public void setIsPreSale(Integer isPreSale) {
		this.isPreSale = isPreSale;
	}

}
