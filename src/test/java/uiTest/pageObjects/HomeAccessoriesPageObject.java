package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class HomeAccessoriesPageObject extends PageObject {
    private TestHelper testHelper;
    public HomeAccessoriesPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
