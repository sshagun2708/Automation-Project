package com.pages.playwright;

import com.microsoft.playwright.Page;
//import com.utils.LocatorUtils;
import com.utils.PropertyReader;

public class AmazonHomePage {
    private final Page page;

    private final String searchBox = PropertyReader.getPlaywrightLocator("AmazonHomePage.searchBox");
    private final String searchBtn = PropertyReader.getPlaywrightLocator("AmazonHomePage.searchBtn");

    public AmazonHomePage(Page page) {
        this.page = page;
    }

    public void searchProduct(String productName) {
        page.fill(searchBox, productName);
        page.click(searchBtn);
    }
}