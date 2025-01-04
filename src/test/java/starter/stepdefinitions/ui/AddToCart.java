package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.HomePage;
import uiTest.pages.ShoppingCartPage;

public class AddToCart {
    @Steps
    HomePage homePage;

    @Steps
    ShoppingCartPage shoppingCartPage;

    @When("User click {string}")
    public void user_click(String string) {homePage.clickProduct();}

    @Then("User should navigate to signal option product page")
    public void user_should_navigate_to_signal_option_product_page() { shoppingCartPage.verifyShoppingCartPage();}

    @When("User enter quantity {int}")
    public void user_enter_quantity(int quantity) {shoppingCartPage.enterQuantity();}

    @When("User click ADD TO CART button")
    public void user_click_add_to_cart_button() {shoppingCartPage.clickAddToCart();}

    @Then("User click Continue shopping")
    public void user_click_continue_shopping() {shoppingCartPage.clickContinueShopping();
    }

   // @When("User click the home tab")
  //  public void user_click_the_home_tab() {shoppingCartPage.clickHomeTab();}

   // @Given("User click cart icon")
  //  public void user_click_cart_icon() {shoppingCartPage.clickCartIcon();}


    @Then("User check total price for item")
    public void user_check_total_price_for_item() {shoppingCartPage.verifyPriceWithQuantity();
    }
    @Then("User check total price of all items")
    public void user_check_total_price_of_all_items() {shoppingCartPage.checkTotalPriceOfAllItems();}

    @Then("user click  proceed to checkout button")
    public void user_click_proceed_to_checkout_button() {shoppingCartPage.clickProceedToCheckout();}

    @Then("User should navigate to to cart page")
    public void user_should_navigate_to_to_cart_page() {shoppingCartPage.verifyCartPage();}


    @Then("User increase quantity higher than available quantity")
    public void user_increase_quantity_higher_than_available_quantity() {shoppingCartPage.clickIncreaseButton();}


    @Then("User delete item")
    public void user_delete_item() {shoppingCartPage.deleteItem();}

    @Then("User make quantity to zero")
    public void user_make_quantity_to_zero() {shoppingCartPage.makeQuantityZero();
    }

    @Then("User can't checkout")
    public void user_can_t_checkout() {

    }


}
