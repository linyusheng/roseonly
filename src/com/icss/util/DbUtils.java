package com.icss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class DbUtils {

	private static DbUtils dbUtil;
	
	private static String url,name,pwd;
	static{
		Properties p = new Properties();
		try{
			p.load(DbUtils.class.getClassLoader().getResourceAsStream("conn.properties"));
			Class.forName(p.getProperty("driver"));
			url 	= p.getProperty("url");
			name 	= p.getProperty("name");
			pwd		= p.getProperty("pwd");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	private DbUtils(){}
	
	public static DbUtils newInstance(){
		if(dbUtil==null)dbUtil = new DbUtils();
		return dbUtil;
	}
	
	public  Connection getConnectin() throws Exception{
		return DriverManager.getConnection(url,name,pwd);
	}
	
	/**
	 * 将sql执行的数据通过rowMapper装载器装载到对象中
	 * @param sql
	 * @param rowMapper
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public <T> T get(String sql,RowMapper<T> rowMapper,Object...objects) throws Exception{
		Connection con=getConnectin();
		con.setAutoCommit(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);  
			setValues(pstmt,objects);  
			rs = pstmt.executeQuery();
			T t = null;
			if(rs.next()){
				t = rowMapper.mapRow(rs, 0);
			}
//			else{
//				throw new Exception("没有数据");
//			}
//			if(rs.next()){
//				throw new Exception("数据不止一条");
//			}
			return t;
		} catch (Exception e) {
			throw e;
		}finally{
			try{
				rs.close();
			}catch (Exception e) {}
			try{
				pstmt.close();
			}catch (Exception e) {}
			con.close();
			
		}
	}
	
	/**
	 * 根据sql执行的结果，获取第一行第一列的数据 必须只有一条记录
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public long getLong(String sql,Object...objects) throws Exception {
		Connection con=getConnectin();	
		con.setAutoCommit(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);  
			setValues(pstmt,objects);  
			rs = pstmt.executeQuery();
			long t = 0;
			if(rs.next()){
				t = rs.getLong(1);
			}else{
				throw new Exception("没有数据");
			}
			if(rs.next()){
				throw new Exception("数据不止一条");
			}
			return t;
		} catch (Exception e) {
			throw e;
		}finally{
			try{
				rs.close();
			}catch (Exception e) {}
			try{
				pstmt.close();
			}catch (Exception e) {}
			con.close();
			
		}
	}
	
	/**
	 * 根据sql执行的结果，获取第一行第一列的数据 必须只有一条记录
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public int getInt(String sql,Object...objects) throws Exception {
		Connection con=getConnectin();	
		con.setAutoCommit(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);  
			setValues(pstmt,objects);  
			rs = pstmt.executeQuery();
			int t = 0;
			if(rs.next()){
				t = rs.getInt(1);
			}else{
				throw new Exception("没有数据");
			}
			if(rs.next()){
				throw new Exception("数据不止一条");
			}
			return t;
		} catch (Exception e) {
			throw e;
		}finally{
			try{
				rs.close();
			}catch (Exception e) {}
			try{
				pstmt.close();
			}catch (Exception e) {}
			con.close();
			
		}
	}

	/**
	 * 根据sql执行的结果，获取第一行第一列的数据 必须只有一条记录
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public String getString(String sql,Object...objects) throws Exception {
		Connection con=getConnectin();	
		con.setAutoCommit(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);  
			setValues(pstmt,objects);  
			rs = pstmt.executeQuery();
			String t = null;
			if(rs.next()){
				t = rs.getString(1);
			}else{
				throw new Exception("没有数据");
			}
			if(rs.next()){
				throw new Exception("数据不止一条");
			}
			return t;
		} catch (Exception e) {
			throw e;
		}finally{
			try{
				rs.close();
			}catch (Exception e) {}
			try{
				pstmt.close();
			}catch (Exception e) {}
			con.close();
			
		}
	}
	
	/**
	 * 根据sql执行的结果，获取第一行的数据 必须只有一条记录
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> get(String sql,Object...objects) throws Exception{
		Connection con=getConnectin();	
		con.setAutoCommit(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);  
			setValues(pstmt,objects);  
			rs = pstmt.executeQuery();
			Map<String,Object> t = null;
			if(rs.next()){
				t = loadMap(rs);
			}else{
				throw new Exception("没有数据");
			}
			if(rs.next()){
				throw new Exception("数据不止一条");
			}
			return t;
		} catch (Exception e) {
			throw e;
		}finally{
			try{
				rs.close();
			}catch (Exception e) {}
			try{
				pstmt.close();
			}catch (Exception e) {}
			con.close();
			
		}
	}
	
	/**
	 * 将sql执行的数据通过rowMapper装载器装载到对象列表中
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> list(String sql,RowMapper<T> rowMapper,Object...objects) throws Exception{
		Connection con=getConnectin();	
		con.setAutoCommit(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);  
			setValues(pstmt,objects);  
			rs = pstmt.executeQuery();
			List<T> list = new ArrayList<T>();
			int index = 0;
			while(rs.next()){
				list.add(rowMapper.mapRow(rs, index));
				index++;
			}
			return list;
		} catch (Exception e) {
			throw e;
		}finally{
			try{
				rs.close();
			}catch (Exception e) {}
			try{
				pstmt.close();
			}catch (Exception e) {}
			con.close();
			
		}
	}
	
	/**
	 * 将sql执行的数据通过rowMapper装载器装载到List<Map>中
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> list(String sql,Object...objects) throws Exception{
		Connection con=getConnectin();	
		con.setAutoCommit(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);  
			setValues(pstmt,objects);  
			rs = pstmt.executeQuery();
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			while(rs.next()){
				list.add(loadMap(rs));
			}
			return list;
		} catch (Exception e) {
			throw e;
		}finally{
			try{
				rs.close();
			}catch (Exception e) {}
			try{
				pstmt.close();
			}catch (Exception e) {}
			con.close();
			
		}
	}
	
	/**
	 * 执行SQL返回影响的行数
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public int execute(String sql,Object...objects) throws Exception{
		int result=0;
		Connection con=getConnectin();	
		PreparedStatement pstmt = null;
		try {
			con.setAutoCommit(false);  //事务处理
			pstmt=con.prepareStatement(sql);  //预编译对象
			setValues(pstmt,objects);    //设置参数
			result=pstmt.executeUpdate();
			con.commit(); //没有错处执行
		} catch (Exception e) {
			con.rollback();
			throw e;
		}finally{
			try{
				pstmt.close();
			}catch (Exception e) {}
			con.close();
			
		}
		return result;
	}
	
	/**
	 * 设置参数
	 * @param pstmt
	 * @param objs
	 * @throws Exception
	 */
	private void setValues(PreparedStatement pstmt,Object[] objs) throws Exception{
		for(int i=0;i<objs.length;i++){
			if(objs[i] instanceof java.util.Date){
				pstmt.setTimestamp(i+1, new java.sql.Timestamp(((java.util.Date)objs[i]).getTime()));
			}else if(objs[i] instanceof Integer){
				pstmt.setInt(i+1, (Integer)objs[i]);
			}else{
				try{
					pstmt.getClass().getMethod("set"+objs[i].getClass().getSimpleName(), int.class,objs[i].getClass()).invoke(pstmt, i+1,objs[i]);
				}catch(Exception ex){
					pstmt.setObject(i+1, objs[i]);
				}
			}
		}
	}
	
	/**
	 * 装载MAP
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	private Map<String,Object> loadMap(ResultSet rs)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
			map.put(rs.getMetaData().getColumnName(i), rs.getObject(rs.getMetaData().getColumnName(i)));
		}
		return map;
	}
}
