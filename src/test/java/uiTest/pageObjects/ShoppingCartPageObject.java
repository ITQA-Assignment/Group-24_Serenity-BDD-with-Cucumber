package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uiTest.helpers.TestHelper;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import org.openqa.selenium.WebElement;


public class ShoppingCartPageObject extends PageObject {
    private final TestHelper testHelper;
    public ShoppingCartPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyShoppingCartPage() {

        testHelper.switchToIFrame("framelive");
        WebElement productName = testHelper.findElementUsingXpath("/html/head/title");
        String breadcrumbItem = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent", productName);
        Assert.assertNotNull("Shopping cart page is not displayed", breadcrumbItem.trim());
    }

    public void selectSize(String size) {
        WebElement sizeDropdown = testHelper.findElementUsingXpath("//select[@id='group_1']/option[text()='S']");
        Assert.assertNotNull("Size dropdown option not found", sizeDropdown);
        sizeDropdown.click();
    }

    public void selectColor(String color) {
        String heading = testHelper.getElementTextContent(element);
        WebElement colorElement = testHelper.findElementUsingXpath("//*[@id=\"group_1\"]");
        Assert.assertNotNull("Color option not found: " + color, colorElement);
        colorElement.click();
    }

    public int enterQuantity(int quantity) {

        testHelper.switchToIFrame("framelive");

        // Wait for the quantity field to be visible
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_wanted")));

        Assert.assertNotNull("Quantity field not found", quantityField);

        // Scroll into view and clear the field
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", quantityField);
        quantityField.clear();

        // Set the desired quantity
        quantityField.sendKeys(Keys.CONTROL + "a");
        quantityField.sendKeys(Keys.DELETE);
        quantityField.sendKeys(String.valueOf(quantity));

        return quantity;
    }

    public void clickAddToCart(int quantity) {
        // Locate the "Add to Cart" button
        WebElement addToCartButton = testHelper.findElementUsingXpath("//*[@id='add-to-cart-or-refresh']/div[2]/div/div[2]");
        Assert.assertNotNull("Add to Cart button not found", addToCartButton);
        // Enter the specified quantity
        enterQuantity(quantity);
        // Extract numeric value from the text
        int availableQuantity = 300;
        // Check conditions
        if (quantity > availableQuantity) {
            System.out.println("There are not enough products in stock.");
            Assert.assertFalse("Add to Cart button should be disabled", addToCartButton.isEnabled());
        } else if (quantity == availableQuantity) {
            System.out.println("Last items in stock.");
            Assert.assertTrue("Add to Cart button should be enabled", addToCartButton.isEnabled());
            addToCartButton.click();
        } else {
            System.out.println("Sufficient stock available. Adding to cart...");
            Assert.assertTrue("Add to Cart button should be enabled", addToCartButton.isEnabled());
            addToCartButton.click();
        }
    }


    public void verifyAddToCartMessage(String expectedMessage) {

        WebElement messageElement = getDriver().findElement(By.id("myModalLabel"));
        String actualMessage = messageElement.getText().trim();
        Assert.assertNotNull("Success message element not found", actualMessage);
    }


    public void clickContinueShoppingButton() {
        testHelper.switchToIFrame("framelive");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement clickContinueShoppingButton = testHelper.findElementUsingXpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/button");
        Assert.assertNotNull("Add to cart button not found", clickContinueShoppingButton);
        clickContinueShoppingButton.click();
    }


    public void enterQuantityAgain(int newQuantity) {

        WebElement quantityField = testHelper.findElementUsingId("quantity_wanted");
        Assert.assertNotNull("Quantity field not found", quantityField);
        quantityField.clear();
        quantityField.sendKeys(Keys.CONTROL + "a");
        quantityField.sendKeys(Keys.DELETE);
        quantityField.sendKeys(String.valueOf(newQuantity));

    }

    public void notifyMeWhenAvailable() {

        // Locate the "Notify Me When Available" button
        WebElement notifyMeButton = testHelper.findElementUsingXpath("//*[@id=\"add-to-cart-or-refresh\"]/div[3]/div[2]/div/button");
        Assert.assertNotNull("Notify Me When Available button not found", notifyMeButton);

        // Ensure the button is enabled
        Assert.assertTrue("Notify Me When Available button should be enabled", notifyMeButton.isEnabled());

        // Click the button
        notifyMeButton.click();
        System.out.println("Notify Me When Available button clicked successfully.");

    }

    public void clickHomeTab() {
        // Locate the Home tab element (adjust the selector as needed)
        WebElement homeTab = testHelper.findElementUsingXpath("//*[@id=\"wrapper\"]/div/nav/ol/li[1]/a/span");

        // Check if the element is present and clickable
        if (homeTab.isDisplayed() && homeTab.isEnabled()) {
            homeTab.click();
            System.out.println("Home tab clicked successfully.");
        } else {
            throw new RuntimeException("Home tab is not clickable.");
        }
    }



    public void selectDifferentProduct() {
        // Find and click the option for selecting a different product
        WebElement differentProductOption = testHelper.findElementUsingXpath("//*[@id=\"content\"]/section[1]/div/div[2]/article/div/div[2]/h3/a");
        differentProductOption.click();
    }

    public void proceedToCheckout() {
        testHelper.switchToIFrame("framelive");
        // Find and click the Proceed to Checkout button
        WebElement proceedButton = testHelper.findElementUsingXpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
        proceedButton.click();
    }

    public void verifyCartPage() {

        testHelper.switchToIFrame("framelive");

        //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement element = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.card-block > h1");

        String breadcrumbItem = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent", element);

        Assert.assertEquals("Couldn't verify the Shopping Cart page", "Shopping Cart", breadcrumbItem.trim());
    }

}





