package com.icss.service;

import java.util.List;

import com.icss.dao.CommentDAO;
import com.icss.po.Comment;

public class CommentService {

	private CommentDAO commentDAO = new CommentDAO();
	
	/**
	 * 功能：添加评论
	 * @param comment
	 * @throws Exception
	 */
	public void addComment(Comment comment) throws Exception{
		commentDAO.add(comment);
	}
	
	/**
	 * 功能：修改评论
	 * @param comment
	 * @throws Exception
	 */
	public void modifyComment(Comment comment) throws Exception{
		commentDAO.modify(comment);
	}
	
	/**
	 * 功能：删除评论
	 * @param comment
	 * @throws Exception
	 */
	public void deleteComment(Comment comment) throws Exception{
		commentDAO.delete(comment);
	}
	
	/**
	 * 功能：获取所有评论
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public List<Comment> findAllComment(Comment comment) throws Exception{
		return commentDAO.findAll();
	}
	
	/**
	 * 功能：通过评论ID获取评论
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public Comment findByCommentId(Comment comment) throws Exception{
		return commentDAO.findById(comment);
	}
}
