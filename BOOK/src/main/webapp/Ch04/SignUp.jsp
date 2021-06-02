<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SignUp</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="SignUp_ok.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pw">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>지역</td>
				<td>
					<select name="addr">
						<option>서울</option>
						<option>대전</option>
						<option>대구</option>
						<option>부산</option>
						<option>광주</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="회원가입">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>