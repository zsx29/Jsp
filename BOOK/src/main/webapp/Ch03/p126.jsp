<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>if-else문 예제 - 좋아하는 색 선택</h2>
	<form action="ifTest.jsp" method="post">
		<dl>
			<dd>
				<label for="name">이름</label>
				<input id="name" name="name" type="text" placeholder="홍길동" autofocus required>
			</dd>
			<dd>
				<label for="color">색선택</label>
				<select id="color" name="name" required>
					<option value="blue" selected>파란색
					<option value="green">초록색
					<option value="red">빨간색
					<option value="orange">주황색
				</select>
			</dd>
			<dd>
				<input type="submit" value="확인">
			</dd>
		</dl>
	</form>
	<%
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String selectColor = "";
		
		if(color.equals("blue")){
			selectColor ="파랑색";
		}else if(color.equals("green")){
			selectColor ="초록색";
		}else if(color.equals("red")){
			selectColor ="빨간색";
			
		}else{
			selectColor ="기타색";
			
		}
	%>
	
	<%=name %>님이 선택한 색은 <%=selectColor %>입니다.
	선택한 색 : <img alt="" src="<%=color + ".jpg%>" border="0">
	
</body>
</html>