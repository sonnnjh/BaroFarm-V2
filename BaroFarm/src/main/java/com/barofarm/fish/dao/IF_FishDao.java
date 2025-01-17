package com.barofarm.fish.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.barofarm.fish.vo.FishVo;
import com.barofarm.fish.vo.PageVO;
import com.barofarm.fish.vo.infoVo;

@Mapper
public interface IF_FishDao {

	public void insert(FishVo fVo) throws Exception;
	public List<FishVo> allview(PageVO pagevo) throws Exception;
	public void delete(int no) throws Exception;
	public FishVo modify(int no) throws Exception;
	public void update(FishVo fVo) throws Exception;
	public List<infoVo> info() throws Exception;
	
	public List<FishVo> view(String category);//대분류
	public List<FishVo> middleview(String middlecategory);//중분류
	public FishVo detail(String name);//상세보기

	public int getTotalCount() throws Exception;
	public void chkDelete(List<Integer> chkDelete);
	public void chkDeleteinfo(List<Integer> chkDelete);
	public List<FishVo> excelview() throws Exception;
	public void infoAdd(infoVo infoVo)throws Exception;
	public infoVo infoDetail(String infoNum)throws Exception;
	public infoVo infoMod(String infoNum)throws Exception;
	public void infoModSave(infoVo infoVo)throws Exception;
}
