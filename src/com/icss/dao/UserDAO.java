package com.icss.dao;

import java.util.List;

import com.icss.po.User;
import com.icss.vo.PageVO;
import com.icss.vo.UserVO;

public class UserDAO extends DAOSupport<User>{

	@Override
	public void add(User vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_user values(null,?,?,?,?,?,?)";
		db.execute(sql, vo.getTypeId(), vo.getAccount(), vo.getPassword(), 
				vo.getMobile(), vo.getEmail(), vo.getCreateTime());
	}

	@Override
	public void modify(User vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_user set typeId = ?, account = ?, password = ?," +
				"mobile = ?,email = ?,createTime = ? where userId = ?";
		db.execute(sql, vo.getTypeId(), vo.getAccount(), vo.getPassword(), 
				vo.getMobile(), vo.getEmail(), vo.getCreateTime(), vo.getUserId());
	}

	@Override
	public void delete(User vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from t_user where userId = ?";
		db.execute(sql, vo.getUserId());
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_user";
		return db.list(sql, new User());
	}

	@Override
	public User findById(User vo) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where userId = ?";
		return db.get(sql, new User(), vo.getUserId());
	}
	/**
	 * 根据帐号查找用户
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public User findByAccount(String account)throws Exception{
		String sql = "select * from t_user where account = ?";
		return db.get(sql, new User(), account);
		
	}
	/**
	 * 根据帐号和密码查找用户
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public User findByAccoutPassword(User vo) throws Exception {
		String sql = "select * from t_user where account = ? and password = ?";
		return db.get(sql, new User(), vo.getAccount(), vo.getPassword());
	}
	/**
	 * 获得所有用户（视图）
	 * @param page
	 * @param rowMax
	 * @return
	 * @throws Exception
	 */
	public PageVO<UserVO> getAllUser(PageVO<UserVO> pageVO) throws Exception {
		String sql = "SELECT u.*,t.typeName FROM t_user AS u , t_utype AS t ";
		sql += "WHERE u.typeId=t.typeId ";
		sql += "ORDER BY userId ASC ";
		return page(sql, pageVO.getPage(), pageVO.getRowMax(), new UserVO());
	}
	/**
	 * 搜索用户（视图）
	 * @param q
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	public PageVO<UserVO> searchUser(String q, PageVO<UserVO> pageVO) throws Exception {
		String sql = "SELECT u.*,t.typeName FROM t_user AS u , t_utype AS t ";
		sql += "WHERE u.typeId=t.typeId ";
		sql += "AND account LIKE '%"+q+"%' OR email LIKE '%"+q+"%' OR mobile LIKE '%"+q+"%' ";
		sql += "ORDER BY userId ASC ";
		return page(sql, pageVO.getPage(), pageVO.getRowMax(), new UserVO());
	}
	/**
	 * 根据用户类型ID查找用户
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	public List<User> findByType(Integer typeId) throws Exception {
		String sql = "select * from t_user where typeId = ?";
		return db.list(sql, new User(), typeId);
	}
	

}
