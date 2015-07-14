<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/7/14
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user list</title>
</head>
<body>
<c:forEach items="${users}" var="um">
  ${um.value.id}---${um.value.name}---  ${um.value.nickname}<br/>
</c:forEach>
</body>
</html>
