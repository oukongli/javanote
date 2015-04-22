<%@ page import="com.shdev.oukongli.dao.IUserDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shdev.oukongli.model.Pager" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/20
  Time: 22:09
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
    int pageSize = 10;
    int pageIndex = 1;
    try {
        pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
    } catch (NumberFormatException e) {

    }
    String con = request.getParameter("con");
    IUserDao userDao = DAOFactory.getUserDao();
    Pager<User> userPager = userDao.list(con, pageSize, pageIndex);
    List<User> users = userPager.getDatas();
%>
<table align="center" border="1" width="1000">
    <tr>
        <td colspan="5">
            <form action="list.jsp">
                请输入用户名或者昵称:
                <input type="text" name="con" value="<%=con==null?"":con%>"/>
                <input type="submit" value="查询"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>用户标识</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>用户昵称</td>
        <td>操作</td>
    </tr>
    <%
        for (User user : users) {
    %>
    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getUsername()%>
        </td>
        <td><%=user.getPassword()%>
        </td>
        <td><%=user.getNickname()%>
        </td>
        <td><a href="delete.jsp?id=<%=user.getId()%>">delete</a>&nbsp;<a
                href="update.jsp?id=<%=user.getId()%>">update</a></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="5">
            共有<%=userPager.getTotalRecord()%>记录,
            当前是第<%=userPager.getPageIndex()%>页,
            每页显示<%=userPager.getPageSize()%>条.
        </td>
    </tr>
    <tr>
        <td colspan="5">
            <a href="list.jsp?pageIndex=<%=pageIndex-1%><%=con==null?"":"&con="+con%>">上一页</a>
            <%
                int totalPage = userPager.getTotalPage();
                for (int i = 1; i <= totalPage; i++) {
                    if (i == pageIndex) {
            %>
            [<%=i%>]
            <%
                    continue;
                }

            %>
            [<a href="list.jsp?pageIndex=<%=i%><%=con==null?"":"&con="+con%>"><%=i%></a>]
            <%
                }
            %>
            <a href="list.jsp?pageIndex=<%=pageIndex+1%><%=con==null?"":"&con="+con%>">下一页</a>
        </td>
    </tr>
</table>
</body>
</html>
