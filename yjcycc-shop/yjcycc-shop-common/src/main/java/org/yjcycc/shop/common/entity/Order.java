package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类-订单
 * 
 * @author Yangjun
 *
 */

public class Order implements Serializable {

	private static final long serialVersionUID = 2802251418821213712L;

	private String id;
	private String code; // 订单编号
	private Double goodsTotalPrice; // 商品总价
	private Double goodsTotalPriceModified; // 修改后的商品总价，下单后支持改价
	private Integer status; // 订单状态
	private String customId; // 用户id
	private String activityId; // 活动id
	private String couponId; // 优惠券id
	private String expressId; // 快递id
	private String paymentId; // 支付id
	private Date insertTime; // 创建时间
	private Date updateTime; // 更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getGoodsTotalPrice() {
		return goodsTotalPrice;
	}

	public void setGoodsTotalPrice(Double goodsTotalPrice) {
		this.goodsTotalPrice = goodsTotalPrice;
	}

	public Double getGoodsTotalPriceModified() {
		return goodsTotalPriceModified;
	}

	public void setGoodsTotalPriceModified(Double goodsTotalPriceModified) {
		this.goodsTotalPriceModified = goodsTotalPriceModified;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getExpressId() {
		return expressId;
	}

	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
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
