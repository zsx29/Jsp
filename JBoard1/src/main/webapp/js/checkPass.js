var isPassOk = false;

$(function(){
	$('input[name=pass2]').focusout(function(){
		
		var pass1 = $('input[name=pass1]').val();
		var pass2 = $('input[name=pass2]').val();
		
		if(pass1 == pass2){
			$('.resultPass').css('color', 'blue').text('비밀번호가 일치 합니다.');
			isPassOk = true;
		}else{
			$('.resultPass').css('color', 'red').text('비밀번호가 일치 하지 않습니다.');
			isPassOk = false;
		}
	});
});