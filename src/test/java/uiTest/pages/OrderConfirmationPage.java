package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.OrderConfirmationPageObject;

import java.util.List;

public class OrderConfirmationPage {

    OrderConfirmationPageObject orderConfirmationPageObject;

    @Step
    public void verifyOrderConfirmationPage(){
        orderConfirmationPageObject.verifyOrderConfirmationPage();
    }

    @Step
    public void seeTheOrderReferenceAndOrderedItems(){ orderConfirmationPageObject.seeTheOrderReferenceAndOrderedItems(); }

    @Step
    public String getOrderReferencce() {
        return OrderConfirmationPageObject.getOrderReferencce();
    }

    @Step
    public List<String> getOrderedItemList() {
        return OrderConfirmationPageObject.getOrderedItemList();
    }
}
