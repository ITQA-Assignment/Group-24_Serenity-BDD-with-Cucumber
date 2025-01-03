package apiTest.methods;

import apiTest.methodImplementations.GetMethodImplementation;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class GetMethod {


    private GetMethodImplementation getMethodImplementation;


    private EnvironmentVariables environmentVariables;
    private String nonNumericId;

    @Step
    public void setBaseURL() {
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.base.url");
        getMethodImplementation = new GetMethodImplementation(baseUrl);

    }

    @Step
    public void setUsernameAndPassword(String username, String password){
        getMethodImplementation.setUsernameAndPassword(username,password);

    }
    public void setNonNumericBookIndex(String nonNumericId) {
        this.nonNumericId = nonNumericId;
    }

    @Step
    public void setAvailableBookIndexToRetrieve(int selectedAvailableIndex) {
        getMethodImplementation.setAvailableBookIndexToRetrieve(selectedAvailableIndex);

    }

    @Step
    public void sendGetAllRequest(String endpoint) {

        getMethodImplementation.sendGetAllRequest(endpoint);

    }

    @Step
    public void sendGetRequest(String endpoint) {
        getMethodImplementation.sendGetRequestWithNonNumericId(endpoint, nonNumericId);
        getMethodImplementation.sendGetRequest(endpoint);


    }

    @Step
    public void verifyResponseStatusCode(int expectedStatus) {
        getMethodImplementation.verifyStatusCode(expectedStatus);

    }

    @Step
    public void displayAllTheAvailableBooks(){
        getMethodImplementation.displayAllTheAvailableBooks();
    }

    @Step
    public void displayTheSelectedBook(){

        getMethodImplementation.displayTheSelectedBook();

    }
    public void displayTheErrorMessage() {
        System.out.println("Book not found");
    }







}
