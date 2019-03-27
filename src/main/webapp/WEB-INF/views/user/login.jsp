<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>User Login</h2>
<a href="${pageContext.request.contextPath}/user/list">Back to list</a>  <a href="${pageContext.request.contextPath}/user/form">Register</a>
<hr/>

<form:form modelAttribute="user"
        method="post"
        action="${pageContext.request.contextPath}/user/login">
    <c:if test="${not empty errorMsg}">
        <span>${errorMsg}</span>

    </c:if>
    <form:input path="email" placeholder="em@il"/>
    <form:errors path="email"/>

    <form:password path="password" placeholder="password"/>
    <form:errors path="password"/>

    <input type="submit" value="save">

</form:form>
</body>
</html>
