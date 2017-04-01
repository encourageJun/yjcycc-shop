package org.yjcycc.shop.goods.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类-商品分类表
 * @author Yangjun
 *
 */

public class GoodsCategory implements Serializable {

	private static final long serialVersionUID = 6863782088201986867L;

	private Long id;
	private String name; // 商品分类名称
	private Integer sort; // 排序序号
	private Date insertTime; // 插入时间
	private Date updateTime; // 更新时间

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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
