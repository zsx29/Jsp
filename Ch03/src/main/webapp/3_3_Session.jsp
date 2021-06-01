<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3_3_Session</title>
	<%--
		날짜 : 2021-06-01
		이름 : 박재형
		내용 : JSP Session 내장객체
		
		* Session 내장객체
			- 일정 시간동안 일어나는 전체시간
			- 클라이언트에서 서버로 요청할때 서버에 기록되는 클라이언트 정보(Session Table)
			- 서버는 각 클라이언트에 대한 고유번호(Session id = sid)를 부여한다.
	--%>
</head>
<body>
	<h1>3.Session 내장객체</h1>
	
	<form action="./proc/sessionProc.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="가입하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>





