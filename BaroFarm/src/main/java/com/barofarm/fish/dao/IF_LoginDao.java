package com.barofarm.fish.dao;

import com.barofarm.fish.vo.UserVo;

public interface IF_LoginDao {

	public UserVo login(String id) throws Exception;
	
}
