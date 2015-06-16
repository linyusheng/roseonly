package com.icss.po;

import java.sql.ResultSet;

import com.icss.util.RowMapper;

/**
 * TUtype entity. @author MyEclipse Persistence Tools
 */

public class Utype implements RowMapper<Utype> {

	// Fields

	private Integer typeId;
	private String typeName;
	
	@Override
	public Utype mapRow(ResultSet rs, int index) throws Exception {
		Utype utype = new Utype();
		utype.setTypeId(rs.getInt("typeId"));
		utype.setTypeName(rs.getString("typeName"));
		return utype;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}