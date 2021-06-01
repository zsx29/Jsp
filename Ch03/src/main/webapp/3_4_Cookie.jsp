<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3_4_Cookie</title>
	<%--
		날짜 : 2021-06-01
		이름 : 박재형
		내용 : JSP Cookie 실습하기
		
		* Cookie
			- 클라이언트와 서버간의 식별의 위해 사용하는 조각파일
			- 서버에서 쿠키를 생성하고 클라이언트로 전송
			- 클라이언트는 전송된 쿠키를 보관, 해당 서버로 다시 요청할 때 보관된 쿠키를 전송
			- ex) 지마켓 장바구니 >> 로그인 안해도 장바구니에 상품이 담겨있음 >> Session(x) Cookie(o)
	--%>
</head>
<body>
	<h1>4.Cookie 실습하기</h1>
	
	<form action="./proc/cookieProc.jsp" method="post">
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
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>














































