<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/10/31
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <% System.out.println("执行java代码！"); %>
  <%! int member=4; %>
  <%= member %>

  <% response.getWriter().write("123123"); %>
  <%out.print("321321");%>
<%-- <%= %>输出在前端界面上--%>

  <% request.getSession(); %>
  </body>
</html>
