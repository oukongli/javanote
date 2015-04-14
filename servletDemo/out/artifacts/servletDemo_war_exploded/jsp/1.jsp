<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/14
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form>
        请输入数字:<input type="text" name="number"/>
        <input type="submit">
    </form>
    <%
      int number = Integer.parseInt(request.getParameter("number"));
    %>
    <table border=1>
        <%
            for (int i=1;i<=number;i++) {
        %>
        <tr><td> <%=i*i%></td></tr>
        <%
            }
        %>
    </table>
    <h1>test</h1>
    <%

    %>
</body>
</html>
