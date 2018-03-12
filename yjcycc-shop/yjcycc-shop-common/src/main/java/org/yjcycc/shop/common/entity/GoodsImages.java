package org.yjcycc.shop.common.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("goodsImages")
public class GoodsImages implements Serializable {

	private static final long serialVersionUID = -6031766178152617977L;

	private String id;
	
	private String goodsId;
	
	private String goodsImageUrl;
	
	private Integer sort;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsImageUrl() {
		return goodsImageUrl;
	}

	public void setGoodsImageUrl(String goodsImageUrl) {
		this.goodsImageUrl = goodsImageUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
