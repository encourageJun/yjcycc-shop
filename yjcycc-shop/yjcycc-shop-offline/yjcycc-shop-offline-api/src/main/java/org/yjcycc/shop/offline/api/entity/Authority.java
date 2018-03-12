package org.yjcycc.shop.offline.api.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 实体类 -- 权限
 * @author Yangjun
 *
 */
@Alias("authority")
public class Authority implements Serializable {

	private static final long serialVersionUID = -7011075459058602392L;

	private Long id;
	
	private String name; // 权限名称
	
	private Long parentId; // 父权限id

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
