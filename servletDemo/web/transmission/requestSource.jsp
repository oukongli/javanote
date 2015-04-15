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
    <a href="requestTarget.jsp">requestSource.jsp</a>
    <%
      String str = "123456";
      request.setAttribute("str", str);
    %>
    <hr/>
    <%=request.getAttribute("str")%>
    <jsp:forward page="requestTarget.jsp"/>
</body>
</html>
