package com.icss.dao;

import java.util.List;

import com.icss.po.Comment;

public class CommentDAO extends DAOSupport<Comment>{

	@Override
	public void add(Comment vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_comment values(null,?,?,?)";
		db.execute(sql, vo.getOrderId(),vo.getContent(),vo.getCreateTime());
		
			
		}

	@Override
	public void modify(Comment vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_comment set orderId = ?,content = ?,createTime = ? where commentId = ?";
		db.execute(sql, vo.getOrderId(),vo.getContent(),vo.getCreateTime(),vo.getCommentId());
		
		
	}

	@Override
	public void delete(Comment vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_comment where commentId = ?";
		db.execute(sql, vo.getCommentId());
	}

	@Override
	public List<Comment> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_comment";
		return db.list(sql, new Comment());
	}

	@Override
	public Comment findById(Comment vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_comment where commentId = ?";
		return db.get(sql, new Comment(), vo.getCommentId());
	}
	

}
