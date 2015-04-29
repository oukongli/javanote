<%@ page import="com.shdev.oukongli.dao.IMessageDao" %>
<%@ page import="com.shdev.oukongli.dao.DAOFactory" %>
<%@ page import="com.shdev.oukongli.model.Message" %>
<%@ page import="com.shdev.oukongli.util.MsgUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: ou_kongli
  Date: 2015/4/29
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="incl.jsp" />

<%
  IMessageDao messageDao = DAOFactory.getMessageDao();
  int id = Integer.parseInt(request.getParameter("id"));
  Message message = messageDao.load(id);
%>
<html>
<head>
  <script src="<%=request.getContextPath()%>/resource/ckeditor/ckeditor.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ckeditor/samples/sample.css">
  <title></title>
</head>
<body>


<form action="update.jsp" method="post">
  <input type="hidden" name="id" value="<%=message.getId()%>" />
  <table width="500" align="center" border="1">
    <tr>
      <td width="130">标题</td>
      <td>
        <input type="text" name="title" size="80" value="<%=message.getTitle()%>" />
      </td>
    </tr>
    <tr>
        <td colspan="2">内容</td>
    </tr>
    <tr>
      <td colspan="2">
            <textarea class="ckeditor" name="content" id="editortest" rows="10" cols="50">
                <%=message.getContent()%>
            </textarea>

      </td>
    </tr>

    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="confirm"/>
        <input type="reset" value="reset"/>
      </td>
    </tr>

  </table>
  <%--<script>--%>
    <%--CKEDITOR.replace("content");--%>
  <%--</script>--%>

</form>

</body>
</html>

<script>
  CKEDITOR.replace("content");
</script>