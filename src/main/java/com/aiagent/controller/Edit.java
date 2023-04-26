// TODO: Ensure edit only edits logged in user's itinerary

package com.aiagent.controller;

import com.aiagent.entity.Itinerary;
import com.aiagent.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(
        name = "edit",
        urlPatterns = { "/edit" }
)
public final class Edit extends HttpServlet {
    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // itineraryDao
    private GenericDao itineraryDao;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // get itinerary id to view
            logger.info("ID to edit: " + request.getParameter("editId"));
            Integer itineraryId = Integer.parseInt(request.getParameter("editId"));
            // call getItineraryDetails
            Itinerary itinerary = getItineraryDetails(itineraryId);
            // parse date
            String formattedDate = parseDateForDisplay(itinerary.getTravelDate());
            // set request attributes
            request.setAttribute("itinerary", itinerary);
            request.setAttribute("formattedDate", formattedDate);
            // set url
            String url = "/editItinerary.jsp";
            // set page title
            request.setAttribute("pageTitle", itinerary.getTitle());
            // get dispatcher
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
            // forward
            dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // get parameters
            String id = request.getParameter("id");
            String itinerary = request.getParameter("itinerary");
            String title = request.getParameter("title");
            String budget = request.getParameter("budget");
            String date = request.getParameter("date");
            String notes = request.getParameter("notes");
            // save to db
            update(id, itinerary, title, budget, date, notes);
            // set successful edit status message
            request.setAttribute("successMessage", "Itinerary edited and saved successfully!");
            // set url
            String url = "/status.jsp";
            // get dispatcher
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
            // forward
            dispatcher.forward(request, response);
    }

    public Itinerary getItineraryDetails(Integer idToGet) {
        // instantiate itineraryDao
        itineraryDao = new GenericDao(Itinerary.class);
        // get requested itinerary
        return (Itinerary) itineraryDao.getById(idToGet);
    }

    public void update(String id, String itinerary, String title, String budget, String date, String notes) {
        // parse id
        Integer itineraryId = Integer.parseInt(id);
        // convert budget to integer
        Integer parsedBudget = Integer.parseInt(budget);
        // parse date for db
        LocalDate parsedDate = parseDateForStorage(date);
        // get itinerary to update
        Itinerary itineraryToUpdate = (Itinerary)itineraryDao.getById(itineraryId);
        // update fields
        itineraryToUpdate.setItinerary(itinerary);
        itineraryToUpdate.setTitle(title);
        itineraryToUpdate.setBudget(parsedBudget);
        itineraryToUpdate.setTravelDate(parsedDate);
        itineraryToUpdate.setNotes(notes);
        // save to db
        itineraryDao.update(itineraryToUpdate);
    }

    public LocalDate parseDateForStorage(String date) {
        // instantiate formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // return
        return LocalDate.parse(date, formatter);
    }

    public String parseDateForDisplay(LocalDate date) {
        // format date for display on HTML form
        DateTimeFormatter formattedDisplay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // get date string
        String formattedDate = date.format(formattedDisplay);
        // log date
        logger.info("Formatted date: " + formattedDate);
        // return formatted date
        return formattedDate;
    }
}
