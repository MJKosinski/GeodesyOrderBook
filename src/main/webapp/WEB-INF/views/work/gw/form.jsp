<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../base/docHeader.jsp"%>
<h1 class="h3 mb-0 text-gray-800">Zlecenie nr ${work.id}</h1>

<hr/>
<form:form modelAttribute="work"
           method="post"
           action="${pageContext.request.contextPath}/work/${type_prefix}/form">


    <form:hidden path="id"/>

    <p>Rodzaj zlecenia:</p>
    <form:select path="catalog" name="catalog"><br>
        <form:options items="${catalogTypes}" itemLabel="title"/><br>
    </form:select>
    <form:input path="trade" placeholder="Wpisz branżę" name="trade"/>
    <form:errors path="trade"/>

<label> Typ roboty:
    <form:select path="workType" name="workType"><br>
        <form:options items="${workTypes}" itemLabel="title"/><br>
    </form:select>
</label>



    <p>Lokalizacja zlecenia:</p>

    <form:input path="object" placeholder="Wpisz obiekt" name="object"/>
    <form:errors path="object"/>

    <form:input path="mileageStart" placeholder="Kilometraż początku" name="milleageStart"/>
    <form:errors path="mileageStart"/>

    <form:input path="mileageEnd" placeholder="Kilometraż końca" name="milleageEnd"/>
    <form:errors path="mileageEnd"/>

    <form:input type="date" path="workDate" name="workDate" value="${work.workDate}"/>
    <form:errors path="workDate"/>

    <p>Opis zlecenia:</p>

    <form:textarea path="description" placeholder="Temat zlecenia" name="description"/>
    <form:errors path="description"/><br>

    <form:textarea path="declarantComment" placeholder="Uwagi dla geodezji" name="declarantComment"/>
    <form:errors path="declarantComment"/><br>

    <form:textarea path="geodesyComment" placeholder="Uwagi dla GW" name="geodesyComment"/>
    <form:errors path="geodesyComment"/><br>

    <p>Podsumowanie:</p>


    <form:textarea path="constructFieldRaport" placeholder="Raport z terenu" name="constructFieldRaport"/>
    <form:errors path="constructFieldRaport"/><br>



    <label> Status zlecenia:
        <form:select path="status" name="status">
            <form:options items="${statusTypes}" itemLabel="title"/><br>
        </form:select>
    </label><br>

    <form:select path="subcontractors" name="subcontractors">
        <form:options items="${subcontractors}" itemLabel="name" itemValue="id"/><br>
    </form:select>

    <input type="submit" value="save">




</form:form>

<a href="/">RETURN HOME</a>
<%@include file="../../base/docFooter.jsp"%>