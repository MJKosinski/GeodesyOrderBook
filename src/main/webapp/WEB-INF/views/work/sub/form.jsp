<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../base/docHeader.jsp"%>
<h1 class="h3 mb-0 text-gray-800">Zlecenie nr ${work.id}</h1>

<hr/>
<p>
    <Strong>Dział: </Strong> ${work.catalog.title}
</p>
<p>
    <Strong>Branża: </Strong> ${work.trade}
</p>
<p>
    <Strong>Typ roboty:</Strong> ${work.workType.title}
</p>

<hr/>
<p>Lokalizacja zlecenia:</p>

<p>
    <Strong>Obiekt:</Strong> ${work.object}
</p>
<p>
    <Strong>Km od:</Strong> ${work.mileageStart} <strong> do: </strong>${work.mileageEnd}
</p>
<p>
    <Strong>Data roboty:</Strong> ${work.workDate}
</p>

<hr/>
    <p>Opis zlecenia:</p>

<p>
    <Strong>Temat:</Strong> ${work.description}
</p>

<p>
    <Strong>Raport z terenu:</Strong> ${work.constructFieldRaport}
</p>

<p>
    <Strong>Status:</Strong> ${work.status.title}
</p>

<%@include file="../../base/docFooter.jsp"%>