<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/22
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<html>
<head>
    <title></title>
</head>
<pg:pager items="1000" maxPageItems="15" maxIndexPages="10">
  <pg:first>
    <a href="<%=pageUrl%>">首页</a>
  </pg:first>
  <pg:prev>
    <a href="<%=pageUrl%>">上一页</a>
  </pg:prev>
  <pg:pages>
    <a href="<%=pageUrl%>"><%=pageNumber%></a>
</pg:pages>
  <pg:next>
  <a href="<%=pageUrl%>">下一页</a>
</pg:next>
  <pg:last>
  <a href="<%=pageUrl%>">尾页</a>

</pg:last>
</pg:pager>

</body>
</html>
