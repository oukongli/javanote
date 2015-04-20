<%@ page import="com.shdev.oukongli.model.User" %>
<%@ page import="com.shdev.oukongli.dao.IUserDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.ShopException" %>
<%@ page import="com.shdev.oukongli.util.ValidateUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/17
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="incl.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String nickname = request.getParameter("nickname");

    if (!ValidateUtil.validateNull(request, new String[] {"username", "password", "nickname"})) {
        %>
            <jsp:forward page="addInput.jsp"/>
        <%
    }

    User user = new User(username, password, nickname);
    IUserDao userDao = DAOFactory.getUserDao();
    try {
      userDao.add(user);
%>
    sucess,<a href="addInput.jsp">go on add</a>&nbsp;<a href="list.jsp">user list</a>
<%
    } catch (ShopException e) {
        System.out.println(e.getMessage());
      %>
        <h2 style="color: red">error<%=e.getMessage()%></h2>
<%
    }
%>