package com.autopractice.ui.pages;

import com.autopractice.ui.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "#search_query_top")
    private WebElement searchQueryInput;

    @FindBy(css = ".ac_results > ul > li")
    private List<WebElement> autoSearchResults;

    @FindBy(css = "[name='submit_search']")
    private WebElement sumbitButton;

    @FindBy(css = ".product_list > li")
    private List<WebElement> productList;

    @FindBy(css = "#block_contact_infos")
    private List<WebElement> contactInfo;

    @FindBy(xpath = "//*[@class='icon-map-marker']/..")
    private WebElement address;

    @FindBy(xpath = "//*[@class='icon-phone']/following-sibling::span")
    private WebElement phone;

    @FindBy(xpath = "//*[@class='icon-envelope-alt']/following-sibling::span")
    private WebElement email;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void emptySearch() {
        wait.until(ExpectedConditions.visibilityOf(sumbitButton));
        sumbitButton.click();
    }

    public void search(String searchTerm) {
        wait.until(ExpectedConditions.visibilityOf(searchQueryInput));
        searchQueryInput.sendKeys(searchTerm);
        sumbitButton.click();
    }

    public void searchAndGo(String searchTerm) {
        searchQueryInput.sendKeys(searchTerm + Keys.DOWN);
        wait.until(ExpectedConditions.visibilityOf(autoSearchResults.get(0)));
        autoSearchResults.get(0).click();
    }

    public void scrolltoContactInfo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void retrieveStoreAddress() {
        wait.until(ExpectedConditions.visibilityOf(address));
        logger.info("Address " + address.getText());
        logger.info("Phone Number " + phone.getText());
        logger.info("Email " + email.getText());
    }

    public void validateStoreAddress() {
        Assert.assertEquals(address.getText(), "Selenium Framework, Research Triangle Park, North Carolina, USA");
        Assert.assertEquals(phone.getText(), "(347) 466-7432");
        Assert.assertEquals(email.getText(), "support@seleniumframework.com");
    }
}
