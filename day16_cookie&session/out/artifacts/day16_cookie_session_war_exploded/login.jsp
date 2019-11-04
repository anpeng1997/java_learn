<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/4
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/day16/ServletLogin" method="post">
    username: <input type="text" name="username">
    <br>
    passwrod:<input type="password" name="password">
    <br>
    <img src="/day16/VerificationCodeServlet" style="width: 200px;height: 50px">
    <input type="text" name="code">
    <button type="submit">login</button>
</form>
</body>
</html>
