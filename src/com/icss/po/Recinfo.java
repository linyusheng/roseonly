package com.icss.po;

import java.sql.ResultSet;

import com.icss.util.RowMapper;

/**
 * TRecinfo entity. @author MyEclipse Persistence Tools
 */

public class Recinfo implements RowMapper<Recinfo> {

	// Fields

	private Integer recInfoId;
	private Integer userId;
	private String consignee;
	private String address;
	private String mobile;
	private String postcode;
	private String privince;
	private String city;
	private String area;

	@Override
	public Recinfo mapRow(ResultSet rs, int index) throws Exception {
		Recinfo recinfo = new Recinfo();
		recinfo.setRecInfoId(rs.getInt("recInfoId"));
		recinfo.setUserId(rs.getInt("userId"));
		recinfo.setConsignee(rs.getString("consignee"));
		recinfo.setAddress(rs.getString("address"));
		recinfo.setMobile(rs.getString("mobile"));
		recinfo.setPostcode(rs.getString("postcode"));
		recinfo.setPrivince(rs.getString("privince"));
		recinfo.setCity(rs.getString("city"));
		recinfo.setArea(rs.getString("area"));
		return recinfo;
	}
	
	// Property accessors

	public Integer getRecInfoId() {
		return this.recInfoId;
	}

	public void setRecInfoId(Integer recInfoId) {
		this.recInfoId = recInfoId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPrivince() {
		return privince;
	}

	public void setPrivince(String privince) {
		this.privince = privince;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	

}