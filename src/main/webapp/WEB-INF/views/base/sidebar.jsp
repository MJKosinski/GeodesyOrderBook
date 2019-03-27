<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<menu>

usertype=${user.type}
<div style hidden>
    <c:choose>
        <c:when test="${user.type == 'GEODESY'}">
            ${prefix = 'geo'}
        </c:when>
        <c:when test="${user.type == 'GENERAL_CONTRACTOR'}">
            ${prefix = 'gw'}
        </c:when>
        <c:otherwise>
            ${prefix = 'sub'}
        </c:otherwise>
    </c:choose>
</div>



    <p><a href="${pageContext.request.contextPath}/user/${prefix}/form/${user.id}">edytuj swój profil</a></p>
    <p><a href="${pageContext.request.contextPath}/user/${prefix}/form">dodaj nowego użytkownika</a></p>
    <p><a href="${pageContext.request.contextPath}/user/${prefix}/list">pokaż listę użytkowników</a></p>
    <p><a href="${pageContext.request.contextPath}/user/${prefix}/form">${prefix}/form</a></p>

<c:if test="${user.type == 'GEODESY'}">
    <p>  link 2 geo</p>
    </c:if>

    <p>  link 3 gw</p>

    <c:if test="${user.type == 'GEODESY' or user.type == 'GENERAL_CONTRACTOR'}">
        <p>  link 5 geo gw</p>
    </c:if>

    <p>  link 4 sub</p>







</menu>

