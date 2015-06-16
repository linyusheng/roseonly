package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Collect;

public class CollectDAOTest {

	private CollectDAO dao = new CollectDAO();
	Collect collect =new Collect();
	
	@Ignore
	@Test
	public void testAddCollect() throws Exception {
		collect.setCollectId(null);
		collect.setRoseId(null);
		collect.setUserId(null);
		dao.add(collect);
	}

	@Test
	public void testModifyCollect() {
	}

	@Ignore
	@Test
	public void testDeleteCollect() throws Exception {
		collect.setCollectId(null);
		dao.delete(collect);
	}

	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}

	@Ignore
	@Test
	public void testFindByIdCollect() throws Exception {
		collect.setCollectId(null);
		System.out.println(dao.findById(collect).getRoseId());
	}

}
