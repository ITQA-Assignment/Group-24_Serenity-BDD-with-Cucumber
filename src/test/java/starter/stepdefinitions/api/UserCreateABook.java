package starter.stepdefinitions.api;

import apiTest.methods.PostMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class UserCreateABook {

    @Steps
    PostMethod postMethod;

    @Given("the base api url for creating a book is set")
    public void the_base_api_url_for_creating_a_book_is_set() { postMethod.setApiUrl();}

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) { postMethod.setAuthentication(username,password);}

    @And("user sends a POST request to the endpoint {string} with the payload:")
    public void user_sends_a_post_request_to_the_endpoint_with_the_payload(String endpoint, String payload) { postMethod.createABook(endpoint,payload);}

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatus) { postMethod.verifyResponseStatusCode(expectedStatus);}


}
