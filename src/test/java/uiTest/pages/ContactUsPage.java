package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.ContactUsPageObject;


public class ContactUsPage {

    ContactUsPageObject contactUsPageObject;

    @Step
    public void verifyContactUsPage() {
        contactUsPageObject.verifyContactUsPage();
    }

    @Step
    public void enterMessage(String message) { contactUsPageObject.enterMessage(message); }

    @Step
    public void clickSend(){ contactUsPageObject.clickSend(); }

    @Step
    public void seeConfirmation(){ contactUsPageObject.seeConfirmation(); }

    @Step
    public void emptyMessage(){ contactUsPageObject.emptyMessage(); }

    @Step
    public void seeErrorMessage(){ contactUsPageObject.seeErrorMessage(); }
}
