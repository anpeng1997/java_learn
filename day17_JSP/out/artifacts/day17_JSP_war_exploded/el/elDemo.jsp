<%@ page import="cn.pengan.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/5
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%
     User user = new User();
     user.setName("pengan");
     user.setAge(20);
     user.setBirthday(new Date());
     request.setAttribute("user",user);

 %>
${requestScope.user.name}

${user.birthday}

${user.strBirthday}


</body>
</html>
