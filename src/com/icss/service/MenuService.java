package com.icss.service;

import java.util.List;

import com.icss.dao.MenuDAO;
import com.icss.po.Menu;

public class MenuService {

	private MenuDAO menuDAO = new MenuDAO();
	
	/**
	 * 功能：添加菜单
	 * @param menu
	 * @throws Exception
	 */
	public void addMenu(Menu menu) throws Exception{
		menuDAO.add(menu);
	}
	
	/**
	 * 功能：修改菜单
	 * @param menu
	 * @throws Exception
	 */
	public void modifyMenu(Menu menu) throws Exception{
		menuDAO.modify(menu);
	}
	
	/**
	 * 功能：删除菜单
	 * @param menu
	 * @throws Exception
	 */
	public void deleteMenu(Menu menu) throws Exception{
		menuDAO.delete(menu);
	}
	
	/**
	 * 功能：获取所有菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	public List<Menu> findAllMenu() throws Exception{
		return menuDAO.findAll();
	}
	
	/**
	 * 功能：通过菜单ID获取菜单
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	public Menu findByMenuId(Menu menu) throws Exception{
		return menuDAO.findById(menu);
	}
	/**
	 * 根据状态查找菜单
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<Menu> findByStatus(String status) throws Exception{
		return menuDAO.findByStatus(status);
	}
}
