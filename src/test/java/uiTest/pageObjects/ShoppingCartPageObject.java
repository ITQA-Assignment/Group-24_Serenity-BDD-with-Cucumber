package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class ShoppingCartPageObject extends PageObject {
    private TestHelper testHelper;
    public ShoppingCartPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
