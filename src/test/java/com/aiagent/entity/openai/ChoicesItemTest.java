package com.aiagent.entity.openai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoicesItemTest {
    ChoicesItem choices;

    @BeforeEach
    public void setUp() {
        choices = new ChoicesItem();
    }

    @Test
    void setFinishReason() {
        choices.setFinishReason("Complete");
        assertEquals("Complete", choices.getFinishReason());
    }

    @Test
    void getFinishReason() {
        choices.setFinishReason("Complete");
        String reason = choices.getFinishReason();
        assertEquals("Complete", reason);
    }

    @Test
    void setIndex() {
        choices.setIndex(1);
        assertEquals(1, choices.getIndex());
    }

    @Test
    void getIndex() {
        choices.setIndex(1);
        int index = choices.getIndex();
        assertEquals(1, index);
    }

    @Test
    void setText() {
        String exampleText = "Arrive in Tokyo";
        choices.setText(exampleText);
        assertEquals(exampleText, choices.getText());
    }

    @Test
    void getText() {
        String exampleText = "Arrive in Tokyo";
        choices.setText(exampleText);
        String text = choices.getText();
        assertEquals(exampleText, text);
    }

    @Test
    void setLogprobs() {
        Object logprobs = new Object();
        choices.setLogprobs(logprobs);
        assertEquals(logprobs.hashCode(), logprobs.hashCode());
    }

    @Test
    void getLogprobs() {
        Object logprobs = new Object();
        choices.setLogprobs(logprobs);
        Object logprobsToGet = choices.getLogprobs();
        assertEquals(logprobsToGet.hashCode(), logprobs.hashCode());
    }
}