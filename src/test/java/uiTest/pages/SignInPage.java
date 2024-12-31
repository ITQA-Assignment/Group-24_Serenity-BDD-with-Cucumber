package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.SignInPageObject;

public class SignInPage {

    SignInPageObject signInPageObject;

    @Step
    public void verifySignInPage(){ signInPageObject.verifySignInPage(); }

    @Step
    public void enterEmail(String email){ signInPageObject.enterEmail(email); }

    @Step
    public void enterPassword(String password){ signInPageObject.enterPassword(password); }

    @Step
    public void ClickSignIn(){ signInPageObject.ClickSignIn(); }
}
