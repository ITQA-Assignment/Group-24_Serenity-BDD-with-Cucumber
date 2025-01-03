package starter.stepdefinitions.api;

import apiTest.methods.PutMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class UserUpdateABook {
    @Steps
    PutMethod putMethod;

    @Given("the base api url for update method is set")
    public void the_base_api_url_for_update_method_is_set() {
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

    @When("user sends a PUT request to the endpoint {string}")
    public void user_sends_put_request_to_the_endpoint(String endpoint) {
        putMethod.sendPutRequest(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatus) {
        putMethod.verifyResponseStatusCode(expectedStatus);
    }
}