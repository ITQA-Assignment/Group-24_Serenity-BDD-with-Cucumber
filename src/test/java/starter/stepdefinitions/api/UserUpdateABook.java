package starter.stepdefinitions.api;

import apiTest.methods.PutMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class UserUpdateABook {
    @Steps
    PutMethod putMethod;

    @Given("set the base api url for update method")
    public void set_the_base_api_url_for_update_method() {
        putMethod.setBaseURL();
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        putMethod.setUsernameAndPassword(username, password);
    }

    @When("user selects a book to update with the bookid {int}, title {string}, and author {string}")
    public void user_select_a_book_to_update_with_the_bookid_title_and_author(int bookId, String title, String author) {
        putMethod.setBookDetailsToUpdate(bookId, title, author);
    }

    @When("user sends a put request to the url {string}")
    public void user_sends_put_request_to_the_url(String endpoint) {
        putMethod.sendPutRequestToUpdateABook(endpoint);
    }

    @Then("the expected response status code should be {int}")
    public void the_expected_response_status_code_should_be(int expectedStatus) {
        putMethod.verifyResponseStatusCode(expectedStatus);
    }
}