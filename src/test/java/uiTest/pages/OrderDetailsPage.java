package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.OrderDetailsPageObject;

public class OrderDetailsPage {

    OrderDetailsPageObject orderDetailsPageObject;

    @Step
    public void verifyOrderDetailsPage(){
        orderDetailsPageObject.verifyOrderDetailsPage();
    }

    @Step
    public void selectAProductInMessageSection(){
        orderDetailsPageObject.selectAProductInMessageSection();
    }

    @Step
    public void typeAMessageInMessageSection(){
        this.selectAProductInMessageSection();
        orderDetailsPageObject.typeAMessageInMessageSection();
    }

    @Step
    public void clickSendButtonInMessageSection(){
        orderDetailsPageObject.clickSendButtonInMessageSection();
    }

    @Step
    public void checkForMessageSendErrorMessage(){
        orderDetailsPageObject.checkForMessageSendErrorMessage();
    }

    @Step
    public void verifyTheMessageIsAdded(){
        orderDetailsPageObject.verifyTheMessageIsAdded();
    }


}
