package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class AccessoriesPageObject extends PageObject {
    private final TestHelper testHelper;
    public AccessoriesPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
