package com.icss.vo;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.icss.util.RowMapper;


public class OrderVO implements RowMapper<OrderVO>{
	
	private Integer orderId;
	private Integer roseId;
	private Integer userId;
	private String account;
	private Integer recInfoId;
	private String orderNo;
	private String orderName;
	private Float money;
	private String status;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer num;
	private Timestamp cTime;
	private String signs;
	private String bless;
	private String roseName;
	private String picture;
	private Float rosePrice;
	private String consignee;
	private String address;
	private String mobile;
	private String postcode;
	private String privince;
	private String city;
	private String area;

	@Override
	public OrderVO mapRow(ResultSet rs, int index) throws Exception {
		OrderVO vo = new OrderVO();
		vo.setOrderId(rs.getInt("orderId"));
		vo.setRoseId(rs.getInt("roseId"));
		vo.setUserId(rs.getInt("userId"));
		vo.setAccount(rs.getString("account"));
		vo.setRecInfoId(rs.getInt("recInfoId"));
		vo.setOrderNo(rs.getString("orderNo"));
		vo.setOrderName(rs.getString("orderName"));
		vo.setMoney(rs.getFloat("money"));
		vo.setStatus(rs.getString("status"));
		vo.setStartTime(rs.getTimestamp("startTime"));
		vo.setEndTime(rs.getTimestamp("endTime"));
		vo.setNum(rs.getInt("num"));
		vo.setcTime(rs.getTimestamp("cTime"));
		vo.setSigns(rs.getString("signs"));
		vo.setBless(rs.getString("bless"));
		vo.setRoseName(rs.getString("roseName"));
		vo.setPicture(rs.getString("picture"));
		vo.setRosePrice(rs.getFloat("rosePrice"));
		vo.setConsignee(rs.getString("consignee"));
		vo.setAddress(rs.getString("address"));
		vo.setMobile(rs.getString("mobile"));
		vo.setPostcode(rs.getString("postcode"));
		vo.setPrivince(rs.getString("privince"));
		vo.setCity(rs.getString("city"));
		vo.setArea(rs.getString("area"));
		return vo;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getRoseId() {
		return roseId;
	}

	public void setRoseId(Integer roseId) {
		this.roseId = roseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getRecInfoId() {
		return recInfoId;
	}

	public void setRecInfoId(Integer recInfoId) {
		this.recInfoId = recInfoId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Timestamp getcTime() {
		return cTime;
	}

	public void setcTime(Timestamp cTime) {
		this.cTime = cTime;
	}

	public String getSigns() {
		return signs;
	}

	public void setSigns(String signs) {
		this.signs = signs;
	}

	public String getBless() {
		return bless;
	}

	public void setBless(String bless) {
		this.bless = bless;
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

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPostcode() {
		return postcode;
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

	public Float getRosePrice() {
		return rosePrice;
	}

	public void setRosePrice(Float rosePrice) {
		this.rosePrice = rosePrice;
	}
	
}
