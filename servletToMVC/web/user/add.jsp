<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/5/15
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/user?method=add" method="post">
    用户名：<input type="text" name="username"/><br/>
    昵称：<input type="text" name="nickname"/><br/>
    年龄：<input type="text" name="age"/><br/>
    <input type="submit" value="submit">
</form>
</body>
</html>
