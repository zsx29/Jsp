<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>회원정보</h1>
	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		// DB 정보
		String host = "jdbc:mysql://54.180.160.240:3306/woguddldla";
		String user = "woguddldla";
		String pass = "1234";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(host, user, pass);
			
			Statement stmt = conn.createStatement();
			
			String sql = "INSERT INTO `USERTEST` VALUES ('"+id+"', '"+name+"', '"+addr+"', NOW())";
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>가입날짜</th>
			<th>기타</th>
		</tr>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>addr</td>
			<td>rdate</td>
			<td>
				<a href="#">수정</a>
				<a href="#">삭제</a>
			</td>
	</table>
</body>
</html>