package com.situ.service;

import java.util.List;

import com.situ.pojo.Banji;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

public interface IBanjiService {

	/**
	 * 查找所有班级
	 * @return List<Banji>
	 */
	public List<Banji> findAll();

	/**
	 * 对班级进行分页
	 * @param pageIndex
	 * @param pageSize
	 * @return PageBean<Banji>
	 */
	public PageBean<Banji> pageList(Integer pageIndex, Integer pageSize);

	/**
	 * 查询班级的人数
	 * @return int
	 */
	public List<Banji> getBanjiPersonNum();

	/**
	 * 根据条件进行分页
	 * @param condition
	 * @return
	 */
	public PageBean<Banji> pageListByCondition(SearchByCondition<Banji> condition);

	/**
	 * 根据id删除班级
	 * @param id
	 * @return boolean
	 */
	public boolean delBanJi(int id);

	/**
	 * 根据id查找班级
	 * @param id
	 * @return
	 */
	public Banji findById(int id);

	/**
	 * 修改班级
	 * @param banji
	 * @return boolean
	 */
	public boolean update(Banji banji);

	/**
	 * 添加班级
	 * @param banji
	 * @return boolean
	 */
	public boolean addBanJi(Banji banji);

}
