<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String seq    = request.getParameter("seq");
	String parent = request.getParameter("parent");
	
	
	ArticleDao.getInstance().deleteArticle(seq, parent);
	
	response.sendRedirect("/JBoard1/list.jsp");
	
	
%>