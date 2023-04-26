package com.aiagent.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    // default values
    static final int MAX_VALUE_20 = 20;
    static final int MAX_VALUE_60 = 60;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Size(max = MAX_VALUE_20)
    @NotNull
    @Column(name = "username", nullable = false, length = MAX_VALUE_20)
    private String username;

    @Size(max = MAX_VALUE_60)
    @NotNull
    @Column(name = "email", nullable = false, length = MAX_VALUE_60)
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
     * @param idToSet user id
     */
    public void setId(Integer idToSet) {
        this.id = idToSet;
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
     * @param usernameToSet username
     */
    public void setUsername(String usernameToSet) {
        this.username = usernameToSet;
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
     * @param emailToSet user's email
     */
    public void setEmail(String emailToSet) {
        this.email = emailToSet;
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
     * @param itinerariesToSet set of itineraries
     */
    public void setItineraries(List<Itinerary> itinerariesToSet) {
        this.itineraries = itinerariesToSet;
    }

}