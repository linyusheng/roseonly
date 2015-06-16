package com.icss.service;

import java.util.List;

import com.icss.dao.ShoppingDAO;
import com.icss.po.Shopping;
import com.icss.vo.ShoppingVO;

public class ShoppingService {

	private ShoppingDAO shoppingDAO =new ShoppingDAO();
	
	/**
	 * 功能：添加购物车信息
	 * @param shopping
	 * @throws Exception
	 */
	public void addShopping(Shopping shopping) throws Exception{
		shoppingDAO.add(shopping);
	}
	/**
	 * 修改购物车信息
	 * @param vo
	 * @throws Exception
	 */
	public void modify(Shopping vo) throws Exception {
		shoppingDAO.modify(vo);
	}
	/**
	 * 功能：删除购物车信息
	 * @param shopping
	 * @throws Exception
	 */
	public void deleteShopping(Shopping shopping) throws Exception{
		shoppingDAO.delete(shopping);
	}
	
	/**
	 * 功能：获取购物车所有信息
	 * @param shopping
	 * @return
	 * @throws Exception
	 */
	public List<Shopping> findAllShopping(Shopping shopping) throws Exception{
		return shoppingDAO.findAll();
	}
	
	/**
	 * 功能：通过购物车ID获取购物车信息
	 * @param shopping
	 * @return
	 * @throws Exception
	 */
	public Shopping findByShoppingId(Shopping shopping) throws Exception{
		return shoppingDAO.findById(shopping);
	}
	/**
	 * 功能：通过用户ID和玫瑰ID获取购物车信息
	 * @param shopping
	 * @return
	 * @throws Exception
	 */
	public Shopping findByUserIdandRoseId(Integer userId,Integer roseId) throws Exception{
		return shoppingDAO.findByUserIdandRoseId(userId, roseId);
	} 
	/**
	 * 功能：获取用户购物车
	 * @param shopping
	 * @return
	 * @throws Exception
	 */
	public List<Shopping> findByUser(Integer userId) throws Exception {
		return shoppingDAO.findByUser(userId);
	}
	/**
	 * 功能：通过用户ID获取购物车信息（视图）
	 * @param shopping
	 * @return
	 * @throws Exception
	 */
	public List<ShoppingVO> findByUserId(Integer userId) throws Exception {
		return shoppingDAO.findByUserId(userId);
	}
	/**
	 * 功能：清除某用户的购物车
	 * @throws Exception
	 */
	public void deleteAll(Integer userId) throws Exception{
		shoppingDAO.deleteAll(userId);
	}
}
