package com.icss.po;

import java.sql.ResultSet;

import com.icss.util.RowMapper;

/**
 * TShopping entity. @author MyEclipse Persistence Tools
 */

public class Shopping implements RowMapper<Shopping> {

	// Fields

	private Integer shoppingId;
	private Integer userId;
	private Integer roseId;
	private Integer num;

	@Override
	public Shopping mapRow(ResultSet rs, int index) throws Exception {
		Shopping shopping = new Shopping();
		shopping.setShoppingId(rs.getInt("shoppingId"));
		shopping.setUserId(rs.getInt("userId"));
		shopping.setRoseId(rs.getInt("roseId"));
		shopping.setNum(rs.getInt("num"));
		return shopping;
	}

	public Integer getShoppingId() {
		return shoppingId;
	}

	public void setShoppingId(Integer shoppingId) {
		this.shoppingId = shoppingId;
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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}