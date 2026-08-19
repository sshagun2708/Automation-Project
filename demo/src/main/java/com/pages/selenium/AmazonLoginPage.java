package com.pages.selenium;

import org.openqa.selenium.WebDriver;
import com.utils.LocatorUtils;

public class AmazonLoginPage {
    private WebDriver driver;

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(LocatorUtils.getBy("AmazonLoginPage.emailInput")).clear();
        driver.findElement(LocatorUtils.getBy("AmazonLoginPage.emailInput")).sendKeys(mobileNumber);
    }

    public void clickContinueBtn() {
        driver.findElement(LocatorUtils.getBy("AmazonLoginPage.continueButton")).click();
    }

    public void enterPassword(String password) {
        driver.findElement(LocatorUtils.getBy("AmazonLoginPage.passwordInput")).clear();
        driver.findElement(LocatorUtils.getBy("AmazonLoginPage.passwordInput")).sendKeys(password);
    }

    public void clickSignInBtn() {
        driver.findElement(LocatorUtils.getBy("AmazonLoginPage.signInSubmitButton")).click();
    }

    public void performFullLogin(String mobileNumber, String password) {
        enterMobileNumber(mobileNumber);
        clickContinueBtn();
        enterPassword(password);
        clickSignInBtn();
    }
}