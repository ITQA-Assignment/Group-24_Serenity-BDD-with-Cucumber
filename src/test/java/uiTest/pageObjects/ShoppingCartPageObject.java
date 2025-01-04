package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiTest.helpers.TestHelper;
import org.junit.Assert;
import java.time.Duration;

public class ShoppingCartPageObject extends PageObject {
    private final TestHelper testHelper;

    public ShoppingCartPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyShoppingCartPage() {
        testHelper.switchToIFrame("framelive");
        WebElement pageTitle = testHelper.findElementUsingXpath("//*[@id=\"wrapper\"]/div/nav/ol/li[4]/span");
        Assert.assertNotNull("Shopping cart page is not displayed", pageTitle);
    }

    public void clickProceedToCheckout() {
        testHelper.switchToIFrame("framelive");
        WebElement proceedButton = testHelper.findElementUsingSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a");
        Assert.assertNotNull("Proceed to Checkout button not found", proceedButton);
        proceedButton.click();
    }

    public void enterQuantity(int quantity) {
        testHelper.switchToIFrame("framelive");
        WebElement quantityField = testHelper.findElementUsingId("quantity_wanted");
        Assert.assertNotNull("Quantity field not found", quantityField);

        // Small delay to ensure the field is cleared
        try {
            Thread.sleep(200); // 200ms delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
    }

    public void clickAddToCart(int quantity) {
        WebElement addToCartButton = testHelper.findElementUsingXpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]");
        Assert.assertNotNull("Add to Cart button not found", addToCartButton);

        int availableQuantity = 300; // Replace with dynamic check if possible

        if (quantity > availableQuantity) {
            System.out.println("There are not enough products in stock.");
            Assert.assertFalse("Add to Cart button should be disabled", addToCartButton.isEnabled());
        } else {
            Assert.assertTrue("Add to Cart button should be enabled", addToCartButton.isEnabled());
            addToCartButton.click();
        }
    }


    public void clickContinueShopping() {
        testHelper.switchToIFrame("framelive");
        WebElement continueShopping = testHelper.findElementUsingXpath("//*[@id=\"main\"]/div/div[1]/a");
        Assert.assertNotNull("Continue Shopping button not found", continueShopping);
        continueShopping.click();
    }

    public void clickCartIcon(){
        testHelper.switchToIFrame("framelive");
        WebElement clickCartIcon=testHelper.findElementUsingSelector("#_mobile_cart > div > div > a");
        clickCartIcon.click();
    }

    public void verifyCartPage() {
        testHelper.switchToIFrame("framelive");
        WebElement cartHeader = testHelper.findElementUsingXpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
        Assert.assertNotNull("Shopping Cart page not displayed", cartHeader);
    }
    public void verifyPriceWithQuantity() {

        testHelper.switchToIFrame("framelive");

        // Locate the price element (adjust the selector as needed)
        WebElement priceElement = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-body.col-md-4.col-xs-8 > div.product-line-info.product-price.h5 > div > span");
        String priceText = priceElement.getText().trim();

        // Check if price text is valid
        if (priceText.isEmpty()) {
            throw new RuntimeException("Price text is empty. Cannot calculate total.");
        }

        double price = extractPrice(priceText); // Extract price from the text (handle currency symbols)

        // Locate the quantity element and extract the quantity as an integer
        //WebElement quantityElement = testHelper.findElementUsingSelector("div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-6.qty > div > input");
        //String quantityText = quantityElement.getText().trim();

        // Parse the quantity as an integer
        int quantity = 300;

        // Calculate the expected total price
        double expectedTotal = price * quantity;
        expectedTotal = roundToTwoDecimalPlaces(expectedTotal);

        // Locate the total price displayed on the page (adjust the selector as needed)
        WebElement totalElement = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-2.price > span > strong");
        String totalText = totalElement.getText().trim();

        // Check if total text is valid
        if (totalText.isEmpty()) {
            throw new RuntimeException("Total price text is empty. Cannot verify total.");
        }

        double displayedTotal = extractPrice(totalText);
        displayedTotal = roundToTwoDecimalPlaces(displayedTotal);

        // Assert the calculated total is equal to the displayed total
        Assert.assertEquals("The calculated total does not match the displayed total.",
                expectedTotal, displayedTotal, 0.02); // 0.02 tolerance for floating point comparison

        System.out.println("Total price validation successful. Calculated: " + expectedTotal + ", Displayed: " + displayedTotal);

    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public double extractPrice(String priceText) {
        // Remove currency symbols and parse as double
        priceText = priceText.replaceAll("[^\\d.]", "");  // Handle decimal points
        if (priceText.isEmpty()) {
            throw new RuntimeException("Invalid price value: " + priceText);
        }
        return Double.parseDouble(priceText);
    }

    public void checkTotalPriceOfAllItems() {

        try {
            // Locate the price elements for the items
            WebElement item1 = testHelper.findElementUsingSelector(
                    "#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li:nth-child(1) > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-2.price > span > strong"
            );
            WebElement item2 = testHelper.findElementUsingSelector(
                    "#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li:nth-child(2) > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-2.price > span > strong"
            );

            // Extract prices from the elements
            String item1PriceText = item1.getText().trim();
            String item2PriceText = item2.getText().trim();

            // Convert the prices to integers/doubles using testHelper.priceExtractor()
            double item1Price = extractPrice(item1PriceText);
            double item2Price = extractPrice(item2PriceText);

            // Calculate the total price
            double calculatedTotal = item1Price + item2Price;

            // Locate the displayed total price element
            WebElement totalElement = testHelper.findElementUsingSelector(
                    "#main > div > div.cart-grid-right.col-lg-4 > div.card.cart-summary > div.cart-detailed-totals.js-cart-detailed-totals > div.card-block.cart-summary-totals.js-cart-summary-totals > div > span.value"
            );

            // Extract and convert the displayed total price
            String totalText = totalElement.getText().trim();
            double displayedTotal = extractPrice(totalText);

            // Assert that the calculated total matches the displayed total
            Assert.assertEquals("The calculated total does not match the displayed total.",
                    calculatedTotal, displayedTotal, 0.02); // Allow small tolerance for rounding issues


            System.out.println("Total price validation successful. Calculated: " + calculatedTotal + ", Displayed: " + displayedTotal);
        } catch (Exception e) {
            System.out.println("An error occurred while validating the total price: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw the exception to fail the test
        }
    }


    public void clickIncreaseButton() {

        int quantity=500;
        // Switch to iframe
        testHelper.switchToIFrame("framelive");

        // Locate quantity input field
        WebElement quantityInput = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-6.qty > div > input");
        Assert.assertNotNull("Quantity input field not found", quantityInput);

        // Enter the quantity
        quantityInput.clear();
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
        quantityInput.sendKeys(Keys.ENTER);

    }

    public void deleteItem(){

        testHelper.switchToIFrame("framelive");
        WebElement deleteItem = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li:nth-child(2) > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-2.col-xs-2.text-xs-right > div > a > i");
        deleteItem.click();
    }

    public void makeQuantityZero(){

        int quantity=0;

        testHelper.switchToIFrame("framelive");

        WebElement makeQuantityZero = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-6.qty > div > input");
        Assert.assertNotNull("Quantity input field not found", makeQuantityZero);

        // Enter the quantity
        makeQuantityZero.clear();
        makeQuantityZero.sendKeys(String.valueOf(quantity));
        makeQuantityZero.sendKeys(Keys.ENTER);
        makeQuantityZero.sendKeys(Keys.ENTER);
    }




}
