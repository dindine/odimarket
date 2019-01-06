<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전체목록</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/title.png">
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

        /******* 페이지 표시 부분 스타일(시작) *****/
        .paging {
            list-style: none;
            margin-left: 700px;
        }

        .paging li {
            float: left;
            margin-right: 8px;
        }

        .paging li a {
            text-decoration: none;
            display: block;
            padding: 3px 7px;
            font-weight: bold;
            color: #bbb;
        }

        .paging li a:hover {
            border-radius: 50%;
            background-color: #babb3c;
            color: white;
        }

        .paging .disable {
            padding: 3px 7px;
            color: silver;
        }

        .paging .now {
            padding: 3px 7px;
            color: black;
            font-weight: bold;
        }

        #manager_btn {
            font-family: 'dotum', '돋움';
            background-color: transparent;
            border: 3px solid orange;
            border-radius: 10px;
            padding: 10px;
            color: orange;
            font-weight: 700;
            float: right;
            position: fixed;
            right: 2%;
            bottom: 450px;
            z-index: 999;
            margin-top: 10px;
            font-size: 20px;

        }

        #manager_btn:hover {
            border: 3px solid #babb3c;
            background-color: #babb3c;
            color: white;
        }

        #manager {
            float: right;
            width: 10%;
            height: 10%;
            display: block;
        }

        .head {
            text-align: left;
            font-size: 50px;
        }

        #cate_name {
            margin-left: 80px;
            margin-bottom: 30px;
        }

        a#MOVE_TOP_BTN {
            position: fixed;
            right: 2%;
            bottom: 50px;
            display: none;
            z-index: 999;
            border: 1px solid #999;
            padding: 10px;
            color: #999;
            font-family: 'dotum', '돋움';
        }

        #top_button a:hover {
            background-color: gray;
            color: white;
        }
    </style>

    <script>
        $(function() {
            $(window).scroll(function() {
                if ($(this).scrollTop() > 500) {
                    $('#MOVE_TOP_BTN').fadeIn();
                    $('#manager_btn').stop();
                    $('#manager_btn').animate({'top': scrollTop});


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

        function user_info(frm) {
            frm.action = "MyCon?type=userinfo";
            frm.submit();
        }

        function add_product(frm) {
            frm.action = "MyCon?type=productReg_main&user_id=${user_id }&user_pw=${user_pw }&p_category=${p_category }";
            frm.submit();

        }

        function go_search(frm) {
            frm.action = "MyCon?type=product_search";
            frm.submit();
        }

        function alert_login() {
            alert("로그인후 이용가능합니다!");

        }
    </script>
</head>
<body>
<div id="top_button">
    <a id="MOVE_TOP_BTN"><strong>TOP</strong></a>
</div>

<jsp:include page="header.jsp"></jsp:include>
<div id="productlist">
    <form method="post">
        <div class="head">
            <div id="cate_name"></div>

            <c:if test="${cust_id eq 'manager' }">
                <div id="manager">
                    <input type="button" value="상품 추가"
                           onclick="add_product(this.form)" id="manager_btn">
                </div>
            </c:if>
        </div>
        <p>
            <a href="MyCon?type=productReg_main"></a>
        </p>


        <div id="list_content" class="row">
            <c:if test="${not empty productList }">
                <c:forEach var="product" items="${productList }">
                    <div id="list_content1" class="col-lg-3 col-md-4 col-sm-6 mb-4">

                        <a href="getProduct.do?p_idx=${product.p_idx }&cust_id=${cust_id }">
                            <img src="images/${product.p_ori_image1 }" class="card-img-top">
                        </a>


                        <br> <input type="hidden" name="idx" value="${product.p_idx }">
                        <input type="hidden" name="p_name" value="${product.p_name  }">
                        <input type="hidden" name="type" value="productOne">
                        <input type="hidden" name="user_id" value="${user_id }">
                        <input type="hidden" name="user_pw" value="${user_pw }">
                        <input type="hidden" name="p_category" value="${product.p_category }">

                        <div id="info">
                            <ul id="infolist">
                                <li>
                                    <a style="text-decoration:none;" href="getProduct.do?p_idx=${product.p_idx }">
                                        <span id="p_name">${product.p_name }</span>
                                    </a>
                                </li>
                                <li id="p_content">${product.p_content }&nbsp;</li>

                                <li id="p_price">${product.p_price }원&nbsp;</li>


                            </ul>

                        </div>

                    </div>
                    <br>
                    </table>
                </c:forEach>
            </c:if>

            <c:if test="${empty productList }">

                <td colspan="4">입력된 자료가 없습니다</td>
                </tr>
            </c:if>
        </div>
    </form>
</div>

<div module="product_normalpaging" class="pagination_wrap">
    <nav aria-label="Page navigation example">
        <ol class="paging">
            <%--[이전으로]에 대한 사용여부 처리 --%>
            <c:choose>
                <%--사용불가(disable) : 첫번째 블록인 경우 --%>

                <c:when test="${pvo.beginPage < pvo.pagePerBlock }">
                    <%-- begin page가 1이 아닌경우 --%>
                    <li class="disable">&lt;</li>
                </c:when>

                <%--사용가능(enable) : 첫번째 블록이 아닌 경우 => 2페이지 이상 --%>
                <c:otherwise>
                    <li class="enable"><a
                            href="MyCon?type=category&p_category=${p_category }&pPage=${pvo.beginPage - 1}&user_id=${user_id }&user_pw=${user_pw }">&lt;</a>
                    </li>

                </c:otherwise>
            </c:choose>

            <%-- 블록내에 표시할 페이지 반복처리 --%>
            <%-- 현재블록 시작페이지~끝페이지 표시 --%>

            <c:forEach var="k" begin="${pvo.beginPage }" end="${pvo.endPage }">
                <c:choose>
                    <c:when test="${k == pvo.nowPage }">
                        <li class="now">${k }</li>
                    </c:when>
                    <c:otherwise>
                        <li><a
                                href="MyCon?type=category&p_category=${p_category }&pPage=${k }&user_id=${user_id }&user_pw=${user_pw }">${k }</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <%--[다음으로]에 대한 사용여부 처리 --%>
            <c:choose>
                <%--사용불가(disable) : 마지막 블록인 경우 -> endPage가 전체페이지수 보다 크거나 같으면 --%>
                <c:when test="${pvo.endPage >= pvo.totalPage }">
                    <li class="disable">&gt;</li>
                </c:when>
                <%--사용가능(enable) : 마지막 블록이 아닌 경우 --%>
                <c:otherwise>
                    <li class="enable"><a
                            href="MyCon?type=category&p_category=${p_category }&pPage=${pvo.endPage + 1 }&user_id=${user_id }&user_pw=${user_pw }">&gt;</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ol>
    </nav>
</div>
<br>
</body>
</html>