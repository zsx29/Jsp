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
	<h3>1.표현언어(ExpressionLanguage)</h3>
	<%
		String name = "홍길동";
		int num1 = 1;
		int num2 = 2;
		
		// JSP 내장객체 - 변수 간접참조
		pageContext.setAttribute("name", name);
		request.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
	%>
	
	<h4>표현식</h4>
	<p>
		name = <%= name %><br>
		num1 = <%= num1 %><br>
		num2 = <%= num2 %><br>
		num1 + num2 = <%= num1 + num2 %>
	</p>
	
	<h4>표현언어</h4>
	<p>
		name : ${name}<br>
		num1 : ${num1}<br>
		num2 : ${num2}<br>
		num1 + num2 : ${num1 + num2}
	</p>
	
	
</body>
</html>