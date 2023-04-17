package com.aiagent.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Logs a logged in user out.
 * @author ereyes3
 */
@WebServlet(
        name = "logout",
        urlPatterns = { "/logout" }
)
public class Logout extends HttpServlet {
    /**
     * doGet method.
     * Called whenever logout is requested.
     * Checks to see if the user is logged in.
     * If user is logged in, it logs them out.
     * Otherwise, forwards to an error page.
     * @exception ServletException if there is a servlet failure.
     * @exception IOException if tehre is an IO error.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // check session to see if user is logged in
            HttpSession session = request.getSession();
            // if not null, remove user from session to log out and forward to test
            if (session.getAttribute("user") != null) {
                session.removeAttribute("user");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage");
                dispatcher.forward(request, response);
            // else forward to error page
            } else {
                request.setAttribute("error", "No user logged in to log out...");
                RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
                dispatcher.forward(request, response);
            }
    }
}
