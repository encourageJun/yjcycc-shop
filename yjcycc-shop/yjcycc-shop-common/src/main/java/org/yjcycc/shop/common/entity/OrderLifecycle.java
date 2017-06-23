package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类-订单生命周期
 * 
 * @author Yangjun
 *
 */

public class OrderLifecycle implements Serializable {

	private static final long serialVersionUID = 9060133406622213966L;

	private String id;
	private String orderId; // 订单id
	private Integer operateType; // 操作类型，1下单 2支付 3申请退款...
	private Integer operateClient; // 操作终端，1PC 2手机App 3微信...
	private Date operateTime; // 操作时间
	private String operateReason; // 操作原因
	private String summary; // 摘要
	private String remark; // 备注

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public Integer getOperateClient() {
		return operateClient;
	}

	public void setOperateClient(Integer operateClient) {
		this.operateClient = operateClient;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateReason() {
		return operateReason;
	}

	public void setOperateReason(String operateReason) {
		this.operateReason = operateReason;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
