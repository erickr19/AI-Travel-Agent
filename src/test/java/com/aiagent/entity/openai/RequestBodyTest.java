package com.aiagent.entity.openai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestBodyTest {

    RequestBody body;

    @BeforeEach
    void setUp() {
        body = new RequestBody();
    }

    @Test
    void setTopP() {
        body.setTopP(1);
        assertEquals(1, body.getTopP());
    }

    @Test
    void getTopP() {
        body.setTopP(1);
        int P = body.getTopP();
        assertEquals(1, P);
    }

    @Test
    void setFrequencyPenalty() {
        body.setFrequencyPenalty(0);
        assertEquals(0, body.getFrequencyPenalty());
    }

    @Test
    void getFrequencyPenalty() {
        body.setFrequencyPenalty(0);
        int P = body.getFrequencyPenalty();
        assertEquals(0, P);
    }

    @Test
    void setMaxTokens() {
        body.setMaxTokens(250);
        assertEquals(250, body.getMaxTokens());
    }

    @Test
    void getMaxTokens() {
        body.setMaxTokens(250);
        int maxTokens = body.getMaxTokens();
        assertEquals(250, maxTokens);
    }

    @Test
    void setPresencePenalty() {
        body.setPresencePenalty(0);
        assertEquals(0, body.getPresencePenalty());
    }

    @Test
    void getPresencePenalty() {
        body.setPresencePenalty(0);
        int presencePenalty = body.getPresencePenalty();
        assertEquals(0, presencePenalty);
    }

    @Test
    void setTemperature() {
        body.setTemperature(0.7);
        assertEquals(0.7, body.getTemperature());
    }

    @Test
    void getTemperature() {
        body.setTemperature(0.7);
        Object temperature = body.getTemperature();
        assertEquals(0.7, temperature);
    }

    @Test
    void setModel() {
        body.setModel("text-davinci-003");
        assertEquals("text-davinci-003", body.getModel());
    }

    @Test
    void getModel() {
        body.setModel("text-davinci-003");
        String model = body.getModel();
        assertEquals("text-davinci-003", model);
    }

    @Test
    void setPrompt() {
        String prompt = "Create a day trip to Tokyo";
        body.setPrompt(prompt);
        assertEquals(prompt, body.getPrompt());
    }

    @Test
    void getPrompt() {
        String prompt = "Create a day trip to Tokyo";
        body.setPrompt(prompt);
        String retrievedPrompt = body.getPrompt();
        assertEquals(prompt, retrievedPrompt);
    }
}