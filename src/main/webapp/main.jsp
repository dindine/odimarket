<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h1>로그인 성공 페이지(메인페이지)</h1>
	<a href="logout.do">Log-out</a>

	<p>${user.cust_nickname }님</p>
	<input id="update" type="button" value="회원정보수정"
		onclick="javascript:location.href='/odi/view/cust_update'">
	
	<input type="button" value="회원탈퇴"
		onclick="javascript:location.href='/odi/view/cust_delete'">
</body>
</html>
