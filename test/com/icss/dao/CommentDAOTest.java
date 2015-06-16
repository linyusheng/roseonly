package com.icss.dao;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Comment;

import junit.framework.TestCase;

public class CommentDAOTest extends TestCase {
	private CommentDAO dao = new CommentDAO();
	Comment comment = new Comment();
	
	@Ignore
    @Test
	public void testAddComment() throws Exception {
		comment.setOrderId(null);
		comment.setContent(null);
		comment.setCreateTime(null);
		dao.add(comment);
		
	}
	
	@Ignore
    @Test
	public void testModifyComment() throws Exception {
		comment.setOrderId(null);
		comment.setContent(null);
		comment.setCreateTime(null);
		comment.setCommentId(null);
		dao.modify(comment);
	}
    
	@Ignore
    @Test
	public void testDeleteComment() throws Exception {
    	comment.setCommentId(null);
    	dao.delete(comment);
	}
    
	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}
	
	@Ignore
	@Test
	public void testFindByIdComment() throws Exception {
		comment.setCommentId(2);
		System.out.println(dao.findById(comment).getCommentId());
	}

}
