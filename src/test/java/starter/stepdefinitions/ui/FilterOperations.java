package starter.stepdefinitions.ui;


import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.helpers.PageNavigator;
import uiTest.pages.AccessoriesPage;

public class FilterOperations {

    @Steps
    AccessoriesPage accessoriesPage;

    private final PageNavigator pageNavigator = PageNavigator.getInstance();

    @Given("the user is on the accessories page")
    public void the_user_is_on_the_accessories_page() {
        pageNavigator.navigateToHomeAccessoriesPage();
        accessoriesPage.verifyAccessoriesPage();

    }
    @When("the user selects the brand {string} from the brand filter")
    public void the_user_selects_the_brand_from_the_brand_filter(String brandName) {
        accessoriesPage.selectStudioDesignFromBrand();

    }
    @Then("only accessories from brand studio design should be displayed")
    public void only_accessories_from_brand_studio_design_should_be_displayed(String brandName) {
        accessoriesPage.verifyFilteredByBrand(brandName);

    }
}
