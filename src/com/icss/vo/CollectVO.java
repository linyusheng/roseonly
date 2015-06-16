package com.icss.vo;

import java.sql.ResultSet;

import com.icss.util.RowMapper;

public class CollectVO implements RowMapper<CollectVO>{
	
	private Integer collectId;
	private Integer userId;
	private Integer roseId;
	private String roseName;
	private String picture;
	private Float rosePrice;

	@Override
	public CollectVO mapRow(ResultSet rs, int index) throws Exception {
		CollectVO vo = new CollectVO();
		vo.setCollectId(rs.getInt("collectId"));
		vo.setUserId(rs.getInt("userId"));
		vo.setRoseId(rs.getInt("roseId"));
		vo.setRoseName(rs.getString("roseName"));
		vo.setPicture(rs.getString("picture"));
		vo.setRosePrice(rs.getFloat("rosePrice"));
		return vo;
	}

	public Integer getCollectId() {
		return collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
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

	public Float getRosePrice() {
		return rosePrice;
	}

	public void setRosePrice(Float rosePrice) {
		this.rosePrice = rosePrice;
	}


}
