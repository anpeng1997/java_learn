<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/6
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css"/>
</head>
<body>
<div style="width: 400px;height: 200px;margin: 100px auto 0;">
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            用户名： <input type="text" name="name" class="form-control">
        </div>
        <div class="form-group">
            密码： <input type="text" name="password" class="form-control">
        </div>
        <div class="form-group">
            验证码：<a href="javascript:refreshCode();"><img id="codeimg" src="${pageContext.request.contextPath}/verificationCodeServlet"> </a>
            <input type="text" name="verificationCode" class="form-control">
        </div>
        <div class="form-group" style="text-align: center;">
            <input type="submit" class="btn btn-primary" value="login">
        </div>
    </form>
    <c:if test="${not empty requestScope.login_msg}">
        <div class="alert alert-danger" role="alert">
                ${requestScope.login_msg}
        </div>
    </c:if>
</div>
<script>
    function refreshCode(){
        document.getElementById("codeimg")
            .setAttribute("src","${pageContext.request.contextPath}/verificationCodeServlet?date="+new Date().getTime())
    }
</script>
</body>
</html>
