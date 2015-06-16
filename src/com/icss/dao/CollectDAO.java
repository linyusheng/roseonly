package com.icss.dao;

import java.util.List;

import com.icss.po.Collect;
import com.icss.vo.CollectVO;

public class CollectDAO extends DAOSupport<Collect>{

	@Override
	public void add(Collect vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_collect values(null,?,?)";
		db.execute(sql, vo.getUserId(), vo.getRoseId());
	}

	@Override
	public void modify(Collect vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Collect vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_collect where collectId = ?";
		db.execute(sql, vo.getCollectId());
	}

	@Override
	public List<Collect> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_collect";
		return db.list(sql, new Collect());
	}

	@Override
	public Collect findById(Collect vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_collect where collectId = ?";
		return db.get(sql, new Collect(),vo.getCollectId());
	}
	/**
	 * 查询用户收藏(视图)
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<CollectVO> findByUserId(Integer userId) throws Exception{
		String sql = "SELECT c.*,r.roseName,r.picture,r.rosePrice ";
		sql += "FROM t_collect AS c, t_rose AS r ";
		sql += "WHERE c.roseId=r.roseId AND userId=?";
		return db.list(sql, new CollectVO(),userId);
	}
	/**
	 * 根据useId和roseId查收藏
	 */
	public Collect findByUserIdAndRoseId(Collect vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_collect where userId = ? and roseId = ?";
		return db.get(sql, new Collect(),vo.getUserId(), vo.getRoseId());
	}
}
