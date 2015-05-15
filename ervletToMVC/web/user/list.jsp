<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/5/14
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <style type="text/css">
    table {
      border-bottom: 1px solid #000;
      border-right: 1px solid #000;
    }
    table td {
      border-top: 1px solid #000;
      border-left: 1px solid #000;
      padding: 6px;
    }
  </style>
</head>
<body>
<a href="/user?method=register">继续添加</a>
<table align="center" width="900" cellpadding="0" cellspacing="0">
  <tr>
    <td>sno</td>
    <td>username</td>
    <td>nickname</td>
    <td>age</td>
  </tr>
  <c:forEach var="u" items="${users}" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td>${u.username}</td>
      <td>${u.nickname}</td>
      <td>${u.age}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
