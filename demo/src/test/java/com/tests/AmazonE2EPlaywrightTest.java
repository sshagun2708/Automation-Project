package com.tests;

import com.base.PlaywrightBaseTest;
import com.pages.playwright.*;
import org.testng.Assert;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class AmazonE2EPlaywrightTest extends PlaywrightBaseTest {

    @Test
    public void testAmazonEndToEndFlow() {
        AmazonLoginPage loginPage = new AmazonLoginPage(page);
        AmazonHomePage homePage = new AmazonHomePage(page);
        AmazonProductListingPage listingPage = new AmazonProductListingPage(page);

        // 1. Login
        loginPage.navigateToLogin("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        loginPage.login("9501343962", "Amandeep@2790");

        // 2. Home Page Search
        homePage.searchProduct("Samsung Z Fold 8 - 5G - 256GB Storage");

        // 3. Select Product from Listing
      Page productDetailPage = page.waitForPopup(() -> {
            listingPage.clickOnProduct(); // Or listingPage.selectProduct()
        });

        // 4. Detail Page Verification (Pass the NEW page instance)
        AmazonProductDetailPage detailPage = new AmazonProductDetailPage(productDetailPage);

        Assert.assertNotNull(detailPage.getProductTitle());
        detailPage.addToCart();
    }
}