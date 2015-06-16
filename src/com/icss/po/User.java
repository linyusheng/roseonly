package com.icss.po;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.icss.util.RowMapper;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class User implements RowMapper<User> {

	// Fields

	private Integer userId;
	private Integer typeId;
	private String account;
	private String password;
	private String mobile;
	private String email;
	private Timestamp createTime;

	@Override
	public User mapRow(ResultSet rs, int index) throws Exception {
		User user = new User();
		user.setUserId(rs.getInt("userId"));	
		user.setTypeId(rs.getInt("typeId"));
		user.setAccount(rs.getString("account"));	
		user.setPassword(rs.getString("password"));
		user.setMobile(rs.getString("mobile"));
		user.setEmail(rs.getString("email"));	
		user.setCreateTime(rs.getTimestamp("createTime"));
		return user;
	}

	// Property accessors
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}