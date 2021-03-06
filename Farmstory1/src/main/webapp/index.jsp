<%@page import="java.util.List"%>
<%@page import="kr.co.farmstory1.dao.ArticleDao"%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<%

	// 최신글 가져오기
	List<ArticleBean> latests = ArticleDao.getInstance().selectLatests();

%>


<!-- image-slider -->
<script>
    $(function(){

        $('.slider > ul').bxSlider({
            slideWidth: 980,
            pager: false,
            controls: false,
            auto: true
        });

        $('#tabs').tabs();

    });
</script>

<main>

	<!-- slider-start -->
    <div class="slider">
        <ul>
            <li><img src="/Farmstory1/img/main_slide_img1.jpg" alt="슬라이더1"></li>
            <li><img src="/Farmstory1/img/main_slide_img2.jpg" alt="슬라이더2"></li>
            <li><img src="/Farmstory1/img/main_slide_img3.jpg" alt="슬라이더3"></li>
        </ul>
        <img src="/Farmstory1/img/main_slide_img_tit.png" alt="사람과 자연을 사랑하는 팜스토리"/>
        <div class="banner">
            <img src="/Farmstory1/img/main_banner_txt.png" alt="GRAND OPEN"/>
            <img src="/Farmstory1/img/main_banner_tit.png" alt="팜스토리 오픈기념 30% 할인 이벤트"/>
            <img src="/Farmstory1/img/main_banner_img.png" alt="과일"/>
        </div>
    </div>
    <!-- slider-end -->
    
    <!-- quick-start -->
    <div class="quick">
        <a href="/Farmstory1/board/list.jsp?group=community&cate=menu"><img src="/Farmstory1/img/main_banner_sub1_tit.png" alt="오늘의 식단"></a>
        <a href="/Farmstory1/board/list.jsp?group=community&cate=chef"><img src="/Farmstory1/img/main_banner_sub2_tit.png" alt="나도 요리사"></a>                
    </div>
    <!-- quick-end -->
    
    <!-- latest-start -->

    <div class="latest">
        <div>
            <a href="/Farmstory1/board/list.jsp?group=croptalk&cate=grow"><img src="/Farmstory1/img/main_latest1_tit.png" alt="텃밭 가꾸기"/></a>
            <img src="/Farmstory1/img/main_latest1_img.jpg" alt="이미지"/>
            <table border="0">
            	<% for(int i = 0; i < 5; i++){ %>
                <tr>
                    <td>></td>
                    <td><a href="/Farmstory1/board/view.jsp?group=croptalk&cate=<%= latests.get(i).getCate() %>&seq=<%= latests.get(i).getSeq() %>"><%= latests.get(i).getTitle() %></a></td>
                    <td><%= latests.get(i).getRdate() %></td>
                </tr>
                <% } %>
            </table>
        </div>
        <div>
            <a href="/Farmstory1/board/list.jsp?group=croptalk&cate=school"><img src="/Farmstory1/img/main_latest2_tit.png" alt="귀농학교"/></a>
            <img src="/Farmstory1/img/main_latest2_img.jpg" alt="이미지"/>
            <table border="0">
            	<% for(int i = 5; i < 10; i++){ %>
                <tr>
                    <td>></td>
                    <td><a href="/Farmstory1/board/view.jsp?group=croptalk&cate=<%= latests.get(i).getCate() %>&seq=<%= latests.get(i).getSeq() %>"><%= latests.get(i).getTitle() %></a></td>
                    <td><%= latests.get(i).getRdate() %></td>
                </tr>
                <% } %>
            </table>
        </div>
        <div>
            <a href="/Farmstory1/board/list.jsp?group=croptalk&cate=story"><img src="/Farmstory1/img/main_latest3_tit.png" alt="농작물 이야기"/></a>
            <img src="/Farmstory1/img/main_latest3_img.jpg" alt="이미지"/>
            <table border="0">
            	<% for(int i = 10; i < 15; i++){ %>
                <tr>
                    <td>></td>
                    <td><a href="/Farmstory1/board/view.jsp?group=croptalk&cate=<%= latests.get(i).getCate() %>&seq=<%= latests.get(i).getSeq() %>"><%= latests.get(i).getTitle() %></a></td>
                    <td><%= latests.get(i).getRdate() %></td>
                </tr>
                <% } %>
            </table>
        </div>
        
    </div>
    <!-- latest-end -->
    
    <!-- info-start -->
    <div class="info">
        <div>
            <img src="/Farmstory1/img/main_sub2_cs_tit.png" class="tit" alt="고객센터 안내"/>
        </div>
        <div>
            <img src="/Farmstory1/img/main_sub2_account_tit.png" class="tit" alt="계좌안내"/>
            <p class="account">
                기업은행 123-456789-01-01-012<br />
                국민은행 01-1234-56789<br />
                우리은행 123-456789-01-01-012<br />
                하나은행 123-456789-01-01<br />
                예 금 주 (주)팜스토리
            </p>
        </div>
        <div>
            <div id="tabs">
                <ul>
                    <li><a href="#tabs-1">공지사항</a></li>
                    <li><a href="#tabs-2">1:1 고객문의</a></li>
                    <li><a href="#tabs-3">자주묻는 질문</a></li>
                </ul>
                <div id="tabs-1">
                	<% for(int i = 15; i < 18; i++){ %>
                    <ul>
                        <li><a href="/Farmstory1/board/view.jsp?group=community&cate=<%= latests.get(i).getCate() %>&seq=<%= latests.get(i).getSeq() %>"><%= latests.get(i).getTitle() %></a></li>
                    </ul>
                    <% } %>
                </div>
                <div id="tabs-2">
                	<% for(int i = 18; i < 21; i++){ %>
                    <ul>
                        <li><a href="/Farmstory1/board/view.jsp?group=community&cate=<%= latests.get(i).getCate() %>&seq=<%= latests.get(i).getSeq() %>"><%= latests.get(i).getTitle() %></a></li>

                    </ul>
                    <% } %>
                </div>
                <div id="tabs-3">
                	<% for(int i = 21; i < 24; i++){ %>
                    <ul>
                        <li><a href="/Farmstory1/board/view.jsp?group=community&cate=<%= latests.get(i).getCate() %>&seq=<%= latests.get(i).getSeq() %>"><%= latests.get(i).getTitle() %></a></li>
					</ul>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
    <!-- info-end -->
</main>
<%@ include file="./_footer.jsp" %>






        