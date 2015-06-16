package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Shopping;

public class ShoppingDAOTest {
	
	private ShoppingDAO dao = new ShoppingDAO();
	Shopping shopping = new Shopping();
    
	@Ignore
	@Test
	public void testAddShopping() throws Exception {
		shopping.setUserId(null);
		shopping.setRoseId(null);
		dao.add(shopping);
	}

	@Test
	public void testModifyShopping() {
	}
    
	@Ignore
	@Test
	public void testDeleteShopping() throws Exception {
		shopping.setShoppingId(2);
		dao.delete(shopping);
	}
    
	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}
	
	@Ignore
	@Test
	public void testFindByIdShopping() throws Exception {
		shopping.setShoppingId(1);
		System.out.println(dao.findById(shopping).getShoppingId());
	}

}
