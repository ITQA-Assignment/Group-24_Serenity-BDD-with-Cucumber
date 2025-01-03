package starter.stepdefinitions.api;

import apiTest.methods.PostMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class MandatoryFieldsMissingAuthor {

    @Steps
    PostMethod postMethod;

    @Given("the base api url for create method is set for post")
    public void the_base_api_url_is_set_for_post() {
        postMethod.setApiUrl();
    }
    @When("user login as username {string} and password {string} for post")
    public void user_login_as_username_and_password_for_post(String username, String password) {postMethod.setAuthentication(username, password);}

    @When("user creates a book using the index {int} for postt")
    public void user_creates_a_book_using_the_index(Integer index) {postMethod.createBook(index);}

    @When("user send create request to endpoint {string} without author")
    public void user_sends_create_request_to_endpoint_without_author(String endpoint) {
        String requestBody = """
            {
               "title": "1984"
            }
        """;
        postMethod.sentCreatedRequest(endpoint, requestBody);
    }
    @Then("create book response status code should {int} invalid input without author")
    public void create_book_response_status_code_should_invalid_input_without_author(Integer expectedStatusCode) {postMethod.createResponse(expectedStatusCode);}

}

