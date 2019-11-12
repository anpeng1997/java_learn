<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" errorPage="500.jsp" language="java" %>
<%@ include file="Header.jsp"%>
<%--<%@ taglib prefix="c" uri="" %>--%>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      request.setAttribute("name","掌声");
    %>
  ${requestScope.name}
  ${name}
  </body>
</html>
