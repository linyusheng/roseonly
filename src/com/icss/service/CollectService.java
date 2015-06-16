package com.icss.service;

import java.util.List;

import com.icss.dao.CollectDAO;
import com.icss.po.Collect;
import com.icss.vo.CollectVO;

public class CollectService {

	private CollectDAO collectDAO = new CollectDAO();
	
	/**
	 * 功能：添加收藏信息
	 * @param collect
	 * @throws Exception
	 */
	public void addCollect(Collect collect) throws Exception{
		collectDAO.add(collect);
	}
	
	/**
	 * 功能：删除收藏信息
	 * @param collect
	 * @throws Exception
	 */
	public void deleteCollect(Collect collect) throws Exception{
		collectDAO.delete(collect);
	}
	
	/**
	 * 功能：获取所有收藏信息
	 * @param collect
	 * @return
	 * @throws Exception
	 */
	public List<Collect> findAllCollect(Collect collect) throws Exception{
		return collectDAO.findAll();
		
	}
	
	/**
	 * 功能：通过收藏ID获取收藏信息
	 * @param collect
	 * @return
	 * @throws Exception
	 */
	public Collect findByCollectId(Collect collect) throws Exception{
		return collectDAO.findById(collect);
		
	}
	/**
	 * 查询用户收藏(视图)
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<CollectVO> findByUserId(Integer userId) throws Exception{
		return collectDAO.findByUserId(userId);
	}
	/**
	 * 根据useId和roseId查收藏
	 */
	public Collect findByUserIdAndRoseId(Collect collect) throws Exception {
		return collectDAO.findByUserIdAndRoseId(collect);
	}
}
