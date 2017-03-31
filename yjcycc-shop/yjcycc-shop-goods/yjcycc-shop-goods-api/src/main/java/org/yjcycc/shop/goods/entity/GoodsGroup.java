package org.yjcycc.shop.goods.entity;

import java.io.Serializable;

/**
 * 实体类-商品分组表
 * @author Yangjun
 *
 */

public class GoodsGroup implements Serializable {

	private static final long serialVersionUID = 6749697395219469310L;

	private Long id;
	private String name; // 商品分组名称
	private Long sort; // 排序序号

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

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

}
