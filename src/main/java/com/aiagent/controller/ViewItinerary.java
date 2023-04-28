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
        name = "viewItinerary",
        urlPatterns = "/viewItinerary"
)
public class ViewItinerary extends HttpServlet {
    // instance variables

    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * doGet method
     * Called when user clicks to view their itinerary.
     * Forwards user to itineraryView.jsp.
     * @exception ServletException if there is a servlet failure
     * @exception IOException if there is an IO error.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // get itinerary id to view
            Integer itineraryId = Integer.parseInt(request.getParameter("itineraryToViewId"));
            // call getItineraryDetails
            Itinerary itinerary = getItineraryDetails(itineraryId);
            // parse date
            String formattedDate = parseDateForDisplay(itinerary.getTravelDate());
            // log itinerary
            logger.info("Itinerary retrieved: " + itinerary.getTitle());
            // set request attributes
            request.setAttribute("itinerary", itinerary);
            request.setAttribute("formattedDate", formattedDate);
            // log id
            logger.info("Itinerary ID: " + itinerary.getId());
            // set url
            String url = "/itineraryView.jsp";
            // set page title
            request.setAttribute("pageTitle", itinerary.getTitle());
            // get dispatcher
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
            // forward
            dispatcher.forward(request, response);
    }

    public Itinerary getItineraryDetails(Integer idToGet) {
        // instantiate itineraryDao
        GenericDao itineraryDao = new GenericDao(Itinerary.class);
        // get requested itinerary
        return (Itinerary) itineraryDao.getById(idToGet);
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
