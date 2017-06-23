package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类- 支付-微信支付
 * 
 * @author Yangjun
 *
 */

public class PaymentWechat implements Serializable {

	private static final long serialVersionUID = -7469169258653084584L;

	private String id;
	private String orderId; // 订单id
	private String code; // 微信账单编码，账单唯一标识
	private Integer isSuccess; // 是否支付成功，0成功 99失败
	private String returnMessage; // 请求返回报文
	private String message; // 返回报文消息
	private String remark; // 备注
	private Date insertTime; // 创建时间

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
