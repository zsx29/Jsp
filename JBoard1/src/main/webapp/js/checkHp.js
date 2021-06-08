/**
 * 아이디 중복 체크
 */
var isHpOk = false;

$(function() {

	$('input[name=hp]').focusout(function() {

		var hp = $(this).val();
		var param = { 'hp': hp }

		$.ajax({

			url: '/JBoard1/user/proc/checkHp.jsp',
			type: 'get',
			data: param,
			datatype: 'json',
			success: function(data) {
				if (data.result == 1) {
					$('.resultHp').css('color','red').text('사용중인 번호 입니다');
					isHpOk = false;
				} else {
					$('.resultHp').css('color','blue').text('사용가능한 번호 입니다');
					isHpOk = true;

				}
			},

		})

	});

});