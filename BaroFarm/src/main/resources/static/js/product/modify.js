/**
 * 
 */

 $(document).ready(function() {
	$('#product_cate').change(function() {
		var selectedmiddle = $(this).val();
		var option = '';

		switch (selectedmiddle) {

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