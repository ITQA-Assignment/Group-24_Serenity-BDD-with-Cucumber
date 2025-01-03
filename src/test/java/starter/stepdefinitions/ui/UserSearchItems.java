package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.HomePage;
import uiTest.pages.SearchResultsPage;

public class UserSearchItems {

    @Steps
    HomePage homePage;

    @Steps
    SearchResultsPage searchResultsPage;

    @Given("User on the home page")
    public void user_on_the_home_page() { homePage.verifyHomePage();}

    @When("User clicks on the search box")
    public void user_clicks_on_the_search_box() { homePage.clickSearchBox();}

    @And("User searches for {string} using the search box")
    public void user_searches_for_using_the_search_box(String keyword) { homePage.searchKeyword(keyword);}

    @Then("User redirects to the search results page")
    public void user_redirects_to_the_search_results_page() { searchResultsPage.redirectSearchResultsPage();}

    @And("User sees search results related to keyword {string}")
    public void user_sees_search_results_related_to_keyword(String keyword) { searchResultsPage.displaySearchResults(keyword);}

    @And("User sees No matches were found for your search message")
    public void user_sees_no_matches_were_found_for_your_search_message() { searchResultsPage.displayMessage();}

    @Then("User navigates to the homepage")
    public void user_navigates_to_the_homepage() { homePage.navigateToHomePage();}


}
