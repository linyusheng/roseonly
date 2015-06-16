package com.icss.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.icss.po.Menu;

public class MenuDAOTest extends MenuDAO {
	
	private MenuDAO dao = new MenuDAO();
	
	Menu menu = new Menu();
	
    @Ignore
	@Test
	public void testAddMenu() throws Exception {
		menu.setParentId(null);
		menu.setMenuName(null);
		menu.setMenuUrl(null);
		dao.add(menu);
	}
    
    @Ignore
	@Test
	public void testModifyMenu() throws Exception {
		menu.setParentId(null);
		menu.setMenuName(null);
		menu.setMenuUrl(null);
		menu.setMenuId(1);
		dao.modify(menu);
	}
    
    @Ignore
	@Test
	public void testDeleteMenu() throws Exception {
		menu.setMenuId(1);
		dao.delete(menu);
	}
    
    @Ignore
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll().size());
	}
    @Ignore
	@Test
	public void testFindByIdMenu() throws Exception {
		menu.setMenuId(1);
		System.out.println(dao.findById(menu).getMenuId());
	}

}
