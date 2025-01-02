package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.MultiOptionProductPage;

public class ProductReviewValidationAndSubmission {

    @Steps
    MultiOptionProductPage multiOptionProductPage;

    @Given("user is on the product page")
    public void user_is_on_the_product_page() {
        multiOptionProductPage.verifyMultiOptionProductPage();
    }

    @When("user clicks write your review button")
    public void user_clicks_write_your_review_button() {
        multiOptionProductPage.clickWriteYourReview();
    }

    @When("user leaves both title and review fields blank")
    public void user_leaves_both_title_and_review_fields_blank() {
        multiOptionProductPage.verifyWriteYourReviewModal();
        multiOptionProductPage.verifyEmptyTitleAndReviewFields();
    }

    @When("user clicks send button")
    public void user_clicks_send_button() {
        multiOptionProductPage.clickSend();
    }

    @Then("title and review fields are highlighted in red")
    public void title_and_review_fields_are_highlighted_in_red() {
        multiOptionProductPage.verifyReviewAndTitleFieldsHighlighted();
    }

    @Given("user is on write your review modal")
    public void user_is_on_write_your_review_modal() {
        multiOptionProductPage.verifyWriteYourReviewModal();
    }

    @Given("user fills the title field but leaves the review field blank")
    public void user_fills_the_title_field_but_leaves_the_review_field_blank() {
        multiOptionProductPage.fillTitleField("Great Product");
        multiOptionProductPage.verifyEmptyReviewFields();
    }

    @Then("review field is highlighted in red")
    public void review_field_is_highlighted_in_red() {
        multiOptionProductPage.verifyReviewFieldHighlighted();
    }

    @When("user fills the review field but leaves the title field blank")
    public void user_fills_the_review_field_but_leaves_the_title_field_blank() {
        multiOptionProductPage.fillReviewField("This product fits perfectly and is made from high quality material");
        multiOptionProductPage.verifyEmptyTitleField();
    }

    @Then("title field is highlighted in red")
    public void title_field_is_highlighted_in_red() {
        multiOptionProductPage.verifyTitleFieldHighlighted();
    }

    @Given("user fills both the title and review fields")
    public void user_fills_both_the_title_and_review_fields() {
        multiOptionProductPage.fillTitleField("Great Product");
        multiOptionProductPage.fillReviewField("This product fits perfectly and is made from high quality material");
    }

    @Then("review sent message is displayed")
    public void review_sent_message_is_displayed() {
        multiOptionProductPage.verifyReviewSentMessageDisplayed();
    }

    @Then("user clicks ok button to close the review sent message")
    public void user_clicks_ok_button_to_close_the_review_sent_message() {
        multiOptionProductPage.verifyReviewSentMessageClosed();
    }

}
