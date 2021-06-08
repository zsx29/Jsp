/**
 * 아이디 중복 체크
 */
 
// 정규표현식
var regUid = /^[a-z]+[a-z0-9]{4,10}$/

// 최종 유효성 검증에 사용할 상태변수 선언
var isUidOk = false;
 
 
 
$(function() {

	$('input[name=uid]').focusout(function() {

		var uid = $(this).val();
		var param = { 'uid': uid }

		$.ajax({

			url: '/JBoard1/user/proc/checkUid.jsp',
			type: 'get',
			data: param,
			datatype: 'json',
			success: function(data) {
				if (data.result == 1) {
					$('.resultId').css('color','red').text(' 사용중인 아이디 입니다');
					isUidOk = true;
				} else {
					
					if(regUid.test(uid) == true){
						
						$('.resultId').css('color','blue').text(' 사용가능한 아이디 입니다');
						isUidOk = false;
					}else{
						$('.resultId').css('color','green').text(' 아이디는 영문 소문자, 숫자 조합 4 ~ 10자 입니다');
						isUidOk = true;
					}

				}
			},

		})

	});

});