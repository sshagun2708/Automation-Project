package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;

public class LocatorUtils {

    private static Properties properties = new Properties();

    // Load the locators.properties file when the class is loaded
    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/locators.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR: Could not find or load locators.properties at 'src/main/resources/locators.properties'!");
        }
    }

    /**
     * Reads a key from locators.properties and converts it into a Selenium By object.
     * 
     * @param key The key defined in locators.properties (e.g. "AmazonLoginPage.emailInput")
     * @return Selenium By locator object
     */
    public static By getBy(String key) {
        String locatorValue = properties.getProperty(key);

        // 1. Guard against missing or empty keys in locators.properties
        if (locatorValue == null || locatorValue.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Locator key '" + key + "' was NOT FOUND in locators.properties! " +
                "Please verify spelling or check if the key exists in the file."
            );
        }

        // 2. Guard against missing colon ':' separator
        if (!locatorValue.contains(":")) {
            throw new IllegalArgumentException(
                "Invalid format for locator key '" + key + "': '" + locatorValue + "'. " +
                "Expected format is 'type:value' (e.g., id:ap_email or xpath://button)"
            );
        }

        // Split into [locator_type, locator_expression]
        String[] parts = locatorValue.split(":", 2);
        String locatorType = parts[0].trim();
        String expression = parts[1].trim();

        // Convert to Selenium By locator
        switch (locatorType.toLowerCase()) {
            case "id":
                return By.id(expression);
            case "name":
                return By.name(expression);
            case "xpath":
                return By.xpath(expression);
            case "css":
                return By.cssSelector(expression);
            case "class":
            case "classname":
                return By.className(expression);
            default:
                throw new IllegalArgumentException(
                    "Unsupported locator type '" + locatorType + "' for key: " + key + 
                    ". Supported types: id, name, xpath, css, class"
                );
        }
    }
}