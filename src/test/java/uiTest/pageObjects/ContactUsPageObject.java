package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class ContactUsPageObject extends PageObject {
    private final TestHelper testHelper;
    public ContactUsPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
