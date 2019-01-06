<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="images/title.png">
    <link rel="stylesheet" type="text/css" href="resources/css/theme.css"></link>
    <script>
        var arrInput = new Array(0);
        var arrInputValue = new Array(0);

        function addInput() {//옵션 텍스트 필드 추가
            arrInput.push(arrInput.length);
            arrInputValue.push("");
            display();
        }

        function display() { //옵션 텍스트박스 화면 출력
            document.getElementById('opt').innerHTML = "";
            for (intI = 0; intI < arrInput.length; intI++) {
                document.getElementById('opt').innerHTML += createInput(arrInput[intI], arrInputValue[intI]);
            }
        }

        function saveValue(intId, strValue) {// 추가되는 텍스트 박스의 값 저장
            arrInputValue[intId] = strValue;
        }

        function createInput(id, value) { //옵션 텍스트 태그 추가
            return "<input type='text' name='opt" + id + "' onChange='javascript:saveValue(" + id + ",this.value)' value='" + value + "'><br>";
        }

        function deleteInput() { //옵션 텍스트 필드 삭제
            if (arrInput.length > 0) {
                arrInput.pop();
                arrInputValue.pop();
            }
            display();
        }

        function list_go() {
            location.href = "";
        }

        function sendData(frm) {
            //form에 name속성을 지정안하면, document에서 form들을 배열형태로 찾는데 첫번째 폼을 찾겠다!
            /*
              for (var i = 0; i < frm.elements.length; i++) {
                if (frm.elements[i].value.trim() == "") {
                   if (i == 5)
                      continue; // 파일첨부는 안해도 입력되도록 처리!
                  // alert(frm.elements[i].name + "를 입력하세요"); //각 입력칸에 비어있는곳이 있으면 alert창을 띄운다.
                   frm.elements[i].focus();
                   return;

                }
             }
              */
            frm.action = "updateProduct.do";
            frm.submit();
        }
    </script>
    <script>
        function go_search(frm) {
            frm.action = "";
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
                    scrollTop: 0
                }, 400);
                return false;
            });
        });
    </script>
</head>
<style>
    #pro {
        width: 440px;
        margin: 0 auto;
    }

    #pro li {
        text-align: left;
        padding: 7px;
        list-style: none;
        padding: 10px;
    }

    h1 {
        text-align: center;
    }

    /* imaged preview */
    .filebox .upload-display { /* 이미지가 표시될 지역 */
        margin-bottom: 5px;
    }

    @media ( min-width: 768px) {
        .filebox .upload-display {
            display: inline-block;
            margin-right: 5px;
            margin-bottom: 0;
        }
    }

    .filebox .upload-thumb-wrap { /* 추가될 이미지를 감싸는 요소 */
        display: inline-block;
        width: 40px;
        padding: 2px;
        vertical-align: middle;
        border: 1px solid #ddd;
        border-radius: 5px;
        background-color: #fff;
    }

    .filebox .upload-display img { /* 추가될 이미지 */
        display: block;
        max-width: 100%;
        width: 100% \9;
        height: auto;
    }

    #button_add_del {
        width: 50px;
        background-color: #ee782f;
        border: none;
        color: #fff;
        padding: 10px 0px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 8px;
        margin: 7px;
        cursor: pointer;

    }

    #button {
        width: 90px;
        background-color: #ee782f;
        border: none;
        color: #fff;
        padding: 10px 0px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 12px;
        margin: 7px;
        cursor: pointer;
        height: 40px;
    }

    #txt {
        text-align: left;
        padding: 7px 20px 0px;
    }

    #form {
        border: 2px solid #ee782f;
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
<jsp:include page="header.jsp" />
<div id="pro">
    <form method="post" enctype="multipart/form-data">
        <%--  <input multiple="multiple" type="file" name="file" />--%>
        <h1>상품 수정</h1><br>
        <div id="form">
            <%--
                   <li>카테고리<span id="txt"><select name="category">
                         <c:forEach var="cate" items="${category_list }">
                            <option>${cate }</option>
                         </c:forEach>
                   </select></span></li>
             --%>
            <li>이름
                <span id="txt"><input type="text" name="p_name" value=${product.p_name } size="12"></span></li>

            <li>가격
                <span id="txt"><input type="text" name="p_price" value=${product.p_price } size="12">원</span>
            </li>

            <li>옵션
                <div id="opt"></div>
                <input id="button_add_del" type="button" value="추가"
                       onclick="addInput()"/> <input id="button_add_del" type="button" value="삭제"
                                                     onclick="deleteInput()"/></li>

            <li>내용<span id="txt"><textarea name="p_content" rows="8" cols="50">${product.p_content }</textarea></span>
            </li>


            <div class="filebox preview-image">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input multiple="multiple" type="file" id="input-file" class="upload-hidden" name="uploadfile"
                       value=${product.p_ori_image1 }>

            </div>

            <div class="filebox preview-image">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input multiple="multiple" type="file" id="input-file" class="upload-hidden" name="uploadfile2"
                       value=${product.p_ori_image2 }>
            </div>

            <div class="filebox preview-image">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input multiple="multiple" type="file" id="input-file" class="upload-hidden" name="uploadfile3"
                       value=${product.p_ori_image3 }>
            </div>
            <div class="filebox preview-image">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input multiple="multiple" type="file" id="input-file" class="upload-hidden" name="uploadfile4"
                       value=${product.p_ori_image4 }>
            </div>
            <div class="filebox preview-image">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input multiple="multiple" type="file" id="input-file" class="upload-hidden" name="uploadfile5"
                       value=${product.p_ori_image5 }>
            </div>

            <input type="hidden" name="p_ori_image1" value="${product.p_ori_image1 }">
            <input type="hidden" name="p_ori_image2" value="${product.p_ori_image2 }">
            <input type="hidden" name="p_ori_image3" value="${product.p_ori_image3 }">
            <input type="hidden" name="p_ori_image4" value="${product.p_ori_image4 }">
            <input type="hidden" name="p_ori_image5" value="${product.p_ori_image5 }">

            <input type="hidden" name="p_new_image1" value="${product.p_new_image1 }">
            <input type="hidden" name="p_new_image2" value="${product.p_new_image2 }">
            <input type="hidden" name="p_new_image3" value="${product.p_new_image3 }">
            <input type="hidden" name="p_new_image4" value="${product.p_new_image4 }">
            <input type="hidden" name="p_new_image5" value="${product.p_new_image5 }">

            <input type="hidden" name="p_idx" value="${product.p_idx }">

            <li>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="button" type="button" value="저장" onclick="sendData(this.form)">
                <input id="button" type="reset" value="다시작성">
                <input id="button" type="button" value="목록" onclick="list_go()"> <input
                    type="hidden" name="product_reg_chk" value="chk">
                <input type="hidden" name="user_id" value="${user_id }">
                <input type="hidden" name="user_pw" value="${user_pw }"></li>
            <input type="hidden" name="p_category" value="${p_category }">
        </div>


    </form>
</div>
<br><br>
<hr>
</body>
</html>