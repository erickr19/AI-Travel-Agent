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
<%-- set generated itinerary --%>
<c:set var="generatedItinerary" value='${requestScope["generatedItinerary"]}' />
<%-- body --%>
<body class="bg-white">
<%-- main container --%>
<div class="container mt-4">
    <%-- nav --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container d-flex justify-content-center p-0 mt-5">
        <%-- search container --%>
        <div class="text-dark w-100">
            <%-- search bar title --%>
            <h3>Create an itinerary</h3>
            <%-- search bar --%>
            <form id="apiCall" method="POST" action="create">
                <%-- text input --%>
                <div>
                    <label for="promptForm" class="form-label">Itinerary prompt</label>
                    <input type="text" class="form-control" id="promptForm" name="prompt" placeholder="Plan a two day trip to Madison, Wisconsin">
                    <div id="promptHelp" class="form-text">Having "plan", trip length, and destination are essential for good results!</div>
                </div>
                <%-- enter and clear button container --%>
                <div class="container mt-3 justify-content-end d-flex p-0">
                    <button class="btn btn-light me-3" type="reset">clear</button>
                    <button class="btn btn-primary" type="submit">create</button>
                </div>
            </form>
            <%-- generation results --%>
            <c:if test = "${not empty generatedItinerary}">
            <form id="saveItineraryForm" method="POST" action="save">
                <%-- generated itinerary --%>
                <div class="mb-3">
                    <label for="itinerary" class="form-label">Itinerary</label>
                    <textarea class="form-control" id="itinerary" rows="20" aria-describedby="itineraryBody" name="itinerary" required>${generatedItinerary}</textarea>
                    <div id="itineraryHelp" class="form-text">Required. You'll be able to edit this later too.</div>
                </div>
                <%-- title --%>
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" id="title" aria-describedby="itineraryTitle" name="title">
                    <div id="titleHelp" class="form-text">100 character limit</div>
                </div>
                <%-- budget --%>
                <div class="mb-3">
                    <label for="budget" class="form-label">Budget</label>
                    <input type="text" class="form-control" id="budget" aria-describedby="itineraryBudget" name="budget" required>
                    <div id="budgetHelp" class="form-text">Required. The AI does not take budget into account when generating.</div>
                </div>
                <%-- date --%>
                <div class="mb-3">
                    <label for="date" class="form-label">Date</label>
                    <input type="date" class="form-control" id="date" aria-describedby="itineraryTravelDate" name="date">
                </div>
                <%-- notes --%>
                <div class="mb-3">
                    <label for="notes" class="form-label">Notes</label>
                    <input type="text" class="form-control" id="notes" aria-describedby="itineraryNotes" name="notes">
                    <div id="noteHelp" class="form-text">1000 character limit</div>
                </div>
                <%-- enter and clear button container --%>
                <div class="container mt-3 justify-content-end d-flex p-0">
                    <button class="btn btn-light me-3" type="reset">clear</button>
                    <button class="btn btn-primary" type="submit">save</button>
                </div>
            </form>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>

