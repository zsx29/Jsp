<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	// 파라미터 수신
	String theme = request.getParameter("theme");
	String date = request.getParameter("date");
/* 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); */
	String time = request.getParameter("time");
	String person = request.getParameter("person");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
	
	//DB 정보
	String host = "jdbc:mysql://54.180.109.191:3306/woguddldla";
	String user = "woguddldla";
	String pass = "qkrwogud1!";

	try{
		// 1
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		// 3
		Statement stmt = conn.createStatement();
		
		// 4
		String sql = "INSERT INTO `ESCAPE` (`theme`, `date`, `time`, `person`, `name`, `tel`, `email`) VALUES ('"+theme+"', '20210506', '1212', '"+person+"', '"+name+"', '"+tel+"', '"+email+"');";
		stmt.execute(sql);
		
		// 5
		
		
		// 6
		conn.close();
		
		
	}catch(Exception e){
		
		e.printStackTrace();
		
	}
	
	response.sendRedirect("../1_Insert.jsp");



%>
