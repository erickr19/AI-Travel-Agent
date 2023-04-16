<%--
  Created by IntelliJ IDEA.
  User: reyesmac
  Date: 4/14/23
  Time: 12:39 PM
  View itinerary page.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- set itinerary --%>
<c:set var="itinerary" value='${requestScope["itinerary"]}' />
<%-- set itinerary formatted date --%>
<c:set var="formattedDate" value='${requestScope["formattedDate"]}' />
<%-- body --%>
<body class="bg-white">
<%-- main container --%>
<div class="container mt-4">
  <%-- nav --%>
  <%@include file="nav.jsp"%>
  <%-- content --%>
  <div class="container d-flex justify-content-center p-0">
    <div class="text-dark w-100">
      <%-- content container --%>
      <div class="mt-5">
        <%-- header --%>
        <h1 class="p-0">Viewing itinerary</h1>
        <%-- form --%>
          <form id="saveItineraryForm" method="POST" action="edit">
            <%-- generated itinerary --%>
            <div class="mb-3">
              <label for="itinerary" class="form-label">Itinerary</label>
              <textarea class="form-control" id="itinerary" rows="20" aria-describedby="itineraryBody" name="itinerary" required>${itinerary.getItinerary()}</textarea>
              <div id="itineraryHelp" class="form-text">You'll be able to edit this later too.</div>
            </div>
            <%-- title --%>
            <div class="mb-3">
              <label for="title" class="form-label">Title</label>
              <input type="text" class="form-control" id="title" aria-describedby="itineraryTitle" name="title" value="${itinerary.getTitle()}">
              <div id="titleHelp" class="form-text">100 character limit</div>
            </div>
            <%-- budget --%>
            <div class="mb-3">
              <label for="budget" class="form-label">Budget</label>
              <input type="text" class="form-control" id="budget" aria-describedby="itineraryBudget" name="budget" value="${itinerary.getBudget()}">
              <div id="budgetHelp" class="form-text">The AI does not take budget into account when generating.</div>
            </div>
            <%-- date --%>
            <div class="mb-3">
              <label for="date" class="form-label">Date</label>
              <input type="date" class="form-control" id="date" aria-describedby="itineraryTravelDate" name="date" value="${formattedDate}">
            </div>
            <%-- notes --%>
            <div class="mb-3">
              <label for="notes" class="form-label">Notes</label>
              <input type="text" class="form-control" id="notes" aria-describedby="itineraryNotes" name="notes" value="${itinerary.getTravelDate()}">
              <div id="noteHelp" class="form-text">1000 character limit</div>
            </div>
            <%-- hidden id --%>
            <input type="text" hidden id="id" name="id" value="${itinerary.getId()}">
            <%-- enter and clear button container --%>
            <div class="container mt-3 justify-content-end d-flex p-0">
              <button class="btn btn-light me-3" type="reset">clear</button>
              <button class="btn btn-primary" type="submit">save</button>
            </div>
          </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
