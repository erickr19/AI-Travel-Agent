package com.aiagent.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Size(max = 20)
    @NotNull
    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Size(max = 60)
    @NotNull
    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Itinerary> itineraries = new ArrayList<>();

    /**
     * Empty constructor
     */
    public User() {}

    /**
     * Gets user id
     * @return user id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets user id
     * @param id user id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets first name
     * @return user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name
     * @param firstName user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets email
     * @return user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     * @param email user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets itineraries
     * @return user's itineraries
     */
    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    /**
     * Sets itineraries
     * @param itineraries set of itineraries
     */
    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

}