<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>header-button</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/theme.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

    <script>
        function alert_login() {
            alert("로그인후 이용가능합니다!");

        }

        function go_search(frm) {
            frm.action = "";
            frm.submit();
        }
    </script>
</head>
<div id="header-button">
    <ul class="list-group list-group-flush">
        <br>
        <c:if test="${cust_id eq 'manager'}">
            <li id="logo_menu"><a href="getCustomerList.do">회원 관리</a></li>
        </c:if>
        <c:choose>
            <%--로그인 했을 경우 --%>
            <c:when test="${cust_id ne null and cust_id ne ''}">
                <li id="logo_menu" class="list-group-item">
                    <a href="javascript:location.href='myZzimList.do?cust_id=${cust_id }'">나의 찜한 상품</a>
                </li>
                <li id="logo_menu" class="list-group-item">
                    <a href="javascript:location.href='/odi/cust_update/page.do'">마이페이지</a>
                </li>
                <li id="logo_menu" class="list-group-item">
                    <a href="user/normal/logout.do">로그아웃</a>
                </li>
                <li id="logo_menu" class="list-group-item">
                    <a href="#">${user.cust_nickname }</a>
                </li>
            </c:when>
            <c:otherwise>
                <%--비로그인 상태 --%>
                <li id="logo_menu" class="list-group-item">
                    <a href="map1.jsp">회원가입</a>
                </li>
                <li id="logo_menu" class="list-group-item">
                    <a href="login.jsp">로그인</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>

    <div id="header-search">
        <div id="header_main_logo">
            <ul>
                <li><a href="main.jsp"> <strong>오디마켓</strong></a></li>
            </ul>
        </div>
        <form method="post">
            <div id="area-search" style="width: 319px; height: 54px;">
                <ul>
                    <input id="input-search" name="product_search_txt" type="text"
                           placeholder="-> 검색해보세요" style="margin-bottom: 30px">
                    <li><input id="button-search" type="image"
                               src="main_img/ic_search.png" onclick="go_search(this.form)">
                        <input type="hidden" name="cust_id" value="${cust_id }"> <input
                                type="hidden" name="user_pw" value="${user_pw }"></li>
                </ul>
            </div>
        </form>
    </div>
</div>
<br>
<hr style="margin-top: 98px; margin-bottom: 8px; border-top: 1px solid gray">
<div id="menu">
    <ul>

        <li><a href="getProductList.do">전체</a></li>
        <li><c:forEach var="categoryList" items="${categoryList }">
        <li><a
                href="getProductList_cate.do?p_category=${categoryList }">${categoryList }</a></li>
        </c:forEach></li>
    </ul>
</div>
</body>
</html>