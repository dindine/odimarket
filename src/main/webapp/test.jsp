<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <title>test</title>
  </head>
  <body>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    
    
    
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
                    <a class="btn btn-default" href="javascript:location.href='myZzimList.do?cust_id=${cust_id }'">나의 찜한 상품</a>
                </li>
                <li id="logo_menu" class="list-group-item">
                    <a class="btn btn-default" href="javascript:location.href='/odi/cust_update/page.do'">마이페이지</a>
                </li>
                <li id="logo_menu" class="list-group-item">
                    <a class="btn btn-default" href="user/normal/logout.do">로그아웃</a>
                </li>
                <li id="logo_menu" class="list-group-item">
                    <a class="btn btn-default" href="#">${user.cust_nickname }</a>
                </li>
            </c:when>
            <c:otherwise>
                <%--비로그인 상태 --%>
                <li id="logo_menu" class="list-group-item">
                    <a class="btn btn-default" href="map1.jsp">회원가입</a>
                </li>
                <li id="logo_menu" class="list-group-item">
                    <a class="btn btn-default" href="login.jsp">로그인</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>

    <div id="header-search">
        <div id="header_main_logo">
            <ul>
                <li><a class="btn" href="main.jsp"> <strong>오디마켓</strong></a></li>
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