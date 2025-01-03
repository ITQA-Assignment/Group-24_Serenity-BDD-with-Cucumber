package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

public class ShoppingCartPageObject extends PageObject {
    private final TestHelper testHelper;
    public ShoppingCartPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyShoppingCartPage(){
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.card-block > h1");

        String heading = testHelper.getElementTextContent(element);

        Assert.assertEquals("Couldn't verify the Shopping Cart page", "Shopping Cart", heading.trim());
    }

    public void clickProceedToCheckout(){

        WebElement element = testHelper.findElementUsingSelector("#main > div > div.cart-grid-right.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.js-cart-detailed-actions.card-block > div > a");
        element.click();
    }

}
