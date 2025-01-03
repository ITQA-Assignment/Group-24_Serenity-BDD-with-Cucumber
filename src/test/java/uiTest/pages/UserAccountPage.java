package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.helpers.PageNavigator;
import uiTest.pageObjects.UserAccountPageObject;

public class UserAccountPage {

    UserAccountPageObject userAccountPageObject;

    PageNavigator pageNavigator;

    @Step
    public void verifyUserAccountPage(){
        pageNavigator = PageNavigator.getInstance();
        pageNavigator.navigateToYourAccountPage();
        userAccountPageObject.verifyUserAccountPage();
    }

    @Step
    public void clickOrderHistoryAndDetails(){
        userAccountPageObject.clickOrderHistoryAndDetails();
    }


}
