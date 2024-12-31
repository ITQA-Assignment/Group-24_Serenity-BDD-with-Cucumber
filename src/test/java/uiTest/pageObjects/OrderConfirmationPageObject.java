package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class OrderConfirmationPageObject extends PageObject {
    private TestHelper testHelper;
    public OrderConfirmationPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
