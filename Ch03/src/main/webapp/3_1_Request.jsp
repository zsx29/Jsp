<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3_1_Requestt</title>
	<%--
		날짜 : 2021-06-01
		이름 : 박재형
		내용 : JSP Request 내장객체
		
		* 데이터 전송방식
			- GET : 기본 데이터 전송방식, 데이터를 주소에 붙여서 전송한다. --> ((데이터 노출됨))
			- POST : 데이터를 request 요청메세지에 심어서 전송하는 방식. --> ((데이터 노출 안됨))
			
		* Request 내장객체
			- Client의 요청 정보를 갖는 객체
			- Client의 전송 데이터(Parameter)를 수신하는 기능을 가장 많이 활용한다.
	--%>
</head>
<body>
	<h3>1. JSP Request</h3>
	<h4>로그인</h4>
	<form action="./proc/login.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>	
		
	<h4>회원가입</h4>
	<form action="./proc/register.jsp" method="post" name="frm1">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label><input type="radio" name="gender" value="1" checked>남자</label>
					<label><input type="radio" name="gender" value="2">여자</label>
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<label><input type="checkbox" name="hobby" value="독서">독서하기</label>
					<label><input type="checkbox" name="hobby" value="등산">등산하기</label>
					<label><input type="checkbox" name="hobby" value="여행">여행하기</label>
					<label><input type="checkbox" name="hobby" value="운동">운동하기</label>
					<label><input type="checkbox" name="hobby" value="영화">영화감상</label>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<select name="addr">
						<option value="서울">서울특별시</option>
						<option value="대전">대전광역시</option>
						<option value="대구">대구광역시</option>
						<option value="부산">부산광역시</option>
						<option value="광주">광주광역시</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="가입완료">
				</td>
			</tr>
		</table>
	</form>		
	
	<h4>클라이언트 정보확인</h4>
	<table border="1">
		<tr>
			<td>헤더정보</td>
			<td><%=request.getHeader("User-Agent") %></td>
		</tr>
		<tr>
			<td>통신규약</td>
			<td><%=request.getProtocol() %></td>
		</tr>
		<tr>
			<td>서버이름</td>
			<td><%=request.getServerName() %></td>
		</tr>
		<tr>
			<td>요청주소</td>
			<td><%=request.getRequestURL() %></td>
		</tr>
		<tr>
			<td>요청경로</td>
			<td><%=request.getRequestURI() %></td>
		</tr>
		<tr>
			<td>클라이언트 IP</td>
			<td><%=request.getRemoteAddr() %></td>
		</tr>
	</table>
</body>
</html>















































