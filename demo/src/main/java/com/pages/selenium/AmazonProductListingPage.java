package com.pages.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.utils.ElementUtils;
import com.utils.LocatorUtils;

public class AmazonProductListingPage {
      private WebDriver driver;

      public AmazonProductListingPage(WebDriver driver){
        this.driver = driver;
      }

      // Example 1: Scroll down by 500 pixels
    public void scrollDownSearchResults() {
        ElementUtils.scrollByPixels(driver, 500);
        // Returns single ID string: "Handle-101"
        String mainTabID = driver.getWindowHandle(); 

    }

      public void clickOnProduct(){
        ElementUtils.scrollToElement(driver, LocatorUtils.getBy("AmazonProductListingPage.productLink"));
        driver.findElement(LocatorUtils.getBy("AmazonProductListingPage.productLink")).click();
      }
     
}
