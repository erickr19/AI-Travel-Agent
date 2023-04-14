<%--
  User: ereyes3
  Date: 4/13/23
  Time: 9:30 PM
  Create page.
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
    <div class="container d-flex justify-content-center p-0 mt-5">
        <%-- search container --%>
        <div class="text-dark w-75">
            <%-- search bar title --%>
            <h3>Create an itinerary</h3>
            <%-- search bar --%>
            <form id="apiSearch" method="POST" action="search">
                <%-- text input --%>
                <input type="text" class="form-control" name="query" placeholder="create a dream trip...">
                <%-- enter and clear button container --%>
                <div class="container mt-3 justify-content-end d-flex p-0">
                    <button class="btn btn-light border-black me-3" type="reset">clear</button>
                    <button class="btn btn-primary border-black" type="submit" value="beginSearch">create</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

