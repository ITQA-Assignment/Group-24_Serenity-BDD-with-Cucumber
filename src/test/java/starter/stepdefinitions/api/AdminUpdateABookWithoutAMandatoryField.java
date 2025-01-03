package starter.stepdefinitions.api;

import apiTest.methods.PutMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class AdminUpdateABookWithoutAMandatoryField {

    @Steps
    PutMethod putMethod;

    @Given("base api url for put method is set")
    public void base_api_url_for_put_method_is_set() {
        putMethod.setBaseURL();
    }

    @When("admin login with the username {string} and password {string}")
    public void admin_login_with_the_username_and_password(String username, String password) {
        putMethod.setUsernameAndPassword(username, password);
    }

    @When("admin select a book to put with index {int}")
    public void admin_select_a_book_to_put_with_index(Integer index) {
        putMethod.setBookIndexToBePut(index);
    }

    @When("admin sets the request body without field {string}")
    public void admin_sets_the_request_body_without_field(String missingField) {
        String requestBody;
        if (missingField.equals("author")) {
            requestBody = "{ \"id\": 1, \"title\": \"Lord of the Rings\" }";
        } else if (missingField.equals("title")) {
            requestBody = "{ \"id\": 1, \"author\": \"J.R.R. Tolkien\" }";
        } else {
            requestBody = "{}";
        }
        putMethod.setRequestBody(requestBody);
    }

    @When("admin send a put request to endpoint {string}")
    public void admin_send_a_put_request_to_endpoint(String endpoint) {
        putMethod.sendPutRequest(endpoint);
    }

    @Then("admin response status code should {int}")
    public void admin_response_status_code_should(int expectedStatus) {
        putMethod.verifyResponseStatusCode(expectedStatus);
    }
}
