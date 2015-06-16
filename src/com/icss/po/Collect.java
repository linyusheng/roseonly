package com.icss.po;

import java.sql.ResultSet;

import com.icss.util.RowMapper;

/**
 * TCollect entity. @author MyEclipse Persistence Tools
 */

public class Collect implements RowMapper<Collect> {

	// Fields

	private Integer collectId;
	private Integer roseId;
	private Integer userId;

	@Override
	public Collect mapRow(ResultSet rs, int index) throws Exception {
		Collect collect = new Collect();
		collect.setCollectId(rs.getInt("collectId"));
		collect.setRoseId(rs.getInt("roseId"));
		collect.setUserId(rs.getInt("userId"));
		return collect;
	}
	
	// Property accessors

	public Integer getCollectId() {
		return this.collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
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





}