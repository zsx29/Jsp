<%@page import="kr.co.farmstory1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String seq     = request.getParameter("seq");
	String cate    = request.getParameter("cate");
	String group   = request.getParameter("group");
	String title   = request.getParameter("title");
	String content = request.getParameter("content");

	ArticleDao.getInstance().updateArticle(title, content, seq, cate);
	
	// 리다이렉트
	response.sendRedirect("/Farmstory1/board/list.jsp?group="+group+"&cate="+cate);
%>