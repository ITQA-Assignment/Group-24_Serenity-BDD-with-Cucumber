package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

public class SignInPageObject extends PageObject {

    private TestHelper testHelper;

    public SignInPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifySignInPage(){
        testHelper.switchToIFrame("framelive");
        WebElement element = testHelper.findElementUsingXpath("//*[@id=\"wrapper\"]/div/nav/ol/li[2]/span");
        String breadcrumbItem = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent", element);

        Assert.assertEquals("Couldn't verify the Home page", "Log in to your account", breadcrumbItem.trim());
    }

    public void enterEmail(String email){
        testHelper.switchToIFrame("framelive");
        $(By.id("field-email")).type(email);
    }

    public void enterPassword(String password){
        testHelper.switchToIFrame("framelive");
        $(By.id("field-password")).type(password);
    }

    public void ClickSignIn(){
        testHelper.switchToIFrame("framelive");
        $(By.id("submit-login")).click();
    }

}
