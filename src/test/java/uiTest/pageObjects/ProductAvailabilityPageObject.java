package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uiTest.helpers.TestHelper;
import org.junit.Assert;

import java.time.Duration;


public class ProductAvailabilityPageObject extends PageObject {

    private static final Logger log = LoggerFactory.getLogger(ProductAvailabilityPageObject.class);
    private final TestHelper testHelper;


    public ProductAvailabilityPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
        ShoppingCartPageObject shoppingCartPage = new ShoppingCartPageObject();
    }

    public void verifyCartPage() {

        testHelper.switchToIFrame("framelive");

        //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement element = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.card-block > h1");

        String breadcrumbItem = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent", element);

        Assert.assertEquals("Couldn't verify the Shopping Cart page", "Shopping Cart", breadcrumbItem.trim());
    }


    public void verifyPriceWithQuantity() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        try {
            testHelper.switchToIFrame("framelive");

            // Locate the price element (adjust the selector as needed)
            WebElement priceElement = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-body.col-md-4.col-xs-8 > div.product-line-info.product-price.h5.has-discount > div.current-price > span");
            String priceText = priceElement.getText().trim();

            // Check if price text is valid
            if (priceText.isEmpty()) {
                throw new RuntimeException("Price text is empty. Cannot calculate total.");
            }

            double price = extractPrice(priceText); // Extract price from the text (handle currency symbols)


            double quantity = 300;

            // Calculate the expected total price
            double expectedTotal = price * quantity;
            expectedTotal = roundToTwoDecimalPlaces(expectedTotal);

            // Locate the total price displayed on the page (adjust the selector as needed)
            WebElement totalElement = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li:nth-child(1) > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-2.price > span > strong");
            String totalText = totalElement.getText().trim();

            // Check if total text is valid
            if (totalText.isEmpty()) {
                throw new RuntimeException("Total price text is empty. Cannot verify total.");
            }

            double displayedTotal = extractPrice(totalText);
            displayedTotal = roundToTwoDecimalPlaces(displayedTotal);

            // Assert the calculated total is equal to the displayed total
            Assert.assertEquals("The calculated total does not match the displayed total.",
                    expectedTotal, displayedTotal, 0.02); // 0.01 tolerance for floating point comparison

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw the exception to fail the test
        }
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }


    private int extractPrice(String priceText) {
        // Remove currency symbols and parse as integer
        priceText = priceText.replaceAll("[^\\d]", "");
        if (priceText.isEmpty()) {
            throw new RuntimeException("Invalid price value: " + priceText);
        }
        return Integer.parseInt(priceText);

    }



    public double priceExtractor(String priceText) {
        try {
            // Remove commas and non-numeric characters except for the decimal point
            String sanitizedPrice = priceText.replaceAll("[^\\d.]", "");
            if (sanitizedPrice.isEmpty()) {
                throw new RuntimeException("Invalid price value: " + priceText);
            }
            // Parse the sanitized string to a double
            return Double.parseDouble(sanitizedPrice);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Failed to parse price: " + priceText, e);
        }
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
            double item1Price = priceExtractor(item1PriceText);
            double item2Price = priceExtractor(item2PriceText);

            // Calculate the total price
            double calculatedTotal = item1Price + item2Price;

            // Locate the displayed total price element
            WebElement totalElement = testHelper.findElementUsingSelector(
                    "#main > div > div.cart-grid-right.col-lg-4 > div.card.cart-summary > div.cart-detailed-totals.js-cart-detailed-totals > div.card-block.cart-summary-totals.js-cart-summary-totals > div > span.value"
            );

            // Extract and convert the displayed total price
            String totalText = totalElement.getText().trim();
            double displayedTotal = priceExtractor(totalText);

            // Assert that the calculated total matches the displayed total
            Assert.assertEquals("The calculated total does not match the displayed total.",
                    calculatedTotal, displayedTotal, 0.02); // Allow small tolerance for rounding issues

            System.out.println("Before success message");
            System.out.println("Total price validation successful. Calculated: " + calculatedTotal + ", Displayed: " + displayedTotal);
            log.info("After success message");
        } catch (Exception e) {
            System.out.println("An error occurred while validating the total price: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw the exception to fail the test
        }
    }

    public void clickDeleteButton() {
        testHelper.switchToIFrame("framelive");
        WebElement deleteButton = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li:nth-child(2) > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-2.col-xs-2.text-xs-right > div > a > i");
        Assert.assertTrue("Delete button is not displayed", deleteButton.isDisplayed());
        deleteButton.click();
    }


}
