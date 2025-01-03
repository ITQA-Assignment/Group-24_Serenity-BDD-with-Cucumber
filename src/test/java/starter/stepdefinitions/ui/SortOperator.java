
package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.helpers.PageNavigator;
import uiTest.pages.AccessoriesPage;
import uiTest.pages.HomePage;

public class SortOperator {

    @Steps
    HomePage homePage;
    @Steps
    AccessoriesPage accessoriesPage;

    private PageNavigator pageNavigator = PageNavigator.getInstance();

    @Given("verify user in the homepage")
    public void verify_user_in_the_homepage() {
        pageNavigator.navigateToHomePage();
        homePage.verifyHomePage();
    }
    @When("the user clicks on the accessories section")
    public void the_user_clicks_on_the_accessories_section() {
        homePage.clickAccessoriesTab();
    }
    @Then("user should navigate to accessories page")
    public void user_should_navigate_to_accessories_page() {
        accessoriesPage.verifyAccessoriesPage();
    }
    @When("user clicks on the sort by dropdown")
    public void user_clicks_on_the_sort_by_dropdown() {
        accessoriesPage.clickSortByDropdown();
    }
    @When("the user selects Name, A to Z option from the sort by dropdown")
    public void the_user_selects_name_a_to_z_option_from_the_sort_by_dropdown() {
        accessoriesPage.selectAToZOptionFromSortByDropdown();
    }

    @Then("the accessories should be sorted in alphabetical order")
    public void verify_accessories_sorted() {
        accessoriesPage.verifyAccessoriesSorted();
    }
}

