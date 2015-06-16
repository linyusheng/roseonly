package com.icss.po;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.icss.util.RowMapper;

/**
 * TRose entity. @author MyEclipse Persistence Tools
 */

public class Rose implements RowMapper<Rose> {

	// Fields

	private Integer roseId;
	private Integer brandId;
	private String roseName;
	private String picture;
	private String roseInfo;
	private Float discount;
	private Float rosePrice;
	private Timestamp createTime;
	private Integer roseNum;
	private Boolean status;
	private String details;

	@Override
	public Rose mapRow(ResultSet rs, int index) throws Exception {
		Rose rose = new Rose();
		rose.setRoseId(rs.getInt("roseId"));
		rose.setBrandId(rs.getInt("brandId"));
		rose.setRoseName(rs.getString("roseName"));
		rose.setPicture(rs.getString("picture"));
		rose.setRoseInfo(rs.getString("roseInfo"));
		rose.setDiscount(rs.getFloat("discount"));
		rose.setRosePrice(rs.getFloat("rosePrice"));
		rose.setCreateTime(rs.getTimestamp("createTime"));
		rose.setRoseNum(rs.getInt("roseNum"));
		rose.setStatus(rs.getBoolean("status"));
		rose.setDetails(rs.getString("details"));
		return rose;
	}

	public Integer getRoseId() {
		return roseId;
	}

	public void setRoseId(Integer roseId) {
		this.roseId = roseId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getRoseName() {
		return roseName;
	}

	public void setRoseName(String roseName) {
		this.roseName = roseName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getRoseInfo() {
		return roseInfo;
	}

	public void setRoseInfo(String roseInfo) {
		this.roseInfo = roseInfo;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Float getRosePrice() {
		return rosePrice;
	}

	public void setRosePrice(Float rosePrice) {
		this.rosePrice = rosePrice;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getRoseNum() {
		return roseNum;
	}

	public void setRoseNum(Integer roseNum) {
		this.roseNum = roseNum;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}