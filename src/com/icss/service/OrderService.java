package com.icss.service;

import java.util.List;

import com.icss.dao.OrderDAO;
import com.icss.po.Order;
import com.icss.vo.OrderVO;
import com.icss.vo.PageVO;

public class OrderService {

	private OrderDAO orderDAO = new OrderDAO();
	
	/**
	 * 功能：添加订单信息
	 * @param order
	 * @throws Exception
	 */
	public void addOrder(Order order) throws Exception{
		orderDAO.add(order);
	}
	
	/**
	 * 功能：修改订单信息
	 * @param order
	 * @throws Exception
	 */
	public void modifyOrder(Order order) throws Exception{
		orderDAO.modify(order);
	}
	
	/**
	 * 功能：删除订单信息
	 * @param order
	 * @throws Exception
	 */
	public void deleteOrder(Order order) throws Exception{
		orderDAO.delete(order);
	}
	
	/**
	 * 功能：获取所有订单信息
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public List<Order> findAllOrder() throws Exception{
		return orderDAO.findAll();
	}
	
	/**
	 * 功能：通过订单ID获取订单信息
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public Order findByOrderId(Order order) throws Exception{
		return orderDAO.findById(order);
	}
	/**
	 * 提交订单
	 * @param list
	 * @param userId
	 * @throws Exception
	 */
	public void submitOrder(List<Order> list,Integer userId) throws Exception{
		orderDAO.submitOrder(list, userId);
	}
	/**
	 * 查找用户订单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<OrderVO> findByUserId(Integer userId) throws Exception{
		return orderDAO.findByUserId(userId);
		
	}
	/**
	 * 查询所有订单
	 * @return
	 * @throws Exception
	 */
	public PageVO<OrderVO> getAllOrder(PageVO<OrderVO> pageVO) throws Exception{
		return orderDAO.getAllOrder(pageVO);
	}
}
