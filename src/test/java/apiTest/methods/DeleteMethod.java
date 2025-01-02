package apiTest.methods;

import apiTest.methodImplementations.DeleteMethodImplementation;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class DeleteMethod {

    private DeleteMethodImplementation deleteMethodImplementation;

    private EnvironmentVariables environmentVariables;

    @Step
    public void setBaseURL() {
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.base.url");
        deleteMethodImplementation = new DeleteMethodImplementation(baseUrl);
    }

    @Step
    public void setUsernameAndPassword(String username, String password){
        deleteMethodImplementation.setUsernameAndPassword(username,password);
    }

    @Step
    public void setBookIndexToBeDeleted(int index) {
        deleteMethodImplementation.setBookIndexToBeDeleted(index);
    }

    @Step
    public void sendDeleteRequest(String endpoint) {
        deleteMethodImplementation.sendDeleteRequest(endpoint);
    }

    @Step
    public void verifyResponseStatusCode(int expectedStatus) {
        deleteMethodImplementation.verifyStatusCode(expectedStatus);
    }

}
