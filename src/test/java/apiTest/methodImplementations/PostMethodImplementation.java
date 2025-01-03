package apiTest.methodImplementations;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class PostMethodImplementation {
    private Response response;
    private final String apiUrl;

    private String username;

    private String password;

    private int bookIndexToBeCreated;

    public PostMethodImplementation(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public void setAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void createBook(int index) {
        this.bookIndexToBeCreated = index;

    }
    public void sentCreatedRequest(String endpoint) {
        String requestBody = """
        {
        }
        """;

        response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .auth()
                .basic("user", "password")
                .body(requestBody)
                .post(apiUrl + endpoint);
    }

    public void createResponse(int expectedStatusCode) {
        Assert.assertEquals("Status code match", expectedStatusCode, response.getStatusCode());

    }

}
