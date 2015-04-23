<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/23
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int items = Integer.parseInt(request.getParameter("items"));
    String params = request.getParameter("params");
%>

<pg:pager maxPageItems="15" items="<%=items%>" export="currentPage=pageNumber">

    <pg:last>
        共有<%=items%>记录,
        当前是第<%=currentPage%>/<%=pageNumber%>页,
    </pg:last>


    <pg:param name="<%=params%>"/>
    <pg:first>
        <a href="<%=pageUrl%>">首页</a>
    </pg:first>
    <pg:prev>
        <a href="<%=pageUrl%>">上一页</a>
    </pg:prev>
    <pg:pages>
        <%
            if (pageNumber == currentPage) {
        %>
        [<%=pageNumber%>]
        <%
        } else {
        %>
        <a href="<%=pageUrl%>"><%=pageNumber%>
        </a>
        <%
            }
        %>
    </pg:pages>
    <pg:next>
        <a href="<%=pageUrl%>">下一页</a>
    </pg:next>
    <pg:last>
        <a href="<%=pageUrl%>">尾页</a>
    </pg:last>
</pg:pager>