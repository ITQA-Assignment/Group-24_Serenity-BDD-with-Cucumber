package starter.stepdefinitions.api;

import apiTest.methods.GetMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class AdminAndUserRetrieveAllBooks {

    @Steps
    GetMethod getMethod;

    @Given("the user base api url for get all books is set")
    public void the_user_base_api_url_for_get_all_books_is_set() {
        getMethod.setBaseURL();
    }

    @When("user login with username {string} and password {string} for get all books")
    public void user_login_with_username_and_password_for_get_all_books(String username, String password) {
        getMethod.setUsernameAndPassword(username,password);
    }

    @When("user send get all request to the endpoint {string}")
    public void user_send_get_all_request_to_the_endpoint(String endpoint) {
        getMethod.sendGetAllRequest(endpoint);
    }

    @Then("the response status code for user get all books should {int}")
    public void the_response_status_code_for_user_get_all_books_should(Integer expectedStatus) {
        getMethod.verifyResponseStatusCode(expectedStatus);
    }

    @Then("user can see all the available books list")
    public void user_can_see_all_the_available_books_list() {
        getMethod.displayAllTheAvailableBooks();
    }

}
