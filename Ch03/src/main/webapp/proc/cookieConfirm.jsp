<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CookieConfirm</title>
</head>
<body>
	<h1>전송된 쿠키값 확인</h1>
	<%
		Cookie[] cookies = request.getCookies();  // 배열
		
		for(Cookie cookie : cookies){
			
	%>
		<p>
			쿠키명 : <%=cookie.getName() %><br/><br/>
			쿠키값 : <%=cookie.getValue() %><br/>
		</p>
	<%
		}
	
	%>
</body>
</html>


