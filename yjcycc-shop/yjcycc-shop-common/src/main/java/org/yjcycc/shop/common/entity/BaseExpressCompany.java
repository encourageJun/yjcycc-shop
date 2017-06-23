package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类- 基础数据-快递公司
 * 
 * @author Yangjun
 *
 */

public class BaseExpressCompany implements Serializable {

	private static final long serialVersionUID = -5512234210201588320L;

	private String id;
	private String name; // 快递公司名称
	private String code; // 快递公司通用编码
	private Date insertTime; // 创建时间
	private Date updateTime; // 更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
