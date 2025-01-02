package uiTest.pageObjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import uiTest.helpers.PageNavigator;
import uiTest.helpers.TestHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderConfirmationPageObject extends PageObject {
    private TestHelper testHelper;
    private static String orderReference;
    private static  List<String> orderedItemList;

    public OrderConfirmationPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyOrderConfirmationPage(){
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingSelector("#wrapper > div > nav > ol > li:nth-child(2) > span");

        String breadcrumbItem = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent", element);

        Assert.assertEquals("Couldn't verify the Order Confirmation Page", "Order confirmation", breadcrumbItem.trim());
    }

    public void seeTheOrderReferenceAndOrderedItems(){
        WebElement element = testHelper.findElementUsingId("order-reference-value");
        String orderRef = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent.trim()", element);
        this.orderReference = orderRef.split(":")[1].trim();

        List<WebElement> orderedItemElements  = getDriver().findElements(By.cssSelector(".order-line .details span"));
        orderedItemList = orderedItemElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public static String getOrderReferencce() {
        return orderReference;
    }

    public static List<String> getOrderedItemList() {
        return orderedItemList;
    }


}
