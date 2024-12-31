package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class MultiOptionProductPageObject extends PageObject {
    private TestHelper testHelper;
    public MultiOptionProductPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
