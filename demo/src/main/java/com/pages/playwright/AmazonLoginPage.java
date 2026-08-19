package com.pages.playwright;

import com.microsoft.playwright.Page;
import com.utils.PropertyReader;

public class AmazonLoginPage {
    private final Page page;

    // Automatically fetches from properties AND converts id: or xpath: for Playwright!
    private final String emailInput = PropertyReader.getPlaywrightLocator("AmazonLoginPage.emailInput");
    private final String continueBtn = PropertyReader.getPlaywrightLocator("AmazonLoginPage.continueButton");
    private final String passwordInput = PropertyReader.getPlaywrightLocator("AmazonLoginPage.passwordInput");
    private final String signInSubmitBtn = PropertyReader.getPlaywrightLocator("AmazonLoginPage.signInSubmitButton");

    public AmazonLoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLogin(String url) {
        page.navigate(url);
    }

    public void login(String email, String password) {
        page.fill(emailInput, email);
        page.click(continueBtn);
        page.fill(passwordInput, password);
        page.click(signInSubmitBtn);
    }
}