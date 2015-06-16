package com.icss.vo;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.icss.util.RowMapper;

public class ShoppingVO implements RowMapper<ShoppingVO>{
	
	private Integer shoppingId;
	private Integer userId;
	private Integer roseId;
	private Integer num;
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
	public ShoppingVO mapRow(ResultSet rs, int index) throws Exception {
		ShoppingVO vo = new ShoppingVO();
		vo.setShoppingId(rs.getInt("shoppingId"));
		vo.setUserId(rs.getInt("userId"));
		vo.setRoseId(rs.getInt("roseId"));
		vo.setNum(rs.getInt("num"));
		vo.setBrandId(rs.getInt("brandId"));
		vo.setRoseName(rs.getString("roseName"));
		vo.setPicture(rs.getString("picture"));
		vo.setRoseInfo(rs.getString("roseInfo"));
		vo.setDiscount(rs.getFloat("discount"));
		vo.setRosePrice(rs.getFloat("rosePrice"));
		vo.setCreateTime(rs.getTimestamp("createTime"));
		vo.setRoseNum(rs.getInt("roseNum"));
		vo.setStatus(rs.getBoolean("status"));
		vo.setDetails(rs.getString("details"));
		return vo;
	}


	public Integer getShoppingId() {
		return shoppingId;
	}


	public void setShoppingId(Integer shoppingId) {
		this.shoppingId = shoppingId;
	}

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getRoseId() {
		return roseId;
	}


	public void setRoseId(Integer roseId) {
		this.roseId = roseId;
	}

	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
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
