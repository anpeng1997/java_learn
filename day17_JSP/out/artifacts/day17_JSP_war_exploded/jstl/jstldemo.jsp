<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List strings = new ArrayList();
    strings.add("one");
    strings.add("two");
    strings.add("three");
    strings.add("four");
    request.setAttribute("strings",strings);
    request.setAttribute("i",2);
%>

    <c:if test="true">
        <h1>hahah</h1>
    </c:if>

    <c:choose>
        <c:when test="${i == 1}"></c:when>
        <c:when test="${i == 2}"></c:when>
        <c:when test="${i == 3}"></c:when>
    </c:choose>

    <c:forEach items="${strings}" varStatus="i" var="s">
        ${i.index}------${i.count}------${s}
    </c:forEach>
</body>
</html>
