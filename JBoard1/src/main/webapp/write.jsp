<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
    <link rel="stylesheet" href="/JBoard1/css/style.css"/>
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <section id="board" class="write">
            <h3>글쓰기</h3>
            <article>
                <form action="/JBoard1/proc/write.jsp" method="post" enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" name="title" placeholder="제목을 입력하세요."/></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>
                                <textarea name="content"></textarea>                                
                            </td>
                        </tr>
                        <tr>
                            <td>첨부</td>
                            <td><input type="file" name="fname" onchange="fileSizeCheck(this)"/></td>
                        </tr>
                    </table>
                    <div>
                        <a href="/JBoard1/list.jsp" class="btnCancel">취소</a>
                        <input type="submit"  class="btnWrite" value="작성완료">
                    </div>
                </form>
            </article>
        </section>
    </div>
</body>
</html>
<script>

	// 업로드 용량 제한 함수
	function fileSizeCheck(input) {
		if(input.files && input.files[0].size > (1024 * 1024 * 10)){
			alert("최대 업로드 용량은 10mb 입니다.");
			input.value = null;
		}
	}
</script>