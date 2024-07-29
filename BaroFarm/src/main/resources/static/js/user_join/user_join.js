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

	
