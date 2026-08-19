package com.pages.playwright;

import com.microsoft.playwright.Page;
import com.utils.PropertyReader;

public class AmazonProductDetailPage {
    private final Page page;

    // 1. Fetching product title locator
    private final String productTitle = PropertyReader.getPlaywrightLocator("AmazonProductDetailPage.productTitle");
    
    // 2. Fetching the new dedicated Playwright property key from locators.properties
    private final String addToCartBtn = PropertyReader.getPlaywrightLocator("AmazonProductDetailPage.addToCartBtnPlaywright");

    public AmazonProductDetailPage(Page page) {
        this.page = page;
    }

    public String getProductTitle() {
        return page.textContent(productTitle);
    }

    public void addToCart() {
        // Dispatches the click event using the 'addToCartBtn' variable
        page.dispatchEvent(addToCartBtn, "click");
    }
}