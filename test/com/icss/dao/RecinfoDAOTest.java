package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Recinfo;

public class RecinfoDAOTest {

	private RecinfoDAO dao = new RecinfoDAO();
	Recinfo recinfo =new Recinfo();
	
	@Ignore
	@Test
	public void testAddRecinfo() throws Exception {
		recinfo.setRecInfoId(1);
		recinfo.setUserId(null);
		recinfo.setConsignee(null);
		recinfo.setAddress(null);
		recinfo.setMobile(null);
		recinfo.setPostcode(null);
		dao.add(recinfo);
		
		
	}
	@Ignore
	@Test
	public void testModifyRecinfo() throws Exception {
		recinfo.setRecInfoId(null);
		recinfo.setUserId(null);
		recinfo.setConsignee(null);
		recinfo.setAddress(null);
		recinfo.setMobile(null);
		recinfo.setPostcode(null);
		dao.modify(recinfo);
		
	}
    @Ignore
	@Test
	public void testDeleteRecinfo() throws Exception {
		recinfo.setRecInfoId(null);
		dao.delete(recinfo);
		
	}
    @Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
		
	}
    @Ignore
	@Test
	public void testFindByIdRecinfo() throws Exception {
		recinfo.setRecInfoId(2);
		System.out.println(dao.findById(recinfo).getRecInfoId());
		
	}

}
