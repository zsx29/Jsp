<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	// 문자셋 인코딩(한글깨짐 방지)
	request.setCharacterEncoding("UTF-8");
	
	// 파라미터 수신(데이터 불러오기)
	String uid  = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp   = request.getParameter("hp");
	String pos  = request.getParameter("pos");
	String dep  = request.getParameter("dep");
	
	// DB 정보
	String host = "jdbc:mysql://54.180.160.240:3306/woguddldla";
	String user = "woguddldla";
	String pass = "1234";
	
	
	try{
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
	
		// 2단계 - 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host, user, pass);
	
		// 3단계 - SQL 실행객체
		Statement stmt = conn.createStatement();
	
		// 4단계 - SQL 실행
		String sql = "INSERT INTO `MEMBER` VALUES ('"+uid+"', '"+name+"', '"+hp+"', '"+pos+"', '"+dep+"', NOW());";
		stmt.execute(sql);
	
		// 5단계 - SQL 결과셋 처리(SELECT일 경우에만)
	
	
		// 6단계 - 데이터베이스 종료
		conn.close();
	
	}catch(Exception e){
		e.printStackTrace();
	}

	// 돌아가기(Redirect)
	response.sendRedirect("../5_1_Insert.jsp");


%>