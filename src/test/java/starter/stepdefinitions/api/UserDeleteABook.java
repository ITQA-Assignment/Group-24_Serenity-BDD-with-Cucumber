package starter.stepdefinitions.api;

import apiTest.methods.DeleteMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class UserDeleteABook {

    @Steps
    DeleteMethod deleteMethod;

    @Given("the user base api url for delete method is set")
    public void the_user_base_api_url_for_delete_method_is_set() {
        deleteMethod.setBaseURL();
    }

    @When("user login with username {string} & password {string}")
    public void user_login_with_username_and_password(String username, String password) {
        deleteMethod.setUsernameAndPassword(username,password);
    }
    @When("user select a book to delete using index {int}")
    public void user_select_a_book_to_delete_using(Integer index) {
        deleteMethod.setBookIndexToBeDeleted(index);
    }

    @When("user send delete request to the endpoint {string}")
    public void user_send_delete_request_to_the_endpoint(String endpoint) {
        deleteMethod.sendDeleteRequest(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be (int expectedStatus) {
        deleteMethod.verifyResponseStatusCode(expectedStatus);
    }
}
