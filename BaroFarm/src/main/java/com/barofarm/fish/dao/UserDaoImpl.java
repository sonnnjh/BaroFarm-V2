package com.barofarm.fish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barofarm.fish.vo.UserVo;

@Repository
public class UserDaoImpl implements IF_UserDao{
	private String usermapper="com.barofarm.fish.dao.IF_UserDao";
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void join(UserVo uVo) throws Exception {
		sqlsession.insert(usermapper+".join",uVo);
	}

	@Override
	public List<UserVo> view() throws Exception {
	
		return sqlsession.selectList(usermapper+".view") ;
	}

	@Override
	public void udelete(String id) throws Exception {
		sqlsession.delete(usermapper+".del",id);
	}

	@Override
	public UserVo umodify(String id) throws Exception {		
		return sqlsession.selectOne(usermapper+".mod",id);
	}

	@Override
	public void umodsave(UserVo uVo) throws Exception {
		sqlsession.update(usermapper+".modsave",uVo);
		
		
	}

	@Override
	public int idchk(UserVo uVo) throws Exception {
		return sqlsession.selectOne(usermapper+".idChk",uVo);
	}

	
}
