package apiTest.methods;


import apiTest.methodImplementations.PutMethodImplementation;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class PutMethod {

    private PutMethodImplementation putMethodImplementation;

    private EnvironmentVariables environmentVariables;

    @Step
    public void setBaseURL() {
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.base.url");
        putMethodImplementation = new PutMethodImplementation(baseUrl);
    }

    @Step
    public void setUsernameAndPassword(String username, String password){
        putMethodImplementation.setUsernameAndPassword(username,password);
    }

    @Step
    public void setBookIndexToBePut(int index) {
        putMethodImplementation.setBookIndexToBePut(index);
    }

    @Step
    public void sendPutRequest(String endpoint) {
        putMethodImplementation.sendPutRequest(endpoint);
    }

    @Step
    public void verifyResponseStatusCode(int expectedStatus) {
        putMethodImplementation.verifyStatusCode(expectedStatus);
    }

}
