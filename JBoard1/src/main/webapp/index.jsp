<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	if(true){
		pageContext.forward("./user/login.jsp");
		
		
	}else{
		pageContext.forward("./list.jsp");
		
	}

%>