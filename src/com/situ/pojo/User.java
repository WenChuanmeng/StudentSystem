package com.situ.pojo;

public class User {

	private Integer uid;
	private String uname;
	private String password;
	private Integer permission;
	
	public User() {
		super();
		
	}

	public User(Integer uid, String uname, String password, Integer permission) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.permission = permission;
	}

	public User(String uname, String password, Integer permission) {
		super();
		this.uname = uname;
		this.password = password;
		this.permission = permission;
	}

	/**
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the permission
	 */
	public Integer getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", permission=" + permission + "]";
	}
	
	
}
