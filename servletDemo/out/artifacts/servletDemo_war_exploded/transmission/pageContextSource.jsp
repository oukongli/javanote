<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/15
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <a href="pageContextTarget.jsp">pageContextTarget.jsp</a>
    <%
      String str = "123456";
      pageContext.setAttribute("str", str);
    %>
    <hr/>
    <%=pageContext.getAttribute("str")%>
</body>
</html>
