package starter.stepdefinitions.api;

import apiTest.methods.PutMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class AdminUpdateABook {

    @Steps
    PutMethod putMethod;

    @Given("the base api url for update method is set")
    public void the_base_api_url_for_update_method_is_set() {
        putMethod.setBaseURL();
    }

    @When("admin authenticates with username {string} and password {string}")
    public void admin_authenticates_with_username_and_password(String username, String password) {
        putMethod.setUsernameAndPassword(username, password);
    }

    @When("admin selects a book to update with the bookid {int}, title {string}, and author {string}")
    public void admin_selects_a_book_to_update_with_the_bookid_title_and_author(int bookId, String title, String author) {
        putMethod.setBookDetailsToUpdate(bookId, title, author);
    }

    @When("admin sends a put request to update a book to the endpoint {string}")
    public void admin_sends_a_put_request_to_update_a_book_to_the_endpoint(String endpoint) {
        putMethod.sendPutRequestToUpdateABook(endpoint);
    }

    @Then ("admin gets response status code should {int}")
    public void admin_gets_response_status_code_should(int expectedStatus) {
        putMethod.verifyResponseStatusCode(expectedStatus);
    }



}
