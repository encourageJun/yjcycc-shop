package org.yjcycc.shop.common.entity;

import java.io.Serializable;

/**
 * 实体类- 订单项-订单包裹关联表
 * 
 * @author Yangjun
 *
 */

public class OrderItemShipping implements Serializable {

	private static final long serialVersionUID = -7692240277861768439L;
	
	private String id;
	private String orderItemId; // 订单项id
	private String orderShippingId; // 订单包裹id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderShippingId() {
		return orderShippingId;
	}

	public void setOrderShippingId(String orderShippingId) {
		this.orderShippingId = orderShippingId;
	}

}
