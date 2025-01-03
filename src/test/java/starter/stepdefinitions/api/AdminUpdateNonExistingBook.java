package starter.stepdefinitions.api;

import apiTest.methods.PutMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class AdminUpdateNonExistingBook {

    @Steps
    PutMethod putMethod;

    @Given("the admin base api url for put method is set")
    public void the_admin_base_api_url_for_put_method_is_set() {
        putMethod.setBaseURL();
    }

    @When("admin login with username {string} and password {string}")
    public void admin_login_with_username_and_password(String username, String password) {
        putMethod.setUsernameAndPassword(username,password);
    }
    @When("admin select a book to put using the index {int}")
    public void admin_select_a_book_to_put_using_the_index(Integer index) {
        putMethod.setBookIndexToBePut(index);
    }

    @When("admin send put request to endpoint {string}")
    public void admin_send_put_request_to_endpoint(String endpoint) {
        putMethod.sendPutRequest(endpoint);
    }

    @Then("the admin response status code should be {int}")
    public void the_admin_response_status_code_should_be(int expectedStatus) {
        putMethod.verifyResponseStatusCode(expectedStatus);
    }
}
