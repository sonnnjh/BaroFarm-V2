package com.barofarm.fish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barofarm.fish.dao.IF_UserDao;
import com.barofarm.fish.vo.UserVo;

@Service
public class UserServiceImpl implements IF_UserService{

	@Autowired
	IF_UserDao uDao;
	@Override
	public void join(UserVo uVo) throws Exception {
		uDao.join(uVo);
	}
	
	@Override
	public List<UserVo> view() throws Exception {
		
		return uDao.view();
	}

	@Override
	public void udelete(String id) throws Exception {
	uDao.udelete(id);
	}

	@Override
	public UserVo umodify(String id) throws Exception {
		
		return uDao.umodify(id);
	}

	@Override
	public void umodsave(UserVo uVo) throws Exception {
		uDao.umodsave(uVo);
		
	}

	@Override
	public int idchk(UserVo uVo) throws Exception {
		return uDao.idchk(uVo);
	}

}
