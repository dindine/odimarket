<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

/******* 페이지 표시 부분 스타일(시작) *****/
.paging {
	list-style: none;
	float: right;
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
/***********************************************************/
div {
	display: block;
}

#writer {
	font-size: 13px;
}

#content {
	font-size: 13px;
}

.comment ul {
	margin-left: 20px;
}

.comment_form_field {
	font-size: 0;
	height: auto;
	width: 70%;
	margin-top: 10px;
	margin-bottom: 20px;
	padding: 15px 13px;
	border: 1px solid #dadada;
	position: relative;
}

.comments_form {
	font-size: 12px;
	min-height: 10px;
	height: auto;
	font-size: 13px;
	line-height: 14px;
	margin: 0px;
	border: 0;
	width: 90%;
	outline: transparent;
	resize: none;
	overflow: hidden;
}

.comment_save_btn {
	float: right;
	font-size: 13px;
	padding: 3px 3px;
	border: 1px solid silver;
	color: #b07c58;
	background-color: white;
}

.save_btn_span {
	margin-bottom: 10px;
}

.div_total_div {
	float: right;
	height: auto;
	width: 95%;
	border: 1px solid silver;
	padding: 10px;
	margin: 20px 10px 20px 10px;
}

.review {
	width: 80%;
	height: auto;
}

.review_cnt {
	color: #9e1200;
	margin-left: 10px;
	margin-bottom: 20px;
}

#img {
	width: 100%;
	height: 100%;
}

#update_form {
	border: 1px solid #dadada;
}

textarea {
	-webkit-appearance: textarea;
	background-color: white;
	-webkit-rtl-ordering: logical;
	flex-direction: column;
	resize: auto;
	cursor: text;
	white-space: pre-wrap;
	overflow-wrap: break-word;
	border-width: 1px;
	border-style: solid;
	border-color: initial;
	border-image: initial;
	padding: 2px;
}
</style>
<script>
	function save_ans(frm) {
		var user_id = frm.cust_id.value;

		if (typeof user_id == "undefined" || user_id == null || user_id == "") {
			alert("로그인해주세요");
			return;
		}
		alert("댓글등록이 완료되었습니다");
		frm.action = "insertProAns.do";
		frm.submit();

	}

	function answer_delete(frm) {
		alert("댓글이 삭제되었습니다.");

		frm.action = "updateProAns.do";
		frm.submit();
	}

	function update_ok(frm) {
		alert("댓글이 수정되었습니다.");
		frm.action = "updateProAns.do";
		frm.submit();
		//location.href = "MyCon?type=answer_update&pPage=${pPage }&c_idx={c_idx }&writer=${user_id }&content=&{content }&pwd=${user_pw }";
	}
</script>
</head>
<body>
	<div class="div_total_div">
		<%-- <img id="review" alt="" src="images/review_cnt">--%>
		<%--댓글 입력 폼 --%>
		<form method="post">
			<input type="hidden" name="cust_nickname" value="${user.cust_nickname }">
			<input type="hidden" name="cust_id" value="${cust_id }"> <input
				type="hidden" name="user_pw" value="${user.cust_pwd }"> <input
				type="hidden" name="pro_a_writer" value="${cust_id }"> <input
				type="hidden" name="p_idx" value="${p_idx }"> <input
				type="hidden" name="pro_b_idx" value="${pro_b_idx }">
			<div class="review_cnt">${c_b_tot }개의 댓글이 있어요~!</div>
			<div class="comment_form_field">
				<textarea class="comments_form" placeholder="댓글을 작성해 주세요 :)"
					maxlength="200" cols="300" name="pro_a_content">${cust_id } 와 ${user.cust_pwd }</textarea>
				<span
					class="save_btn_span"><input type="button"
					class="comment_save_btn" value="등록" onclick="save_ans(this.form)"></span>
				<input type="hidden" name="write_chk" value="chk"> <input
					type="hidden" name="cPage" value="${cPage }">

			</div>
		</form>


		<%--댓글 출력(동적 태그 작성) --%>
		<c:choose>
			<c:when test="${empty b_answers }">

			</c:when>
			<c:otherwise>
				<%--<c:forEach var="b_answers" items="${b_answers }">
		 --%>
				<c:forEach var="i" begin="0" end="${proAns_totalcount - 1 }">
					<div class="comment">
						<form method="post">

							<ul>
								<li><span id="writer"><strong>${b_answers[i].cust_nickname }</strong></span></li>
								<li><span id="content"><input type="text"
										id="txt${i }" readonly="readonly"
										value="${b_answers[i].pro_a_content }"
										style="display: ''; height: 15px;"></span> <input
									id="update_form${i }" type="text" name="pro_a_content"
									value="${b_answers[i].pro_a_content }"
									style="display: none; border: 1px solid #b07c58; height: 15px;">
									<input type="hidden" name="pro_b_idx" value="${pro_b_idx }">
								</li>
								<input type="hidden" id="${i }" value="${i }">
								<c:choose>
									<%--로그인 했을 경우 --%>
									<c:when test="${b_answers[i].pro_a_writer eq user_id }">
										<li style="padding-right: 0px"><input type="button"
											id="update${i }" class="btn" value="수정"
											onclick="answer_update(this.id)"
											style="font-size: 11px; display: '';"> <input
											type="button" id="ok${i }" class="btn" value="확인"
											onclick="update_ok(this.form)"
											style="font-size: 11px; display: none;"></li>
										<li style="padding-right: 0px"><input type="button"
											id="delete${i }" class="btn" value="삭제"
											onclick="answer_delete(this.form)" style="font-size: 11px;"></li>
									</c:when>
									<c:otherwise>
										<li style="padding-right: 0px"><input type="button"
											id="update${i }" class="btn" value="수정"
											onclick="answer_update(this.id)"
											style="font-size: 11px; display: none;"> <input
											type="button" id="ok${i }" class="btn" value="확인"
											onclick="update_ok(this.form)"
											style="font-size: 11px; display: none;"></li>
										<li style="padding-right: 0px"><input type="button"
											id="delete${i }" class="btn" value="삭제"
											onclick="answer_delete(this.form)"
											style="font-size: 11px; display: none"></li>
									</c:otherwise>
								</c:choose>


								<script>
									function answer_update(frm) {
										/*if(document.getElementById("update${i }").value == "수정"){
											
											document.getElementById('txt${i }').style.display = "none";
											document.getElementById('update_form${i }').style.display = "";
											document.getElementById('ok${i }').style.display = "";
											document.getElementById('update${i }').style.display = "none";
											

											
											} else {
												document.getElementById('update_form${i }').style.display = "none";
												document.getElementById('txt${i }').style.display = "";
												document.getElementById('update${i }').style.display = "";
											}*/
										var idx = frm;
										idx = idx.substring(6, 7);
										//alert(idx);
										if (document.getElementById(frm).value == "수정") {

											document
													.getElementById('txt' + idx).style.display = "none";
											document
													.getElementById('update_form'
															+ idx).style.display = "";
											document.getElementById('ok' + idx).style.display = "";
											document.getElementById('update'
													+ idx).style.display = "none";

										} else {
											document
													.getElementById('update_form'
															+ idx).style.display = "none";
											document
													.getElementById('txt' + idx).style.display = "";
											document.getElementById('update'
													+ idx).style.display = "";
										}

									}
								</script>


							</ul>

							<input type="hidden" name="pro_a_content"
								value="${b_answers[i].pro_a_content }"> <input type="hidden"
								name="pro_a_writer" value="${b_answers[i].pro_a_writer }"> <input
								type="hidden" name="pro_a_idx" value="${b_answers[i].pro_a_idx }">
							<input type="hidden" name="p_idx" value="${b_answers[i].p_idx }">
							<input type="hidden" name="pro_a_pwd" value="${b_answers[i].pro_a_pwd }">
							<input type="hidden" name="pro_b_idx" value="${b_answers[i].pro_b_idx }">
							<%--
							<input type="hidden" name="cPage" value="${cPage }">
							 --%>
							 

						</form>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>