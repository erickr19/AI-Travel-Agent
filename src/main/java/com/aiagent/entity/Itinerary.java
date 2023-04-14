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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itinerary_id", nullable = false)
    private Integer id;

    @Size(max = 1000)
    @NotNull
    @Column(name = "itinerary", nullable = false, length = 1000)
    private String itinerary;

    @NotNull
    @Column(name = "budget", nullable = false)
    private Integer budget;

    @NotNull
    @Column(name = "travel_date", nullable = false)
    private LocalDate travelDate;

    @Size(max = 200)
    @NotNull
    @Column(name = "notes", nullable = false, length = 200)
    private String notes;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Empty constructor
     */
    public Itinerary() {}

    /**
     * Gets user id
     * @return user id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id
     * @param id user id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @param itinerary the itinerary to set
     */
    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
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
     * @param budget the budget to set
     */
    public void setBudget(Integer budget) {
        this.budget = budget;
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
     * @param travelDate the travel date to set
     */
    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
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
     * @param notes the itinerary notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
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
     * @param user the itinerary's user
     */
    public void setUser(User user) {
        this.user = user;
    }

}