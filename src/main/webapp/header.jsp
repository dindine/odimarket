<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header-button</title>
<link rel="stylesheet" type="text/css" href="resources/css/theme.css"></link>
<style>
h1 {
	
}

#productlist {
	width: 80%;
	margin-left: 150px;
	margin-top: 30px;
}

#infolist {
	list-style: none;
}

#list_content {
	display: flex;
}

#list_content1 {
	border-color: white;
	float: center;
	width: 25%;
}

#list_content1 li {
	margin: 0 auto;
}

#list_content2 ul li {
	list-style: none;
}

#p_price {
	font-weight: 700;
	font-size: 14px;
	
	
}

#p_saleprice {
	color: #ee782f;
	font-weight: 700;
}

#p_content, #p_category {
	overflow: hidden;
	color: #000;
}

#info ul li {
	text-align: center;
	margin: 0 auto;
}

#p_name {
	margin: 0 auto;
}
</style>
<script>


	function user_info(frm) {
		frm.action = "MyCon?type=userinfo";
		frm.submit();
	}
	
</script>
<script> 
function alert_login() {
	 alert("로그인후 이용가능합니다!");
	
}
</script>
</head>
	<div id="header-button">
		<ul>
			<br>
				<c:if test="${cust_id eq 'manager'}">		
				<li id="logo_menu"><a href="getCustomerList.do">회원 관리</a></li>
				</c:if>
				<c:choose>
					<%--로그인 했을 경우 --%>
					<c:when test="${cust_id ne null and cust_id ne ''}">
						<li id="logo_menu"> <a href="insertProduct.jsp?cust_id=${cust_id }">글 등록하기</a></li>
						<li id="logo_menu"><a href="javascript:location.href='myZzimList.do?cust_id=${cust_id }'">나의 찜한 상품</a></li>
						<li id="logo_menu"><a href="javascript:location.href='/odi/cust_update/page.do'">마이페이지</a></li>
						<li id="logo_menu"><a href="user/normal/logout.do">로그아웃</a></li>
						<li id="logo_menu"><a href="#">${user.cust_nickname }</a></li>
					</c:when>
					

					<c:otherwise>
						<%--비로그인 상태 --%>
						<li id="logo_menu"><a href="login.jsp">로그인</a></li>
						<li id="logo_menu"><a href="map1.jsp">회원가입</a></li>
					</c:otherwise>
				</c:choose>

		</ul>

		<div id="header-search">

			<div id="header_main_logo">

				<ul>
					<li><a href="main.jsp"> <strong>FOREVER YOUNG</strong></a></li>
				</ul>
			</div>

<form method="post" >
            <div id="area-search" style="width:319px; height:54px;">
               <ul>
                  <input id="input-search" name="product_search_txt" type="text"
                      placeholder="-> 검색해보세요" style="margin-bottom: 30px">
                  <li>
                  <input id="button-search" type="image" src="main_img/ic_search.png"
                        onclick="go_search(this.form)">
                  <input type="hidden" name="cust_id" value="${cust_id }">
                  <input type="hidden" name="user_pw" value="${user_pw }">
                  </li>
               </ul>
            </div>
         </form>
      </div>
   </div>
   <br>
   <hr style="margin-top: 98px; margin-bottom: 8px; border-top: 1px solid gray" >
<div id="menu">
		<ul>

			<li><a  href="getProductList.do">전체</a></li>
		      <li>
                        <c:forEach var="categoryList" items="${categoryList }">
                           <li><a  href="getProductList_cate.do?p_category=${categoryList }">${categoryList }</a></li>
                        </c:forEach>
                  </li>
                  <li><a  href="communityList.do">커뮤니티</a></li>
		</ul>
	
	</div>
</body>
</html>