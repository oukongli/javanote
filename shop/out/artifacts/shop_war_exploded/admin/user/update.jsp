<%@ page import="com.shdev.oukongli.dao.IUserDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.User" %>
<%@ page import="com.shdev.oukongli.util.ValidateUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/21
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="incl.jsp" />
      <%
        int id = Integer.parseInt(request.getParameter("id"));
        IUserDao userDao = DAOFactory.getUserDao();
        User u = userDao.load(id);

      %>

      <form action="updateResult.jsp" method="post">
        <input type="hidden" name="id" value="<%=u.getId()%>" />
        <table align="center" width="500" border="1">
          <tr>
            <td>username</td>
            <td>password</td>
            <td>nickname</td>
            <td>action</td>
          </tr>

          <tr>
            <td><%=u.getUsername()%></td>
            <td><input type="password" name="password" value="<%=u.getPassword()%>"/><%=ValidateUtil.showError(request, "password")%></td>
            <td><input type="text" name="nickname" value="<%=u.getNickname()%>"/><%=ValidateUtil.showError(request, "nickname")%></td>
            <td><input type="submit" value="update"/><input type="reset" value="reset"/></td>
          </tr>

        </table>
      </form>
</body>
</html>
