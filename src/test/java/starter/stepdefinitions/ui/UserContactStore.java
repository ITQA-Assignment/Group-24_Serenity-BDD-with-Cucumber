package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.ContactUsPage;
import uiTest.pages.HomePage;

public class UserContactStore {

    @Steps
    HomePage homePage;

    @Steps
    ContactUsPage contactUsPage;


    @Given("User on the homepage")
    public void user_on_the_homepage() { homePage.verifyHomePageAfterSignIn();}

    @When("User clicks on the contact us section")
    public void user_clicks_on_the_contact_us_section() { homePage.clickContactUs();}

    @Then("User should navigate to contact us page")
    public void user_should_navigate_to_contact_us_page() { contactUsPage.verifyContactUsPage();}

    @When("User types a message in the form")
    public void user_types_a_message_in_the_form() {
        String testMessage = "This is a test message for validation.";
        contactUsPage.enterMessage(testMessage);}

    @And("User clicks the send button")
    public void user_clicks_the_send_button() { contactUsPage.clickSend(); }

    @Then("User should see a confirmation that the form was successfully submitted")
    public void user_should_see_a_confirmation_that_the_form_was_successfully_submitted() { contactUsPage.seeConfirmation(); }

    @When("User leaves the message field empty")
    public void user_leaves_the_message_field_empty() {contactUsPage.emptyMessage();}

    @Then("User should see an error message indicating that the message field is required")
    public void user_should_see_an_error_message_indicating_that_the_message_field_is_required() { contactUsPage.seeErrorMessage(); }

    @Given("User on the contact us page")
    public void user_on_the_contact_us_page() {contactUsPage.verifyContactUsPage();}

    @Then("User navigates back to the homepage")
    public void user_navigates_back_to_the_homepage() { homePage.navigateToHomePage();}

}
