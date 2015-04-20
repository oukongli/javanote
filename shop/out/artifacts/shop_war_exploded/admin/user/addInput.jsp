<%@ page import="com.shdev.oukongli.util.ValidateUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/16
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="incl.jsp" />
<%=request.getAttribute("error")%>
<form action="add.jsp" method="post">
          <table align="center" width="500" border="1">
                <tr>
                  <td>username</td>
                  <td>password</td>
                  <td>nickname</td>
                  <td>action</td>
                </tr>

                  <tr>
                      <td><input type="text" name="username"/><%=ValidateUtil.showError(request, "username")%></td>
                      <td><input type="password" name="password"/><%=ValidateUtil.showError(request, "password")%></td>
                      <td><input type="text" name="nickname"/><%=ValidateUtil.showError(request, "nickname")%></td>
                      <td><input type="submit" value="submit"/></td>
                  </tr>

          </table>
    </form>
</body>
</html>
