<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	// 로그아웃
	session.invalidate();

	response.sendRedirect("/JBoard1/user/login.jsp?success=102");
%>