<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/7
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add student</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/addStudentServlet" method="post">
        <div class="form-group">
            <label for="nameInputEmail1">name:</label>
            <input type="text" name="name" class="form-control" id="nameInputEmail1">
        </div>
        <div class="form-row">
            <div class="col-7">
                <label for="angInput">age:</label>
                <input type="text" name="age" class="form-control" id="angInput">
            </div>
            <div class="col">
                <label for="scoreInput">score:</label>
                <input type="text" name="score" class="form-control" id="scoreInput">
            </div>
        </div>
        <button style="margin: 0 auto" type="submit" class="btn btn-primary">Submit</button>
    </form>
    <c:if test="${not empty add_msg}">
        <div class="alert alert-danger" role="alert">
                ${add_msg}
        </div>
    </c:if>
</div>
</body>
</html>
