package com.situ.pojo;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("all")
public class Banji implements Serializable {

	private Integer bid;
	private String bno;
	private String bname;
	private Integer totalPersonNum;
	private List<Course> list;
	
	public Banji() {
		super();
		
	}

	

	public Banji(Integer bid, Integer totalPersonNum) {
		super();
		this.bid = bid;
		this.totalPersonNum = totalPersonNum;
	}



	public Banji(Integer bid, String bno, String bname, Integer totalPersonNum, List<Course> list) {
		super();
		this.bid = bid;
		this.bno = bno;
		this.bname = bname;
		this.totalPersonNum = totalPersonNum;
		this.list = list;
	}



	public Banji(String bno, String bname, List<Course> list) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.list = list;
	}



	public Banji(Integer bid, String bno, String bname, List<Course> list) {
		super();
		this.bid = bid;
		this.bno = bno;
		this.bname = bname;
		this.list = list;
	}



	/**
	 * @return the bid
	 */
	public Integer getBid() {
		return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}

	/**
	 * @return the bno
	 */
	public String getBno() {
		return bno;
	}

	/**
	 * @param bno the bno to set
	 */
	public void setBno(String bno) {
		this.bno = bno;
	}

	/**
	 * @return the bname
	 */
	public String getBname() {
		return bname;
	}

	/**
	 * @param bname the bname to set
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}

	/**
	 * @return the totalPersonNum
	 */
	public Integer getTotalPersonNum() {
		return totalPersonNum;
	}



	/**
	 * @param totalPersonNum the totalPersonNum to set
	 */
	public void setTotalPersonNum(Integer totalPersonNum) {
		this.totalPersonNum = totalPersonNum;
	}



	/**
	 * @return the list
	 */
	public List<Course> getList() {
		return list;
	}



	/**
	 * @param list the list to set
	 */
	public void setList(List<Course> list) {
		this.list = list;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Banji [bid=" + bid + ", bno=" + bno + ", bname=" + bname + ", totalPersonNum=" + totalPersonNum
				+ ", list=" + list + "]";
	}



	

	
	
	
}
