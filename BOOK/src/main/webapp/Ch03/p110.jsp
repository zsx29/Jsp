<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>선언문 예제 - 메소드 선언</h2>
	<%!
		String id = "park";
	
		public String getId(){
			return id;
		}
	%>
	
	id변수 : <%=id %><br>
	getId()메소드 실행결과 : <%=getId() %>
</body>
</html>