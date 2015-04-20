<%@ page import="com.shdev.oukongli.util.ValidateUtil" %>
<%@ page import="com.shdev.oukongli.dao.IUserDao" %>
<%@ page import="com.shdev.oukongli.model.User" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.ShopException" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/21
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>

<jsp:include page="incl.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  String password = request.getParameter("password");
  String nickname = request.getParameter("nickname");

  if (!ValidateUtil.validateNull(request, new String[]{ "password", "nickname"})) {
%>
<jsp:forward page="update.jsp"/>
<%
  }

  IUserDao userDao = DAOFactory.getUserDao();
  User user = userDao.load(id);
  user.setNickname(nickname);
  user.setPassword(password);
  try {
    userDao.update(user);
    response.sendRedirect("list.jsp");
    return;
} catch (ShopException e) {
  System.out.println(e.getMessage());
%>
<h2 style="color: red">error<%=e.getMessage()%></h2>
<%
  }
%>
