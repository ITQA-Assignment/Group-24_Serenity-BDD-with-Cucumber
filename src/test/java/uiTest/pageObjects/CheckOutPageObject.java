package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class CheckOutPageObject extends PageObject {
    private TestHelper testHelper;
    public CheckOutPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
