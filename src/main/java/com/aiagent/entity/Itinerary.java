package com.aiagent.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "Itineraries")
public class Itinerary {
    // default values
    static final int MAX_VALUE_1K = 1000;
    static final int MAX_VALUE_200 = 200;
    static final int MAX_VALUE_50 = 50;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itinerary_id", nullable = false)
    private Integer id;

    @Size(max = MAX_VALUE_1K)
    @NotNull
    @Column(name = "itinerary", nullable = false, length = MAX_VALUE_1K)
    private String itinerary;

    @Column(name = "budget", nullable = true)
    private Integer budget;

    @Column(name = "travel_date", nullable = true)
    private LocalDate travelDate;

    @Size(max = MAX_VALUE_200)
    @Column(name = "notes", nullable = true, length = MAX_VALUE_200)
    private String notes;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = MAX_VALUE_50)
    @Column(name = "title", length = MAX_VALUE_50)
    private String title;

    /**
     * Empty constructor
     */
    public Itinerary() {}

    /**
     * Constructs an Itinerary with most properties except ID
     * @param itineraryToSet the itinerary text
     * @param budgetToSet trip budget
     * @param travelDateToSet travel date
     * @param notesToSet notes
     * @param userToSet user to save itinerary to
     * @param titleToSet title of itinerary
     */
    public Itinerary(String itineraryToSet, Integer budgetToSet, LocalDate travelDateToSet, String notesToSet, User userToSet, String titleToSet) {
        this.itinerary = itineraryToSet;
        this.budget = budgetToSet;
        this.travelDate = travelDateToSet;
        this.notes = notesToSet;
        this.user = userToSet;
        this.title = titleToSet;
    }

    /**
     * Gets user id
     * @return user id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id
     * @param idToSet user id to set
     */
    public void setId(Integer idToSet) {
        this.id = idToSet;
    }

    /**
     * Gets itinerary
     * @return itinerary
     */
    public String getItinerary() {
        return itinerary;
    }

    /**
     * Sets itinerary
     * @param itineraryToSet the itinerary to set
     */
    public void setItinerary(String itineraryToSet) {
        this.itinerary = itineraryToSet;
    }

    /**
     * Gets budget
     * @return the itinerary budget
     */
    public Integer getBudget() {
        return budget;
    }

    /**
     * Sets budget
     * @param budgetToSet the budget to set
     */
    public void setBudget(Integer budgetToSet) {
        this.budget = budgetToSet;
    }

    /**
     * Gets travel date
     * @return the travel date
     */
    public LocalDate getTravelDate() {
        return travelDate;
    }

    /**
     * Sets travel date
     * @param travelDateToSet the travel date to set
     */
    public void setTravelDate(LocalDate travelDateToSet) {
        this.travelDate = travelDateToSet;
    }

    /**
     * Gets notes
     * @return itinerary notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes
     * @param notesToSet the itinerary notes to set
     */
    public void setNotes(String notesToSet) {
        this.notes = notesToSet;
    }

    /**
     * Gets user
     * @return the user of the itinerary
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user
     * @param userToSet the itinerary's user
     */
    public void setUser(User userToSet) {
        this.user = userToSet;
    }

    /**
     * Gets title
     * @return itinerary title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title
     * @param titleToSet title
     */
    public void setTitle(String titleToSet) {
        this.title = titleToSet;
    }
}