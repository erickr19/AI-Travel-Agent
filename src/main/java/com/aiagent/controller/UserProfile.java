package com.aiagent.controller;

import com.aiagent.entity.Itinerary;
import com.aiagent.entity.User;
import com.aiagent.persistence.GenericDao;
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
import java.util.ArrayList;
import java.util.List;


@WebServlet(
        name = "userprofile",
        urlPatterns = "/profile"
)
public class UserProfile extends HttpServlet {
    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // itinerary list
    private List<Itinerary> itineraryList = new ArrayList<>();

    // HTTP session
    private HttpSession session;

    /**
     * doGet method
     * Called when user visits profile.
     * Forwards user to profile.jsp with their itineraries retrieved.
     * @exception ServletException if there is a servlet failure
     * @exception IOException if there is an IO error.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get session
        session = request.getSession();
        // get user's itinerary and set to itinerary list
        getItineraries((User)session.getAttribute("user"));
        // set list request attribute
        request.setAttribute("itineraryList", itineraryList);
        // set url
        String url = "/profile.jsp";
        // set page title
        request.setAttribute("pageTitle", "Your profile");
        // get dispatcher
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        // forward
        dispatcher.forward(request, response);
    }

    /**
     * Gets user's itineraries and sets itineraryList.
     */
    private void getItineraries(User user) {
        // refresh user
        refreshUser(user);
        // get user's itinerary
        itineraryList = user.getItineraries();
        // log itineraries
        logger.info("Itineraries retrieved: " + itineraryList.size());
        for (Itinerary itinerary : itineraryList) {
            logger.info("itinerary: " + itinerary.getItinerary());
        }
    }

    private void refreshUser(User user) {
        // instantiate userDao
        GenericDao userDao = new GenericDao(User.class);
        // get user
        User userToRefresh = user;
        // get id
        Integer idToRefresh = userToRefresh.getId();
        // get user from db
        User refreshedUser = (User)userDao.getById(idToRefresh);
        // set refreshed user to session
        session.setAttribute("user", refreshedUser);
        // log refresh
        logger.info("User refreshed: " + refreshedUser.getUsername());
    }
}
