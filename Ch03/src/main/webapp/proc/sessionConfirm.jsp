<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>sessionConfirm</title>
</head>
<body>
	<h1>사용자 Session값 확인</h1>
	<%
		String sid = session.getId();  // chrome browser의 session id (번호표)
		String name = (String)session.getAttribute("name");
		String uid = (String)session.getAttribute("uid");
	%>
	
	<p>
		사용자 세션아이디 : <%=sid %><br/><br/>
		사용자 아이디 : <%=uid %><br/><br/>
		사용자 이름 : <%=name %><br/>
	</p>
	
</body>
</html>





