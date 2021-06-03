<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert</title>
</head>
<body>
	<h1>예약</h1>
	
	<form action="./proc/insertProc.jsp" method="post" name="frm1">
		<table border="1">
			<tr>
				<td>Theme</td>
				<td>
					<select name="theme">
						<option>라운지바</option>
						<option>위험한취미</option>
						<option>정의의저울</option>
						<option>박물관</option>
						<option>4.29</option>
						<option>아마존</option>
						<option>Loo</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Date</td>
				<td>
					<input type="date" name="date" value="2021-06-03">
				</td>
			</tr>
			<tr>
				<td>Time</td>
				<td>
					<input type="time" name="time">
				</td>
			</tr>
			<tr>
				<td>Person</td>
				<td>
					<select name="person">
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>
					<input type="text" name="name" placeholder="이름">
				</td>
			</tr>
			<tr>
				<td>Tel</td>
				<td>
					<input type="text" name="tel" placeholder="010-0000-0000">
				</td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td>
					<input type="email" name="email">
				</td>
			</tr>
			<tr>
				<td colspan="6" align="center">
					<input type="button" value="예약" onclick="send()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<script>
	function send() {
		if(confirm("예약하시겠습니까?")){
			frm1.submit();
		}
	}
</script>