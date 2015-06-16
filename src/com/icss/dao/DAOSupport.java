package com.icss.dao;

import java.util.List;

import com.icss.util.DbUtils;
import com.icss.util.RowMapper;
import com.icss.vo.PageVO;
/**
 * DAO的基本方法
 * @author Lydia
 *
 * @param <T>
 */
public abstract class DAOSupport<T> {
	
	protected DbUtils db = DbUtils.newInstance();
	/**
	 * 添加记录
	 * @param po
	 * @throws Exception
	 */
	public abstract void add(T vo)throws Exception;
	/**
	 * 根据主键修改记录
	 * @param po
	 * @throws Exception
	 */
	public abstract void modify(T vo)throws Exception;
	/**
	 * 根据主键删除记录
	 * @param po
	 * @throws Exception
	 */
	public abstract void delete(T vo)throws Exception;
	
	/**
	 * 查找所有
	 * @return
	 * @throws Exception
	 */
	public abstract List<T> findAll()throws Exception;
	
	/**
	 * 根据主键装置完整的对象
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public abstract T findById(T vo)throws Exception;
	
	private String getSql(String sql,int index,int len) throws Exception{
//		sql = sql.trim().replaceAll(" +", " ");
//		String tempsql = sql.toLowerCase();
//		if(tempsql.indexOf(" order by ")==-1){
//			throw new Exception("返回若干定条记录，sql必须包含order by子句");
//		}
//		return "select * from (select __tb1.*,ROW_NUMBER()OVER("+sql.substring(tempsql.lastIndexOf(" order by ")).trim()+") as row_number_temp from ("+sql.substring(0,tempsql.lastIndexOf(" order by "))+")__tb1)__td2 where __td2.row_number_temp>"+index+" and __td2.row_number_temp<="+(index+len);
		return sql+" LIMIT "+index+","+len;
	}
	
	/**
	 * 获取一部分数据
	 * @param <E>
	 * @param sql
	 * @param index		数据开始的行索引
	 * @param len   	数据长度
	 * @param rowMapper	数据对应的对象加载器
	 * @param objects	sql对应的参数
	 * @return
	 * @throws Exception
	 */
	public <E> List<E> list(String sql,int index,int len,RowMapper<E> rowMapper,Object... objects) throws Exception{
		return db.list(getSql(sql,index,len), rowMapper, objects);
	}
	
	/**
	 * 分页的实现
	 * @param <E>
	 * @param sql
	 * @param page		当前页码
	 * @param rowMax	每页记录数
	 * @param rowMapper	数据对应的对象加载器
	 * @param objects	sql对应的参数
	 * @return
	 * @throws Exception
	 */
	public <E> PageVO<E> page(String sql,int page,int rowMax,RowMapper<E> rowMapper,Object... objects)throws Exception{
		PageVO<E> pageVO = new PageVO<E>();
		String countSql = sql;
		if(sql.toLowerCase().indexOf(" order by ")>-1){
			countSql = sql.substring(0,sql.toLowerCase().indexOf(" order by "));
		}
		countSql = "select count(*) from(" + countSql + ")__a";
		pageVO.setTotal(db.getLong(countSql, objects));
		pageVO.setRows(list(sql, (page-1)*rowMax, rowMax, rowMapper, objects));
		pageVO.setPage(page);
		pageVO.setRowMax(rowMax);
		return pageVO;
	}

}
