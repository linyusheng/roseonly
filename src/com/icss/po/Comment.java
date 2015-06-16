package com.icss.po;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.icss.util.RowMapper;

/**
 * TComment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements RowMapper<Comment> {

	// Fields

	private Integer commentId;
	private Integer orderId;
	private String content;
	private Timestamp createTime;

	@Override
	public Comment mapRow(ResultSet rs, int index) throws Exception {
		Comment comment = new Comment();
		comment.setCommentId(rs.getInt("commentId"));
		comment.setOrderId(rs.getInt("orderId"));
		comment.setContent(rs.getString("content"));
		comment.setCreateTime(rs.getTimestamp("createTime"));
		return comment;
	}
	
	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}



}