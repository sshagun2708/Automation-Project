package com.pages.selenium;

import org.openqa.selenium.WebDriver;

import com.utils.LocatorUtils;

public class AmazonHomePage {
    private WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void searchProduct(String productName){
        driver.findElement(LocatorUtils.getBy("AmazonHomePage.searchBox")).clear();
        driver.findElement(LocatorUtils.getBy("AmazonHomePage.searchBox")).sendKeys(productName);
    }

        public void clickOnSearchBtn(String searchBtn){
        driver.findElement(LocatorUtils.getBy("AmazonHomePage.searchBtn")).click();
    }
}
