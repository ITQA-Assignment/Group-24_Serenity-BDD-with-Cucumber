package apiTest.methodImplementations;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class PutMethodImplementation {
    private Response response;
    private final String baseUrl;

    private String username;
    private String password;
    private int bookIndexToBePut;
    private String requestBody;

    public PutMethodImplementation(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setUsernameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setBookIndexToBePut(int index) {
        this.bookIndexToBePut = index;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public void sendPutRequest(String endpoint) {
        response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .auth()
                .basic(username, password)
                .body(requestBody)
                .when()
                .put(baseUrl + endpoint + "/" + bookIndexToBePut);
    }

    public void verifyStatusCode(int expectedStatus) {
        Assert.assertEquals("Status code mismatch", expectedStatus, response.getStatusCode());
    }
}
