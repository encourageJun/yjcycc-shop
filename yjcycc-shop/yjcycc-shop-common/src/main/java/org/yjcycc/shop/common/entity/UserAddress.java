package org.yjcycc.shop.common.entity;

import java.io.Serializable;

/**
 * 实体类- 用户-收货地址
 * 
 * @author Yangjun
 *
 */

public class UserAddress implements Serializable {

	private static final long serialVersionUID = -8589214809642197213L;

	private String id;
	private String customId; // 用户id
	private String receiver; // 收货人
	private String mobile; // 收货人电话
	private String provinceId; // 省份id
	private String cityId; // 城市id
	private String districtId; // 区县id
	private String address; // 地址

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
