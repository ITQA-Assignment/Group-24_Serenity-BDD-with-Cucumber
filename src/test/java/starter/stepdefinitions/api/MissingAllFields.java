package starter.stepdefinitions.api;

import apiTest.methods.PostMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class MissingAllFields {

    @Steps
    PostMethod postMethod;


    @Given("the base api url for create method is set missing all mandatory filed")
    public void the_base_api_url_for_create_method_is_set_missing_all_mandatory_filed() {postMethod.setApiUrl();}

    @When("user login as username {string} and password {string} missing all mandatory filed")
    public void user_login_as_username_and_password_missing_all_mandatory_filed(String username, String password) {postMethod.setAuthentication(username, password);}
    @When("user creates a book using the index {int} missing all mandatory filed")
    public void user_creates_a_book_using_the_index_missing_all_mandatory_filed(Integer index) { postMethod.createBook(index);}
    @When("user send create request to endpoint {string} missing all mandatory filed")
    public void user_send_create_request_to_endpoint_missing_all_mandatory_filed(String endpoint) {
        String requestBody = """
            {
        
            }
        """;
        postMethod.sentCreatedRequest(endpoint, requestBody);
    }
    @Then("create book response status code should {int} missing all mandatory filed")
    public void create_book_response_status_code_should_missing_all_mandatory_filed(Integer expectedStatusCode) {postMethod.createResponse(expectedStatusCode);
    }

}



