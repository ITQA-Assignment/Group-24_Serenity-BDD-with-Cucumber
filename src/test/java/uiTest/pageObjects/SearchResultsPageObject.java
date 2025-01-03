package uiTest.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

import java.util.List;

public class SearchResultsPageObject extends PageObject {

    private TestHelper testHelper;

    public SearchResultsPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }


    public void redirectSearchResultsPage() {
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingSelector("#wrapper > div > nav > ol > li:nth-child(2) > span");
        String breadcrumbItem = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent", element);

        Assert.assertEquals("Couldn't verify the Search results page", "Search results", breadcrumbItem.trim());
    }


    public void displaySearchResults(String keyword) {
        List<WebElement> searchResults = getDriver().findElements(By.xpath("//*[@id='js-product-list']/div[1]/div/article/div/div[1]/a/picture/img"));
        if (searchResults.isEmpty()) {
            throw new AssertionError("No search results found for the keyword: " + keyword);
        }
        for (WebElement result : searchResults) {
            String altText = result.getAttribute("alt");
            if (altText == null || !altText.toLowerCase().contains(keyword.toLowerCase())) {
                throw new AssertionError("Search result does not match the keyword: " + keyword);
            }
        }
    }

    public void displayMessage(){
        testHelper.switchToIFrame("framelive");
        WebElement noResultsMessage = $("//*[@id=\"product-search-no-matches\"]");
        if (!noResultsMessage.isDisplayed() || !noResultsMessage.getText().contains("No matches were found")) {
            throw new AssertionError("Expected 'No matches were found' message is not displayed.");
        }
    }

}
