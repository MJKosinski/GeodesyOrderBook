<%--usertype=${user.type}--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center"
       href="${pageContext.request.contextPath}/">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">${logUser.type.title}</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Strona startowa</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Ustawienia konta
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
           aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>Użytkownicy</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">UŻYTKOWNICY:</h6>
                <a class="collapse-item"
                   href="${pageContext.request.contextPath}/user/${type_prefix}/form/${logUser.id}">Edytuj
                    swój profil</a>
                <c:if test="${logUser.type == 'GEODESY' or logUser.type == 'GENERAL_CONTRACTOR'}">
                    <a class="collapse-item" href="${pageContext.request.contextPath}/user/${type_prefix}/form">Dodaj
                        użytkownika</a>

                    <a class="collapse-item" href="${pageContext.request.contextPath}/user/${type_prefix}/list">Lista
                        użytkowników</a>
                </c:if>
            </div>
        </div>
    </li>
    <hr class="sidebar-divider">

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-table"></i>
            <span>Zlecenia</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">ZLECENIA:</h6>
                <c:if test="${logUser.type == 'GEODESY' or logUser.type == 'GENERAL_CONTRACTOR'}">
                    <a class="collapse-item" href="${pageContext.request.contextPath}/work/${type_prefix}/form">Dodaj
                        zlecnie</a>
                </c:if>
                <a class="collapse-item" href="${pageContext.request.contextPath}/">Wyszukaj zlecenie</a>
                <a class="collapse-item"
                   href="${pageContext.request.contextPath}/work/${type_prefix}/list/${logUser.id}">Moje zlecenia</a>
                <c:if test="${logUser.type == 'GEODESY' or logUser.type == 'GENERAL_CONTRACTOR'}">
                    <a class="collapse-item" href="${pageContext.request.contextPath}/work/${type_prefix}/list">Wszystkie
                        zlecenia</a>
                </c:if>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>