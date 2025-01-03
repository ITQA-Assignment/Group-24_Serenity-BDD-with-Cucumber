package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

public class HomePageObject extends PageObject {
    private final TestHelper testHelper;

    public HomePageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyHomePage() {

        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingSelector("#wrapper > div > nav > ol > li > span");

        String breadcrumbItem = testHelper.getElementTextContent(element);

        Assert.assertEquals("Couldn't verify the Home page", "Home", breadcrumbItem);
    }

    public void verifyHomePageAfterSignIn() {
        testHelper.switchToIFrame("framelive");
        this.verifyHomePage();

        WebElement element = testHelper.findElementUsingSelector("#_desktop_user_info > div > a.logout.hidden-sm-down");
        String loginStatus = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].childNodes[2].textContent.trim()", element);

        Assert.assertEquals("Couldn't verify the Home page", "Sign out", loginStatus);
    }

    public void clickSignIn() {
        testHelper.switchToIFrame("framelive");
        WebElement signInButton = testHelper.findElementUsingXpath("//*[@id=\"_desktop_user_info\"]/div/a");
        signInButton.click();
    }
}