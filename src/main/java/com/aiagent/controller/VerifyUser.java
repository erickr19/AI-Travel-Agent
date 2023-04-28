package com.aiagent.controller;

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
import java.util.List;

@WebServlet(
        name = "verifyUser",
        urlPatterns = { "/verify" }
)
public final class VerifyUser extends HttpServlet {
    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());
    // declare session
    private HttpSession session;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // instantiate session
            session = request.getSession();
            // get username
            String username = (String)session.getAttribute("username");
            // get email
            String email = (String)session.getAttribute("userEmail");
            // check database
            checkDatabaseAndSetToSession(username, email);
            // set url
            String url = "/homepage";
            // get request dispatcher
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
            // forward
            dispatcher.forward(request, response);
    }

    public void checkDatabaseAndSetToSession(String username, String email) {
        User user = getUser(username, email);
        session.setAttribute("user", user);
    }

    public User getUser(String username, String email) {
        // instance variables
        User user;
        // instantiate userDao
        GenericDao userDao = new GenericDao(User.class);
        // check if username exists in db (always unique)
        List foundUserByUsername = userDao.findByPropertyEqual("username", username);
        // if username doesn't exist in db, create user into db
        if (foundUserByUsername.isEmpty()) {
            // instantiate new user object
            User newUser = new User();
            // add data to new user
            newUser.setUsername(username);
            newUser.setEmail(email);
            // insert user
            int newUserId = userDao.insert(newUser);
            // get newly created user
            user = (User)userDao.getById(newUserId);
            // log user
            logger.info("User created: " + user.getUsername());
        // else get existing user
        } else {
            // get found user
            user = (User)foundUserByUsername.get(0);
            // log user
            logger.info("Found user: " + user.getUsername());
        }
        return user;
    }
}
