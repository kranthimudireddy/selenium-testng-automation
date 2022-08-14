package com.autopractice.ui.pages;

import com.autopractice.ui.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchProductListPage extends BasePage {

    @FindBy(css = ".alert-warning")
    private WebElement warningMessage;

    public SearchProductListPage(WebDriver driver) {
        super(driver);
    }

    public void validateErrorMessage(String message) {
        Assert.assertEquals(warningMessage.getText(), message);
    }

}
