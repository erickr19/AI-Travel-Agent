<%--
  User: ereyes3
  Date: 4/12/23
  Time: 2:43 PM
  Homepage.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- set user --%>
<c:set var="user" value='${sessionScope["user"]}' />
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
            <div class="mt-3">
                <%-- header --%>
                <h1 class="mb-4">Make trip planning <span class="custom-text-sky-blue">fly</span> with <span class="custom-text-sky-blue">AI</span><c:if test="${not empty user}">, ${user.getUsername()}!</c:if></h1>
                <%-- grid container --%>
                <div class="container">
                    <%-- row --%>
                    <div class="row">
                        <%-- first column --%>
                        <div class="col-md-6 p-1">
                            <h2>Trip planning is always a hassle... looking for ideas from blogs, videos, etc.</h2>
                            <h3>Have a personal AI travel agent plan it for you!</h3>
                            <%-- button container --%>
                            <c:if test="${empty user}">
                            <div class="container justify-content-start mt-3 mt-sm-3 mt-md- d-flex p-0">
                                <a class="text-decoration-none" href="${pageContext.request.contextPath}/logIn"><button class="btn btn-primary border-black me-3">Sign-up / Log-in</button></a>
                            </div>
                            </c:if>
                            <c:if test="${not empty user}">
                            <div class="container justify-content-start mt-3 d-flex p-0">
                                <a class="text-decoration-none" href="${pageContext.request.contextPath}/logout"><button class="btn btn-light border-black me-3">Logout</button></a>
                                <a class="text-decoration-none" href="${pageContext.request.contextPath}/create"><button class="btn btn-primary border-black me-3">Create new itinerary</button></a>
                            </div>
                            </c:if>
                        </div>
                        <%-- second column --%>
                        <div class="col-md-6 p-1 mt-4 mt-sm-4 mt-md-0">
                            <h4>Example:</h4>
                            <p class="custom-text-sky-blue">Create a two-day itinerary for a trip to Spain in the spring.</p>
                            <h4>Day 1:</h4>
                            <p>Arrive in Madrid and explore the city. Visit attractions such as Plaza Mayor, Palacio Real, Puerta del Sol and Gran Via.</p>
                            <h4>Day 2:</h4>
                            <p>Take a day trip to Segovia. Explore the old town of Segovia, visit Alcazar Castle and admire Roman aqueducts...</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
