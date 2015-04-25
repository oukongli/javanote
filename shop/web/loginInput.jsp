<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/21
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="/inc/inc.jsp"></jsp:include>
<h2 align="center">用户登录</h2><hr/>
<form action="login.jsp" method="post">
    用户名称：<input type="text" name="username"/><br/>
    用户密码：<input type="password" name="password"/><br/>
    <input type="submit" value="login">
</form>
</body>
</html>
