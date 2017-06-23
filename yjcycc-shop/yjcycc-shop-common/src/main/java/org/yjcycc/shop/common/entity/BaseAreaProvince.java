package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类- 基础数据-行政区域-省份
 * @author Yangjun
 *
 */

public class BaseAreaProvince implements Serializable {

	private static final long serialVersionUID = 5007903629651427398L;

	private String id;
	private String name; // 名称
	private Integer stdCode; // 国家标准行政编码-省份
	private Date insertTime; // 创建时间

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

	public Integer getStdCode() {
		return stdCode;
	}

	public void setStdCode(Integer stdCode) {
		this.stdCode = stdCode;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
