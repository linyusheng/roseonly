package com.icss.vo;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 * @param <E>
 */
public class PageVO<E> {
	/**
	 * 当前页
	 */
	private int page = 1;
	/**
	 * 当前页的行数
	 */
	private int rowMax = 10;
	/**
	 * 分页后的总页数
	 */
	private int totalPage;
	/**
	 * 总计数量
	 */
	private long total;
	/**
	 * 当前页的数据
	 */
	private List<E> rows;
	
	
	public PageVO() {
		super();
	}
	public PageVO(long total, List<E> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
		// 重新计算总页数
		calcTotalPage();
	}
	public List<E> getRows() {
		return rows;
	}
	public void setRows(List<E> rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRowMax() {
		return rowMax;
	}
	public void setRowMax(int rowMax) {
		this.rowMax = rowMax;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * 计算总页数
	 */
	private void calcTotalPage() {
		totalPage = (int)total / rowMax;
		int mod = (int)total % rowMax;
		if (mod > 0) {
			totalPage++; // 最后一页记录数不够，总页数加上一页
		}
		// 限制当前页值在1到总页数之间
		if (page > totalPage) {
			this.page = totalPage;
		}
		if (page <= 0) {
			this.page = 1;
		}
	}
}
