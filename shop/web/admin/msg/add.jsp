<%@ page import="com.shdev.oukongli.dao.IMessageDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.Message" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/26
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

  IMessageDao messageDao = DAOFactory.getMessageDao();
  String title = request.getParameter("title");
  String content = request.getParameter("content");
  Message msg = new Message();
  msg.setContent(content);
  msg.setTitle(title);
  msg.setPostDate(new Date());

  int userId = Integer.parseInt(request.getParameter("userId"));

  messageDao.add(msg, userId);
  response.sendRedirect(request.getContextPath()+"/msg/list.jsp");
%>