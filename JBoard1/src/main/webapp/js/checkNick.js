/**
 * 아이디 중복 체크
 */
var regNick = /^[a-z가-힣0-9]{2,10}%/
var isNickOk = false;

$(function() {

	$('input[name=nick]').focusout(function() {

		var nick = $(this).val();
		var param = { 'nick': nick }

		$.ajax({

			url: '/JBoard1/user/proc/checkNick.jsp',
			type: 'get',
			data: param,
			datatype: 'json',
			success: function(data) {
				if (data.result == 1) {
					$('.resultNick').css('color','red').text('사용중인 닉네임 입니다');
					isNickOk = false;
				} else {
					
					if(regNick.test(nick)){
						$('.resultNick').css('color','blue').text('사용가능한 닉네임 입니다');
						isNickOk = true;
					}else{
						$('.resultNick').css('color','red').text('닉네임은 영문한글 최소 2 ~ 5자 입니다.');
						isNickOk = false;
					}

				}
			},

		})

	});

});