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
                <%-- header --%>
                <h1 class="mb-4">Make trip planning <span class="custom-text-sky-blue">fly</span> with AI</h1>
                <%-- grid container --%>
                <div class="container">
                    <%-- row --%>
                    <div class="row">
                        <%-- first column --%>
                        <div class="col-md-6 p-1">
                            <h2>Trip planning is always a hassle... looking for ideas from blogs, videos, etc.</h2>
                            <h3>Have a personal AI travel agent plan it for you!</h3>
                            <%-- button container --%>
                            <div class="container justify-content-start mt-5 d-flex p-0">
                                <button class="btn btn-light border-black me-3">Sign-up</button>
                                <button class="btn btn-primary border-black">Log-in</button>
                            </div>
                        </div>
                        <%-- second column --%>
                        <div class="col-md-6 p-1">
                            <h4>Example:</h4>
                            <p class="custom-text-sky-blue">Create a week-long itinerary for a trip to Spain in the spring.</p>
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
