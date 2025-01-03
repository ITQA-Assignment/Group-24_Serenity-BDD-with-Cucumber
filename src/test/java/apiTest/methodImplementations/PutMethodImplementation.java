package apiTest.methodImplementations;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class PutMethodImplementation {
    private Response response;
    private final String baseUrl;

    private String username;
    private String password;
    private int bookIdToBeUpdated;
    private String bookTitle;
    private String bookAuthor;


    public PutMethodImplementation(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setUsernameAndPassword(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setBookDetailsToUpdate(int bookId, String title, String author) {
        this.bookIdToBeUpdated = bookId;
        this.bookTitle = title;
        this.bookAuthor = author;
    }

    // Send PUT request to update the book
    public void sendPutRequest(String endpoint) {
        String requestBody = "{\n" +
                "    \"id\": " + bookIdToBeUpdated + ",\n" +
                "    \"title\": \"" + bookTitle + "\",\n" +
                "    \"author\": \"" + bookAuthor + "\"\n" +
                "}";

        response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .auth()
                .basic(username, password)
                .body(requestBody)
                .when()
                .put(baseUrl+endpoint+"/"+bookIdToBeUpdated);
    }

    public void verifyStatusCode(int expectedStatus) {
        Assert.assertEquals("Status code mismatch", expectedStatus, response.getStatusCode());

    }

}