package org.yjcycc.shop.offline.api.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 实体类 -- 角色
 * @author Yangjun
 *
 */

@Alias("role")
public class Role implements Serializable {

	private static final long serialVersionUID = 7249066077217086717L;

	private Long id;
	
	private String name; // 角色名称

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
