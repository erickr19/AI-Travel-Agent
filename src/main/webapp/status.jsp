<%--
  Created by IntelliJ IDEA.
  User: reyesmac
  Date: 4/13/23
  Time: 10:14 PM
  Profile page.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- set error message --%>
<c:set var="errorMessage" value='${requestScope["errorMessage"]}' />
<%-- set success message --%>
<c:set var="successMessage" value='${requestScope["successMessage"]}' />
<%-- body --%>
<body class="bg-white">
<%-- main container --%>
<div class="container mt-4">
    <%-- nav --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container d-flex justify-content-center p-0">
        <div class="text-dark">
            <%-- content container --%>
            <div class="mt-5">
                <c:if test="${not empty errorMessage}">
                <%-- error message container --%>
                <div class="d-flex justify-content-center">
                    <div class="rounded bg-danger-subtle w-75">
                        <h1 class="m-0 p-3">${errorMessage}</h1>
                    </div>
                </div>
                </c:if>
                <c:if test="${not empty successMessage}">
                    <%-- success message container --%>
                    <div class="d-flex justify-content-center">
                        <div class="rounded bg-success-subtle w-75">
                            <h1 class="m-0 p-3">${successMessage}</h1>
                            <p class="p-3"><a href="${pageContext.request.contextPath}/profile">Check it out here!</a></p>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
