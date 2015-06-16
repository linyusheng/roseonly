package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Brand;

public class BrandDAOTest {
    
	private BrandDAO dao = new BrandDAO();
	Brand brand = new Brand();
	
	@Ignore
	@Test
	public void testAddBrand() throws Exception {
		brand.setBrandName(null);
		dao.add(brand);
	}
	
	@Ignore
	@Test
	public void testModifyBrand() throws Exception {
		brand.setBrandId(null);
		brand.setBrandName(null);
		dao.modify(brand);
	}
    
	@Ignore
	@Test
	public void testDeleteBrand() throws Exception {
		brand.setBrandId(null);
		dao.delete(null);
	}

	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}

	@Ignore
	@Test
	public void testFindByIdBrand() throws Exception {
		brand.setBrandId(null);
		System.out.println(dao.findById(brand).getBrandName());
	}
	
	@Test
	public void testindByBrandName() throws Exception {
		System.out.println(dao.findByBrandName("玫瑰珠宝").getBrandId());
	}
}
