package com.icss.dao;

import java.util.List;

import com.icss.po.Story;

public class StoryDAO extends DAOSupport<Story>{

	@Override
	public void add(Story vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_story values(null,?,?,?,?)";
		db.execute(sql, vo.getStoryName(),vo.getStoryContent(),vo.getPicture(),vo.getCreateTime());
	}

	@Override
	public void modify(Story vo) throws Exception {
		// TODO Auto-generated method stub
		String sql= "update t_story set storyName = ?,storyContent = ?,picture = ?,createTime = ? where storyId = ?";
		db.execute(sql, vo.getStoryName(),vo.getStoryContent(),vo.getPicture(),vo.getCreateTime(),vo.getStoryId());
	}

	@Override
	public void delete(Story vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_story where storyId = ?";
		db.execute(sql, vo.getStoryId());
		
	}

	@Override
	public List<Story> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_story";
		return db.list(sql, new Story());
	}

	@Override
	public Story findById(Story vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_story where storyId = ?";
		return db.get(sql, new Story(), vo.getStoryId());
	}

}
