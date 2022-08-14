package com.autopractice.ui.tests;

import com.autopractice.ui.base.BaseTest;
import com.autopractice.ui.pages.HomePage;
import org.testng.annotations.Test;

public class ValidateStoreInformationTest extends BaseTest {

    @Test(testName = "Validate Store Information")
    public void validateStoreinfoTest() {
        navigateToBaseUrl();
        HomePage homepage = new HomePage(getDriver());
        homepage.scrolltoContactInfo();
        homepage.retrieveStoreAddress();
        homepage.validateStoreAddress();
    }

}
