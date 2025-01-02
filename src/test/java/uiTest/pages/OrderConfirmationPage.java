package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.OrderConfirmationPageObject;

public class OrderConfirmationPage {

    OrderConfirmationPageObject orderConfirmationPageObject;

    @Step
    public void verifyOrderConfirmationPage(){
        orderConfirmationPageObject.verifyOrderConfirmationPage();
    }

    @Step
    public void seeTheOrderReferenceAndOrderedItems(){ orderConfirmationPageObject.seeTheOrderReferenceAndOrderedItems(); }
}
