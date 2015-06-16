package com.icss.service;

import java.util.List;

import com.icss.dao.UserDAO;
import com.icss.po.User;
import com.icss.vo.PageVO;
import com.icss.vo.UserVO;

public class UserService {

	private UserDAO userDAO = new UserDAO();
	
	/**
	 * 功能：添加用户信息
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception{
		userDAO.add(user);
	}
	
	/**
	 * 功能：修改用户信息
	 * @param user
	 * @throws Exception
	 */
	public void modifyUser(User user) throws Exception{
		userDAO.modify(user);
	}
	
	/**
	 * 功能：删除用户信息
	 * @param user
	 * @throws Exception
	 */
	public void deleteUser(User user) throws Exception{
		userDAO.delete(user);
	}
	
	/**
	 * 功能：获取所有用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<User> findAllUser() throws Exception{
		return userDAO.findAll();
	}
	
	/**
	 * 功能：通过用户ID获取用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findByUserId(User user) throws Exception{
		return userDAO.findById(user);
	}
	/**
	 * 功能：根据帐号查找用户
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public User findByAccount(String account) throws Exception{
		return userDAO.findByAccount(account);
	}
	/**
	 * 功能：根据帐号和密码查找用户
	 * @param account
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User findByAccoutPassword(String account,String password) throws Exception{
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		return userDAO.findByAccoutPassword(user);
	}
	/**
	 * 获得所有用户信息（视图对象）
	 * @return
	 * @throws Exception
	 */
	public PageVO<UserVO> getAllUser(PageVO<UserVO> pageVO) throws Exception{
		return userDAO.getAllUser(pageVO);
	}
	/**
	 * 搜索用户（视图）
	 * @return
	 * @throws Exception
	 */
	public PageVO<UserVO> searchUser(String q, PageVO<UserVO> pageVO) throws Exception{
		return userDAO.searchUser(q, pageVO);
	}
	/**
	 * 根据用户类型ID查找用户
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	public List<User> findByType(Integer typeId) throws Exception{
		return userDAO.findByType(typeId);
	}
}
