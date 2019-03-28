<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/docHeader.jsp"%>
<h1 class="h3 mb-0 text-gray-800">Ostatnie zlecenia</h1>



<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
    <thead>
    <tr>
        <th>Id</th>
        <th>Obiekt</th>
        <th>Kilometraż od</th>
        <th>Kilometraż do</th>
        <th>Temat zlecenia</th>
        <th>Status</th>
        <th>Data zgłoszenia</th>
        <th>Szczegóły</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${last10}" var="work">
        <tr>
            <td>${work.id}</td>
            <td>${work.object}</td>
            <td>${work.mileageStart}</td>
            <td>${work.mileageEnd}</td>
            <td>${work.description}</td>
            <td>${work.status.title}</td>
            <td>${work.applicationDate}</td>
            <td>
                <a href="${pageContext.request.contextPath}/work/${type_prefix}/form/${work.id}" class="btn btn-info rounded-0 text-light m-1">Pokaż</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>













<%@include file="base/docFooter.jsp"%>
