package com.aiagent.persistence;

import com.aiagent.entity.Itinerary;
import com.aiagent.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItineraryDaoTest {
    // instance variables
    GenericDao itineraryDao;
    GenericDao userDao;
    Database db;
    List<Itinerary> itineraries;

    @BeforeEach
    void setUp() {
        itineraryDao = new GenericDao(Itinerary.class);
        userDao = new GenericDao(User.class);
        db = Database.getInstance();
        db.runSQL("ai-travel-agent-dump.sql");
        itineraries = itineraryDao.getAll();
    }

    /**
     * Test inserting a new itinerary into database.
     */
    @Test
    void insert() {
        // create a new itinerary
        Itinerary itinerary = new Itinerary();
        // add data to itinerary
        // main body
        String outline = "Day 1: Arrive in Madrid and explore the city. Visit attractions such as Plaza Mayor, Palacio Real, Puerta del Sol and Gran Via.";
        itinerary.setItinerary(outline);
        // title
        String title = "Week-long trip to Spain!";
        itinerary.setTitle(title);
        // budget
        Integer budget = 2000;
        itinerary.setBudget(budget);
        // travel date
        LocalDate travelDate = LocalDate.of(2024, 5, 11);
        itinerary.setTravelDate(travelDate);
        // note
        String note = "Getting to know Spain for the first time!";
        itinerary.setNotes(note);
        // user
        User user = (User)userDao.getById(1);
        itinerary.setUser(user);
        // insert new itinerary into database
        int newItineraryId = itineraryDao.insert(itinerary);
        // get inserted itinerary
        Itinerary insertedItinerary = (Itinerary)itineraryDao.getById(newItineraryId);
        // test
        assertEquals(outline, insertedItinerary.getItinerary());
        assertEquals(title, insertedItinerary.getTitle());
        assertEquals(budget, insertedItinerary.getBudget());
        assertEquals(travelDate, insertedItinerary.getTravelDate());
        assertEquals(note, insertedItinerary.getNotes());
        assertEquals(user.getId(), insertedItinerary.getUser().getId());
    }

    @Test
    void getById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void findByPropertyEqual() {
    }
}