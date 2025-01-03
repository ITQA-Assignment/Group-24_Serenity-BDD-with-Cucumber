package apiTest.methodImplementations;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class GetMethodImplementation {

    private Response response;
    private final String baseUrl;

    private String username;

    private String password;


    public GetMethodImplementation(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setUsernameAndPassword(String username, String password){
        this.username=username;
        this.password=password;
    }

    public void sendGetAllRequest(String endpoint) {
        response = SerenityRest.given()
                .header("Content-Type", "application/json")
                .auth()
                .basic(username, password)
                .when()
                .get(baseUrl+endpoint);
    }

    public void verifyStatusCode(int expectedStatus) {
        Assert.assertEquals("Status code mismatch", expectedStatus, response.getStatusCode());
    }

    public void displayAllTheAvailableBooks(){

        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> books = jsonPath.getList("$");

        if (books == null || books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("Available Books:\n");
        books.forEach(book -> {
            String title = (String) book.get("title");
            String author = (String) book.get("author");
            System.out.println("Title: " + title + ",\nAuthor: " + author + "\n");
        });
    }

}
