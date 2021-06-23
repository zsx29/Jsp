<%@page import="kr.co.farmstory1.dao.ArticleDao"%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%

	String seq   = request.getParameter("seq");
	String group = request.getParameter("group");
	String cate  = request.getParameter("cate");
	String path  = "./_aside_"+group+".jsp";
	
	ArticleBean article = ArticleDao.getInstance().selectArticle(seq);
	
%>
<jsp:include page="<%= path %>"/>
<section id="board" class="modify">
    <h3>글수정</h3>
    <article>
        <form action="/Farmstory1/board/proc/modify.jsp">
			<input type="hidden" value="<%= seq %>" name="seq">
        	<input type="hidden" value="<%= cate %>" name="cate">
        	<input type="hidden" value="<%= group %>" name="group">
            <table>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" placeholder="제목을 입력하세요." value="<%= article.getTitle() %>"/></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content"><%= article.getContent() %></textarea>                                
                    </td>
                </tr>
            </table>
            <div>
                <a href="/Farmstory1/board/list.jsp?group=<%= group %>&cate=<%= cate %>" class="btnCancel">취소</a>
                <input type="submit"  class="btnWrite" value="수정완료">
            </div>
        </form>
    </article>
</section>
<!-- 내용 끝 -->
</article>
</section>
</div>
<%@ include file="../_footer.jsp" %>