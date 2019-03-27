<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>WIDOK GEO</h2>

<form:form modelAttribute="user"
           method="post"
           action="/user/geo/form"
           cssClass="user">

    <form:hidden path="id"/>

    <form:input path="name" placeholder="name"/>
    <form:errors path="name"/>

    <form:input path="email" placeholder="em@il"/>
    <form:errors path="email"/>

<c:if test="${user.id == null}">
    <form:password path="password" placeholder="password"/>
    <form:errors path="password"/>
</c:if>

    <form:select path="type" name="type"><br>
        <form:options items="${userTypes}" itemLabel="title"/><br>
    </form:select>

    <input type="submit" value="save">

</form:form>



</body>
</html>
