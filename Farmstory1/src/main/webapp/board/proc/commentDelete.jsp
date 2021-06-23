<%@page import="kr.co.farmstory1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	request.setCharacterEncoding("utf-8");
	String seq    = request.getParameter("seq");
	String parent = request.getParameter("parent");
	
	// 댓글 삭제
	ArticleDao.getInstance().deleteComment(seq);
	
	// 댓글 카운트 -1
	ArticleDao.getInstance().updateCommentCount(parent, -1);

	response.sendRedirect("/farmstory1/view.jsp?seq="+parent);
%>