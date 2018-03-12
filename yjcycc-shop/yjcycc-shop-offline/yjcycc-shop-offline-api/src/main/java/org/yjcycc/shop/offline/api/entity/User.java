package org.yjcycc.shop.offline.api.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 实体类 -- 用户
 * @author Yangjun
 *
 */

@Alias("user")
public class User implements Serializable {

	private static final long serialVersionUID = 6359101379760774633L;

	private Long id;
	
	private String realName; // 姓名
	
	private String mobile; // 手机号
	
	private String weixin; // 微信号
	
	private String qq; // qq号
	
	private Long levelId;// 用户等级id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	
}
