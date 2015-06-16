package com.icss.vo;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.icss.util.RowMapper;

/**
 * 用户视图类
 * @author 林玉生
 *
 */
public class UserVO implements RowMapper<UserVO>{
	
	private Integer userId;
	private Integer typeId;
	private String	typeName;
	private String account;
	private String password;
	private String mobile;
	private String email;
	private Timestamp createTime;

	@Override
	public UserVO mapRow(ResultSet rs, int index) throws Exception {
		UserVO vo = new UserVO();
		vo.setUserId(rs.getInt("userId"));
		vo.setTypeId(rs.getInt("typeId"));
		vo.setTypeName(rs.getString("typeName"));
		vo.setAccount(rs.getString("account"));	
		vo.setPassword(rs.getString("password"));
		vo.setMobile(rs.getString("mobile"));
		vo.setEmail(rs.getString("email"));	
		vo.setCreateTime(rs.getTimestamp("createTime"));
		return vo;
	}

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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
