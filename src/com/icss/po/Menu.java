package com.icss.po;

import java.sql.ResultSet;

import com.icss.util.RowMapper;

/**
 * TMenu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements RowMapper<Menu> {

	// Fields

	private Integer menuId;
	private Integer parentId;
	private String menuName;
	private String menuUrl;
	private String target;
	private String status;
	
	@Override
	public Menu mapRow(ResultSet rs, int index) throws Exception {
		Menu menu = new Menu();
		menu.setMenuId(rs.getInt("menuId"));
		menu.setParentId(rs.getInt("parentId"));
		menu.setMenuName(rs.getString("menuName"));
		menu.setMenuUrl(rs.getString("menuUrl"));
		menu.setTarget(rs.getString("target"));
		menu.setStatus(rs.getString("status"));
		return menu;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}