<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- DB데이타 조회하고 조회된 데이타를 화면 출력 --%>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원목록</title>
    <!--
    <style>
        #container {
            width: 700px;
            margin: 0 auto;
        }
        h1, h3 { text-align: center; }
        table { border-collapse: collapse; }
        table, th, td {
            border: 1px solid black;
            margin: 0 auto;
        }
        th { background-color: orange; }
        .center { text-align: center; }
        .border-none, .border-none td { border: none; }
    </style>
     -->
</head>
<body>

<div id="container">
    <h1>회원목록</h1>

    <!-- 검색을 위한 폼 -->
    <form action="getCustomerList.do" method="post">
        <table class="border-none">
            <tr>
                <td>
                    <select name="searchCondition">
                        <!--
                        <option value="TITLE">제목
                        <option value="CONTENT">내용
                        -->
                        <c:forEach var="option" items="${conditionMap }">
                        <option value="${option.value }">${option.key }
                            </c:forEach>
                    </select>

                    <input type="text" name="searchKeyword">
                    <input type="submit" value="검색">
                </td>

            </tr>
        </table>
    </form>

    <!-- 데이타 표시 -->
    <form>
        <table>
            <tr>
                <th>아이디</th>
                <th>비번</th>
                <th>이메일</th>
                <th>전화번호</th>
                <th>동네</th>
                <th>레벨</th>
                <th>닉네임</th>
            </tr>

            <c:forEach var="customer" items="${customerList }">
                <tr>
                    <td>${customer.cust_id }</td>
                    <td>
                            ${customer.cust_pwd }
                    </td>
                    <td>${customer.cust_email }</td>
                    <td>${customer.cust_phone }</td>
                    <td>${customer.cust_addr }</td>
                    <td>${customer.cust_level }</td>
                    <td>${customer.cust_nickname }</td>
                    <td><a href="deleteCustomer.do?cust_id=${customer.cust_id }">강퇴</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <p><a href="index.jsp">처음으로 돌아가기</a></p>

</div>

</body>
</html>