package com.barofarm.fish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.barofarm.fish.vo.FishVo;
import com.barofarm.fish.vo.PageVO;
import com.barofarm.fish.vo.infoVo;

@Repository
@Primary
public class FishDaoImpl implements IF_FishDao{

	private String mapperQuery="com.barofarm.fish.dao.IF_FishDao";

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public void insert(FishVo fVo) throws Exception {
		sqlsession.insert(mapperQuery+".insert",fVo);
	}

	@Override
	public List<FishVo> allview(PageVO pagevo) throws Exception {
		return sqlsession.selectList(mapperQuery+".select", pagevo);
	}

	@Override
	public void delete(int no) throws Exception {
		sqlsession.delete(mapperQuery+".delete",no);
		
	}

	@Override
	public FishVo modify(int no) throws Exception {
		return sqlsession.selectOne(mapperQuery+".modify",no);
	}

	@Override
	public void update(FishVo fVo) throws Exception {
		sqlsession.update(mapperQuery+".update",fVo);
	}


	@Override//상세보기
	public FishVo detail(String name) {
		return sqlsession.selectOne(mapperQuery+".detail", name);
	}

	@Override//대분류
	public List<FishVo> view(String category) {
		return sqlsession.selectList(mapperQuery+".view", category);
	}
	@Override//중분류
	public List<FishVo> middleview(String middlecategory) {
		return sqlsession.selectList(mapperQuery+".middleview", middlecategory);
	}

	@Override
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(mapperQuery+".getTotalCount");
	}
	@Override //체크박스 선택 삭제
	public void chkDelete(List<Integer> chkDelete) {
		sqlsession.delete(mapperQuery+".chkDelete",chkDelete);

	}

	@Override
	public List<FishVo> excelview() throws Exception {
		
		return sqlsession.selectList(mapperQuery+".excelview");
	}

	@Override
	public List<infoVo> info() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(mapperQuery+".selectinfo");
	}

	@Override
	public void chkDeleteinfo(List<Integer> chkDelete) {
		
		sqlsession.delete(mapperQuery+".chkDeleteinfo",chkDelete);
	}

	public void infoAdd(infoVo infoVo) throws Exception {
		sqlsession.insert(mapperQuery+".infoInsert", infoVo);		
	}

	@Override
	public infoVo infoDetail(String infoNum) throws Exception {
		
		return sqlsession.selectOne(mapperQuery+".infoDetail", infoNum);
	}

	@Override
	public infoVo infoMod(String infoNum) throws Exception {
		return sqlsession.selectOne(mapperQuery+".infoMod", infoNum);
	}

	@Override
	public void infoModSave(infoVo infoVo) throws Exception {
		sqlsession.update(mapperQuery+".infoModSave", infoVo);
	}

}
