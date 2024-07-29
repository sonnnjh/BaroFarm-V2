package com.barofarm.fish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barofarm.fish.dao.IF_FishDao;
import com.barofarm.fish.vo.FishVo;
import com.barofarm.fish.vo.PageVO;

@Service
public class FishServiceImpl implements IF_FishService{

	@Autowired
	IF_FishDao fDao;
	
	@Override
	public void insert(FishVo fVo) throws Exception {
		fDao.insert(fVo);
	}

	@Override
	public List<FishVo> allview(PageVO pagevo) throws Exception {
	
		return fDao.allview(pagevo);
	}

	@Override
	public void delete(int no) throws Exception {
		fDao.delete(no);
		
	}

	@Override
	public FishVo modify(int no) throws Exception {
		return fDao.modify(no);
	}

	@Override
	public void update(FishVo fVo) throws Exception {
		// TODO Auto-generated method stub
		fDao.update(fVo);
	}


	@Override //상세보기
	public FishVo detail(String name) {
		FishVo detail = fDao.detail(name);
		return detail;
	}

	@Override//대분류
	public List<FishVo> view(String category) {
		List<FishVo> vo = fDao.view(category);
		return vo;
	}

	@Override//중분류
	public List<FishVo> middleview(String middlecategory) {
		List<FishVo> vo = fDao.middleview(middlecategory);
		return vo;
	}

	@Override
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return fDao.getTotalCount();
	}
	
	@Override//체크박스 선택 삭제
	public void chkDelete(List<Integer> chkDelete) {
		fDao.chkDelete(chkDelete);

	}

	@Override
	public List<FishVo> excelview() throws Exception {
		// TODO Auto-generated method stub
		return fDao.excelview();
	}

}
