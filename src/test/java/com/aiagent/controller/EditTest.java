package com.aiagent.controller;

import com.aiagent.entity.Itinerary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EditTest {

    Edit edit;

    @BeforeEach
    void setUp() {
        edit = new Edit();
    }

    @Test
    void getItineraryDetails() {
        Integer idToGet = 1;
        Itinerary itinerary = edit.getItineraryDetails(idToGet);
        assertEquals(idToGet, itinerary.getId());
    }

    @Test
    void parseDateForStorage() {
        String testDate = "2013-04-05";
        LocalDate parsedTestDate = LocalDate.of(2013, 04, 05);
        LocalDate parsedDate = edit.parseDateForStorage(testDate);
        assertEquals(parsedTestDate, parsedDate);
    }

    @Test
    void parseDateForDisplay() {
        String testDate = "2013-04-05";
        LocalDate parsedTestDate = LocalDate.of(2013, 04, 05);
        String parsedDisplayDate = edit.parseDateForDisplay(parsedTestDate);
        assertEquals(testDate, parsedDisplayDate);
    }
}