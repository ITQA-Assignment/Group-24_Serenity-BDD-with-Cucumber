package starter.stepdefinitions.api;

import apiTest.methods.PostMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class MandatoryFieldMissingTitle {

    @Steps
    PostMethod postMethod;

    @Given("the base api url for create method")
    public void the_base_api_url_is_set() {
        postMethod.setApiUrl();
    }
    @When("user login as username  {string} and {string} for create method")
    public void userLoginAsUsernameAndForCreateMethod(String username, String password) {
        postMethod.setAuthentication(username, password);
    }

    @When("user creates a book using the index {int} for create book")
    public void user_creates_a_book_using_the_index_for_create_book(Integer index) {postMethod.createBook(index);}

    @When("user send create request to endpoint {string} without title")
    public void user_sends_create_request_to_endpoint_without_title(String endpoint) {
        String requestBody = """
            {
        
                             "author": "J.R.R. Tolkien"
            }
        """;
        postMethod.sentCreatedRequest(endpoint, requestBody);
    }
    @Then("create book response status code should {int} invalid input without title")
    public void create_book_response_status_code_should_invalid_input_without_title(Integer expectedStatusCode) {postMethod.createResponse(expectedStatusCode);}

    @When("user creates a book using the index {int} for post")
    public void userCreatesABookUsingTheIndexForPost(int arg0) {
    }


}
