<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/7
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css"/>
</head>
<body>
<div class="container" style="margin-top: 50px;">
    <a class="btn btn-light" href="${pageContext.request.contextPath}/addStudent.jsp">add student</a>
    <button class="btn btn-danger" id="deleteBtn">删除选中</button>
    <form id="studentForm" action="${pageContext.request.contextPath}/deleteStudentServlet" method="post">
        <table class="table">
            <thead class="thead-light">
            <tr>
                <th><input type="checkbox"></th>
                <th scope="col">name</th>
                <th scope="col">age</th>
                <th scope="col">score</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paginationStudent.students}" varStatus="v" var="student">
                <tr>
                    <th><input type="checkbox" name="uid" value="${student.id}"></th>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item ${paginationStudent.currentPage == 1 ? "disabled":""}">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/studentListServlet?pageNumber=${paginationStudent.currentPage-1}&pageSize=5"
                   tabindex="-1" aria-disabled="true">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach step="1" begin="1" var="i" end="${paginationStudent.totalPage}">
                <li class="page-item ${i == paginationStudent.currentPage ? "active":""}" aria-current="page">
                    <c:if test="${i != paginationStudent.currentPage}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/studentListServlet?pageNumber=${i}&pageSize=5">
                                ${i}
                        </a>
                    </c:if>
                    <c:if test="${i == paginationStudent.currentPage}">
                         <span class="page-link">
                                 ${i}
                         </span>
                    </c:if>
                </li>
            </c:forEach>
            <li class="page-item ${paginationStudent.currentPage == paginationStudent.totalPage ? "disabled":""}">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/studentListServlet?pageNumber=${paginationStudent.currentPage+1}&pageSize=5">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    <h3>总共${paginationStudent.totalPage}条页，共${paginationStudent.totalCount}记录</h3>
</div>
<script>
    window.onload = function () {
        document.getElementById("deleteBtn").onclick = function () {
            document.getElementById("studentForm").submit();
        }
    }
</script>
</body>
</html>
