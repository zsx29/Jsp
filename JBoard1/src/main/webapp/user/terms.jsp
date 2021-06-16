<%@page import="kr.co.jboard1.db.Sql"%>
<%@page import="kr.co.jboard1.db.DBConfig"%>
<%@page import="kr.co.jboard1.bean.TermsBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	TermsBean tb = new TermsBean();
	try {
		//1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		// 3단계
		Statement stmt = conn.createStatement();
		// 4단계
		ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
		// 5단계
		if (rs.next()) {
			tb.setTerms(rs.getString(1));
			tb.setPrivacy(rs.getString(2));
		}
		// 6단계
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>약관</title>
<link rel="stylesheet" href="/JBoard1/css/style.css" />
</head>
	<body>
		<div id="wrapper">
			<section id="user" class="terms">
				<table>
					<caption>사이트 이용약관</caption>
					<tr>
						<td>
							<textarea readonly><%=tb.getTerms()%></textarea>
							<p>
								<label><input type="checkbox" name="chk1" />동의합니다.</label>
							</p>
						</td>
					</tr>
				</table>
				<table>
					<caption>개인정보 취급방침</caption>
					<tr>
						<td>
							<textarea readonly><%=tb.getPrivacy()%></textarea>
							<p>
								<label><input type="checkbox" name="chk2" />동의합니다.</label>
							</p>
						</td>
					</tr>
				</table>
				<div>
					<a href="/JBoard1/user/login.jsp">취소</a> 
					<a href="/JBoard1/user/register.jsp">다음</a> 
				</div>
			</section>
		</div>
	
	</body>
</html>
<script>
	function send() {
		if (document.getElementById("chk1").checked && document.getElementById("chk2").checked) {
			
			location.href = '/JBoard1/user/register.jsp';
		} else {
			
			alert("사이트 이용약관, 개인정보 취급방침 체크");
		}
	}

</script>












