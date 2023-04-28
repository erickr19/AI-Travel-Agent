package com.aiagent.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;

class VerifyUserTest {
    String testUsername = "ereyes3";
    String testEmail = "ereyes3@madisoncollege.edu";
    VerifyUser verify = new VerifyUser();

    @Test
    void getUser() {
        assertEquals(testUsername, verify.getUser(testUsername, testEmail).getUsername());
    }
}