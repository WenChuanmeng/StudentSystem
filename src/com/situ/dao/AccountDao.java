package com.situ.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {

	public void in(@Param("inuser")int inuser, @Param("money")double money);
	public void out(@Param("outuser")int outuser, @Param("money")double money);
}
