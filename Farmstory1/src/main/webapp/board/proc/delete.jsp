<%@page import="kr.co.farmstory1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String seq    = request.getParameter("seq");
	String parent = request.getParameter("parent");
	String group  = request.getParameter("group");
	String cate   = request.getParameter("cate");
	ArticleDao.getInstance().deleteArticle(seq, parent);
	
	response.sendRedirect("/Farmstory1/board/list.jsp?group="+group+"&cate="+cate+"&seq="+seq);
%>