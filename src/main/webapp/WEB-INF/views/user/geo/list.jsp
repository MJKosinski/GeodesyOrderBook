<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<%@include file="../../base/sidebar.jsp"%>
<table border="1px">
    <thead>
    <tr>
    <th>Id</th>
    <th>Nazwa</th>
    <th>email</th>
    <th>typ</th>
    <th>Edit/Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="list">
        <c:if test="${user.id != list.id}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.email}</td>
            <td>${list.type}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/${prefix}/form/${list.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/user/${prefix}/list/del/${list.id}">Delete</a>
            </td>
        </tr>
        </c:if>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
