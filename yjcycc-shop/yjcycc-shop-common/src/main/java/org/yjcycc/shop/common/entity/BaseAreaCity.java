package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类- 基础数据-行政区域-城市
 * 
 * @author Yangjun
 *
 */

public class BaseAreaCity implements Serializable {

	private static final long serialVersionUID = 5263080337273103227L;

	private String id;
	private String provinceId; // 省份id
	private String name; // 名称
	private Integer stdCode; // 国家标准行政编码-城市
	private Integer baiduCityCode; // 百度城市编码
	private Double centerLng; // 市中心经度
	private Double centerLat; // 市中心纬度
	private Date insertTime; // 创建时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
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

	public Integer getBaiduCityCode() {
		return baiduCityCode;
	}

	public void setBaiduCityCode(Integer baiduCityCode) {
		this.baiduCityCode = baiduCityCode;
	}

	public Double getCenterLng() {
		return centerLng;
	}

	public void setCenterLng(Double centerLng) {
		this.centerLng = centerLng;
	}

	public Double getCenterLat() {
		return centerLat;
	}

	public void setCenterLat(Double centerLat) {
		this.centerLat = centerLat;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
