package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.helpers.PageNavigator;
import uiTest.pageObjects.YourAccountPageObject;

public class YourAccountPage {

    YourAccountPageObject yourAccountPageObject;

    PageNavigator pageNavigator;

    @Step
    public void verifyUserAccountPage(){
        pageNavigator = PageNavigator.getInstance();
        pageNavigator.navigateToYourAccountPage();
        yourAccountPageObject.verifyUserAccountPage();
    }

    @Step
    public void clickOrderHistoryAndDetails(){
        yourAccountPageObject.clickOrderHistoryAndDetails();
    }


}
