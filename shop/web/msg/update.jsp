<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.Message" %>
<%@ page import="com.shdev.oukongli.dao.IMessageDao" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/29
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    String title = request.getParameter("title");
    String content = request.getParameter("content");
    IMessageDao messageDao = DAOFactory.getMessageDao();

    Message message = messageDao.load(id);
    message.setContent(content);
    message.setTitle(title);
    messageDao.update(message);


    response.sendRedirect(request.getContextPath() + "/msg/show.jsp?id=" + message.getId());
%>
</body>
</html>
