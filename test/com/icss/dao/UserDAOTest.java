package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.User;

public class UserDAOTest {

	private UserDAO dao = new UserDAO();
	User user = new User();
	
	@Ignore
	@Test
	public void testAddUser() throws Exception {
		user.setTypeId(null);
		user.setAccount(null);
		user.setPassword(null);
		user.setMobile(null);
		user.setEmail(null);
		user.setCreateTime(null);
		dao.add(user);
	}

	@Ignore
	@Test
	public void testModifyUser() throws Exception {
		user.setTypeId(null);
		user.setAccount(null);
		user.setPassword(null);
		user.setMobile(null);
		user.setEmail(null);
		user.setCreateTime(null);
		user.setUserId(null);
		dao.modify(user);
	}

	@Ignore
	@Test
	public void testDeleteUser() throws Exception {
		user.setUserId(null);
		dao.delete(user);
	}

	@Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}

	@Ignore
	@Test
	public void testFindByIdUser() throws Exception {
		user.setUserId(null);
		System.out.println(dao.findById(user).getMobile());
	}

}
