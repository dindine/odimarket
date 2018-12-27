<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>개인정보수정</title>

</head>
<body>

<form action="/odi/user/update.do" method="post" modelAttibute="user">
    <table>
        <tr>
            <th>아이디</th>
            <td><input type="text" name="cust_id" placeholder="아이디"
                       readonly="readonly" value="${user.cust_id }"></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="text" name="cust_pwd" placeholder="비밀번호"></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="email" name="cust_email" placeholder="이메일"
                       readonly="readonly" value="${user.cust_email }"></td>
        </tr>
        <tr>
            <th>핸드폰</th>
            <td><input type="text" name="cust_phone" placeholder="핸드폰"
                       value="${user.cust_phone }"></td>
        </tr>
        <tr>
            <th>등급</th>
            <td><input type="text" name="cust_level" placeholder="등급"
                       value="${user.cust_level }" readonly></td>
        </tr>
        <tr>
            <th>주소</th>
            <td><input type="text" name="cust_addr" placeholder="주소"
                       value="${user.cust_addr }"></td>
        </tr>
        <tr>
            <th>닉네임</th>
            <td><input type="text" name="cust_nickname" placeholder="닉네임"
                       value="${user.cust_nickname }"></td>
        </tr>
    </table>
    <input type="reset" value="초기화">
    <input type="submit" value="수정">
    <input type="button" value="회원탈퇴"
           onclick="javascript:location.href='/odi/cust_delete/page.do'">
</form>
</body>
</html>