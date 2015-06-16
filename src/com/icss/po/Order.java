package com.icss.po;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.icss.util.RowMapper;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class Order implements RowMapper<Order> {

	// Fields

	private Integer orderId;
	private Integer roseId;
	private Integer userId;
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

	@Override
	public Order mapRow(ResultSet rs, int index) throws Exception {
		Order order = new Order();
		order.setOrderId(rs.getInt("orderId"));
		order.setRoseId(rs.getInt("roseId"));
		order.setUserId(rs.getInt("userId"));
		order.setRecInfoId(rs.getInt("recInfoId"));
		order.setOrderNo(rs.getString("orderNo"));
		order.setOrderName(rs.getString("orderName"));
		order.setMoney(rs.getFloat("money"));
		order.setStatus(rs.getString("status"));
		order.setStartTime(rs.getTimestamp("startTime"));
		order.setEndTime(rs.getTimestamp("endTime"));
		order.setNum(rs.getInt("num"));
		order.setcTime(rs.getTimestamp("cTime"));
		order.setSigns(rs.getString("signs"));
		order.setBless(rs.getString("bless"));
		return order;
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
	
}