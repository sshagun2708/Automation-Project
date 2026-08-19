package com.pages.playwright;

import com.microsoft.playwright.Page;
import com.utils.PropertyReader;

public class AmazonProductListingPage {
    private final Page page;

    private final String productLink = PropertyReader.getPlaywrightLocator("AmazonProductListingPage.productLink");

    public AmazonProductListingPage(Page page) {
        this.page = page;
    }

    public void clickOnProduct() {
        page.click(productLink);
    }
}