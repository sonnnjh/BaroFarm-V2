package com.barofarm.fish.service;

import java.util.List;

import com.barofarm.fish.vo.UserVo;

public interface IF_UserService {
// 정의만
	public void join(UserVo uVo) throws Exception;
	public List<UserVo> view() throws Exception;
	public void udelete(String id) throws Exception;
	public UserVo umodify(String id) throws Exception;
	public void umodsave(UserVo uVo) throws Exception;
	public int idchk(UserVo uVo) throws Exception;



}
