<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<form action="/odi/user/delete.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" placeholder="아이디"
					readonly="readonly" value="${user.cust_id }"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="password" placeholder="비밀번호"></td>
			</tr>
		</table>
		<input type="submit" value="탈퇴하기" > 
		<input type="button" value="홈으로" onclick="javascript:location.href='/odi/main/page.do'">
	</form>
</body>
</html>