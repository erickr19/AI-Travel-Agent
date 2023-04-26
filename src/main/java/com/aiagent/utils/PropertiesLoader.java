package com.aiagent.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * This interface contains a default method that can
 * can be used anywhere a Properties object is needed to be loaded.
 * @author Eric Knapp
 */
public interface PropertiesLoader {

    // logger
    Logger LOGGER = LogManager.getLogger(PropertiesLoader.class);

    /**
     * This default method will load a properties file into a Properties instance
     * and return it.
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance
     * if the file path was not found.
     */
    default Properties loadProperties(String propertiesFilePath) {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException iOException) {
            LOGGER.error("Failed to load properties file: " + iOException);
        } catch (Exception exception) {
            LOGGER.error("Failed to load properties file | General exception: " + exception);
        }
        return properties;
    }
}
