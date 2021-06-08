var regName = /^[ㄱ-힣]{2,10}$/
var isNameOk = false;

$(function() {
	$('input[name=name]').focusout(function() {
		var name = $(this).val();

		if (regName.test(name)) {
			$('resultName').text('');
			isNameOk = true;

		} else {
			$('resultName').css("color", "red").text('이름은 할글 2 ~ 10자 까지 가능합니다.');
			isNameOk = false;

		}
	});

});