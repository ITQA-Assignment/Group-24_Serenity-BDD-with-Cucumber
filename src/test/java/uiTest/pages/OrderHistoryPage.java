package uiTest.pages;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import uiTest.pageObjects.OrderHistoryPageObject;

import java.util.List;

public class OrderHistoryPage {

    OrderHistoryPageObject orderHistoryPageObject;

    private List<String> allRecordedReferences;

    @Step
    public void verifyOrderHistoryPage(){
        orderHistoryPageObject.verifyOrderHistoryPage();
    }

    @Step
    public void getAllRecordedReferences(){
        this.allRecordedReferences = orderHistoryPageObject.getAllRecordedReferences();
    }

    @Step
    public void verifyLastOrderIsRecorded(String lastOrderReference){
        Assert.assertTrue(allRecordedReferences.contains(lastOrderReference));
    }

    @Step
    public void clickDetailsLink(String lastOrderReference){
        orderHistoryPageObject.clickDetailsLink(lastOrderReference);
    }

    @Step
    public void clickReorderLink(String lastOrderReference){
        orderHistoryPageObject.clickReorderLink(lastOrderReference);
    }



}
