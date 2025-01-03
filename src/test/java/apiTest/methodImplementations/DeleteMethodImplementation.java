package apiTest.methodImplementations;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class DeleteMethodImplementation {
    private Response response;
    private final String baseUrl;

    private String username;

    private String password;

    private int bookIndexToBeDeleted;


    public DeleteMethodImplementation(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setUsernameAndPassword(String username, String password){
        this.username=username;
        this.password=password;
    }

    public void setBookIndexToBeDeleted(int index) {
        this.bookIndexToBeDeleted=index;
    }

    public void sendDeleteRequest(String endpoint) {
        response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .auth()
                .basic(username, password)
                .when()
                .delete(baseUrl+endpoint+"/"+bookIndexToBeDeleted);
    }

    public void verifyStatusCode(int expectedStatus) {
        Assert.assertEquals("Status code mismatch", expectedStatus, response.getStatusCode());
    }

}
