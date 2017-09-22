package com.situ.vo;

import java.io.Serializable;
import java.util.Date;

import com.situ.pojo.Banji;
import com.situ.pojo.Course;
import com.situ.pojo.Student;
import com.situ.pojo.User;

@SuppressWarnings("all")
public class SearchByCondition<T> implements Serializable {

	private Integer pageIndex;
	private Integer pageSize;
	private Student student;
	private Banji banji;
	private Course course;
	private User user;
	
	public SearchByCondition() {
		super();
		
	}
	
	

	public SearchByCondition(Integer pageIndex, Integer pageSize, User user) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.user = user;
	}



	public SearchByCondition(Integer pageIndex, Integer pageSize, Student student, Banji banji, Course course) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.student = student;
		this.banji = banji;
		this.course = course;
	}

	public SearchByCondition(Integer pageIndex, Integer pageSize, Student student) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.student = student;
	}

	public SearchByCondition(Integer pageIndex, Integer pageSize, Banji banji) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.banji = banji;
	}

	public SearchByCondition(Integer pageIndex, Integer pageSize, Course course) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.course = course;
	}

	
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}



	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}



	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
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
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the banji
	 */
	public Banji getBanji() {
		return banji;
	}

	/**
	 * @param banji the banji to set
	 */
	public void setBanji(Banji banji) {
		this.banji = banji;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchByCondition [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", student=" + student
				+ ", banji=" + banji + ", course=" + course + ", user=" + user + "]";
	}

	
	
	
	
	/*private Integer id;
	private String no;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private Date birthday;
	private Integer banji_id;

	public SearchByCondition() {
		super();
		
	}

	public SearchByCondition(Integer pageIndex, Integer pageSize, Integer id, String no, String name) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.id = id;
		this.no = no;
		this.name = name;
	}

	public SearchByCondition(Integer pageIndex, Integer pageSize, Integer id, String no, String name, Integer age,
			String gender, String address, Date birthday) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.id = id;
		this.no = no;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
	}
	

	public SearchByCondition(Integer pageIndex, Integer pageSize, Integer id, String no, String name, Integer age,
			String gender, String address, Date birthday, Integer banji_id) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.id = id;
		this.no = no;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.banji_id = banji_id;
	}

	*//**
	 * @return the pageIndex
	 *//*
	public Integer getPageIndex() {
		return pageIndex;
	}

	*//**
	 * @param pageIndex the pageIndex to set
	 *//*
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	*//**
	 * @return the pageSize
	 *//*
	public Integer getPageSize() {
		return pageSize;
	}

	*//**
	 * @param pageSize the pageSize to set
	 *//*
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	*//**
	 * @return the id
	 *//*
	public Integer getId() {
		return id;
	}

	*//**
	 * @param id the id to set
	 *//*
	public void setId(Integer id) {
		this.id = id;
	}

	*//**
	 * @return the no
	 *//*
	public String getNo() {
		return no;
	}

	*//**
	 * @param no the no to set
	 *//*
	public void setNo(String no) {
		this.no = no;
	}

	*//**
	 * @return the name
	 *//*
	public String getName() {
		return name;
	}

	*//**
	 * @param name the name to set
	 *//*
	public void setName(String name) {
		this.name = name;
	}

	*//**
	 * @return the age
	 *//*
	public Integer getAge() {
		return age;
	}

	*//**
	 * @param age the age to set
	 *//*
	public void setAge(Integer age) {
		this.age = age;
	}

	*//**
	 * @return the gender
	 *//*
	public String getGender() {
		return gender;
	}

	*//**
	 * @param gender the gender to set
	 *//*
	public void setGender(String gender) {
		this.gender = gender;
	}

	*//**
	 * @return the address
	 *//*
	public String getAddress() {
		return address;
	}

	*//**
	 * @param address the address to set
	 *//*
	public void setAddress(String address) {
		this.address = address;
	}

	*//**
	 * @return the birthday
	 *//*
	public Date getBirthday() {
		return birthday;
	}

	*//**
	 * @param birthday the birthday to set
	 *//*
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	*//**
	 * @return the banji_id
	 *//*
	public Integer getBanji_id() {
		return banji_id;
	}

	*//**
	 * @param banji_id the banji_id to set
	 *//*
	public void setBanji_id(Integer banji_id) {
		this.banji_id = banji_id;
	}

	 (non-Javadoc)
	 * @see java.lang.Object#toString()
	 
	@Override
	public String toString() {
		return "SearchByCondition [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", id=" + id + ", no=" + no
				+ ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address + ", birthday="
				+ birthday + "]";
	}*/

	
	
	
	
	
	
	
}
