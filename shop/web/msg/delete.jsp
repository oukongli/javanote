<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/29
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    int id = Integer.parseInt(request.getParameter("id"));
    DAOFactory.getMessageDao().delete(id);
    response.sendRedirect(request.getContextPath() + "/msg/list.jsp");
%>
