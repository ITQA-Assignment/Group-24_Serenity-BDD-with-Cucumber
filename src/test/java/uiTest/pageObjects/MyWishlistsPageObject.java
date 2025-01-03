package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class MyWishlistsPageObject extends PageObject {
    private final TestHelper testHelper;
    public MyWishlistsPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
