package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import uiTest.helpers.TestHelper;

public class SearchResultsPageObject extends PageObject {
    private final TestHelper testHelper;
    public SearchResultsPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }
}
