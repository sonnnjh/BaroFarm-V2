package com.barofarm.fish.controller;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.barofarm.fish.service.IF_FishService;
import com.barofarm.fish.vo.FishVo;
import com.barofarm.fish.vo.PageVO;
import com.barofarm.fish.vo.infoVo;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FishController {

	@Autowired
	IF_FishService fService;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/add")
	public String add() {
		return "add";
	}

	@PostMapping("/addSave")
	public String addSave(@ModelAttribute FishVo fVo) throws Exception {
		fService.insert(fVo);
		return "redirect:/allview";
	}

	@GetMapping("/allview")
	public String allview(Model model, @ModelAttribute PageVO pagevo) throws Exception{
	if(pagevo.getPage()==null) {
		pagevo.setPage(1);
	}
	pagevo.setTotalCount(fService.getTotalCount());
	List<FishVo> fVo = fService.allview(pagevo);
//	pagevo.prt();
	model.addAttribute("pagevo",pagevo);
	model.addAttribute("allList",fVo);
	return "allview";
	}

	@GetMapping("/delete/{product_no}")
	public String delete(@PathVariable("product_no") int no) throws Exception {
		fService.delete(no);
		return "redirect:/allview";
	}

	@GetMapping("/modify/{product_no}")
	public String modify(@PathVariable("product_no") int no, Model model) throws Exception {
		FishVo fVo = fService.modify(no);
		model.addAttribute("modiVo", fVo);
		return "modify";
	}

	@PostMapping("/modifySave")
	public String modify(@ModelAttribute FishVo fvo) throws Exception {
		fService.update(fvo);
		// System.out.println(fvo.getProduct_name());

		return "redirect:/allview";
	}

	// 담당자 meat
	@GetMapping("/mypage")
	public String mypage() {

		return "mypage";
	}
	

	//-담당자 meat- 관리자페이지에서 관리자 전체보기기능에서 회원정보 수정기능 구현 
	@PostMapping("/memberUpdate") //회원정보 수정기능 
	public String memberUpdate() {
		
		return "mypage";
	}

	@GetMapping("/order")
	public String orderDelivery() {

		return "orderDelivery";
	}

	@GetMapping("/basket")
	public String basket() {

		return "basket";
	}

	@GetMapping("info")
	public String info(Model model) throws Exception {
		List<infoVo> infoview = fService.info();
		model.addAttribute("infoview", infoview);
		return "infoview";
	}

	// 담당자 son
	@GetMapping("/")
	public String usermain() {
		return "UserMain";
	}

	
	//대분류
	@GetMapping("view")
	public String view(@RequestParam("product_cate") String category , Model model) throws Exception {
		List<FishVo> Vo=fService.view(category);
		model.addAttribute("Vo",Vo);
		return "View";
	}

	//상세보기
	@GetMapping("detail")
	public String detail(@RequestParam("product_no") String name, Model model) throws Exception {
		FishVo detailVo=fService.detail(name);
		model.addAttribute("detailVo", detailVo);
		return "FruitDetail";
	}
	
	//중분류
	@GetMapping("middleview")
	public String middleview(@RequestParam("product_middle") String middlecategory , Model model) throws Exception {
		List<FishVo> Vo=fService.middleview(middlecategory);
		model.addAttribute("Vo", Vo);
		return "View";
	}
	
	//선택삭제 
	@PostMapping("checkProduct")
	public String chkDelete(Model model, @RequestParam ("checkList")  List<Integer> chkDelete) {		
		fService.chkDelete(chkDelete);
		return "redirect:/allview";
	}
	//공지사항 등록 
	@GetMapping("infoAdd")
	public String infoAdd() {
		return "infoAdd";
	}
	//공지사항 저장 
	@PostMapping("infoAddSave")
	public String infoAddSave(@ModelAttribute infoVo infoVo) throws Exception {
		fService.infoAdd(infoVo);
		return "redirect:/info";
	}
	//공지사항 자세히보기 
	@GetMapping("/infoDetail/{infoNo}")
	public String infoDetail(Model model, @PathVariable("infoNo") String infoNum) throws Exception {
		infoVo infoVo = fService.infoDetail(infoNum);
		System.out.println("디테일 뷰" +infoVo.getInfoNo() + infoVo.getInfoText() + infoVo.getInfoTitle());
		model.addAttribute("infoVo", infoVo);
		return "infoDetail";
	}
	//공지사항 수정하기 
	@GetMapping("/infoMod/{infoNo}")
	public String infoMod(Model model, @PathVariable("infoNo") String infoNum) throws Exception{
		infoVo infoVo = fService.infoMod(infoNum);
		System.out.println("수정 뷰" + infoVo.getInfoNo() + infoVo.getInfoText() + infoVo.getInfoTitle());
		model.addAttribute("infoVo", infoVo);
		return "infoMod";
	}
	//공지사항 수정사항 저장하기 
	@GetMapping("/infoModSave")
	public String infoModSave(@ModelAttribute infoVo infoVo) throws Exception{
		fService.infoModSave(infoVo);
		return "redirect:/info";
	}
	
	@PostMapping("checkinfo")
	public String chkDeleteinfo(Model model, @RequestParam ("checkList")  List<Integer> chkDelete) {
		fService.chkDeleteinfo(chkDelete);
		return "info"; 
	}
	
	// 엑셀 다운로드 
			@GetMapping("excelDown")
			public void excelDown(HttpServletResponse response) throws Exception{
				// 게시판 목록을 List 객체에 저장
				List<FishVo> pList = fService.excelview();
				// .xlsx 확장자 -> 엑셀 2007 이후 엑셀 
				Workbook wb = new XSSFWorkbook();
				Sheet sheet = wb.createSheet("상품 리스트");
				// 엑셀 시트이름 설정 
				// import org.apache.poi.ss.usermodel.Sheet;
				Row row = null;
				// ㅡ 행 값
				Cell cell = null;
				// 셀 값 
				int rowNo = 0;
				
				CellStyle headStyle = wb.createCellStyle();
				headStyle.setAlignment(HorizontalAlignment.CENTER);
				// 셀 안의 데이터 값을 가운데 정렬 
				
				// 헤더 생성
				row = sheet.createRow(rowNo++);
				cell = row.createCell(0);
				// 셀 시작이 0번 부터 시작 
				cell.setCellStyle(headStyle);
				// 셀 값의 가운데 정렬 값 적용 
				cell.setCellValue("번호");
				
				cell = row.createCell(1);
				cell.setCellStyle(headStyle);
				cell.setCellValue("대분류");
				
				cell = row.createCell(2);
				cell.setCellStyle(headStyle);
				cell.setCellValue("중분류");
				
				cell = row.createCell(3);
				cell.setCellStyle(headStyle);
				cell.setCellValue("상품명");
				
				cell = row.createCell(4);
				cell.setCellStyle(headStyle);
				cell.setCellValue("상품가격");
				
				cell = row.createCell(5);
				cell.setCellStyle(headStyle);
				cell.setCellValue("원산지");
				
				cell = row.createCell(6);
				cell.setCellStyle(headStyle);
				cell.setCellValue("재고");
				
				///// head 영역 생성완료 /// 
				
				// 헤드 밑에 들어갈 데이터를 확장 For문으로 뽑아 오기 
				for(FishVo pVo:pList) {
					row = sheet.createRow(rowNo++);
					// 행 만들기 ㅡ> 순차적으로 행 번호는 증가
					
					cell=row.createCell(0);
					// 셀 만들기 행의 0번 부터 시작 
					cell.setCellStyle(headStyle);
					// 셀 데이터 값 가운데 정렬
					cell.setCellValue(pVo.getProduct_no());
					// 셀 데이터 값을 가져온다 
					
					cell=row.createCell(1);
					cell.setCellStyle(headStyle);
					cell.setCellValue(pVo.getProduct_cate());
					// 대룬류 값을 가져온다
					
					cell=row.createCell(2);
					cell.setCellStyle(headStyle);
					cell.setCellValue(pVo.getProduct_middle());
					// 중분류 값을 가져온다.
					
					cell=row.createCell(3);
					cell.setCellStyle(headStyle);
					cell.setCellValue(pVo.getProduct_name());
					// 상품명 데이터 값을 가져온다.
					
					cell=row.createCell(4);
					cell.setCellStyle(headStyle);
					cell.setCellValue(pVo.getProduct_price());
					// 상품가격 데이터 값을 가져온다.
					
					cell=row.createCell(5);
					cell.setCellStyle(headStyle);
					cell.setCellValue(pVo.getProduct_origin());
					// 원산지 데이터 값을 가져온다
					
					cell=row.createCell(6);
					cell.setCellStyle(headStyle);
					cell.setCellValue(pVo.getProduct_stock());
					// 재고 데이터 값을 가져온다.
				}
				
				// 컨텐츠 타입과 파일명 지정 
				response.setContentType("ms-vnd/excel");
				response.setHeader("Content-Disposition", "attachment;filename=product_list.xlsx");
				
				//엑셀 출력
				wb.write(response.getOutputStream());
				wb.close();
				
			}


}
