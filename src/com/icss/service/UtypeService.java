package com.icss.service;

import java.util.List;

import javax.management.relation.Role;

import com.icss.dao.UtypeDAO;
import com.icss.po.Utype;
import com.icss.vo.RoleVO;

public class UtypeService {

	private UtypeDAO utypeDAO = new UtypeDAO();
	
	/**
	 * 功能：添加用户类型
	 * @param utype
	 * @throws Exception
	 */
	public void addUtype(Utype utype) throws Exception{
		utypeDAO.add(utype);
	}
	
	/**
	 * 功能：修改用户类型
	 * @param utype
	 * @throws Exception
	 */
	public void modify(Utype utype) throws Exception{
		utypeDAO.modify(utype);
	}
	
	/**
	 * 功能：删除用户类型
	 * @param utype
	 * @throws Exception
	 */
	public void delete(Utype utype) throws Exception{
		utypeDAO.delete(utype);
	}
	
	/**
	 * 功能:获取所有用户类型
	 * @param utype
	 * @return
	 * @throws Exception
	 */
	public List<Utype> findAllUtype(Utype utype) throws Exception{
		return utypeDAO.findAll();
	}
	
	/**
	 * 功能：通过用户类型ID获取用户类型
	 * @param utype
	 * @return
	 * @throws Exception
	 */
	public Utype findByUtypeId(Utype utype) throws Exception{
		return utypeDAO.findById(utype);
	}
	/**
	 * 获取所有角色（视图）
	 * @return
	 * @throws Exception
	 */
	public List<RoleVO> getAllRole() throws Exception{
		return utypeDAO.getAllRole();
	}
}
