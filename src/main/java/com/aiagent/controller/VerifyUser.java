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
public class VerifyUser extends HttpServlet {
    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());
    // declare session
    HttpSession session;
    // userDao
    private GenericDao userDao;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // instantiate session
            session = request.getSession();
            // get username
            String username = (String)session.getAttribute("username");
            // get email
            String email = (String)session.getAttribute("email");
            // check database
            checkDatabase(username, email);
            // set url
            String url = "/homepage";
            // get request dispatcher
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
            // forward
            dispatcher.forward(request, response);
    }

    public void checkDatabase(String username, String email) {
        // instantiate userDao
        userDao = new GenericDao(User.class);
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
            User createdUser = (User)userDao.getById(newUserId);
            // log user
            logger.info("User created: " + createdUser.getUsername());
            // set new user to session
            session.setAttribute("user", createdUser);
        // else get existing user
        } else {
            // get found user
            User foundUser = (User)foundUserByUsername.get(0);
            // log user
            logger.info("Found user: " + foundUser);
            // set existing user to session
            session.setAttribute("user", foundUser);
        }
    }
}
