<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>선언문 예제 - 변수선언</h2>
	<%
		String str1 = "Game ID - " + str2;
	%>
	
	<%!
		String str2 = "park";
	%>
	
	결과 : <%= str1 %>
</body>
</html>