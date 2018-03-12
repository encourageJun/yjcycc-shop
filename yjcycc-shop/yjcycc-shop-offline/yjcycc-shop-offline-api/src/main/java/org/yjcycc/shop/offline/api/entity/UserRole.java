package org.yjcycc.shop.offline.api.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 
 * @ClassName: UserRole 
 * @Description: 用户角色实体类
 * @author yangjun 
 * @date 2017年11月20日 下午5:46:50 
 *
 */

@Alias("userRole")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1373348900475108221L;

	private User user;
	
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
