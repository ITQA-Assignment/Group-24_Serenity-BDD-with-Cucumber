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

    @When("User select size {string}")
    public void user_select_size(String string) { shoppingCartPage.selectSize();}

    @When("User click color {string}")
    public void user_click_color(String string) { shoppingCartPage.selectColor();}

    @When("User enter quantity {int}")
    public void user_enter_quantity(int quantity) {shoppingCartPage.enterQuantity();}

    @When("User click ADD TO CART button")
    public void user_click_add_to_cart_button() {shoppingCartPage.clickAddToCart();}

    @Then("System should display {string}")
    public void system_should_display(String expectedMessage) {shoppingCartPage.verifyAddToCartMessage();}

    @Then("User click Continue shopping button")
    public void user_click_continue_shopping_button() {shoppingCartPage.clickContinueShoppingButton();}

    @Then("User enter new quantity {int}")
    public void user_enter_new_quantity(int newQuantity) {shoppingCartPage.enterQuantityAgain();}

    @Then("User enter notify me when available button")
    public void user_enter_notify_me_when_available_button() {shoppingCartPage.notifyMeWhenAvailable();}

    @When("User click the home tab")
    public void user_click_the_home_tab() {shoppingCartPage.clickHomeTab();}

    @Then("User select new item")
    public void user_select_new_item() {shoppingCartPage.selectDifferentProduct();}

    @Then("user click  proceed to checkout button")
    public void user_click_proceed_to_checkout_button() {shoppingCartPage.proceedToCheckout();}

    @Then("User should navigate to to cart page")
    public void user_should_navigate_to_to_cart_page() {shoppingCartPage.verifyCartPage();}


}
