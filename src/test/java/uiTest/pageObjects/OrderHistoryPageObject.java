package uiTest.pageObjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistoryPageObject extends PageObject {
    private final TestHelper testHelper;

    public OrderHistoryPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyOrderHistoryPage(){
        WebElement element = testHelper.findElementUsingSelector("#main > header > h1");
        String header = testHelper.getElementTextContent(element);

        Assert.assertEquals("Couldn't verify the Order History Page", "Order history", header);
    }

    public List<String> getAllRecordedReferences(){
        List<WebElement> orderReferenceElements  = getDriver().findElements(By.cssSelector("#content > table > tbody > tr:nth-child(1) > th"));
        return
                orderReferenceElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickDetailsLink(String lastOrderReference){
        testHelper.findElementUsingSelector("#content > table > tbody > tr:nth-child(1) > td.text-sm-center.order-actions > a.view-order-details-link").click();
    }

    public void clickReorderLink(String lastOrderReference){
        testHelper.findElementUsingSelector("#content > table > tbody > tr:nth-child(1) > td.text-sm-center.order-actions > a.reorder-link").click();
    }

}
