<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="112107668673-pmmd3611vdqhcsfsd6ot71ktl686ja9r.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>Login Page</title>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
	function login(frm) {
		for (var i = 0; i < frm.elements.length; i++) {
			if (frm.elements[i].value.trim() == "") {
				alert(frm.elements[i].name + "를 입력하세요");
				frm.elements[i].focus();
				return;
			}
		}
		frm.action = "/odi/user/normal/login.do";
		frm.submit();
	}
</script>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="/odi/user/normal/login.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" class="center"><input type="button" value="로그인"
					onclick="login(this.form)"></td>
			</tr>
		</table>
	</form>
	<!-- naver login form -->
	<a href="/odi/user/naver/login.do"> <img width="223"
		src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png" /></a>
	<br>
	<!-- google login form -->
	<a href="/odi/user/google/login.do">
		<button id="btnJoinGoogle" class="btn btn-primary btn-round"
			style="width: 20%;">
			<i class="fa fa-google" aria-hidden="true"></i>Google Login
		</button>
	</a>
	
</body>
</html>