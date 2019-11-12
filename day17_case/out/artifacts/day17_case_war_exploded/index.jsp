<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/6
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
    <h4>欢迎你，</h4>
    <%= request.getSession().getAttribute("current_login_username")%>
  <h3><a href="${pageContext.request.contextPath}/studentListServlet">进入后台管理</a></h3>
  </body>
</html>
