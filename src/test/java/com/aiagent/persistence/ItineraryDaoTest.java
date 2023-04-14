package com.aiagent.persistence;

import com.aiagent.entity.Itinerary;
import com.aiagent.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    /**
     * Tests getting by id
     */
    @Test
    void getById() {
        // get itinerary
        Itinerary retrievedItinerary = (Itinerary)itineraryDao.getById(2);
        // test
        assertEquals(2, retrievedItinerary.getId().intValue());
    }

    @Test
    void update() {
        // get itinerary
        Itinerary updatedItinerary = (Itinerary)itineraryDao.getById(1);
        // create a new date
        LocalDate newDate = LocalDate.of(2023, 5, 15);
        // set new date
        updatedItinerary.setTravelDate(newDate);
        // update
        itineraryDao.update(updatedItinerary);
        // get updated itinerary
        Itinerary itinerary = (Itinerary)itineraryDao.getById(1);
        // test
        assertEquals(newDate, itinerary.getTravelDate());
    }

    @Test
    void delete() {
        // get itinerary to delete
        Itinerary itineraryToDelete = (Itinerary)itineraryDao.getById(1);
        // delete itinerary
        itineraryDao.delete(itineraryToDelete);
        // test
        assertNull((Itinerary)itineraryDao.getById(1));
    }

    @Test
    void getAll() {
        // test
        assertEquals(2, itineraries.size());
    }

    @Test
    void findByPropertyEqual() {
        // find itineraries
        List foundItineraries = itineraryDao.findByPropertyEqual("travelDate", LocalDate.of(2024, 5, 11));
        // test
        assertEquals(1, foundItineraries.size());
    }
}