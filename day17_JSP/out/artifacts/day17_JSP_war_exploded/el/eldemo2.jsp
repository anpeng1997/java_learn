<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/5
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String,String> map =new HashMap<String, String>();
        map.put("one","一");
        map.put("two","二");
        request.setAttribute("map",map);
    %>

    ${requestScope.map.two }
    <br>
    ${map["one"]}
        <br>
    ${pageContext.request.contextPath}
</body>
</html>
