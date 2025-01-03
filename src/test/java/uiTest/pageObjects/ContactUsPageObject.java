package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

public class ContactUsPageObject extends PageObject {

 private final TestHelper testHelper;

    public ContactUsPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyContactUsPage(){
        testHelper.switchToIFrame("framelive");
        WebElement element = testHelper.findElementUsingSelector("#wrapper > div > nav > ol > li:nth-child(2) > span");
        String breadcrumbItem = testHelper.getElementTextContent(element);

        Assert.assertEquals("Couldn't verify the Contact Us page", "Contact us", breadcrumbItem);
    }


    public void enterMessage(String message){
        testHelper.switchToIFrame("framelive");
        $(By.id("contactform-message")).type(message);
    }


    public void clickSend() {
        testHelper.switchToIFrame("framelive");
        WebElement sendButton = testHelper.findElementUsingSelector("#content > section > form > footer > input.btn.btn-primary");
        sendButton.click();
    }


    public void seeConfirmation() {
        testHelper.switchToIFrame("framelive");
        WebElement confirmationMessage = testHelper.findElementUsingSelector("#content > section > form > div > ul > li");
        Assert.assertTrue("Confirmation message is not displayed", confirmationMessage.isDisplayed());

        String confirmationText = confirmationMessage.getText().trim();
        Assert.assertEquals("Confirmation message does not match", "Your message has been successfully sent to our team.", confirmationText);
    }


    public void emptyMessage() {
        testHelper.switchToIFrame("framelive");
        $(By.id("contactform-message")).clear();
    }

    public void seeErrorMessage(){
        testHelper.switchToIFrame("framelive");
        WebElement errorMessage = testHelper.findElementUsingSelector("#content > section > form > div");
        Assert.assertTrue("Error message is not displayed",errorMessage.isDisplayed());

        String errorText = errorMessage.getText().trim();
        Assert.assertEquals("Error message does not match","The message cannot be blank.",errorText);
    }

}
