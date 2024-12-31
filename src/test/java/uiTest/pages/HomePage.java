package uiTest.pages;

import net.serenitybdd.annotations.Step;
import starter.implementations.homePageImplement;

public class HomePage {

    homePageImplement homepage;

    @Step
    public void openApplication(){
        homepage.open();
    }

    @Step
    public void clickAccount(){
        homepage.clickAccount();
    }

    @Step
    public void selectLogin(){
        homepage.selectLogin();
    }
}
