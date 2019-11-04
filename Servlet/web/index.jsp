<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/10/21
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <form action="/day14/login" method="get">
      <input type="text" name="name">
      <input type="radio" value="male" name="sex">男
      <input type="radio" value="female" name="sex">女
      <input type="submit" value="post">
    </form>
  </body>
</html>
