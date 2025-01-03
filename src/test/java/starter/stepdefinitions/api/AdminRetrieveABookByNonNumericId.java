package starter.stepdefinitions.api;

import apiTest.methods.GetMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class AdminRetrieveABookByNonNumericId {

    @Steps
    GetMethod getMethod;

    @Given("the user base url for get a book is set")
    public void the_user_base_url_for_get_a_book_is_set() {
        getMethod.setBaseURL();
    }

    @When("admin login with username {string} and password {string} for get only a book")
    public void admin_login_with_username_and_password_for_get_only_a_book(String username, String password) {
        getMethod.setUsernameAndPassword(username, password);
    }

    @When("user select a book to retrieve using the non numeric id {string}")
    public void user_select_a_book_to_retrieve_using_the_non_numeric_id(String selectedAvailableIndex) {
        getMethod.setNonNumericBookIndex(selectedAvailableIndex);
    }

    @When("user send the get request to the endpoint {string}")
    public void user_send_the_get_request_to_the_endpoint(String endpoint) {
        getMethod.sendGetRequest(endpoint);
    }

    @Then("the status code for user retrieve the chosen book should {int}")
    public void the_response_code_for_user_retrieve_the_chosen_book_should(Integer expectedStatus) {
        getMethod.verifyResponseStatusCode(expectedStatus);
    }


}



