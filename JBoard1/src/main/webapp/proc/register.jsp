<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String uid = request.getParameter("uid");
	String pass1 = request.getParameter("pass1");
	String name = request.getParameter("name");
	String nick = request.getParameter("nick");
	String email = request.getParameter("email");
	String hp = request.getParameter("hp");
	String grade = request.getParameter("grade");
	String zip = request.getParameter("zip");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String regip = request.getRemoteAddr();

	
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
		String sql  = "INSERT INTO `JBOARD_MEMBER` SET ";
	           sql += "`uid`='"+uid+"',";
	           sql += "`pass`=PASSWORD('"+pass1+"'),";
	           sql += "`name`='"+name+"',";
	           sql += "`nick`='"+nick+"',";
	           sql += "`email`='"+email+"',";
	           sql += "`hp`='"+hp+"',";
	           sql += "`zip`='"+zip+"',";
	           sql += "`addr1`='"+addr1+"',";
	           sql += "`addr2`='"+addr2+"',";
	           sql += "`regip`='"+regip+"',";
	           sql += "`rdate`=NOW();";
		stmt.executeUpdate(sql);
		// 5
		// 6
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	// 로그인 페이지로 리다이렉트
	response.sendRedirect("/JBoard1/user/login.jsp");
%>