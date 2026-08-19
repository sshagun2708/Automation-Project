package com.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("locators.properties")) {
            if (input == null) {
                System.err.println("❌ Unable to find locators.properties in src/main/resources/");
            } else {
                properties.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the raw property value from locators.properties
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("⚠️ Warning: Property key '" + key + "' was NOT found in locators.properties!");
        }
        return value;
    }

    /**
     * Converts Selenium-formatted locators (id:..., xpath:..., css:...) 
     * into clean, Playwright-compatible selector strings.
     */
    public static String getPlaywrightLocator(String key) {
        String rawLocator = getProperty(key);

        if (rawLocator == null) {
            return null;
        }

        // Clean up whitespace around the locator
        rawLocator = rawLocator.trim();

        // Convert 'id:ap_email' -> '#ap_email' (CSS ID selector)
        if (rawLocator.startsWith("id:")) {
            return "#" + rawLocator.substring(3).trim();
        }

        // Convert 'xpath://...' -> '//...'
        if (rawLocator.startsWith("xpath:")) {
            return rawLocator.substring(6).trim();
        }

        // Convert 'css:...' -> '...'
        if (rawLocator.startsWith("css:")) {
            return rawLocator.substring(4).trim();
        }

        // Return as-is if no prefix is matched
        return rawLocator;
    }
}