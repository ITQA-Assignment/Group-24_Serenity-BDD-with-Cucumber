package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

public class YourAccountPageObject extends PageObject {
    private final TestHelper testHelper;
    public YourAccountPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyUserAccountPage(){
        WebElement element = testHelper.findElementUsingSelector("#wrapper > div > nav > ol > li:nth-child(2) > span");
        String breadcrumbItem = testHelper.getElementTextContent(element);

        Assert.assertEquals("Couldn't verify the User Account Page", "Your account", breadcrumbItem);
    }

    public void clickOrderHistoryAndDetails(){
        testHelper.findElementUsingId("history-link").click();
    }


}
