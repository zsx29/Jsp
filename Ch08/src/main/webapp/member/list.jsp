<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListService</title>
</head>
<body>
	<h1>List</h1>
	<a href="../member/register.do">직원등록</a>
	<h3>직원목록</h3>
	<form action="./proc/insertProc.jsp" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>직급</th>
				<th>부서</th>
				<th>입사일</th>
				<th>기타</th>
			</tr>
			<tr>
				<td>zsx29</td>
				<td>박재형</td>
				<td>010-9214-8036</td>
				<td>인턴</td>
				<td>101</td>
				<td>21-08-09</td>
				<td><a href="../member/modify.do">수정</a> <a href="#">삭제</a></td>
			</tr>
		</table>
	</form>
</body>
</html>





























