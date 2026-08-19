package com.pages.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.ElementUtils;
import com.utils.LocatorUtils;

public class AmazonProductDetailPage {
    private WebDriver driver;

    public AmazonProductDetailPage(WebDriver driver){
        this.driver = driver;
    }

   /**
     * Call this first to switch WebDriver focus to this product tab!
     */
    public void switchToProductTab(String mainTabHandle) {
        ElementUtils.switchToNewTab(driver, mainTabHandle);
    }

    /**
     * Safely gets and trims the product title.
     */
    public String getProductTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By titleLocator = LocatorUtils.getBy("AmazonProductDetailPage.productTitle");
        
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        String fullTitle = titleElement.getText();
        String shortTitle = fullTitle.split("-")[0].trim();
       System.out.println(shortTitle); 
      // Output: "Samsung Galaxy Z Fold8 Ultra 5G"
        return driver.findElement(LocatorUtils.getBy("AmazonProductDetailPage.productTitle")).getText();
    }


    public String getProductPrice(){
        return driver.findElement(LocatorUtils.getBy("AmazonProductDetailPage.productPrice")).getText();
    }

        public void scrollDownSearchResults() {
        ElementUtils.scrollByPixels(driver, 500);
    }

    public String addToCart(){

     WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        By addToCart = LocatorUtils.getBy("AmazonProductDetailPage.addToCartBtn");
        
        WebElement hiddenElement = wait1.until(ExpectedConditions.presenceOfElementLocated(addToCart));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", hiddenElement);
   
        return driver.findElement(LocatorUtils.getBy("AmazonProductDetailPage.cartConfirmationMessage")).getText();       
    }
    
}
