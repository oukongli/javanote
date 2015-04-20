<%@ page import="com.shdev.oukongli.dao.IUserDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/20
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
      <%
        int id = Integer.parseInt(request.getParameter("id"));
        IUserDao userDao = DAOFactory.getUserDao();
        userDao.delete(id);
        response.sendRedirect("list.jsp");
      %>
</body>
</html>
