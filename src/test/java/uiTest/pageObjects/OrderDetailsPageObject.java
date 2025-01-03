package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

public class OrderDetailsPageObject extends PageObject {

    private final TestHelper testHelper;
    public OrderDetailsPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyOrderDetailsPage(){
        WebElement element = testHelper.findElementUsingSelector("#main > header > h1");
        String header = testHelper.getElementTextContent(element);

        Assert.assertEquals("Couldn't verify the Order Details Page", "Order details", header);
    }

    public void selectAProductInMessageSection(){
        testHelper.findElementUsingSelector("#content > section.order-message-form.box > form > section > div:nth-child(1) > div > select").click();
        testHelper.findElementUsingSelector("#content > section.order-message-form.box > form > section > div:nth-child(1) > div > select > option:nth-child(2)").click();
    }

    public void typeAMessageInMessageSection(){
        WebElement textArea = testHelper.findElementUsingSelector("#content > section.order-message-form.box > form > section > div:nth-child(2) > div > textarea");
        textArea.sendKeys("Please ensure delivery between 9 AM and 5 PM. Thank you!");
    }

    public void clickSendButtonInMessageSection(){
        testHelper.findElementUsingSelector("#content > section.order-message-form.box > form > footer > button").click();
    }

    public void checkForMessageSendErrorMessage(){
        WebElement notification = testHelper.findElementUsingSelector("#notifications > div > article");
        Assert.assertEquals(notification.getAttribute("data-alert").trim(),"danger");
    }

    public void verifyTheMessageIsAdded(){
        WebElement notification = testHelper.findElementUsingSelector("#notifications > div > article");
        WebElement messagesSection = testHelper.findElementUsingSelector("#content > div.box.messages");

        Assert.assertNotNull(messagesSection);
        Assert.assertEquals(notification.getAttribute("data-alert").trim(),"success");
    }

}
