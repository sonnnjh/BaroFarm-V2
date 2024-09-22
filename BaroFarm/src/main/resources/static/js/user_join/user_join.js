function checkId() {
    var user_id = $('#user_id').val();
    // 사용자가 입력한 값을 user_id에 저장, 제이쿼리.val
    $.ajax({
        url: './idChk',
        type: 'post',
        contentType: 'application/json',
        //전송할 데이터 자료형을 json 형식으로 설정한다.
        data: JSON.stringify({ user_id: user_id }),
        //
        success: function(result) {
            if (result == 0) {
                $('.id_ok').css("display", "block");
                //html span태그의 class를 지칭한다. 성공시 display를 inline-block 
                // 실패시 아래 else 코드
                // inline-block >> block 변경. 
                // 실시간이라서 test까지만 쳐도 무조건 중복이라고 한다. test2가 안된다.
                $('.id_already').css("display", "none");
            } else {
                $('.id_already').css("display", "block");
                $('.id_ok').css("display", "none");
                alert("아이디를 다시 입력해주세요");
                //$('#user_id').val('');
                //↑↑ 주석 처리한 이유 > 중복 일 경우, 알람이 나오고 초기화 되는 것을 방지 >test2 가능
            }
        },
        error: function() {
            alert("에러입니다");
        }
    });
}

document.getElementById('user_pw').addEventListener('input',function(){
	if(document.getElementById('user_pw').value.length<6){
		document.getElementsByClassName('pw')[0].classList.add('pw_ok');
	}else{
		document.getElementsByClassName('pw')[0].classList.remove('pw_ok');
	}
})
document.getElementById('user_email').addEventListener('input',function(){
	if(document.getElementById('user_email').value.includes('@')){
		document.getElementsByClassName('email')[0].classList.remove('email_ok');
	}else{
		document.getElementsByClassName('email')[0].classList.add('email_ok');
	}
})
document.getElementById('user_phone').addEventListener('input',function(){
	document.getElementById('user_phone').value = document.getElementById('user_phone').value.replace(/[^0-9]/g, '') // 숫자를 제외한 모든 문자 제거
	.replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, `$1-$2-$3`)//3자리,4자리,4자리로 그룹짓기.
	.replace(/(\-{1,2})$/g, "")//해당범위 사이에 하이픈이 즉시 생성됨.
	if(document.getElementById('user_phone').value.length < 13){
		document.getElementsByClassName('phone')[0].classList.add('phone_ok');
	}else{
		document.getElementsByClassName('phone')[0].classList.remove('phone_ok');
	}
	
})

