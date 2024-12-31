package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class SingleOptionProductPageObject extends PageObject {
    private TestHelper testHelper;
    public SingleOptionProductPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
