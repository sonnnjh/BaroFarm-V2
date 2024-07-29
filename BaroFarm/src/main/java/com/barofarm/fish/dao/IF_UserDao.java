package com.barofarm.fish.dao;

import java.util.List;

import com.barofarm.fish.vo.UserVo;

public interface IF_UserDao {
// 메서드 정의 
	public void join(UserVo uVo) throws Exception;
	public List<UserVo> view() throws Exception;
	public void udelete(String id) throws Exception;
	public UserVo umodify(String id) throws Exception;
	public void umodsave(UserVo uVo) throws Exception;
	public int idchk(UserVo uVo) throws Exception;
	

}
