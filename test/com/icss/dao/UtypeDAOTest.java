package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Utype;

public class UtypeDAOTest {

	private UtypeDAO dao = new UtypeDAO();
	Utype utype = new Utype();
	
	@Ignore
	@Test
	public void testAddUtype() throws Exception {
		utype.setTypeName(null);
		dao.add(utype);
	}

	@Ignore
	@Test
	public void testModifyUtype() throws Exception {
		utype.setTypeName(null);
		utype.setTypeId(null);
		dao.modify(utype);
	}

	@Ignore
	@Test
	public void testDeleteUtype() throws Exception {
		utype.setTypeId(null);
		dao.delete(utype);
	}

	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}

	@Ignore
	@Test
	public void testFindByIdUtype() throws Exception {
		utype.setTypeId(null);
		System.out.println(dao.findById(utype).getTypeName());
	}

}
