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
        <form>
          <%-- title --%>
          <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" class="form-control" id="title" value="${itinerary.getTitle()}" aria-describedby="itineraryTitle" disabled>
          </div>
          <%-- budget --%>
          <div class="mb-3">
            <label for="budget" class="form-label">Budget</label>
            <input type="text" class="form-control" id="budget" value="${itinerary.getBudget()}" aria-describedby="itineraryBudget" disabled>
          </div>
          <%-- date --%>
          <div class="mb-3">
            <label for="date" class="form-label">Date</label>
            <input type="date" class="form-control" id="date" value='<c:out value="${formattedDate}" />' aria-describedby="itineraryTravelDate" disabled>
          </div>
          <%-- notes --%>
          <div class="mb-3">
            <label for="notes" class="form-label">Notes</label>
            <input type="text" class="form-control" id="notes" value="${itinerary.getNotes()}" aria-describedby="itineraryNotes" disabled>
          </div>
          <%-- itinerary body --%>
          <div class="mb-3">
            <label for="itinerary" class="form-label">Itinerary</label>
            <textarea class="form-control" id="itinerary" rows="3" aria-describedby="itineraryBody" disabled>${itinerary.getItinerary()}</textarea>
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
