package com.icss.dao;

import java.util.List;

import com.icss.po.Brand;

public class BrandDAO extends DAOSupport<Brand>{

	@Override
	public void add(Brand vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_brand values(null,?,?)";
		db.execute(sql, vo.getParentId(), vo.getBrandName());
	}

	@Override
	public void modify(Brand vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_brand set brandName = ? where brandId = ?";
		db.execute(sql, vo.getBrandName(), vo.getBrandId());
	}

	@Override
	public void delete(Brand vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_brand where brandId = ?";
		db.execute(sql, vo.getBrandId());
	}

	@Override
	public List<Brand> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_brand";
		return db.list(sql, new Brand());
	}

	@Override
	public Brand findById(Brand vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_brand where brandId = ?";
		return db.get(sql, new Brand(), vo.getBrandId());
	}
	/**
	 * 根据品牌名查找对象
	 */
	public Brand findByBrandName(String name) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_brand where brandName = ?";
		return db.get(sql, new Brand(), name);
	}
	

}
