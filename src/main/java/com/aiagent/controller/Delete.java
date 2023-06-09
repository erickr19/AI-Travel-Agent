// TODO: Ensure delete only deletes logged-in user's itinerary

package com.aiagent.controller;

import com.aiagent.entity.Itinerary;
import com.aiagent.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "delete",
        urlPatterns = { "/delete" }
)
public final class Delete extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            // instantiate an itineraryDao
            GenericDao itineraryDao = new GenericDao(Itinerary.class);

            // get id to delete
            Integer idToDelete = Integer.parseInt(request.getParameter("deleteId"));

            // get itinerary to delete
            Itinerary itineraryToDelete = (Itinerary)itineraryDao.getById(idToDelete);

            // delete
            itineraryDao.delete(itineraryToDelete);

            // set successful delete status message
            request.setAttribute("successMessage", "Itinerary deleted successfully!");

            // set url
            String url = "/status.jsp";

            // get dispatcher
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);

            // forward
            dispatcher.forward(request, response);
    }
}
