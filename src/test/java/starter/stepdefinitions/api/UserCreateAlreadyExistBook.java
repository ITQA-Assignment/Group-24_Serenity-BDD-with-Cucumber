package starter.stepdefinitions.api;

import apiTest.methods.PostMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class UserCreateAlreadyExistBook {

    @Steps
    PostMethod postMethod;

    @Given("the base api url for create method is set")
    public void the_base_api_url_for_create_method_is_set() {postMethod.setApiUrl();}
    @When("user login as username {string} and password {string}")
    public void user_login_as_username_and_password(String username, String password) {
        postMethod.setAuthentication(username, password);
    }

    @When("user creates a book using the index {int}")
    public void user_creates_a_book_using_the_index(Integer index) {postMethod.createBook(index);}

    @When("user send create request to endpoint {string}")
    public void user_send_create_request_to_endpoint(String endpoint) {
        String requestBody = """
            {
                              "id": 3,
                             "title": "The Hobbit",
                             "author": "J.R.R. Tolkien"
            }
        """;
        postMethod.sentCreatedRequest(endpoint,requestBody);}
    @Then("create book response status code should {int}")
    public void create_book_response_status_code_should(Integer expectedStatusCode) {postMethod.createResponse(expectedStatusCode);}

}
