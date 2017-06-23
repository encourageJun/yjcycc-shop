package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类- 基础数据-行政区域-区县
 * 
 * @author Yangjun
 *
 */

public class BaseAreaDistrict implements Serializable {

	private static final long serialVersionUID = -1869788756864212522L;

	private String id;
	private String cityId; // 城市id
	private String name; // 名称
	private String stdCode; // 国家标准行政编码-区县
	private Date insertTime; // 创建时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStdCode() {
		return stdCode;
	}

	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
