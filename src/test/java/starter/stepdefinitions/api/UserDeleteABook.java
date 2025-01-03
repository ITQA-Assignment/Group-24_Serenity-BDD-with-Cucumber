package starter.stepdefinitions.api;

import apiTest.methods.DeleteMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class UserDeleteABook {

    @Steps
    DeleteMethod deleteMethod;

    @Given("the user base api url for delete method is set")
    public void the_base_api_url_for_delete_method_is_set() {
        deleteMethod.setBaseURL();
    }

    @When("user login with username {string} & password {string}")
    public void user_login_with_username_and_password(String username, String password) {
    }
    @When("user select a book to delete with the index {int}")
    public void user_select_a_book_to_delete_using_the_index(Integer index) {
        deleteMethod.setBookIndexToBeDeleted(index);
    }

    @When("user send delete request to the endpoint {string}")
    public void user_send_delete_request_to_endpoint(String endpoint) {
        deleteMethod.sendDeleteRequest(endpoint);
    }

    @Then("the response status code for user should {int}")
    public void the_response_status_code_should (int expectedStatus) {
        deleteMethod.verifyResponseStatusCode(expectedStatus);
    }
}
