<%--
  Created by IntelliJ IDEA.
  User: ereyes3
  Date: 4/12/23
  Time: 2:46 PM
  Navigation component.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg mt-2 mb-3 bg-white rounded shadow sticky-top">
    <div class="container-fluid">
        <%-- logo --%>
        <img src="${pageContext.request.contextPath}/images/pixel-airplane.png" class="plane-logo-sizing">
        <%-- project name --%>
        <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/homepage">AI Travel Agent</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarToggler">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/homepage">Home</a>
                </li>
                <c:if test="${not empty user}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/create">Create</a>
                </li>
                </c:if>
                <c:if test="${not empty user}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/profile">Profile</a>
                    </li>
                </c:if>
                <c:if test="${empty user}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logIn">Login</a>
                </li>
                </c:if>
                <c:if test="${not empty user}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
