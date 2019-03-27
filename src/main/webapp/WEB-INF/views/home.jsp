<%--
  Created by IntelliJ IDEA.
  User: mk84
  Date: 20.03.19
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Users</h2>
<a href="/user/form">Add user</a><br>
<hr/>
<h2>Works</h2>
<a href="/work/form">Add Work</a><br>
<a href="user/geo/form">geo/form</a><br>
<a href="user/gw/form">user/form</a><br>
<a href="user/sub/form">sub/form</a><br>
<br>
<a href="/logout">logout</a><br>

<%@include file="base/sidebar.jsp"%>
</body>
</html>
