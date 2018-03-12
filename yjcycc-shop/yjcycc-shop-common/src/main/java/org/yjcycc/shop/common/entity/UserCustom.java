package org.yjcycc.shop.common.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类-用户
 * @author Yangjun
 *
 */

@Alias("userCustom")
public class UserCustom implements Serializable {

	private static final long serialVersionUID = -5588922233549903724L;

	private String id;
	private String mobile; // 用户手机
	private String password; // 登录密码
	private String payPassword; // 支付密码
	private String nick; // 昵称
	private Date insertTime; // 插入时间
	private Date updateTime; // 更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
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

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

}
