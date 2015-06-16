package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Rose;

public class RoseDAOTest {
 
	private RoseDAO dao = new RoseDAO();
	Rose rose = new Rose();
	
	
	@Test
	public void testAddRose() throws Exception {
		rose.setBrandId(1);
		rose.setRoseName(null);
		rose.setPicture(null);
		rose.setRoseInfo(null);
		rose.setDiscount(null);
		rose.setRosePrice(null);
		rose.setCreateTime(null);
		rose.setRoseNum(null);
		rose.setStatus(null);
		dao.add(rose);
	}

	@Ignore
	@Test
	public void testModifyRose() throws Exception {
		rose.setBrandId(null);
		rose.setRoseName(null);
		rose.setPicture(null);
		rose.setRoseInfo(null);
		rose.setDiscount(null);
		rose.setRosePrice(null);
		rose.setCreateTime(null);
		rose.setRoseNum(null);
		rose.setStatus(null);
		rose.setRoseId(null);
		dao.modify(rose);
	}

	@Ignore
	@Test
	public void testDeleteRose() throws Exception {
		rose.setRoseId(null);
		dao.delete(rose);
	}

	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}

	@Ignore
	@Test
	public void testFindByIdRose() throws Exception {
		rose.setRoseId(2);
		System.out.println(dao.findById(rose).getRoseId());
	}

}
