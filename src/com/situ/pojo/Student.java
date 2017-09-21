package com.situ.pojo;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("all")
public class Student implements Serializable {

	private Integer sid;
	private String sno;
	private String sname;
	private Integer sage;
	private String sgender;
	private String saddress;
	private Date sbirthday;
	private Integer sbanji_id;
	private Banji banji;
	
	public Student() {
		super();
		
	}

	public Student(Integer sid, String sno, String sname, Integer sage, String sgender, String saddress, Date sbirthday,
			Banji banji) {
		super();
		this.sid = sid;
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
		this.saddress = saddress;
		this.sbirthday = sbirthday;
		this.banji = banji;
	}

	public Student(String sno, String sname, Integer sage, String sgender, String saddress, Date sbirthday,
			Banji banji) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
		this.saddress = saddress;
		this.sbirthday = sbirthday;
		this.banji = banji;
	}

	public Student(String sno, String sname, Integer sage, String sgender, String saddress, Date sbirthday,
			Integer sbanji_id) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
		this.saddress = saddress;
		this.sbirthday = sbirthday;
		this.sbanji_id = sbanji_id;
	}

	public Student(Integer sid, String sno, String sname, Integer sage, String sgender, String saddress, Date sbirthday,
			Integer sbanji_id) {
		super();
		this.sid = sid;
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
		this.saddress = saddress;
		this.sbirthday = sbirthday;
		this.sbanji_id = sbanji_id;
	}
	
	

	/**
	 * @return the sbanji_id
	 */
	public Integer getSbanji_id() {
		return sbanji_id;
	}

	/**
	 * @param sbanji_id the sbanji_id to set
	 */
	public void setSbanji_id(Integer sbanji_id) {
		this.sbanji_id = sbanji_id;
	}

	/**
	 * @return the sid
	 */
	public Integer getSid() {
		return sid;
	}

	/**
	 * @param sid the sid to set
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}

	/**
	 * @return the sno
	 */
	public String getSno() {
		return sno;
	}

	/**
	 * @param sno the sno to set
	 */
	public void setSno(String sno) {
		this.sno = sno;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return the sage
	 */
	public Integer getSage() {
		return sage;
	}

	/**
	 * @param sage the sage to set
	 */
	public void setSage(Integer sage) {
		this.sage = sage;
	}

	/**
	 * @return the sgender
	 */
	public String getSgender() {
		return sgender;
	}

	/**
	 * @param sgender the sgender to set
	 */
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	/**
	 * @return the saddress
	 */
	public String getSaddress() {
		return saddress;
	}

	/**
	 * @param saddress the saddress to set
	 */
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	/**
	 * @return the sbirthday
	 */
	public Date getSbirthday() {
		return sbirthday;
	}

	/**
	 * @param sbirthday the sbirthday to set
	 */
	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sno=" + sno + ", sname=" + sname + ", sage=" + sage + ", sgender=" + sgender
				+ ", saddress=" + saddress + ", sbirthday=" + sbirthday + ", sbanji_id=" + sbanji_id + ", banji="
				+ banji + "]";
	}

	
	
}
