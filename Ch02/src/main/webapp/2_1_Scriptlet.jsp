<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2_1_Scriptlet</title>
	<!-- 
		날짜 : 2021-05-31
		이름 : 박재형
		내용 : JSP 스크립트릿 실습하기
	 -->
</head>
<body>
	<h3>1.Scriptlet 기초</h3>
	<%
		// 스크립트릿 영역(프로그래밍 코드영역)
		int var1 = 1;
		boolean var2 = true;
		double var3 = 3.14;
		String var4 = "Hello";
		
		out.print("<h4>var1 : " + var1 + " </h4>");
		out.print("<h4>var2 : " + var2 + " </h4>");
		
	%>
	
	<!-- 표현식(Expression)으로 출력 -->
	<h4>var3 : <%=var3 %></h4>
	<h4>var4 : <%=var4 %></h4>
</body>
</html>