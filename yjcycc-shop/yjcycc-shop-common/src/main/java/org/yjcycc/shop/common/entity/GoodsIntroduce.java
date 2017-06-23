package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类-商品介绍表
 * @author Yangjun
 *
 */

public class GoodsIntroduce implements Serializable {

	private static final long serialVersionUID = 976212696659106943L;

	private Long id;
	private String introduce; // 商品介绍
	private Date updateTime; // 更新时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
