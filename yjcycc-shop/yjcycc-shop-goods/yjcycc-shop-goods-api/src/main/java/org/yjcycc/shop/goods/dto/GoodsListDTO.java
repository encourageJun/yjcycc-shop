package org.yjcycc.shop.goods.dto;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("goodsListDTO")
public class GoodsListDTO implements Serializable {

	private static final long serialVersionUID = 3438766455461513477L;

	private Long id; 
	
	private String name; // 商品名称
	
	private Double price; // 商品价格
	
	private String firstGoodsImageUrl; // 商品第一张主图

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getFirstGoodsImageUrl() {
		return firstGoodsImageUrl;
	}

	public void setFirstGoodsImageUrl(String firstGoodsImageUrl) {
		this.firstGoodsImageUrl = firstGoodsImageUrl;
	}
	
}
