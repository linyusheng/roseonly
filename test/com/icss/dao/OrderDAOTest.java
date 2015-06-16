package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Order;

public class OrderDAOTest {
	
	private OrderDAO dao = new OrderDAO();
	Order order  = new Order();
	
	@Ignore
	@Test
	public void testAddOrder() throws Exception {
		order.setUserId(null);
		order.setRoseId(null);
		order.setRecInfoId(2);
		order.setOrderNo(null);
		order.setOrderName(null);
		order.setMoney(null);
		order.setStatus(null);
		order.setStartTime(null);
		order.setEndTime(null);
		order.setNum(null);
		dao.add(order);
	}
    
	@Ignore
	@Test
	public void testModifyOrder() throws Exception {
		order.setUserId(null);
		order.setRoseId(null);
		order.setRecInfoId(null);
		order.setOrderNo(null);
		order.setOrderName(null);
		order.setMoney(null);
		order.setStatus(null);
		order.setStartTime(null);
		order.setEndTime(null);
		order.setNum(null);
		order.setOrderId(null);
		dao.modify(order);
	}
    
	//出错**********************************************************
	@Ignore
	@Test
	public void testDeleteOrder() throws Exception {
		order.setOrderId(null);
		dao.delete(order);
	}
	
	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}
   
	//出错***********************************************
	@Test
	public void testFindByIdOrder() throws Exception {
		order.setOrderId(null);
		System.out.println(dao.findById(order).getOrderId());
	}

}
