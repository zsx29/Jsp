<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글목록</title>
    <link rel="stylesheet" href="/JBoard2/css/style.css">    
</head>
<body>
    <div id="wrapper">
        <section id="board" class="list">
            <h3>글목록</h3>
            <article>
                <p>
                    ${sessMember.nick}님 반갑습니다.
                    <a href="/JBoard2/user/logout.do" class="logout">[로그아웃]</a>
                </p>
                <table border="0">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>날짜</th>
                        <th>조회</th>
                    </tr>
                    <tr>
                        <td>${av.seq }</td>
                        <td><a href="/JBoard2/view.do">${av.title}</a>&nbsp;[3]</td>
                        <td>${av.nick }</td>
                        <td>${av.rdate }</td>
                        <td>12</td>
                    </tr>
                </table>
            </article>

            <!-- 페이지 네비게이션 -->
            <div class="paging">
                <a href="#" class="prev">이전</a>
                <a href="#" class="num current">1</a>                
                <a href="#" class="num">2</a>                
                <a href="#" class="num">3</a>                
                <a href="#" class="next">다음</a>
            </div>

            <!-- 글쓰기 버튼 -->
            <a href="./write.html" class="btnWrite">글쓰기</a>

        </section>
    </div>    
</body>
</html>