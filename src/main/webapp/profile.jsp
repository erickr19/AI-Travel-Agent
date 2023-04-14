<%--
  Created by IntelliJ IDEA.
  User: reyesmac
  Date: 4/13/23
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
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
            </div>
            <%-- TODO: Add grid container for user's saved itineraries. --%>
        </div>
    </div>
</div>
</body>
</html>
