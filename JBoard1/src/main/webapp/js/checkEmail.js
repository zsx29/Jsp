var isEmailOk = false; 
 
$(function(){
    		
	$('input[name=email]').focusout(function(){
		
		var email = $(this).val(); 
		var param = {'email': email};
		    			
		$.ajax({
			url: '/JBoard1/user/proc/checkEmail.jsp',
			type: 'get',
			data: param,
			dataType: 'json',
			success: function(data){
				if(data.result == 1){
					$('.resultEmail').css('color', 'red').text('이미 사용중인 이메일 입니다.');
					isEmailOk = false;
				}else{
					$('.resultEmail').css('color', 'blue').text('사용 가능한 이메일 입니다.');
					isEmailOk = true;
				}
			}    				
		});
	});
});