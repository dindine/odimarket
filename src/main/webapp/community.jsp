<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 페이지</title>
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
		interval : 2000
	})

	$('#myCarousel').on('slide.bs.carousel', function() {

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
		if (n > slides.length) {
			slideIndex = 1
		}
		if (n < 1) {
			slideIndex = slides.length
		}
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" active", "");
		}
		slides[slideIndex - 1].style.display = "block";
		dots[slideIndex - 1].className += " active";
	}
</script>
</head>
<body>
	<div id="top_button">
		<a id="MOVE_TOP_BTN"><strong>TOP</strong></a>
	</div>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="list_content" class="row">
		<c:if test="${not empty communityList }">
			<c:forEach var="product" items="${communityList }">
				<div id="list_content1" class="col-lg-3 col-md-4 col-sm-6 mb-4">

					<a
						href="communityList.do?p_idx=${product.p_idx }&cust_id=${cust_id }">
						<img src="images/${product.p_ori_image1 }" class="card-img-top">
					</a> <br> <input type="hidden" name="idx"
						value="${product.p_idx }"> <input type="hidden"
						name="p_name" value="${product.p_name  }"> <input
						type="hidden" name="type" value="productOne"> <input
						type="hidden" name="user_id" value="${user_id }"> <input
						type="hidden" name="user_pw" value="${user_pw }"> <input
						type="hidden" name="p_category" value="${product.p_category }">

					<div id="info">
						<ul id="infolist">
							<li><a style="text-decoration: none;"
								href="communityList.do?p_idx=${product.p_idx }"> <span
									id="p_name">${product.p_name }</span>
							</a></li>
							<li id="p_content">${product.p_content }&nbsp;</li>
							<li id="p_price">${product.p_price }원&nbsp;</li>
						</ul>
					</div>
				</div>
				<br>
				</table>
			</c:forEach>
		</c:if>
		<c:if test="${empty communityList }">
			<td colspan="4">입력된 자료가 없습니다.</td>
			</tr>
		</c:if>
	</div>
	<p>
		<a href="community_form.jsp?pro_b_writer=${cust_id }">글쓰기</a>
	</p>
</body>
</html>