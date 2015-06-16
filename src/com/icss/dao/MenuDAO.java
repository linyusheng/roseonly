package com.icss.dao;

import java.util.List;

import com.icss.po.Menu;


public class MenuDAO extends DAOSupport<Menu>{

	@Override
	public void add(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_menu values(null,?,?,?,?,?)";
		db.execute(sql, vo.getParentId(),vo.getMenuName(),vo.getMenuUrl(),vo.getTarget(),vo.getStatus());
		
	}

	@Override
	public void modify(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_menu set parentId = ?,menuName = ?,menuUrl = ?,target = ?,status = ? where menuId = ?";
		db.execute(sql, vo.getParentId(),vo.getMenuName(),vo.getMenuUrl(),vo.getTarget(),vo.getStatus(),vo.getMenuId());
	}

	@Override
	public void delete(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_menu where menuId = ?";
		db.execute(sql, vo.getMenuId());
	}

	@Override
	public List<Menu> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_menu";
		return db.list(sql, new Menu());
	}

	@Override
	public Menu findById(Menu vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_menu where menuId = ?";
		return db.get(sql, new Menu(), vo.getMenuId());
	}
	/**
	 * 根据状态查找菜单
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<Menu> findByStatus(String status) throws Exception{
		String sql = "select * from t_menu where status = ?";
		return db.list(sql, new Menu(), status);
	}
	
}
