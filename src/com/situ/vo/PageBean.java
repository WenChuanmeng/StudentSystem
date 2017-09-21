package com.situ.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("all")
public class PageBean<T> implements Serializable {

	//当前页
	private Integer pageIndex;
	//一页有多少数据
	private Integer pageSize;
	//一共有多少数据
	private Integer totalSize;
	//一共有多少页
	private Integer totalPage;
	private List<T> list;
	
	public PageBean() {
		super();
		
	}

	public PageBean(Integer pageIndex, Integer pageSize, Integer totalSize, Integer totalPage, List<T> list) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.totalPage = totalPage;
		this.list = list;
	}

	/**
	 * @return the pageIdex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIdex the pageIdex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalSize
	 */
	public Integer getTotalSize() {
		return totalSize;
	}

	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageBean [pageIdex=" + pageIndex + ", pageSize=" + pageSize + ", totalSize=" + totalSize + ", totalPage="
				+ totalPage + ", list=" + list + "]";
	}
	
	
	
}
