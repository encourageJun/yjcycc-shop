package org.yjcycc.shop.goods.entity;

import java.io.Serializable;

/**
 * 商品分组-商品关联表
 * @author Yangjun
 *
 */

public class GoodsGroupGoods implements Serializable {

	private static final long serialVersionUID = -4347185660745639632L;

	private Long id;
	private Long goodsId; // 商品id
	private Long goodsGroupId; // 商品分组id
	private Integer sort; // 排序序号

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsGroupId() {
		return goodsGroupId;
	}

	public void setGoodsGroupId(Long goodsGroupId) {
		this.goodsGroupId = goodsGroupId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
