package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.helpers.TestHelper;
import uiTest.pageObjects.HomePageObject;

public class HomePage {

    HomePageObject homePageObject;

    @Step
    public void openApplication() {
        homePageObject.open();
        this.verifyHomePage();
    }

    @Step
    public void verifyHomePage() {
        homePageObject.verifyHomePage();
    }

    @Step
    public void verifyHomePageAfterSignIn() {
        homePageObject.verifyHomePageAfterSignIn();
    }

    @Step
    public void clickSignIn() {
        homePageObject.clickSignIn();
    }
}
