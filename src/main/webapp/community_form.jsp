<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>community_form</title>

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
			document.getElementById('opt').innerHTML += createInput(
					arrInput[intI], arrInputValue[intI]);
		}
	}

	function saveValue(intId, strValue) {// 추가되는 텍스트 박스의 값 저장
		arrInputValue[intId] = strValue;
	}

	function createInput(id, value) { //옵션 텍스트 태그 추가
		return "<input type='text' name='opt" + id
				+ "' onChange='javascript:saveValue(" + id
				+ ",this.value)' value='" + value + "'><br>";
	}

	function deleteInput() { //옵션 텍스트 필드 삭제
		if (arrInput.length > 0) {
			arrInput.pop();
			arrInputValue.pop();
		}
		display();
	}

	function list_go() {
		location.href = "getCommunityList.do";
	}

	function sendData(frm) {
		frm.action = "insertCommunity.do";
		frm.submit();
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="pro">
		<form method="post" enctype="multipart/form-data">

			<h1>게시글 쓰기</h1>
			<br>
			<div id="form">

				<li>이름 <span id="txt"><input type="text" name="p_name"
						value="${product.p_name }" size="12"></span></li>

				<li>가격 <span id="txt"><input type="text" name="p_price"
						value="${product.p_price }" size="12">원</span>
				</li>

				<li>옵션
					<div id="opt"></div> <input id="button_add_del" type="button"
					value="추가" onclick="addInput()" /> <input id="button_add_del"
					type="button" value="삭제" onclick="deleteInput()" />
				</li>

				<li>내용<span id="txt"><textarea name="p_content" rows="8"
							cols="50">${product.p_content }</textarea></span></li>

				<div class="filebox preview-image">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input multiple="multiple"
						type="file" id="input-file" class="upload-hidden"
						name="uploadfile" value=${product.p_ori_image1 }>

				</div>

				<div class="filebox preview-image">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input multiple="multiple"
						type="file" id="input-file" class="upload-hidden"
						name="uploadfile2" value=${product.p_ori_image2 }>
				</div>

				<div class="filebox preview-image">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input multiple="multiple"
						type="file" id="input-file" class="upload-hidden"
						name="uploadfile3" value=${product.p_ori_image3 }>
				</div>
				<div class="filebox preview-image">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input multiple="multiple"
						type="file" id="input-file" class="upload-hidden"
						name="uploadfile4" value=${product.p_ori_image4 }>
				</div>
				<div class="filebox preview-image">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input multiple="multiple"
						type="file" id="input-file" class="upload-hidden"
						name="uploadfile5" value=${product.p_ori_image5 }>
				</div>

				<input type="hidden" name="p_ori_image1"
					value="${product.p_ori_image1 }"> <input type="hidden"
					name="p_ori_image2" value="${product.p_ori_image2 }"> <input
					type="hidden" name="p_ori_image3" value="${product.p_ori_image3 }">
				<input type="hidden" name="p_ori_image4"
					value="${product.p_ori_image4 }"> <input type="hidden"
					name="p_ori_image5" value="${product.p_ori_image5 }"> <input
					type="hidden" name="p_new_image1" value="${product.p_new_image1 }">
				<input type="hidden" name="p_new_image2"
					value="${product.p_new_image2 }"> <input type="hidden"
					name="p_new_image3" value="${product.p_new_image3 }"> <input
					type="hidden" name="p_new_image4" value="${product.p_new_image4 }">
				<input type="hidden" name="p_new_image5"
					value="${product.p_new_image5 }"> <input type="hidden"
					name="p_idx" value="${product.p_idx }">
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input id="button"
					type="button" value="저장" onclick="sendData(this.form)"> <input
					id="button" type="reset" value="다시작성"> <input id="button"
					type="button" value="목록" onclick="list_go()"> <input
					type="hidden" name="product_reg_chk" value="chk"> <input
					type="hidden" name="user_id" value="${user_id }"> <input
					type="hidden" name="user_pw" value="${user_pw }">
				</li> <input type="hidden" name="p_category" value="${p_category }">
			</div>
		</form>
	</div>
</body>
</html>