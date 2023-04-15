package com.aiagent.controller;

import com.aiagent.entity.openai.RequestBody;
import com.aiagent.entity.openai.Response;
import com.aiagent.utils.PropertiesLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class OpenAi implements PropertiesLoader {
    // logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Calls OpenAI API through HttpRequest
     * @param userPrompt the prompt the AI will use to create the itinerary
     * @return text of generated itinerary
     * @throws IOException if there is an error reading/writing JSON with Jackson
     */
    private String callApi(String userPrompt) throws IOException {
        // instantiate mapper
        ObjectMapper mapper = new ObjectMapper();

        // instantiate default request body with userPrompt
        RequestBody requestBodyEntity = new RequestBody(userPrompt);

        // parse request body entity to request string format and log
        String requestBody = mapper.writeValueAsString(requestBodyEntity);
        logger.info("Request body in string format: " + requestBody);

        // get properties
        Properties aiProperties = loadProperties("/openai-api.properties");
        String key = aiProperties.getProperty("apiKey");

        // build request with uri, two headers, and method with parsed request body
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(aiProperties.getProperty("completionsUri")))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + key)
                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // try to POST request
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            logger.error("Error sending request, I/O Error: " + e);
        } catch (InterruptedException e) {
            logger.error("Error sending request, Interrupted: " + e);
        }

        // map to entity
        Response aiResponse = mapper.readValue(response.body(), Response.class);

        // log and return
        logger.info("Itinerary Response Test: " + aiResponse.getChoices().get(0).getText());
        return aiResponse.getChoices().get(0).getText();
    }
}
