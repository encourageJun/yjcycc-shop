package org.yjcycc.shop.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 实体类-商品基本信息表
 * @author Yangjun
 *
 */

@Alias("goods")
public class Goods implements Serializable {

	private static final long serialVersionUID = -610525676727417054L;

	private Long id;
	private String name; // 商品名称
	private String description; // 商品描述
	
	// seo
	private String metaDescription; // 搜索引擎seo，商品描述
	private String metaKeywords; // 搜索引擎seo，商品标签
	
	// 价格
	private Double costPrice; // 成本价(作统计用)
	private Double marketPrice; // 市场价
	private Double price; // 实际价格
	
	// 库存
	private Long stock; // 库存
	private Long initSales; // 初始销量(50~500之间的随机数)
	private Long realSales; // 实际销量
	
	// 颜色和尺码
	private String colorSize; // 颜色-尺码组合信息
	
	// 业务相关
	private Integer isShelvesUp; // 是否上架(1是0否)
	private Integer isPreSale; // 是否预售(1是0否)
	
	// 外键
	private Long goodsCategoryId; // 商品分类id
	private Long goodsIntroduceId; // 商品介绍id
	private Long goodsParamsId; // 商品参数id
	
	// 时间
	private Date insertTime; // 插入时间
	private Date updateTime; // 更新时间

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getInitSales() {
		return initSales;
	}

	public void setInitSales(Long initSales) {
		this.initSales = initSales;
	}

	public Long getRealSales() {
		return realSales;
	}

	public void setRealSales(Long realSales) {
		this.realSales = realSales;
	}

	public String getColorSize() {
		return colorSize;
	}

	public void setColorSize(String colorSize) {
		this.colorSize = colorSize;
	}

	public Integer getIsShelvesUp() {
		return isShelvesUp;
	}

	public void setIsShelvesUp(Integer isShelvesUp) {
		this.isShelvesUp = isShelvesUp;
	}

	public Integer getIsPreSale() {
		return isPreSale;
	}

	public void setIsPreSale(Integer isPreSale) {
		this.isPreSale = isPreSale;
	}

	public Long getGoodsCategoryId() {
		return goodsCategoryId;
	}

	public void setGoodsCategoryId(Long goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}

	public Long getGoodsIntroduceId() {
		return goodsIntroduceId;
	}

	public void setGoodsIntroduceId(Long goodsIntroduceId) {
		this.goodsIntroduceId = goodsIntroduceId;
	}

	public Long getGoodsParamsId() {
		return goodsParamsId;
	}

	public void setGoodsParamsId(Long goodsParamsId) {
		this.goodsParamsId = goodsParamsId;
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
