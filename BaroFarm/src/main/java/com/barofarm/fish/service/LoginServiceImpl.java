package com.barofarm.fish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barofarm.fish.dao.IF_LoginDao;
import com.barofarm.fish.vo.UserVo;

@Service
public class LoginServiceImpl implements IF_LoginService{

	@Autowired
	IF_LoginDao lDao;
	
	@Override
	public UserVo login(String id) throws Exception {
		
		return lDao.login(id);
		
	}

}
