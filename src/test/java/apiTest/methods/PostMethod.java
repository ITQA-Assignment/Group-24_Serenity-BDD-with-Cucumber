package apiTest.methods;


import apiTest.methodImplementations.PostMethodImplementation;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

import java.security.PublicKey;

public class PostMethod {
    private EnvironmentVariables environmentVariables;
    private PostMethodImplementation postMethodImplementation;

    @Step
    public void setApiUrl() {
        String apiUrl= EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.base.url");
        postMethodImplementation = new PostMethodImplementation(apiUrl);
    }

 @Step
    public void setAuthentication(String username, String password) {
        postMethodImplementation. setAuthentication(username,password);
    }
    @Step
    public void createBook(int index){
        postMethodImplementation.createBook(index);
    }
    @Step
    public void sentCreatedRequest(String endpoint){
        postMethodImplementation.sentCreatedRequest(endpoint);

    }
    @Step
    public void createResponse(int expectedStatusCode){
        postMethodImplementation.createResponse(expectedStatusCode);
    }

}
