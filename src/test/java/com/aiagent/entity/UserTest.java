package com.aiagent.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void getId() {
        Integer testId = 1;
        user.setId(testId);
        Integer retrievedID = user.getId();
        assertEquals(testId, retrievedID);
    }

    @Test
    void setId() {
        Integer testId = 1;
        user.setId(testId);
        assertEquals(testId, user.getId());
    }

    @Test
    void getUsername() {
        String testUsername = "test";
        user.setUsername(testUsername);
        String retrievedUsername = user.getUsername();
        assertEquals(testUsername, retrievedUsername);
    }

    @Test
    void setUsername() {
        String testUsername = "test";
        user.setUsername(testUsername);
        assertEquals(testUsername, user.getUsername());
    }

    @Test
    void getEmail() {
        String testEmail = "test@test.com";
        user.setEmail(testEmail);
        String retrievedEmail = user.getEmail();
        assertEquals(testEmail, retrievedEmail);
    }

    @Test
    void setEmail() {
        String testEmail = "test@test.com";
        user.setEmail(testEmail);
        assertEquals(testEmail, user.getEmail());
    }

    @Test
    void getItineraries() {
        List<Itinerary> itineraries = new ArrayList<>();
        Itinerary testItinerary = new Itinerary();
        itineraries.add(testItinerary);
        user.setItineraries(itineraries);
        assertEquals(itineraries.size(), user.getItineraries().size());
    }

    @Test
    void setItineraries() {

    }
}