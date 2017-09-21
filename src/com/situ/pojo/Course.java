package com.situ.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("all")
public class Course implements Serializable {

	private Integer cid;
	private String cno;
	private String cname;
	private Integer credit;
	private List<Banji> list;
	private Integer totalBanjis;
	private Integer totalPersons;
	
	public Course() {
		super();
		
	}
	

	public Course(Integer cid, String cno, String cname, Integer credit, List<Banji> list, Integer totalBanjis,
			Integer totalPersons) {
		super();
		this.cid = cid;
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.list = list;
		this.totalBanjis = totalBanjis;
		this.totalPersons = totalPersons;
	}


	public Course(Integer cid, String cno, String cname, Integer credit) {
		super();
		this.cid = cid;
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
	}

	public Course(String cno, String cname, Integer credit) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
	}

	/**
	 * @return the cid
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * @return the cno
	 */
	public String getCno() {
		return cno;
	}

	/**
	 * @param cno the cno to set
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @return the credit
	 */
	public Integer getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	

	/**
	 * @return the list
	 */
	public List<Banji> getList() {
		return list;
	}


	/**
	 * @param list the list to set
	 */
	public void setList(List<Banji> list) {
		this.list = list;
	}


	/**
	 * @return the totalBanjis
	 */
	public Integer getTotalBanjis() {
		return totalBanjis;
	}


	/**
	 * @param totalBanjis the totalBanjis to set
	 */
	public void setTotalBanjis(Integer totalBanjis) {
		this.totalBanjis = totalBanjis;
	}


	/**
	 * @return the totalPersons
	 */
	public Integer getTotalPersons() {
		return totalPersons;
	}


	/**
	 * @param totalPersons the totalPersons to set
	 */
	public void setTotalPersons(Integer totalPersons) {
		this.totalPersons = totalPersons;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cno=" + cno + ", cname=" + cname + ", credit=" + credit + ", list=" + list
				+ ", totalBanjis=" + totalBanjis + ", totalPersons=" + totalPersons + "]";
	}


	
	
}
