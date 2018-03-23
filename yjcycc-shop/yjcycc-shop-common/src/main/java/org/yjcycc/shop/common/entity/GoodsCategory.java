package org.yjcycc.shop.common.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类-商品分类表
 * @author Yangjun
 *
 */
@Alias("goodsCategory")
public class GoodsCategory implements Serializable {

	private static final long serialVersionUID = 6863782088201986867L;

	private String id;
	private String parentId; // 父分类
	private String name; // 分类名称
	private String picUrl; // 分类图片url
	private Integer sort; // 排序序号
	private Date insertTime; // 插入时间
	private Date updateTime; // 更新时间

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}
