package com.barofarm.fish.service;

import com.barofarm.fish.vo.UserVo;

public interface IF_LoginService {

	// 로그인 서비스 기능 정의만 
	public UserVo login(String id) throws Exception;
	
}
