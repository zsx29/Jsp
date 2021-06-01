<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CookieProc</title>

</head>
<body>
	<h1>쿠키생성 및 쿠키 전송</h1>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		
		// 쿠키 생성
		Cookie c1 = new Cookie("uid", uid);
		Cookie c2 = new Cookie("name", name);
		
		// 쿠키 전송(클라이언트로 전송)
		response.addCookie(c1);
		response.addCookie(c2);
	
	%>
	<h3>쿠키 전송 완료...</h3>
	<a href="./cookieConfirm.jsp">클라이언트 쿠키 확인</a>
	
</body>
</html>


