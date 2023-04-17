package com.aiagent.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Create servlet class.
 * Forwards user to the create page.
 * @author ereyes3
 */
@WebServlet(
        name = "create",
        urlPatterns = { "/create" }
)
public class Create extends HttpServlet {
    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method.
     * Called when user visits the create page.
     * Redirects to create.jsp
     * @exception ServletException is there is a servlet failure
     * @exception IOException if there is an IO error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // get session
                HttpSession session = request.getSession();
                // if user logged in forward to create page
                if (session.getAttribute("user") != null) {
                    // set url
                    String url = "/create.jsp";
                    // set page title
                    request.setAttribute("pageTitle", "Create a new itinerary");
                    // get dispatcher
                    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
                    // forward
                    dispatcher.forward(request, response);
                // else redirect to status page with error
                } else {
                    // set url
                    String url = "/status.jsp";
                    // set error message
                    request.setAttribute("errorMessage", "401: Unauthorized. User not logged in.");
                    // set page title
                    request.setAttribute("pageTitle", "401 Not Authorized");
                    // get dispatcher
                    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
                    // forward
                    dispatcher.forward(request, response);
                }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // get prompt
                String prompt = request.getParameter("prompt");
                // instantiate API
                OpenAi openAi = new OpenAi();
                // call API
                String generatedItinerary = openAi.callApi(prompt);
                // set page title
                request.setAttribute("pageTitle", "View generated itinerary");
                // set request attribute
                request.setAttribute("generatedItinerary", generatedItinerary);
                // set url
                String url = "/create.jsp";
                // get dispatcher
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
                // forward
                dispatcher.forward(request, response);
    }

}
