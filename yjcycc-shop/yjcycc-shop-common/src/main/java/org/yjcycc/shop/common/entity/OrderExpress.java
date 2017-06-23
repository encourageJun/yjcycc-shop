package org.yjcycc.shop.common.entity;

import java.io.Serializable;

/**
 * 实体类-订单物流信息
 * 
 * @author Yangjun
 *
 */

public class OrderExpress implements Serializable {

	private static final long serialVersionUID = -1596981742182915020L;

	private String id;
	private String expressCompanyId; // 快递公司id
	private Double expressFee; // 快递费用

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(String expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	public Double getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(Double expressFee) {
		this.expressFee = expressFee;
	}

}
