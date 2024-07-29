/* .ready document가 완전히 로드 후 실행 */
$(document).ready(function() {
	$('#product_cate').change(function() {
		var selected = $(this).val();
		var option = '';

		switch (selected) {
			case '수산':
				option += '<option value="생선">생선</option>';
				option += '<option value="해물">해물</option>';
				option += '<option value="갑각류">갑각류</option>';
				break;
				
			case '축산':
				option += '<option value="돼지">돼지</option>';
				option += '<option value="소">소</option>';
				option += '<option value="양">양</option>';
				break;
				
			case '농산':
				option += '<option value="과일">과일</option>';
				option += '<option value="채소">채소</option>';
				option += '<option value="곡물">쌀/잡곡</option>';
				break;
				
			default:
				option = '';
				break;
		}
		$('#product_middle').html(option);
	});

	$('#product_cate').change();

});

//allview html 삭제 클릭시 확인 알림창 완료
//confirm 함수의 자료형타입은 불린 확인을 누룰시 true 값 리턴
//allview html 문서에서 a태그에 onclick 속성을 추가  
//add.js 파일에 구현한 delchk() 함수 호출 하여 삭제 알림창 구현 
function delchk(){
	return confirm("정말로 삭제하시겠습니까?")
}

function selectAll(selectAll) {
	const checkboxes = document.getElementsByName('checkList');
	Array.from(checkboxes).forEach((checkbox)=>{
		checkbox.checked = selectAll.checked;		
	});

}
