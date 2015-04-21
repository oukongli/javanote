<%@ page import="com.shdev.oukongli.dao.IUserDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.User" %>
<%@ page import="com.shdev.oukongli.model.ShopException" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/21
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
       try{
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         IUserDao userDao = DAOFactory.getUserDao();
         User u = userDao.login(username, password);
         session.setAttribute("loginUser", u);
         response.sendRedirect(request.getContextPath()+"/admin/user/list.jsp");
       } catch (ShopException e) {
    %>
    <h2 style="color: red;">error<%=e.getMessage()%></h2>
    <%
       }
    %>
</body>
</html>
