package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.SearchResultsPageObject;

public class SearchResultsPage {

    SearchResultsPageObject searchResultsPageObject;

    @Step
    public void redirectSearchResultsPage() { searchResultsPageObject.redirectSearchResultsPage(); }

    @Step
    public void displaySearchResults(String keyword) { searchResultsPageObject.displaySearchResults(keyword); }

    @Step
    public void displayMessage() { searchResultsPageObject.displayMessage(); }
}
