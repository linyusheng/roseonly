package com.icss.dao;

import java.util.List;

import com.icss.po.Shopping;
import com.icss.vo.ShoppingVO;

public class ShoppingDAO extends DAOSupport<Shopping>{

	@Override
	public void add(Shopping vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_shopping values(null,?,?,?)";
		db.execute(sql, vo.getUserId(),vo.getRoseId(),vo.getNum());
		
	}

	@Override
	public void modify(Shopping vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_shopping set userId = ?,roseId = ?,num = ? where shoppingId = ?";
		db.execute(sql, vo.getUserId(), vo.getRoseId(), vo.getNum(), vo.getShoppingId());
	}

	@Override
	public void delete(Shopping vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_shopping where shoppingId = ?";
		db.execute(sql, vo.getShoppingId());
	}

	@Override
	public List<Shopping> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_shopping";
		return db.list(sql, new Shopping());
	}

	@Override
	public Shopping findById(Shopping vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_shopping where shoppingId = ?";
		return db.get(sql, new Shopping(),vo.getShoppingId());
	}
	
	public Shopping findByUserIdandRoseId(Integer userId,Integer roseId) throws Exception{
		String sql = "select * from t_shopping where userId = ? and roseId = ?";
    	return db.get(sql, new Shopping(), userId, roseId);
    }
	/**
     * 查找用户购物车列表
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Shopping> findByUser(Integer userId) throws Exception {
		String sql = "SELECT * FROM t_shopping WHERE userId=?";
		return db.list(sql, new Shopping(),userId);
	}
    /**
     * 查找用户购物车列表(视图)
     * @param userId
     * @return
     * @throws Exception
     */
    public List<ShoppingVO> findByUserId(Integer userId) throws Exception {
		String sql = "SELECT shoppingId,userId,num,t_rose.* FROM t_shopping, t_rose ";
		sql += "WHERE t_shopping.roseId=t_rose.roseId AND userId=?";
		return db.list(sql, new ShoppingVO(),userId);
	}
    public void deleteAll(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_shopping where userId = ?";
		db.execute(sql, userId);
	} 
}
