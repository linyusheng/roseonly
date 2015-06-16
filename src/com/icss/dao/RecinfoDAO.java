package com.icss.dao;

import java.util.List;

import com.icss.po.Recinfo;

public class RecinfoDAO extends DAOSupport<Recinfo>{

	@Override
	public void add(Recinfo vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_recinfo values(null,?,?,?,?,?,?,?,?)";
		db.execute(sql, vo.getUserId(), vo.getConsignee(),
				vo.getAddress(), vo.getMobile(), vo.getPostcode(), 
				vo.getPrivince(), vo.getCity(), vo.getArea());
	}

	@Override
	public void modify(Recinfo vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_recinfo set userId = ?,consignee = ?,"
				+ "address = ?,mobile = ?,postcode = ?,privince = ?,city = ?,area = ? "
				+ "where recInfoId = ?";
		db.execute(sql, vo.getUserId(),vo.getConsignee(),
				vo.getAddress(),vo.getMobile(),vo.getPostcode(),
				vo.getPrivince(), vo.getCity(), vo.getArea(),
				vo.getRecInfoId());
		
		
	}

	@Override
	public void delete(Recinfo vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_recinfo where recInfoId = ?";
		db.execute(sql, vo.getRecInfoId());
	}

	@Override
	public List<Recinfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_recinfo";
		return db.list(sql, new Recinfo());
	}

	@Override
	public Recinfo findById(Recinfo vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_recinfo where recInfoId = ?";
		return db.get(sql, new Recinfo(), vo.getRecInfoId());
	}
	/**
	 * 查找用户的所有收货地址
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Recinfo> findByUserId(Integer userId) throws Exception{
		String sql = "select * from t_recinfo where userId = ? order by recInfoId desc";
		return db.list(sql, new Recinfo(), userId);
	}
	

}
