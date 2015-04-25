<%@ page import="com.shdev.oukongli.dao.IMessageDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.Pager" %>
<%@ page import="com.shdev.oukongli.model.Message" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/26
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="incl.jsp"/>
<%
  IMessageDao messageDao = DAOFactory.getMessageDao();
  Pager<Message> pagers = messageDao.list();
  int totalRecord = pagers.getTotalRecord();
%>
<table align="center" width="900" border="1">
    <tr>
      <td>标题</td>
      <td>发表时间</td>
      <td>发布人</td>
      <td>评论数量</td>
    </tr>
      <%
        for (Message message : pagers.getDatas()) {
      %>
      <tr>
            <td><%=message.getTitle()%></td>
            <td><%=message.getPostDate()%></td>
            <td><%=message.getUserId()%></td>
            <td>1111111111</td>
      </tr>
      <%
        }
      %>
  <tr>
    <td colspan="4">
      <jsp:include page="/inc/pager.jsp">
        <jsp:param name="items" value="<%=totalRecord%>"/>
      </jsp:include>
    </td>
  </tr>
</table>
</body>
</html>
