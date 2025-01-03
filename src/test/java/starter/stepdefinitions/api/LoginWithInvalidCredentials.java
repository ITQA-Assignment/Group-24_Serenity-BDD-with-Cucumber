package starter.stepdefinitions.api;

import apiTest.methods.PostMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class LoginWithInvalidCredentials {

    @Steps
    PostMethod postMethod;

    @Given("the base API URL for login invalid is set")
    public void the_base_api_url_for_login_invalid_is_set() { postMethod.setApiUrl();}

    @When("the user logs in with invalid username {string} and password {string}")
    public void the_user_logs_in_with_invalid_username_and_password(String username, String password) { postMethod.setAuthentication(username,password);}

    @And("user send a login request to the endpoint {string} and {string}")
    public void user_send_a_login_request_to_the_endpoint_and(String endpoint, String payload) { postMethod.sendLoginRequest(endpoint,payload);}

    @Then("the response status code will be {int}")
    public void the_response_status_code_will_be(int expectedStatus) { postMethod.verifyResponseStatusCode(expectedStatus);}

    @When("admin logs in with invalid username {string} and password {string}")
    public void admin_logs_in_with_invalid_username_and_password(String username, String password) { postMethod.setAuthentication(username,password);}

    @When("the admin send a login request to the endpoint {string} and {string}")
    public void the_admin_send_a_login_request_to_the_endpoint_and(String endpoint, String payload) { postMethod.sendLoginRequest(endpoint,payload);}
}
