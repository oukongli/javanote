<%@ page import="com.shdev.oukongli.dao.IUserDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/20
  Time: 22:09
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
      String con = request.getParameter("con");
      IUserDao userDao = DAOFactory.getUserDao();
      List<User> users = userDao.list(con);
    %>
    <table align="center" border="1" width="800">
        <tr>
            <td colspan="5">
                <form action="list.jsp">
                    请输入用户名或者昵称:
                    <input type="text" name="con" value="<%=con==null?"":con%>"/>
                    <input type="submit" value="查询"/>
                </form>
            </td>
        </tr>
        <tr>
          <td>用户标识</td>
          <td>用户名</td>
          <td>用户密码</td>
          <td>用户昵称</td>
          <td>操作</td>
        </tr>
        <%
            for (User user: users) {
         %>
            <tr>
              <td><%=user.getId()%></td>
              <td><%=user.getUsername()%></td>
              <td><%=user.getPassword()%></td>
              <td><%=user.getNickname()%></td>
              <td><a href="delete.jsp?id=<%=user.getId()%>">delete</a>&nbsp;<a href="update.jsp?id=<%=user.getId()%>">update</a></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
