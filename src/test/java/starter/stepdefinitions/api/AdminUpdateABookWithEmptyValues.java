package starter.stepdefinitions.api;

import apiTest.methods.PutMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class AdminUpdateABookWithEmptyValues {
    @Steps
    PutMethod putMethod;

    @Given("the base api url for put method is set")
    public void theBaseApiUrlForPutMethodIsSet() {
        putMethod.setBaseURL();
    }

    @When("admin logs in to the system with the username {string} and password {string}")
    public void adminLogsInToTheSystemWithTheUserAndPassword(String username, String password) {
        putMethod.setUsernameAndPassword(username, password);
    }

    @When("admin selects a book to update with the empty values for bookid {int}, title {string}, and author {string}")
    public void admin_selects_a_book_to_update_with_the_empty_values_for_bookid_title_and_author(int bookId, String title, String author) {
        putMethod.setBookDetailsToUpdate(bookId, title, author);
    }

    @When("admin sends a put request to update a book to the end url {string}")
    public void admin_sends_a_put_request_to_update_a_book_to_the_end_url(String endpoint) {
        putMethod.sendPutRequestToUpdateABook(endpoint);
    }

    @Then("the received response status code should be {int}")
    public void theReceivedResponseStatusCodeShouldBe(int expectedStatus) {
        putMethod.verifyResponseStatusCode(expectedStatus);
    }
}
