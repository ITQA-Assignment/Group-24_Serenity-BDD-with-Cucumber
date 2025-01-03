package uiTest.pageObjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderConfirmationPageObject extends PageObject {
    private final TestHelper testHelper;
    private static String orderReference;
    private static final List<String> orderedItemList = new ArrayList<>();

    public OrderConfirmationPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyOrderConfirmationPage(){
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingSelector("#wrapper > div > nav > ol > li:nth-child(2) > span");

        String breadcrumbItem = testHelper.getElementTextContent(element);

        Assert.assertEquals("Couldn't verify the Order Confirmation Page", "Order confirmation", breadcrumbItem.trim());
    }

    public void seeTheOrderReferenceAndOrderedItems() {
        WebElement element = testHelper.findElementUsingId("order-reference-value");
        String orderRef = testHelper.getElementTextContent(element);
        orderReference = orderRef.split(":")[1].trim();

        List<WebElement> orderedItemElements = getDriver().findElements(By.cssSelector(".order-line .details span"));
        List<WebElement> quantityElements = getDriver().findElements(By.cssSelector(".order-line .qty .row .col-xs-4:nth-child(2)"));

        for (int i = 0; i < orderedItemElements.size(); i++) {
            String productName = orderedItemElements.get(i).getText();
            String quantity = quantityElements.get(i).getText();
            orderedItemList.add(productName + " x" + quantity);
        }
    }

    public static String getOrderReferencce() {
        return orderReference;
    }

    public static List<String> getOrderedItemList() {
        return orderedItemList;
    }


}
