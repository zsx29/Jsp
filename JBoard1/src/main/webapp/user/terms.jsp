<%@page import="kr.co.jboard1.bean.TermsBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");


	//DB 정보
	String host = "jdbc:mysql://54.180.109.191:3306/woguddldla";
	String user = "woguddldla";
	String pass = "qkrwogud1!";
	
	TermsBean tb = new TermsBean();
	
	
	try{
		
		//	1단계
		Class.forName("com.mysql.jdbc.Driver");
			
		//	2단계
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		//	3단계
		Statement stmt = conn.createStatement();
		
		//	4단계
		String sql = "SELECT * FROM `JBOARD_TERMS`;";
		ResultSet rs = stmt.executeQuery(sql);
		//	5단계
		if(rs.next()){
			tb.setTerms(rs.getString(1));
			tb.setPrivacy(rs.getString(2));
		}
		//	6단계
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}



%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>약관</title>
    <link rel="stylesheet" href="/JBoard1/css/style.css"/>
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <section id="user" class="terms">
            <table>
                <caption>사이트 이용약관</caption>
                <tr>
                    <td>
                        <textarea readonly><%=tb.getTerms() %></textarea>
                        <p>
                            <label><input type="checkbox" name="chk1" id="chk1"/>동의합니다.</label>
                        </p>
                    </td>
                </tr>
            </table>
            <table>
                <caption>개인정보 취급방침</caption>
                <tr>
                    <td>
                        <textarea readonly><%=tb.getPrivacy() %></textarea>
                        <p>
                            <label><input type="checkbox" name="chk2" id="chk2"/>동의합니다.</label>
                        </p>
                    </td>
                </tr>
            </table>
            <div>
                <a href="/JBoard1/user/login.jsp">취소</a>
                <a href="#" onclick="send()">다음</a>
            </div>
        </section>
    </div>
    
</body>
</html>
<script>
	function send() {
		if(document.getElementById("chk1").checked && document.getElementById("chk2").checked){
			location.href = '/JBoard1/user/register.jsp';
		}else{
			alert("사이트 이용약관, 개인정보 취급방침 체크");
		}
	}
</script>












