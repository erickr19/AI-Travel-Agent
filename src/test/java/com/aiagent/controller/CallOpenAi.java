package com.aiagent.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import testUtils.PropertiesLoader;

import java.io.IOException;


public class CallOpenAi implements PropertiesLoader {
    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());
    OpenAi ai = new OpenAi();

    @Test
    void openAIAPITest() throws IOException {
        ai.callApi("Plan a day trip to Paris, France");
    }
}
