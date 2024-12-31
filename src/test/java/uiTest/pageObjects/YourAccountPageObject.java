package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class YourAccountPageObject extends PageObject {
    private TestHelper testHelper;
    public YourAccountPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
