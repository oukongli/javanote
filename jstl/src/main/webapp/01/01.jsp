<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/5/13
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    request.setAttribute("username", "<h1>张三</h1>");
%>

<c:out value="${username}"></c:out>
${username}
${param.hello}

</body>
</html>
