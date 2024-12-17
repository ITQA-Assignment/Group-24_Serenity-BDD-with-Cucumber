package starter.stepdefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.HomePage;
import uiTest.pages.LoginPage;

public class LoginToApplication {

    @Steps
    HomePage homePage;

    @Steps
    LoginPage loginPage;

    @Given("open the application")
    public void open_the_application() {
        homePage.openApplication();
    }

    @When("user clicked Account")
    public void user_clicked_account() {
        homePage.clickAccount();
    }

    @When("user select Login")
    public void user_select_login() {
        homePage.selectLogin();
    }

    @Then("user is in the loginpage")
    public void user_is_in_the_loginpage() {
        loginPage.verifyLoginPage();
    }

    @When("user enter email address as {string}")
    public void user_enter_email_address_as(String email) {
        loginPage.enterEmailAddress(email);
    }

    @When("user enter password as {string}")
    public void user_enter_password_as(String password) {
        loginPage.enterPassword(password);
    }

    @Then("user clicked login button")
    public void user_clicked_login_button() {
        loginPage.clickLoginButton();
    }
}
