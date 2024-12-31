package uiTest.pages;

import net.serenitybdd.annotations.Step;
import starter.implementations.loginPageImplement;

public class LoginPage {

    loginPageImplement loginPage;

    @Step
    public void verifyLoginPage(){
        loginPage.verifyLoginPage();
    }

    @Step
    public void enterEmailAddress(String email){
        loginPage.enterEmailAddress(email);
    }

    @Step
    public void enterPassword(String password){
        loginPage.enterPassword(password);
    }

    @Step
    public void clickLoginButton(){
        loginPage.clickLoginButton();
    }


}


