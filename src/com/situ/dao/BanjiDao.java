package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.pojo.Banji;
import com.situ.vo.SearchByCondition;

public interface BanjiDao {

	/**
	 * 查找所有的班级
	 * @return List<Banji>
	 */
	public List<Banji> findAll();

	/**
	 * 查找有多少班级
	 * @return int
	 */
	public int totalSize();

	/**
	 * 对学生进行分页
	 * @param pageIndex
	 * @param pageSize
	 * @return List<Student>
	 */
	public List<Banji> pageList(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize);

	/**
	 * 获得班级的总人数
	 * @return List<Banji>
	 */
	public List<Banji> getBanjiPersonNum();

	/**
	 * 根据条件获取班级的数量
	 * @param condition
	 * @return int
	 */
	public int totalSizeByCondition(SearchByCondition<Banji> condition);

	/**
	 * 根据查询条件进行分页
	 * @param condition
	 * @return List<Banji>
	 */
	public List<Banji> pageListByCondition(SearchByCondition<Banji> condition);

	/**
	 * 根据id删除班级
	 * @param id
	 * @return int
	 */
	public int delBanji(int id);

	/**
	 * 根据id查找班级
	 * @param id
	 * @return Banji
	 */
	public Banji findById(int id);

	/**
	 * 修改班级
	 * @param banji
	 * @return int
	 */
	public int update(Banji banji);

	/**
	 * 添加班级
	 * @param banji
	 * @return int
	 */
	public int addBanJi(Banji banji);

}
