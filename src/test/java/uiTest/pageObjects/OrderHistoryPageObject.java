package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class OrderHistoryPageObject extends PageObject {
    private TestHelper testHelper;
    public OrderHistoryPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
