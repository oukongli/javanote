<%@ page import="com.shdev.oukongli.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/26
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="<%=request.getContextPath()%>/resource/ckeditor/ckeditor.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ckeditor/samples/sample.css">
    <title></title>
</head>
<body>
<%
  User user = (User)session.getAttribute("loginUser");
%>
<jsp:include page="/msg/incl.jsp" />
<form action="add.jsp" method="post">
  <input type="hidden" name="userId" value="<%=user.getId()%>">
  <table width="900" align="center" border="1">
    <tr>
      <td width="120">标题</td><td><input type="text" name="title" size="80"/></td>
    </tr>
    <tr>
      <td colspan="2">内容</td>
    </tr>
    <tr>
      <td colspan="2">
        <textarea class="ckeditor" rows="20" cols="100" name="content"></textarea>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="confirm"/>
        <input type="reset" value="reset"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>

<script>
CKEDITOR.replace("content");
</script>
