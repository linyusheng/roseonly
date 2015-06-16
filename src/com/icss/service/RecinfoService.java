package com.icss.service;

import java.util.List;

import com.icss.dao.RecinfoDAO;
import com.icss.po.Recinfo;

public class RecinfoService {

	private RecinfoDAO recinfoDAO = new RecinfoDAO();
	
	/**
	 * 功能：添加收货信息
	 * @param recinfo
	 * @throws Exception
	 */
	public void addRecinfo(Recinfo recinfo) throws Exception{
		recinfoDAO.add(recinfo);
	}
	
	/**
	 * 功能：修改收货信息
	 * @param recinfo
	 * @throws Exception
	 */
	public void modifyRecinfo(Recinfo recinfo) throws Exception{
		recinfoDAO.modify(recinfo);
	}
	
	/**
	 * 功能：删除收货信息
	 * @param recinfo
	 * @throws Exception
	 */
	public void deleteRecinfo(Recinfo recinfo) throws Exception{
		recinfoDAO.delete(recinfo);
	}
	
	/**
	 * 功能：获取所有收货信息
	 * @param recinfo
	 * @return
	 * @throws Exception
	 */
	public List<Recinfo> findAllRecinfo(Recinfo recinfo) throws Exception{
		return recinfoDAO.findAll();
	}
	
	/**
	 * 功能：通过收货信息ID获取收货信息
	 * @param recinfo
	 * @return
	 * @throws Exception
	 */
	public Recinfo findByRecinfoId(Recinfo recinfo) throws Exception{
		return recinfoDAO.findById(recinfo);
	}
	/**
	 * 查找用户的所有收货地址
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Recinfo> findByUserId(Integer userId) throws Exception{
		return recinfoDAO.findByUserId(userId);
	}
	
}
