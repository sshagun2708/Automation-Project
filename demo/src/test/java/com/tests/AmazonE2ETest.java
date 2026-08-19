package com.tests;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.selenium.AmazonHomePage;
import com.pages.selenium.AmazonLoginPage;
import com.pages.selenium.AmazonProductDetailPage;
import com.pages.selenium.AmazonProductListingPage;
import com.utils.ElementUtils;

public class AmazonE2ETest extends BaseTest {

    @Test(description = "Verify End to End Amazon Flow: Login -> Search -> Product Selection -> Add to Cart -> Cart Verification")
   public void verifyAmazonE2EFlow() throws InterruptedException {
        
        // Test Data
        String mobileNumber = "9501343962";
        String password = "Amandeep@2790";
        String searchProduct = "Samsung Z Fold 8 - 5G - 256GB Storage";

        // Step 1: Login
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);
        loginPage.performFullLogin(mobileNumber, password);

        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.searchProduct(searchProduct);
        homePage.clickOnSearchBtn("AmazonHomePage.searchBtn");

        AmazonProductListingPage productListingPage = new AmazonProductListingPage(driver);
        productListingPage.scrollDownSearchResults();
        // 🔑 STEP A: Store the Main Tab ID BEFORE clicking the product
        String mainTabHandle = driver.getWindowHandle();
        productListingPage.clickOnProduct();

        // 4. Product Detail Page Actions
        AmazonProductDetailPage productDetailPage = new AmazonProductDetailPage(driver);
        // 🔑 STEP C: Switch focus to the new product tab!
        productDetailPage.switchToProductTab(mainTabHandle);
        String productTitle = productDetailPage.getProductTitle();
        String productPrice = productDetailPage.getProductPrice();
        productDetailPage.scrollDownSearchResults();
        productDetailPage.addToCart();
        String cartConfirmationMessage = productDetailPage.addToCart();
        }
}
