package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.ProductAvailabilityPage;

public class ProductAvailability {


    @Steps
    ProductAvailabilityPage productAvailabilityPage;

    @Then("User should navigate to cart page")
    public void user_should_navigate_to_cart_page() {productAvailabilityPage.verifyCartPage();}

    @Then("User check total price")
    public void user_check_total_price() {productAvailabilityPage.verifyPriceWithQuantity();}

    @Given("User check total price of all items")
    public void user_check_total_price_of_all_items() {productAvailabilityPage.checkTotalPriceOfAllItems();}

    @Given("user delete a item")
    public void user_delete_a_item() {productAvailabilityPage.clickDeleteButton();}

}
