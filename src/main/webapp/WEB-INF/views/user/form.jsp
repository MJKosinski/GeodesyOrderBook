<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add/Edit User</h2>
<hr/>
<form:form modelAttribute="user"
           method="post"
           action="${pageContext.request.contextPath}/user/form"
           cssClass="user">

    <form:hidden path="id"/>

    <form:input path="login" placeholder="login"/>
    <form:errors path="login"/>

    <form:input path="email" placeholder="em@il"/>
    <form:errors path="email"/>

    <form:password path="password" placeholder="password"/>
    <form:errors path="password"/>

    <form:select path="type" name="type"><br>
        <form:options items="${userTypes}" itemLabel="title"/><br>
    </form:select>

    <%--itemLabel="${userTypes.title}"--%>


    <input type="submit" value="save">

</form:form>



</body>
</html>
