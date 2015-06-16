package com.icss.service;

import java.util.List;

import com.icss.dao.RoseDAO;
import com.icss.po.Rose;
import com.icss.vo.PageVO;

public class RoseService {
 
	private RoseDAO roseDAO = new RoseDAO();
	
	/**
	 * 功能：添加玫瑰信息
	 * @param rose
	 * @throws Exception
	 */
	public void addRose(Rose rose) throws Exception{
		roseDAO.add(rose);
	}
	
	/**
	 * 功能：修改玫瑰信息
	 * @param rose
	 * @throws Exception
	 */
	public void modifyRose(Rose rose) throws Exception{
		roseDAO.modify(rose);
	}
	
	/**
	 * 功能：删除玫瑰信息
	 * @param rose
	 * @throws Exception
	 */
	public void deleteRose(Rose rose) throws Exception{
		roseDAO.delete(rose);
	}
	
	/**
	 * 功能：获取所有玫瑰信息
	 * @param rose
	 * @return
	 * @throws Exception
	 */
	public List<Rose> findAllRose() throws Exception{
		return roseDAO.findAll();
	}
	
	/**
	 * 功能：通过玫瑰ID获取玫瑰信息
	 * @param rose
	 * @return
	 * @throws Exception
	 */
	public Rose findByRoseId(Rose rose) throws Exception{
		return roseDAO.findById(rose);
		
	}
	/**
	 * 根据类型查询玫瑰
	 * @param brandId
	 * @return
	 * @throws Exception
	 */
	public List<Rose> roseList(Integer brandId) throws Exception{
		return roseDAO.roseList(brandId);
	}
	/**
	 * 获得所有玫瑰（视图）
	 * @param page
	 * @param rowMax
	 * @return
	 * @throws Exception
	 */
	public PageVO<Rose> getAllRose(PageVO<Rose> pageVO) throws Exception {
		return roseDAO.getAllRose(pageVO);
	}
}
