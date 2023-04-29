package com.aiagent.entity.openai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    Response response;

    @BeforeEach
    void setUp() {
        response = new Response();
    }

    @Test
    void setCreated() {
        response.setCreated(123);
        assertEquals(123, response.getCreated());
    }

    @Test
    void getCreated() {
        int createdId = 123;
        response.setCreated(createdId);
        assertEquals(createdId, response.getCreated());
    }

    @Test
    void setUsage() {
        Usage usage = new Usage();
        usage.setCompletionTokens(100);
        usage.setPromptTokens(30);
        usage.setTotalTokens(130);
        response.setUsage(usage);
        assertEquals(usage.hashCode(), response.getUsage().hashCode());
    }

    @Test
    void getUsage() {
        Usage usage = new Usage();
        usage.setCompletionTokens(100);
        usage.setPromptTokens(30);
        usage.setTotalTokens(130);
        response.setUsage(usage);
        Usage retrievedUsage = response.getUsage();
        assertEquals(usage.hashCode(), retrievedUsage.hashCode());
    }

    @Test
    void setModel() {
        String exampleModel = "example-model";
        response.setModel(exampleModel);
        assertEquals(exampleModel, response.getModel());
    }

    @Test
    void getModel() {
        String exampleModel = "example-model";
        response.setModel(exampleModel);
        String retrievedModel = response.getModel();
        assertEquals(exampleModel, retrievedModel);
    }

    @Test
    void setId() {
        String exampleId = "exampleId";
        response.setId(exampleId);
        assertEquals(exampleId, response.getId());
    }

    @Test
    void getId() {
        String exampleId = "exampleId";
        response.setId(exampleId);
        String retrivedExampleId = response.getId();
        assertEquals(exampleId, retrivedExampleId);
    }

    @Test
    void setChoices() {
        List<ChoicesItem> choices = new ArrayList<ChoicesItem>();
        response.setChoices(choices);
        assertNotNull(response.getChoices());
    }

    @Test
    void getChoices() {
        List<ChoicesItem> choices = new ArrayList<ChoicesItem>();
        response.setChoices(choices);
        List<ChoicesItem> retrievedChoices = response.getChoices();
        assertEquals(choices.size(), retrievedChoices.size());
    }

    @Test
    void setObject() {
        String object = "example-mode";
        response.setObject(object);
        assertEquals(object, response.getObject());
    }

    @Test
    void getObject() {
        String object = "example-mode";
        response.setObject(object);
        String retrievedObject = response.getObject();
        assertEquals(object, retrievedObject);
    }
}