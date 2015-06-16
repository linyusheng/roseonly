package com.icss.dao;

import java.util.List;

import com.icss.po.Rose;
import com.icss.vo.PageVO;
import com.icss.vo.UserVO;

public class RoseDAO extends DAOSupport<Rose>{

	@Override
	public void add(Rose vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_rose values(null,?,?,?,?,?,?,?,?,?)";
		db.execute(sql, vo.getBrandId(), vo.getRoseName(), vo.getPicture(),
				vo.getRoseInfo(), vo.getDiscount(), vo.getRosePrice(), 
				vo.getCreateTime(), vo.getRoseNum(), vo.getStatus());
	}

	@Override
	public void modify(Rose vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_rose set brandId = ?, roseName = ?, picture = ?," +
				"roseInfo = ?, discount = ?, rosePrice = ?," +
				"createTime = ?, roseNum = ?, status = ?, details = ? where roseId = ?";
		db.execute(sql, vo.getBrandId(), vo.getRoseName(), vo.getPicture(),
				vo.getRoseInfo(), vo.getDiscount(), vo.getRosePrice(), 
				vo.getCreateTime(), vo.getRoseNum(), vo.getStatus(), vo.getDetails(), vo.getRoseId());
	}

	@Override
	public void delete(Rose vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_rose where roseId = ?";
		db.execute(sql, vo.getRoseId());
	}

	@Override
	public List<Rose> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_rose";
		return db.list(sql, new Rose());
	}

	@Override
	public Rose findById(Rose vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_rose where roseId = ?";
		return db.get(sql, new Rose(), vo.getRoseId());
	}
	public List<Rose> roseList(Integer brandId) throws Exception{
		String sql = "select * from t_rose where brandId = ?";
		return db.list(sql, new Rose(), brandId);
		
	}
	/**
	 * 获得所有玫瑰（视图）
	 * @param page
	 * @param rowMax
	 * @return
	 * @throws Exception
	 */
	public PageVO<Rose> getAllRose(PageVO<Rose> pageVO) throws Exception {
		String sql = "select * from t_rose";
		return page(sql, pageVO.getPage(), pageVO.getRowMax(), new Rose());
	}
}
