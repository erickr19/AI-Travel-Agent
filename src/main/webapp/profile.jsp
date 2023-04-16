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
<%-- set list itineraries --%>
<c:set var="itineraryList" value='${requestScope["itineraryList"]}' />
<c:set var="successMessage" value='${requestScope["successMessage"]}' />
<%-- body --%>
<body class="bg-white">
<%-- main container --%>
<div class="container mt-4">
    <%-- nav --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container d-flex p-0">
        <div class="text-dark">
            <%-- content container --%>
            <div class="mt-5">
                <h1>Profile</h1>
                <h2 class="custom-text-sky-blue">Saved itineraries</h2>
                <%-- results grid--%>
                <div class="container p-0 text-center ">
                    <%-- row --%>
                    <div class="row justify-content-center justify-content-md-evenly row-cols-auto">
                        <%-- for each item in results, create column --%>
                        <c:forEach items="${itineraryList}" var="itinerary">
                            <%-- column --%>
                            <div class="col p-3">
                                <%-- card container --%>
                                <a class="text-decoration-none" href="${pageContext.request.contextPath}/viewItinerary?itineraryToViewId=${itinerary.getId().toString()}">
                                    <div class="custom-bg-sky-blue rounded text-white m-1 overflow-auto">
                                        <div>
                                            <%-- title --%>
                                            <p class="p-3">${itinerary.getTitle()}</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
