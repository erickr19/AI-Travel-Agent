package com.aiagent.controller;


import com.aiagent.entity.Itinerary;
import org.junit.jupiter.api.Test;
import com.aiagent.controller.ViewItinerary;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ViewItineraryTest {

    Integer testId = 1;
    LocalDate date = LocalDate.of(2023, 2, 19);
    ViewItinerary viewer = new ViewItinerary();

    @Test
    void getItineraryDetails() {
        Itinerary itinerary = viewer.getItineraryDetails(testId);
        assertEquals(testId, itinerary.getId());
    }

    @Test
    void parseDateForDisplay() {
        assertEquals("2023-02-19", viewer.parseDateForDisplay(date));
    }
}