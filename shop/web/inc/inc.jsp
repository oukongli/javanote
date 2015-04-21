<%@ page import="com.shdev.oukongli.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/21
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User userLogin = (User) session.getAttribute("loginUser");
%>
<div style="text-align: right;border-bottom: 1px solid #000">
    欢迎[<%=userLogin.getNickname()%>]使用我们的系统&nbsp;
  <a href="<%=request.getContextPath()%>/admin/user/list.jsp">管理信息</a>&nbsp;
  <a href="<%=request.getContextPath()%>/logout.jsp">exit</a>
</div>