package com.autopractice.ui.tests;

import com.autopractice.ui.base.BaseTest;
import com.autopractice.ui.pages.HomePage;
import com.autopractice.ui.pages.SearchProductListPage;
import org.testng.annotations.Test;

public class ProductSearchNegativeTest extends BaseTest {

    SearchProductListPage searchProductListPage;
    HomePage homepage;

    @Test(testName = "Empty Search", description = "Empty Search Negative Test")
    public void emptySearchTest() {
        navigateToBaseUrl();
        homepage = new HomePage(getDriver());
        searchProductListPage = new SearchProductListPage(getDriver());

        homepage.emptySearch();
        searchProductListPage.validateErrorMessage("Please enter a search keyword");
    }

    @Test(testName = "No Results Search", description = "No Results Search Negative Test")
    public void noResultsSearchTest() {
        navigateToBaseUrl();
        homepage = new HomePage(getDriver());
        searchProductListPage = new SearchProductListPage(getDriver());

        homepage.search("No Results");
        searchProductListPage.validateErrorMessage("No results were found for your search \"No Results\"");
    }

}