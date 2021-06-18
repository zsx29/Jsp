<%@page import="kr.co.jboard1.bean.ArticleBean"%>
<%@page import="kr.co.jboard1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String seq     = request.getParameter("seq");
	String title   = request.getParameter("title");
	String content = request.getParameter("content");
	
	
	ArticleDao dao = ArticleDao.getInstance();
	
	dao.updateAritcle(title, content, seq);
	
	// 리다이렉트
	response.sendRedirect("/JBoard1/list.jsp");	
%>