package com.icss.util;

/**
 * 数据装载器
 * @author J.L.Zhou
 *
 * @param <T>
 */
public interface RowMapper<T> {

	/**
	 * 将当前行数据装载到对象T中
	 * @param rs
	 * @param index 行索引
	 * @return
	 * @throws Exception
	 */
	T mapRow(java.sql.ResultSet rs, int index)throws Exception;
}
