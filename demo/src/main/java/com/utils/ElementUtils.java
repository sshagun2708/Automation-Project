package com.utils;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.microsoft.playwright.Page;

public class ElementUtils {


 //   =============================================================
    //Scroll down
 //   =============================================================
    /**
     * Scrolls down the browser window by a specified pixel amount.
     * 
     * @param driver The active WebDriver instance
     * @param pixels The number of pixels to scroll down (e.g., 500)
     */
    public static void scrollByPixels(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ");");
    }

    /**
     * Scrolls the browser window directly until a specific element is in view.
     * 
     * @param driver  The active WebDriver instance
     * @param locator The By locator of the element to scroll to
     */
    public static void scrollToElement(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls directly to the very bottom of the page.
     * 
     * @param driver The active WebDriver instance
     */
    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

  //  =======================================================================
    //Switch to the main window.
   // =======================================================================

    // ... (Your existing scroll methods remain here) ...

    /**
     * Switches WebDriver focus to the newly opened browser tab.
     * 
     * @param driver              The active WebDriver instance
     * @param originalWindowHandle The window handle ID of the main/original tab
     */
    public static void switchToNewTab(WebDriver driver, String originalWindowHandle) {
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static Page switchToNewTab(Page currentPage, Runnable action) {
        return currentPage.waitForPopup(() -> {
            action.run();
        });
    }


    /**
     * Closes the current active tab and switches focus back to the original main tab.
     * 
     * @param driver              The active WebDriver instance
     * @param originalWindowHandle The window handle ID of the main/original tab
     */
    public static void closeAndSwitchToOriginalTab(WebDriver driver, String originalWindowHandle) {
        driver.close(); // Closes current tab
        driver.switchTo().window(originalWindowHandle); // Focuses back on main tab
    }
}
