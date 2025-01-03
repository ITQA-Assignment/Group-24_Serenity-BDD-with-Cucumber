package starter.stepdefinitions.api;

import apiTest.methods.PostMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class UserCreateAlreadyExistBook {

    @Steps
    PostMethod postMethod;

    @Given("the base api url for create method is set")
    public void the_base_api_url_for_create_method_is_set() {postMethod.setApiUrl();}
    @When("user creates a book using the index {int}")
    public void user_creates_a_book_using_the_index(Integer index) {postMethod.createBook(index);}
    @When("user send create request to endpoint {string}")
    public void user_send_create_request_to_endpoint(String endpoint) {postMethod.sentCreatedRequest(endpoint);}
    @Then("create book response status code should {int}")
    public void create_book_response_status_code_should(Integer expectedStatusCode) {postMethod.createResponse(expectedStatusCode);}

}
