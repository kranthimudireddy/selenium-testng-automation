package com.autopractice.ui.tests;

import com.autopractice.ui.base.BaseTest;
import com.autopractice.ui.pages.HomePage;
import com.autopractice.ui.pages.ProductPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    HomePage homepage;
    ProductPage productPage;

    @Parameters("productName")
    @Test(testName = "Search Item", priority = 1)
    public void searchTest(String productName) {
        logger.info("Searching for the product");
        navigateToBaseUrl();
        homepage = new HomePage(getDriver());
        productPage = new ProductPage(getDriver());

        homepage.searchAndGo(productName);
        productPage.VerifyProductSearch(productName);
    }

    @Parameters("productName")
    @Test(testName = "Add to Cart", description = "Add item to shopping cart", priority = 2)
    public void addtoCartTest(String productName) {
        logger.info("Adding item to shopping cart");
        homepage = new HomePage(getDriver());
        productPage = new ProductPage(getDriver());

        productPage.addProducttoCart();
        productPage.verifyProductaddedtoCart(productName);
        productPage.closeAddtoCartPopup();
    }

    @Test(testName = "Remove from Cart", description = "Remove item inside shopping cart", priority = 3)
    public void removefromCartTest() {
        logger.info("Removing item to shopping cart");
        productPage.removeItemfromcart();
        productPage.verifyProductRemovedfromCart();
    }

}
