<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!-- 
	날짜 : 2021-06-28
	내용 : 표현언어(ExpressionLanguage)
 -->
	<h3>2.표현언어 내장객체</h3>
	<%
		/* 크기 : appli > session > request > pageC */
		pageContext.setAttribute("name", "김유신");
		request.setAttribute("name", "김춘추");
		session.setAttribute("name", "장보고");
		application.setAttribute("name", "강감찬");		
	%>
	<p>
		<!-- Scope 내장객체불러오기 -->
		pageContext name : ${pageScope.name}<br>
		request 	name : ${requestScope.name}<br>
		session 	name : ${sessionScope.name}<br>
		application name : ${applicationScope.name}<br>
	</p>

</body>
</html>