package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 实体类- 基础数据-系统参数
 * 
 * @author Yangjun
 *
 */

@Alias("baseSystemParam")
public class BaseSystemParam implements Serializable {

	private static final long serialVersionUID = -6041333248609105501L;

	private String id;
	private String name; // 参数名称
	private String code; // 参数编码
	private String value; // 参数值
	private Integer dataType; // 值的数据类型(1整数、2数字、3字符串、4日期(yyyy-MM-dd)、5时间(hh:mm:ss)、6日期+时间(yyyy-MM-dd
								// hh:mm:ss))
	private Integer paramLevel; // 系统参数级别(1系统级、2运营级)只有运营级运营人员才能修改
	private Integer isLimitValue; // 是否限定值的范围(1是、0否，默认否)
	private String minValue; // 最小值
	private String maxValue; // 最大值
	private String remark; // 备注
	private Integer isValid; // 是否有效，1有效 0无效，默认1
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public Integer getParamLevel() {
		return paramLevel;
	}

	public void setParamLevel(Integer paramLevel) {
		this.paramLevel = paramLevel;
	}

	public Integer getIsLimitValue() {
		return isLimitValue;
	}

	public void setIsLimitValue(Integer isLimitValue) {
		this.isLimitValue = isLimitValue;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
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
