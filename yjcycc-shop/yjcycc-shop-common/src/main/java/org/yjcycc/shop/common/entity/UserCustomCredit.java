package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类-用户-实名认证
 * 
 * @author Yangjun
 *
 */

public class UserCustomCredit implements Serializable {

	private static final long serialVersionUID = 3644124700302548636L;

	private String id;
	private String customId; // 用户id
	private String idCard; // 身份证号码
	private String idCardFrontImg; // 身份证正面照
	private String idCardBackImg; // 身份证反面照
	private String realName; // 姓名
	private Date insertTime; // 插入时间
	private Date updateTime; // 更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCardFrontImg() {
		return idCardFrontImg;
	}

	public void setIdCardFrontImg(String idCardFrontImg) {
		this.idCardFrontImg = idCardFrontImg;
	}

	public String getIdCardBackImg() {
		return idCardBackImg;
	}

	public void setIdCardBackImg(String idCardBackImg) {
		this.idCardBackImg = idCardBackImg;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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
}
