package com.aiagent.controller;

import com.aiagent.entity.Itinerary;
import com.aiagent.entity.User;
import com.aiagent.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(
        name = "save",
        urlPatterns = { "/save" }
)
public final class Save extends HttpServlet {

    /**
     * doGet method.
     * Called when a user visits this servlet (no form submission).
     * Redirects to an error page with error message.
     * @exception ServletException if there is a servlet failure
     * @exception IOException if there is an IO error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // set url
            String url = "/status.jsp";
            // set page title
            request.setAttribute("pageTitle", "Error!");
            // set error message
            request.setAttribute("errorMessage", "Nothing to save... you're quite the traveller though!");
            // get dispatcher
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
            // forward
            dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // get session
            HttpSession session = request.getSession();
            // get parameters
            String itinerary = request.getParameter("itinerary");
            String title = request.getParameter("title");
            String budget = request.getParameter("budget");
            String date = request.getParameter("date");
            String notes = request.getParameter("notes");
            // save to db
            save(itinerary, title, budget, date, notes, (User)session.getAttribute("user"));
            // set success message
            request.setAttribute("successMessage", "Itinerary added successfully!");
            // set url
            String url = "/status.jsp";
            // get dispatcher
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
            // forward
            dispatcher.forward(request, response);
    }

    public boolean save(String itinerary, String title, String budget, String date, String notes, User user) {
        // instantiate itineraryDao
        GenericDao itineraryDao = new GenericDao(Itinerary.class);
        // convert budget to integer
        Integer parsedBudget = Integer.parseInt(budget);
        // parse date for db
        LocalDate parsedDate = parseDateForStorage(date);
        // create new itinerary
        Itinerary newItinerary = new Itinerary(itinerary, parsedBudget, parsedDate, notes, user, title);
        // save to db
        itineraryDao.insert(newItinerary);
        // return boolean
        return true;
    }

    public LocalDate parseDateForStorage(String date) {
        // instantiate formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // return
        return LocalDate.parse(date, formatter);
    }
}
