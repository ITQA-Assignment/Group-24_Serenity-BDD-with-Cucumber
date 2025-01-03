package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import uiTest.helpers.TestHelper;

public class HomeAccessoriesPageObject extends PageObject {

    private final TestHelper testHelper;

    public HomeAccessoriesPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public int getInStockCount() {
        WebElement stockCountElement = testHelper.findElementUsingXpath("/html/body/main/section/div/div/div[1]/div[4]/div[2]/section[4]/ul/li[2]/label/a/span");
        String stockCountText = stockCountElement.getText();
        return Integer.parseInt(stockCountText.replaceAll("\\D", ""));
    }

    public void selectProduct(String productName) {
        WebElement productElement = testHelper.findElementUsingXpath("/html/body/main/section/div/div/div[2]/section/section/div[3]/div[1]/div[2]/article/div/div[1]/a/picture/img");
        productElement.click();
    }

    public void setQuantity(int quantity) {
        WebElement quantityField = testHelper.findElementUsingXpath("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/input");

        // Wait for the quantity field to be clickable before interacting with it
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(quantityField));

        // Clear the existing value using JavascriptExecutor to ensure it's cleared properly
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", quantityField);

        // Wait after clearing to ensure the value is cleared
        wait.until(ExpectedConditions.attributeToBe(quantityField, "value", ""));

        // Enter the new quantity
        quantityField.sendKeys(String.valueOf(quantity));
    }

    public void clickAddToCart() {
        WebElement addToCartButton = testHelper.findElementUsingXpath("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button");
        addToCartButton.click();
    }

    public void clickContinueShopping() {
        WebElement continueShoppingButton = testHelper.findElementUsingSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > button");
        continueShoppingButton.click();
    }
}
