<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/theme.css"></link>
<script>
	function del_go(frm) {
		alert("상품을 삭제합니다.");
		frm.action = "MyCon?type=deletecart";
		frm.submit();
	}
	function modify_go(frm) {
		alert("수량이 수정되었습니다.");
		frm.action = "MyCon?type=modifycart";
		frm.submit();
	}

	function go_main(frm) {
		frm.action = "MyCon?type=main";
		frm.submit();
	}

	function go_pay(frm) {
		frm.action = "MyCon?type=pay_go&user_id=${user_id }&user_pw=${user_pw }";
		frm.submit();
	}
</script>
<script>
	function go_search(frm) {
		frm.action = "MyCon?type=product_search";
		frm.submit();
	}
</script>
<script>
	$(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 500) {
				$('#MOVE_TOP_BTN').fadeIn();
			} else {
				$('#MOVE_TOP_BTN').fadeOut();
			}
		});

		$("#MOVE_TOP_BTN").click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, 400);
			return false;
		});
	});
</script>
<link rel="shortcut icon" type="image/x-icon" href="images/title.png">

</head>
<style>
body {
	font-family: 'dotum', '고딕';
}

#cart_image {
	width: 300px;
	height: 250px;
}

#cartlist_footer li {
	float: right;
	list-style: none;
	font-size: 25px;
}

.p_saleprice {
	color: #ee782f;
}

#pay {
	width: 250px;
	background-color: #ee782f;
	border: none;
	color: #fff;
	padding: 15px 0;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px;
	cursor: pointer;
}

#update {
	width: 150px;
	background-color: #ee782f;
	border: none;
	color: #fff;
	padding: 15px 0;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px;
	cursor: pointer;
}

#delete {
	width: 150px;
	background-color: #ee782f;
	border: none;
	color: #fff;
	padding: 15px 0;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px;
	cursor: pointer;
}

#cart_cnt{
	display:block;
	width:50px;
	height:50px;
	background-color: orange;
	border-radius: 50px;
	border: 1px solid orange;
	float: right;
	color: white;

	
}

#info {
	list-style: none;
	width: 1020px;
	margin: 5px auto 5px auto;
}

#first_info {
	text-align: center;
}

#info_txt {
	font-size: 18px;
}

#info ul {
	list-style-type: none;
	margin: 10px auto;
	padding: 1px auto;
	overflow: hidden;
}

#info ul li {
	margin: 0 auto;
	float: left;
	display: inline;
	font: 15px Dotum;
	padding: 0 10px;
	border-left: none;
}

#txt li {
	padding: 10px 10px 10px;
}

#info_box_c_p {
	color: #ee782f;
}

h1 {
	width:30%;
	margin: 0 auto;
	padding: 0px 0px 0px 200px;
}

#info_box {
	margin: 0 auto;
	border: 2px solid #ee782f;
	width: 350px;
	height: 70px;
	font-family: 'dotum', '돋움';
	font-size: 20px;
}

#info_box_c_p {
	color: #ee782f;
}

.img_word {
   width: 64.5%;
   height: 70px;
   position: absolute;
   top: 200px;
   right: 300px;
   left: 400px;
   bottom: Opx;

}

#empty_cart {
font-size: 30px;
margin-left: 600px;
margin-top:150px;
list-style: none;

}

h1.word {
   text-align: center;
   font-size: 40px;
   margin-top: 10px;
   margin-left: 10px;
}
</style>

<script> 
function alert_login() {
	 alert("로그인후 이용가능합니다!");
	
}
</script>

<body>
	<div id="top_button">
		<a id="MOVE_TOP_BTN"><strong>TOP</strong></a>
	</div>


	<jsp:include page="header.jsp"></jsp:include>
	<!-- header 끝나는 부분  -->

	<div id="cartlist_body">
		<div class="img_word">
			<h1 class="word">${user.cust_nickname }의 찜 리스트<div id="cart_cnt"><div><center>${zzimList.size() }</center></div></h1>
		</div>

		<form method="post" action="MyCon?type=modifycart">

			<div>
				<div>
					<c:if test="${empty zzimList}">
						<ul>
							<div id="empty_cart"><li>장바구니가 비었습니다.</li></div>
						</ul>
					</c:if>
					<div id="info">

						<c:if test="${not empty zzimList}">
							
	
							<br>
							<c:forEach var="i" begin="0" end="${zzimList.size() - 1}">

								<%-- <li><input type="checkbox" name="sel" value="${c_list[i].cart_tot_price }" onclick="itemSum(liis.form)"></li>
			--%>

								<ul>
									<br>
									<hr>
									<br>
									<br>
									<li><img id="cart_image"
										src="images/${zzimList[i].p_ori_image1 }"></li>
									<br>
									<li><span id="info_txt">제품번호 : ${zzimList[i].p_idx }</span></li>
									<br>
									<br>
									<li><span id="info_txt">제품이름 : ${zzimList[i].p_name }</span></li>
									<br>
									<br>
									
									<li><span id="info_txt">가격 : ${zzimList[i].p_price }원</span>
									
									<br>
									<br>
									
									<li> <input id="delete"
										type="button" value="삭제"
										onclick="javascript:location.href='zzimDel.do?cust_id=${cust_id }&p_idx=${zzimList[i].p_idx }'">
										</li>
								</ul>

							</c:forEach>
					</div>

					<br>
					<hr>
				</div>

			</div>


				</c:if>
		</form>
	</div>



</body>
</html>