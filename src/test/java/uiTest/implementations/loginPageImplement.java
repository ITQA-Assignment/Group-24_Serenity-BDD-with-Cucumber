package uiTest.implementations;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class loginPageImplement extends PageObject {


    public void verifyLoginPage(){
        Assert.assertTrue(getDriver().getTitle().contains("Login"));
    }

    public void enterEmailAddress(String email){
        $(By.id("email")).type(email);
    }

    public void enterPassword(String password){
        $(By.id("password")).type(password);
    }

    public void clickLoginButton(){
        $(By.id("submitBTN")).click();

    }
}
