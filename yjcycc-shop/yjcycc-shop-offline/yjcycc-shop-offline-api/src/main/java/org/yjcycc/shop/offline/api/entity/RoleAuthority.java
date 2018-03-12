package org.yjcycc.shop.offline.api.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("roleAuthority")
public class RoleAuthority implements Serializable {

	private static final long serialVersionUID = -1608898577914862533L;

	private Role role;
	
	private Authority authority;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
}
