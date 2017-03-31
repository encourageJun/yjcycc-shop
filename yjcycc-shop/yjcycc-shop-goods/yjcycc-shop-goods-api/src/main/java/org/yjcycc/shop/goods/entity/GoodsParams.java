package org.yjcycc.shop.goods.entity;

import java.io.Serializable;

/**
 * 实体类-商品参数表
 * @author Yangjun
 *
 */

public class GoodsParams implements Serializable {

	private static final long serialVersionUID = 4548386295871653661L;

	private Long id;
	private String fabric;    // 面料
	private String producer;  // 产地

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

}
