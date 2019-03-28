<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../base/docHeader.jsp"%>
<h1 class="h3 mb-0 text-gray-800">Lista zleceń</h1>
<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
    <thead>
    <tr>
    <th>Id</th>
    <th>Katalog</th>
    <th>Branża</th>
    <th>Obiekt</th>
    <th>Kilometraż od</th>
    <th>Kilometraż do</th>
    <th>Temat zlecenia</th>
    <th>Status</th>
    <th>Edycja</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${works}" var="work">
        <tr>
            <td>${work.id}</td>
            <td>${work.catalog.title}</td>
            <td>${work.trade}</td>
            <td>${work.object}</td>
            <td>${work.mileageStart}</td>
            <td>${work.mileageEnd}</td>
            <td>${work.description}</td>
            <td>${work.status.title}</td>
            <td>
                <a href="${pageContext.request.contextPath}/work/${type_prefix}/form/${work.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<%@include file="../../base/docFooter.jsp"%>
