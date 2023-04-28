package com.aiagent.controller;

import com.aiagent.entity.User;
import com.aiagent.persistence.GenericDao;
import org.junit.jupiter.api.Test;
import org.mockito.verification.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SaveTest {
    GenericDao userDao = new GenericDao(User.class);
    Save test = new Save();
    String itinerary = "Day 1: Go to Chicago";
    String title = "One day trip to Chicago";
    String budget = "2000";
    String date = "2023-02-19";
    LocalDate testDate = LocalDate.of(2023, 02, 19);
    String notes = "";
    User user = (User)userDao.getById(1);
    @Test
    void save() {
        assertTrue(test.save(itinerary, title, budget, date, notes, user));
    }

    @Test
    void parseDateForStorage() {
        assertEquals(testDate, test.parseDateForStorage(date));
    }
}