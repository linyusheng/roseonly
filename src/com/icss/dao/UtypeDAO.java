package com.icss.dao;

import java.util.List;

import com.icss.po.Utype;
import com.icss.vo.RoleVO;

public class UtypeDAO extends DAOSupport<Utype>{

	@Override
	public void add(Utype vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_utype values(null,?)";
		db.execute(sql, vo.getTypeName());
	}

	@Override
	public void modify(Utype vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_utype set typeName = ? where typeId = ?";
		db.execute(sql, vo.getTypeName(), vo.getTypeId());	
	}

	@Override
	public void delete(Utype vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_utype where typeId = ?";
		db.execute(sql, vo.getTypeId());
	}

	@Override
	public List<Utype> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_utype";
		return db.list(sql, new Utype());
	}

	@Override
	public Utype findById(Utype vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_utype where typeId = ?";
		return db.get(sql, new Utype(), vo.getTypeId());
	}
	/**
	 * 获取所有角色（视图）
	 * @return
	 * @throws Exception
	 */
	public List<RoleVO> getAllRole() throws Exception{
		String sql = "SELECT * FROM t_utype GROUP BY typeId";
		return db.list(sql, new RoleVO());
	}

}
