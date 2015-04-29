<%@ page import="com.shdev.oukongli.dao.IMessageDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.Message" %>
<%@ page import="com.shdev.oukongli.util.MsgUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/27
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言显示</title>
    <script src="<%=request.getContextPath()%>/resource/ckeditor/ckeditor.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ckeditor/samples/sample.css">
</head>
<body>
<jsp:include page="incl.jsp" />
<%
    IMessageDao messageDao = DAOFactory.getMessageDao();
    int id = Integer.parseInt(request.getParameter("id"));
    Message message = messageDao.load(id);
%>
<table width="900" align="center" border="1">
    <tr>
        <td><h3><%=message.getTitle()%>
        </h3></td>
    </tr>
    <tr>
        <td>发表日期：<%=MsgUtil.formatDate(message.getPostDate())%>&nbsp;&nbsp;&nbsp;&nbsp;
            发表人：<%=message.getUserId()%>
            <a href="delete.jsp?id=<%=id%>">delete</a>&nbsp;
            <a href="updateInput.jsp?id=<%=id%>">update</a>
        </td>
    </tr>
    <tr>
        <td>
            <%--<textarea class="ckeditor" name="editortest" id="editortest" rows="10" cols="100">--%>
                <%=message.getContent()%>
            <%--</textarea>--%>

        </td>
    </tr>
</table>
</body>
</html>
