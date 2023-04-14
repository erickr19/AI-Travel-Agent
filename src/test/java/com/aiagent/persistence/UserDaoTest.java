package com.aiagent.persistence;

import com.aiagent.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    // instance variables
    GenericDao userDao;
    Database db;
    List<User> users;

    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
        db = Database.getInstance();
        db.runSQL("ai-travel-agent-dump.sql");
        users = userDao.getAll();
    }

    /**
     * Inserts user into the database
     */
    @Test
    void insert() {
        // create new user
        User newUser = new User();
        // add data to user
        newUser.setFirstName("John");
        newUser.setUsername("jsmithy14");
        newUser.setEmail("jsmith@example.com");
        // not possible to add multiple itineraries to user
        // insert user
        int newUserId = userDao.insert(newUser);
        // get inserted user
        User insertedUser = (User) userDao.getById(newUserId);
        // test
        assertEquals(3, insertedUser.getId().intValue());
    }

    @Test
    void getById() {
        // get user by id
        User retrievedUser = (User)userDao.getById(1);
        // test
        assertEquals("Erick", retrievedUser.getFirstName());
    }

    @Test
    void update() {
        // get user to update
        User userToUpdate = (User)userDao.getById(1);
        // create new email
        String newEmail = "ereyes4@madisoncollege.edu";
        // update email
        userToUpdate.setEmail(newEmail);
        // update
        userDao.update(userToUpdate);
        // get updated user
        User updatedUser = (User)userDao.getById(1);
        // test
        assertEquals(newEmail, updatedUser.getEmail());
    }

    @Test
    void delete() {
        // get user to delete
        User userToDelete = (User)userDao.getById(1);
        // delete user
        userDao.delete(userToDelete);
        // test
        assertNull((User)userDao.getById(1));
    }

    @Test
    void getAll() {
        // test
        assertEquals(2, users.size());
    }

    @Test
    void findByPropertyEqual() {
        // find user
        List foundUsers = userDao.findByPropertyEqual("username", "ereyes3");
        // test
        assertEquals(1, foundUsers.size());
    }
}