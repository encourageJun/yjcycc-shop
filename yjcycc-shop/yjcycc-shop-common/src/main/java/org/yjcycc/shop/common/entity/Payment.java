package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类-支付
 * 
 * @author Yangjun
 *
 */

public class Payment implements Serializable {

	private static final long serialVersionUID = 5494332236419615247L;

	private String id;
	private Integer status; // 支付状态，1待支付 2已支付...
	private Integer payType; // 支付方式, 1余额 2微信 3支付宝
	private Double goodsTotalPrice; // 商品总价
	private Double expressFee; // 物流费用
	private Double activityFee; // 活动优惠费用
	private Double couponFee; // 优惠券抵扣费用
	private Date insertTime; // 创建时间
	private Date updateTime; // 更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Double getGoodsTotalPrice() {
		return goodsTotalPrice;
	}

	public void setGoodsTotalPrice(Double goodsTotalPrice) {
		this.goodsTotalPrice = goodsTotalPrice;
	}

	public Double getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(Double expressFee) {
		this.expressFee = expressFee;
	}

	public Double getActivityFee() {
		return activityFee;
	}

	public void setActivityFee(Double activityFee) {
		this.activityFee = activityFee;
	}

	public Double getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Double couponFee) {
		this.couponFee = couponFee;
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
