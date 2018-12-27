<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.odi.biz.product.impl.ProductDAO"%>
<%@page import="com.odi.biz.product.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 제품번호를 사용 DB에서 제품정보 조회후 화면 출력 --%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>${product.p_name }의상세정보</title>
<link rel="shortcut icon" type="image/x-icon" href="images/title.png">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/theme.css"></link>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<link href="jquery.bxslider/jquery.bxslider.css" rel="stylesheet" /> <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script> <script src="jquery.bxslider/jquery.bxslider.js"></script>

<style>
#p_c_body {
	clear: right;
	float: right;
	padding: 50px 0px 50px 0px;
	margin-right: 250px;
	width: 30%;
	
}

#p_c_main ul li {
	list-style: none;
	
}


#pro_img {
	width: 100%;
	vertical-align: middle;
}

#info {
	padding: auto 90px 0px 0px;
	font-family: 'dotum', '돋움';
	font-size: 15px;
}

#first_info {
	font-family: 'dotum', '돋움';
	font-size: 30px;
	color: #babb3c;
}

#second_info {
	font-family: 'dotum', '돋움';
	font-size: 30px;
}

#name_price_sale {
	color: #999;
	font-family: 'Nanum Gothic';
	font-size: 17px;
	font-weight: 700;
}

#name_price_sale2 {
	float: right;
	font-family: 'Nanum Gothic';
	font-size: 17px;
	font-weight: 700;
	
}

#sale {
	color: #ee782f;
	font-family: 'Nanum Gothic';
	font-size: 17px;
	font-weight: 700;
}

#opt {
	font-family: 'dotum', '돋움';
}



#footer {
	bottom: auto;
	width: 130%;
}

#manager_btn {
font-family: 'dotum', '돋움';
background-color: transparent; 
border:3px solid orange;
padding: 2px;
color:orange;
font-weight: 700;
}
#manager_btn:hover {
	border:3px solid #babb3c;
	background-color: #babb3c;
	color: white;
}

#sel_opt {
width: 37%;
}

.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

.prev, .next {
  cursor: pointer;

}

#slider {
	margin-left: 100px;
	width: 700px;
	height: 500px;
	
}
#slidebox {
	position:relative;
	
	overflow:hidden;
	white-space:nowrap;
	float: left;
	margin-left: 100px;
}

#slidebox ul#slider {
	list-style:none;
	margin:0;
	padding:0;
}

#slidebox ul li {
	position: absolute;
	width: 700px;
	height: 500px;
	margin-left: 100px;
}

#slidebox ul li img {

}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -22px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
}

.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}


</style>


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
	 
	function product_update(frm) {
		frm.action = "updateProduct_form.do";
		frm.submit();
	}

	function delete_product(frm) {
		frm.action = "deleteProduct.do";
		frm.submit();
	}

	function go_productlist(frm) {
		frm.action = "";
		frm.submit();
	}

	function go_cartlist(frm) {
		var user_id = frm.user_id.value;
		if (typeof user_id == "undefined" || user_id == null || user_id == "") {
			alert("로그인해주세요");
			return;
		}
		frm.action = "";
		frm.submit();
	}

	function go_addcart(frm) {
		var user_id = frm.user_id.value;
		if (typeof user_id == "undefined" || user_id == null || user_id == "") {
			alert("로그인해주세요");
			return;
		}
		frm.action = "";
		frm.submit();
	}

	function go_buy(frm) { //물건 바로 구매
		var user_id = frm.user_id.value;
		if (typeof user_id == "undefined" || user_id == null || user_id == "") {
			alert("로그인해주세요");
			return;
		}
		frm.action = "";
		frm.submit();
	}
	
	
	
</script>

<script> 
function alert_login() {
	 alert("로그인후 이용가능합니다!");
	

}

$('.carousel').carousel({
	  interval: 2000
	})
	
$('#myCarousel').on('slide.bs.carousel', function () {
  
})

</script>

<script> 
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}

</script>

</head>
<body>
	<div id="top_button">
		<a id="MOVE_TOP_BTN"><strong>TOP</strong></a>
	</div>
<jsp:include page="header.jsp"></jsp:include>

		<!-- The slideshow -->
  		<div id="slidebox" class="slideshow-container">
  		
			<ul id="slider" class="slider">
			<c:forEach var="img" items="${imgarr }">
				<c:if test="${img ne null }">		
				 
  			<div class="mySlides">
				 <li id="pro_img"><img class="detail-image" src="images/${img }"></img></li>
			
				</div>
	
				</c:if>
			</c:forEach>
    			
		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
		<a class="next" onclick="plusSlides(1)">&#10095;</a>
			</ul>
			
			</div>
	
	<form method="post">
		<div id="p_c_main">
			<div id="p_c_body">
				<ul id="info">
					<li id="first_info"><strong>${product.p_category }  </strong>
					<div style="float: right;">
					
							<c:choose>
							<c:when test="${'manager' eq cust_id }">
								<input type="button" value="수정하기"
									onclick="product_update(this.form)" id="manager_btn">
								<input type="button" value="삭제하기"
									onclick="delete_product(this.form)" id="manager_btn">
							</c:when>
					</c:choose>
					</div>	
					</li>
					<li id="second_info"><strong>${product.p_name }</strong></li>
			
					<br>
					<li id="name_price_sale">상세 정보</li>
					<li id="name_price_sale2" style="float:left; margin-top: 10px; margin-bottom: 5px;">${product.p_content }</li>
					<br>
					<li id="name_price_sale2">${product.p_price }원</li>
					<li id="name_price_sale"><br>판매가</li>
					<br>
					<hr>
					<br>
					<li id="name_price_sale2">3%</li>
					<li id="name_price_sale">forever young 포인트 예상 적립</li>
					<br>
					<hr>
					<br>
					<li> 
					<script>
					function login() {
						var user_id = "${cust_id }";
						if (typeof user_id == "undefined" || user_id == null || user_id == "") {
							alert("로그인해주세요");
							return;
						}
						like_func();
					}
					
					function like_func() {

						var frm_read = $('#frm_read');
						var p_idx = $('#p_idx', frm_read).val();
						
						$.ajax({
							url:"like.do?cust_id=${cust_id }&p_idx=${product.p_idx }",
							type: "GET",
							cache: false,
							dataType: "json",
							data: 'p_idx=' + p_idx,
							success: function(data) {
								var msg = '';
								var like_img = '';
								msg += data.msg;
								
								if(data.zzim_check == '0') {
									like_img = "images/emptyheart.png";
								} else {
									like_img = "images/fullheart.png";
								}
								$('#like_img').attr('src', like_img);
								$('#zzim').html(data.zzim_cnt);
								$('#zzim_check').html(data.zzim_check);
							},
							error: function(request, status, error) {
								alert("code : " + request.status+"\n"+"message:" + request.responseText+"\n"+"error:" + error);
							}
						});
					}
					</script>
					
					<li>
					<!--  -->
					<c:choose>
					<c:when test="${zzimInfo.zzim_check eq '1' }">
					<a href="javascript:login();"><img src="images/fullheart.png" id="like_img"></a><span id="zzim">${product.zzim }</span>
					</c:when>
					<c:otherwise>
					<a href="javascript:login();"><img src="images/emptyheart.png" id="like_img"></a><span id="zzim" >${product.zzim }</span>
					</c:otherwise>
					</c:choose>
					</li>
					<li> 

						<input width="150px" type="image" src="main_img/data14.PNG"
						value="장바구니 담기" onclick="go_addcart(this.form)"> 
						<input width="150px" type="image" src="main_img/data15.PNG"
						value="장바구니 보기" onclick="go_cartlist(this.form)"> 
						<input width="150px" type="image" src="main_img/data13.PNG" value="구매"
						onclick="go_buy(this.form)">
						<!--  
						<input type="hidden" name="user_id" value="${user_id }"> 
						<input type="hidden" name="user_pw" value="${user_pw }">
						 -->
					    <input type="hidden" name="p_idx" value="${product.p_idx }">  
					    <input type="hidden" name="p_price" value="${product.p_price }"> 
					    <input type="hidden" name="p_ori_image" value="${product.p_ori_image1 }">
					    <input type="hidden" name="p_ori_image" value="${product.p_ori_image2 }">
					    <input type="hidden" name="p_ori_image" value="${product.p_ori_image3 }">
					    <input type="hidden" name="p_ori_image" value="${product.p_ori_image4 }">
					    <input type="hidden" name="p_ori_image" value="${product.p_ori_image5 }">
						<input type="hidden" name="p_cnt" value="1"> 
						<input type="hidden" name="p_name" value="${product.p_name }">
						<input type="hidden" name="cPage" value="${cPage }">
						<input type="hidden" name=p_category value="${product.p_category }">
						</li>
				</ul>

			</div>

		</div>
		
	</form>

					
					
					


</body>
</html>