<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
                    scrollTop: 0
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
<p><a href="community_form.jsp">글쓰기</a></p>
</body>
</html>