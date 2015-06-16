package com.icss.po;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.icss.util.RowMapper;

/**
 * TStory entity. @author MyEclipse Persistence Tools
 */

public class Story implements RowMapper<Story> {

	// Fields

	private Integer storyId;
	private String storyName;
	private String storyContent;
	private String picture;
	private Timestamp createTime;

	@Override
	public Story mapRow(ResultSet rs, int index) throws Exception {
		Story story = new Story();
		story.setStoryId(rs.getInt("storyId"));
		story.setStoryName(rs.getString("storyName"));
		story.setStoryContent(rs.getString("storyContent"));
		story.setPicture(rs.getString("picture"));
		story.setCreateTime(rs.getTimestamp("createTime"));
		return story;
	}
	
	// Property accessors

	public Integer getStoryId() {
		return this.storyId;
	}

	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}

	public String getStoryName() {
		return this.storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public String getStoryContent() {
		return this.storyContent;
	}

	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}