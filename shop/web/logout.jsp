<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/21
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
  session.invalidate();
  response.sendRedirect(request.getContextPath()+"/loginInput.jsp");
%>
</body>
</html>
