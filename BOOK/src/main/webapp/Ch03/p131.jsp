<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>while문 예제</h2>
	<form action="whileTest.jsp" method="post">
		<dl>
			<dd>
				<label for="number">곱해질 값:</label>
				<input type="number" name="number" autofocus required>
			</dd>
			<dd>
				<label for="num">곱해질 수:</label>
				<input type="number" name="num" required>
			</dd>
			<dd>
				<input type="submit" value="확인">
			</dd>
		</dl>
	</form>
</body>
</html>