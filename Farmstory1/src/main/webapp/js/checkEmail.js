/**
	날짜 : 2021/06/08
	이름 : 김철학
	내용 : 이메일 중복체크 스크립트
 */
// 최종 유효성 검증에 사용할 상태변수 선언
var isEmailOk = false; 
 
$(function(){
    		
	$('input[name=email]').focusout(function(){
		
		var email = $(this).val(); 
		var param = {'email': email};
		    			
		$.ajax({
			url: '/Farmstory1/user/proc/checkEmail.jsp',
			type: 'get',
			data: param,
			dataType: 'json',
			success: function(data){
				if(data.result == 1){
					$('.resultEmail').css('color', 'red').text('이미 사용중인 이메일 입니다.');
					isEmailOk = false;
				}else{
					$('.resultEmail').css('color', 'green').text('사용 가능한 이메일 입니다.');
					isEmailOk = true;
				}
			}    				
		});
	});
});