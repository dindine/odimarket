<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>		
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<!-- 실제 지도를 그리는 Javascript API를 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fedae3690acef97ddb7d251e66dc1516"></script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fedae3690acef97ddb7d251e66dc1516&libraries=services,clusterer,drawing"></script>

<style>

.btn {
	float: right;
}


.container {
	width: 80%;
	margin-top: 60px;
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

</script>
<script>
//------- validation 검사
$( "form" ).submit(function( event ) {
     
    var provision = $('#provision');
    var memberInfo = $('#memberInfo');

    //회원가입약관
    if($('#provisionYn:checked').val()=="N"){
        modalContents.text("회원가입약관에 동의하여 주시기 바랍니다."); //모달 메시지 입력
        modal.modal('show'); //모달 띄우기
         
        provision.removeClass("has-success");
        provision.addClass("has-error");
        $('#memberInfoYn').focus();
        return false;
    }else{
        provision.removeClass("has-error");
        provision.addClass("has-success");
    }
     
    //개인정보취급방침
    if($('#memberInfoYn:checked').val()=="N"){
        modalContents.text("개인정보취급방침에 동의하여 주시기 바랍니다.");
        modal.modal('show');
         
        memberInfo.removeClass("has-success");
        memberInfo.addClass("has-error");
        $('#memberInfoYn').focus();
        return false;
    }else{
        memberInfo.removeClass("has-error");
        memberInfo.addClass("has-success");
    }

</script>


<script>
$(document).ready(function (){

	//lblError 레이어 클리어

	$('#cust_pw').keyup(function (){

	    $('#same').text('');//제거

	});

	//암호 확인 기능 구현

	$('#cust_pw2').keyup(function(){

	    if($('#cust_pw').val() != $('#cust_pw2').val()){

			$('#same').text('');

			$('#same').html("<b>비밀번호가 일치하지 않습니다.</b>");
			$('#same').css("color",'#ee782f');
		}else{

			$('#same').text('');

			$('#same').html("<b>비밀번호가 일치합니다.</b>");
			$('#same').css("color",'#babb3c');

		}

	});



});
</script>



<script>
	function send_go(frm) {
		for (var i = 1; i < frm.elements.length; i++) {
	         if (frm.elements[i].value.trim() == "") {

	        	 if (i == 1)
	                 continue; 
	        	 if (i == 4)
	                 continue; 
	        	 if (i == 5)
	                 continue; 
	        	 if (i > 10)
	                 continue; 
	        	
	        	alert(frm.elements[i].name +">" +i + "를 입력하세요"); //각 입력칸에 비어있는곳이 있으면 alert창을 띄운다.
	            frm.elements[i].focus();
	            frm.elements[i].value = "";

	            return;

	         }
	         
	         
	       /*  if (frm.elements[1].value != frm.elements[2].value) {
	        	 alert("비밀번호를 다시 입력해주세요.");
	        	 frm.elements[1].focus();
	        	 frm.elements[1].value = '';
	        	 return;
	      }*/
	         }
		frm.action = "insertCustomer.do";
		frm.submit();
	}
</script>
<script>
//sns동의 체크박스
function allcheckFunc(obj) {
	$("[name=checkOne]").prop("checked", $(obj).prop("checked"));
}

/* 체크박스 체크시 전체선택 체크 여부 */
function onecheckFunc(obj) {
	var allObj = $("[name=checkAll]");
	var objName = $(obj).attr("name");

	if ($(obj).prop("checked")) {
		checkBoxLength = $("[name=" + objName + "]").length;
		checkedLength = $("[name=" + objName + "]:checked").length;

		if (checkBoxLength == checkedLength) {
			allObj.prop("checked", true);
		} else {
			allObj.prop("checked", false);
		}
	} else {
		allObj.prop("checked", false);
	}
}

$(function() {
	$("[name=checkAll]").click(function() {
		allcheckFunc(this);
	});
	$("[name=checkOne]").each(function() {
		$(this).click(function() {
			onecheckFunc($(this));
		});
	});
});
</script>
<script> 
function alert_login() {
	 alert("로그인후 이용가능합니다!");	
}

function chk_id(frm) {
	frm.action = "MyCon?type=idchk";
	frm.submit();
}

</script>

</head>
<body>

<div id="top_button">
		<a id="MOVE_TOP_BTN"><strong>TOP</strong></a>
	</div>
	
<form method="POST" autocomplete="off" action="insertCustomer.do" class="form-horizontal" role="form">
	<div id="join_form" class="container">
    <div class="row">
    <div class="col-sm-12 text-center" >
    <div class="col-sm-3"></div>
	<table class="table table-bordered">
			<!-- 아이디 -->
			<div class="form-group">
				<label for="cust_id">아이디</label>
					<input type="text" class="form-control" id="cust_id" name="cust_id" placeholder="ID" required>
				<button type="button" class="idCheck">중복확인</button>
				<p class="result"><span class="idCheckMsg">* 아이디 중복 확인을 해주세요 ;) *</span></p>
			</div>
			<!-- 비밀번호 -->
			<div class="form-group">
				<label for="cust_pw">비밀번호</label>
					<input type="password" class="form-control" id="cust_pw" name="cust_pwd" placeholder="PASSWORD" required>
				<div class="check_font" id="pw_check"></div>
			</div>
			<!-- 비밀번호 일치 ajax -->
			<div id="same" style="float:right; margin-left:1px; margin-top:5px;" ></div>
			<!-- 비밀번호 재확인 -->
			<div class="form-group">
				<label for="cust_pw2">비밀번호 확인</label>
					<input type="password" class="form-control" id="cust_pw2" name="cust_pw2" placeholder="Confirm Password" required>
				<div class="check_font" id="pw2_check"></div>
			</div>
			<!-- 닉네임 -->
			<div class="form-group">
				<label for="cust_name">닉네임</label>
					<input type="text" class="form-control" id="cust_nickname" name="cust_nickname" placeholder="Nickname" required>
				<div class="check_font" id="nickname_check"></div>
			</div>
			<!-- 본인확인 이메일 -->
			<div class="form-group">
				<label for="cust_email">이메일</label>
					<input type="text" class="form-control" name="cust_email" id="cust_email" placeholder="E-mail" required>
				<button type="button" class="emailCheck">중복확인</button>
				<p class="result"><span class="emailCheckMsg">* 이메일 중복 확인을 해주세요 ;) *</span></p>
			</div>
			<!-- 동네 위치 인증 -->
			<div class="form-group">
				<label for="cust_addr">동네 인증하기</label>
				<input type="text" class="form-control" id="cust_addr" name="cust_addr" value="${cust_addr }" placeholder="Address" required>
				<div class="check_font" id="addr_check"></div>
			</div>
			<!-- 휴대전화 -->
			<div class="form-group">
				<label for="cust_phone">휴대전화 ('-' 없이 번호만 입력해주세요)</label>
				<input type="text" class="form-control" id="cust_phone" name="cust_phone" placeholder="Phone Number" required>
				<div class="check_font" id="phone_check"></div>
			</div>
	
	<script>
	
	function getSelectValue(frm)
	{
		var target = document.getElementById("email_sel");
		 document.getElementById("email").value += target.options[target.selectedIndex].text;
		 document.getElementById("email_sel").value = frm.selectBox.options[frm.selectBox.selectedIndex].value;

	}
	
	</script>
	
		<hr><br>
		<div>
		<tr>
		<td id="update_form_p" colspan="2"><strong>ForeverYonug 마켓팅 정보 동의 수신 </strong><br><br>
		포인트/이벤트/문화공연/상품 소식을 전해드립니다. (공지 목적의 발송되는 메일은 제외)<br><br>
		<input type="checkbox" name="checkAll">전체선택 <input
						type="checkbox" value="이메일" name="checkOne"> 이메일 <input
						type="checkbox" value="SNS" name="checkOne"> SNS <input
						type="checkbox" value="휴대전화" name="checkOne"> 휴대전화<br>
						<br>
		
		</td>
		</tr>
		
		<tr>
		<td id="update_form_p" colspan="2">
		<!-- ---------------약관 동의 폼 ------------------------ -->
	<div class="container" style="width: 100%">
	        <form class="form-horizontal" role="form" method="post" action="javascript:alert( 'success!' );">
            <div class="form-group">
                <label for="provision" class="col-lg-10 control-label" style="margin-bottom: 10px"><b>회원가입약관</b></label>
               <label for="provision" class=" control-label" style="margin-left:350px;"> </label>
                <div class="col-lg-20" id="provision">
                    <textarea class="form-control" rows="8" style="resize:none;">
약관동의

                    </textarea>
                    <div class="radio" style="float: left; margin-right: 20px;">
                        <label>
                            <input type="radio" id="provisionYn" name="provisionYn" value="Y" autofocus="autofocus" checked>
                            동의합니다.
                        </label>
                    </div>
                    <div class="radio" style="float: left">
                        <label>
                            <input type="radio" id="provisionYn" name="provisionYn" value="N">
                            동의하지 않습니다.
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="memberInfo" class="col-lg-10 control-label" style="margin: 30px 0px 30px 0px"><b>개인정보취급방침</b></label>
                <div class="col-lg-20" id="memberInfo">
                    <textarea class="form-control" rows="8" style="resize:none">
                    </textarea>
                    <div class="radio" style="float: left; margin-right: 20px;">
                        <label>
                            <input type="radio" id="memberInfoYn" name="memberInfoYn" value="Y" checked>
                            동의합니다.
                        </label>
                    </div>
                    <div class="radio" style="float: left">
                        <label>
                            <input type="radio" id="memberInfoYn" name="memberInfoYn" value="N">
                            동의하지 않습니다.
                        </label>
                    </div>
                </div>
            </div>
		</form>
	</div>

		</td>
		</tr>
		</div>

<span id="guide" style="color:#999"></span>

	
	<!-- <button type="button" id="btn2" class="btn btn-success" onclick="send_go(this.form)">가입하기</button>  -->

			<div class="reg_button">
				<button class="btn btn-primary px-3" id="reg_submit" onclick="send_go(this.form)">
					<i class="fa fa-heart pr-2" aria-hidden="true"></i>가입하기
				</button>
			</div>
			</table>
			</div>
			</div>
			</div>
			
		</form>
<script>
//아이디 중복체크
$(".idCheck").click(function(){
 var query = {cust_id : $("#cust_id").val()};
 
 $.ajax({
  url : "idCheck.do",
  type : "post",
  data : query,
  success : function(data) {
   if(data == 1) {
    $(".result .idCheckMsg").text("이미 사용중인 아이디입니다. :( ");
    $(".result .idCheckMsg").attr("style", "color:#f00");    
   } else {
    $(".result .idCheckMsg").text("사용 가능한 아이디입니다! :D");
    $(".result .idCheckMsg").attr("style", "color:#00f");
   }
  }
 });  // ajax 끝
});
</script>
<script>
//이메일 중복체크
$(".emailCheck").click(function(){
 var query = {cust_email : $("#cust_email").val()};

 
 $.ajax({
  url : "emailCheck.do",
  type : "post",
  data : query,
  success : function(data) {
  
   if(data == 1) {
    $(".result .emailCheckMsg").text("이미 가입된 이메일입니다. :( ");
    $(".result .emailCheckMsg").attr("style", "color:#f00");    
   } else {
    $(".result .emailCheckMsg").text("사용 가능한 이메일입니다! :D");
    $(".result .emailCheckMsg").attr("style", "color:#00f");
   }
  }
 });  // ajax 끝
});
</script>
</body>
</html>