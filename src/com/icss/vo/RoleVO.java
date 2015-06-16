package com.icss.vo;

import java.sql.ResultSet;
import java.util.List;

import com.icss.po.User;
import com.icss.util.RowMapper;

public class RoleVO implements RowMapper<RoleVO>{
	
	private Integer typeId;
	private String typeName;
	private List<User> uList;
	
	@Override
	public RoleVO mapRow(ResultSet rs, int index) throws Exception {
		RoleVO vo = new RoleVO();
		vo.setTypeId(rs.getInt("typeId"));
		vo.setTypeName(rs.getString("typeName"));
		return vo;
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

	public List<User> getuList() {
		return uList;
	}


	public void setuList(List<User> uList) {
		this.uList = uList;
	}
	
}
