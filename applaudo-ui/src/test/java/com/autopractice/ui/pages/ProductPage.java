package com.autopractice.ui.pages;

import com.autopractice.ui.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductPage extends BasePage {

    @FindBy(css = "[id='bigpic']")
    private WebElement productItemImage;

    @FindBy(css = "[itemprop='name']")
    private WebElement productItemName;

    @FindBy(css = "button.exclusive")
    private WebElement addtoCartButton;

    @FindBy(xpath = "//*[@class='icon-ok']/..")
    private WebElement addtoCartMessage;

    @FindBy(css = "[title='Close window']")
    private WebElement closeWindowButton;

    @FindBy(css = ".product-image-container .layer_cart_img")
    private WebElement productCartImage;

    @FindBy(css = "#layer_cart_product_title")
    private WebElement productCartName;

    @FindBy(css = "[title='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(css = "[title='View my shopping cart']")
    private WebElement viewShoppingCart;

    @FindBy(css = ".ajax_cart_block_remove_link")
    private WebElement removefromShoppingCart;

    @FindBy(css = ".cart_block_no_products[style='display: block;']")
    private WebElement noProductsinBlock;

    @FindBy(css = ".ajax_cart_no_product[style='display: inline-block;']")
    private WebElement noProductsinCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void VerifyProductSearch(String productName) {
        Assert.assertEquals(productItemImage.getAttribute("title"), productName);
        Assert.assertEquals(productItemName.getText(), productName);
        logger.info("Product Search is Successful");
    }

    public void addProducttoCart() {
        Assert.assertTrue(addtoCartButton.isDisplayed());
        addtoCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(addtoCartMessage));
        Assert.assertEquals(addtoCartMessage.getText(), "Product successfully added to your shopping cart");
    }

    public void verifyProductaddedtoCart(String productName) {
        Assert.assertEquals(productCartImage.getAttribute("title"), productName);
        Assert.assertEquals(productCartName.getText(), productName);
        logger.info("Product added to cart successfully");
    }

    public void closeAddtoCartPopup() {
        wait.until(ExpectedConditions.visibilityOf(closeWindowButton));
        closeWindowButton.click();
    }

    public void continueShopping() {
        wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
        continueShoppingButton.click();
    }

    public void removeItemfromcart() {
        wait.until(ExpectedConditions.visibilityOf(viewShoppingCart));
        Actions action = new Actions(driver);
        action.moveToElement(viewShoppingCart).perform();
        wait.until(ExpectedConditions.visibilityOf(removefromShoppingCart));
        removefromShoppingCart.click();
    }

    public void verifyProductRemovedfromCart() {
        wait.until(ExpectedConditions.visibilityOf(noProductsinCart));
        Assert.assertTrue(noProductsinCart.isDisplayed());
        logger.info("Product Removed from cart successfully");
    }

}
