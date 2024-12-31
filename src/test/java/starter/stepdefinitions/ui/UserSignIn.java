package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.SignInPage;
import uiTest.pages.HomePage;

public class UserSignIn {
    @Steps
    HomePage homePage;

    @Steps
    SignInPage signInPage;

    @Given("User in the homepage")
    public void user_in_the_homepage() {
        homePage.openApplication();
    }

    @When("User click sign in tab")
    public void user_click_sign_in_tab() {
        homePage.clickSignIn();
    }

    @Then("User should navigate to sign in page")
    public void user_should_navigate_to_sign_in_page() {
        signInPage.verifySignInPage();
    }

    @When("User enter email {string}")
    public void user_enter_email(String email) {
        signInPage.enterEmail(email);
    }

    @And("User enter password {string}")
    public void user_enter_password(String password) {
        signInPage.enterPassword(password);
    }

    @And("User click sign in button")
    public void user_click_sign_in_button() {
        signInPage.ClickSignIn();
    }

    @Then("User login to the application")
    public void user_login_to_the_application() { homePage.verifyHomePageAfterSignIn();}

}



