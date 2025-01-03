package starter.stepdefinitions.api;

import apiTest.methods.PostMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class LoginWithMixLetters {

    @Steps
    PostMethod postMethod;

    @Given("the base API URL for login is set")
    public void the_base_api_url_for_login_is_set() { postMethod.setApiUrl();}

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) { postMethod.setAuthentication(username,password);}

    @And("user send a request to the endpoint {string} and {string}")
    public void user_send_a_request_to_the_endpoint_and(String endpoint, String payload) { postMethod.sendLoginRequest(endpoint,payload);}

    @Then("the response status code is {int}")
    public void the_response_status_code_is(int expectedStatus) { postMethod.verifyResponseStatusCode(expectedStatus);}

    @When("the admin logs in with username {string} and password {string}")
    public void the_admin_logs_in_with_username_and_password(String username, String password) { postMethod.setAuthentication(username,password);}

    @And("admin send a request to the endpoint {string} and {string}")
    public void admin_send_a_request_to_the_endpoint_and(String endpoint, String payload) { postMethod.sendLoginRequest(endpoint,payload);}



}
