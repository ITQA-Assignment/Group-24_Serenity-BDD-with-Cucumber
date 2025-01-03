package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.CheckOutPage;
import uiTest.pages.OrderConfirmationPage;
import uiTest.pages.ShoppingCartPage;

public class CheckoutAndOrderPlacement {

    @Steps
    ShoppingCartPage shoppingCartPage;

    @Steps
    CheckOutPage checkOutPage;

    @Steps
    OrderConfirmationPage orderConfirmationPage;

    @Given("user is on the shopping cart page")
    public void user_is_on_the_shopping_cart_page() {
        shoppingCartPage.verifyShoppingCartPage();
    }

    @When("user click the proceed to checkout button")
    public void user_click_the_proceed_to_checkout_button() {
        shoppingCartPage.clickProceedToCheckout();
    }

    @Then("user navigate to the checkout page")
    public void user_navigate_to_the_checkout_page() {
        checkOutPage.verifyCheckoutPage();
    }

    @Given("personal information section is auto completed")
    public void personal_information_section_is_auto_completed() {
        checkOutPage.verifyPersonalInfoAutoCompletion();
    }

    @When("user select a predefined address")
    public void user_select_a_predefined_address() {
        checkOutPage.selectPredefinedAddress();
    }

    @And("user select a shipping method")
    public void user_select_a_shipping_method() {
        checkOutPage.selectShippingMethod();
    }

    @Then("total price update with the shipping cost")
    public void total_price_update_with_the_shipping_cost() {
        checkOutPage.verifyTotalPriceWithShipping();
    }

    @When("user select a payment option")
    public void user_select_a_payment_option() {
        checkOutPage.selectPaymentOption();
    }

    @And("user verify the agreement is unchecked")
    public void user_verify_the_agreement_is_unchecked() {
        checkOutPage.verifyTheUncheckedAgreement();
    }

    @Then("place order button is disabled")
    public void place_order_button_is_disabled() {
        checkOutPage.verifyDisabledPlaceOrderButton();
    }

    @When("user check the agreement")
    public void user_check_the_agreement() {
        checkOutPage.checkAgreement();
    }

    @Then("place order button is enabled")
    public void place_order_button_is_enabled() {
        checkOutPage.verifyEnabledPlaceOrderButton();
    }

    @When("user click the place order button")
    public void user_click_the_place_order_button() {
        checkOutPage.clickPlaceOrderButton();
    }

    @Then("user navigate to the order confirmation page")
    public void user_navigate_to_the_order_confirmation_page() {
        orderConfirmationPage.verifyOrderConfirmationPage();
    }

    @And("user see the order reference and ordered items")
    public void user_see_the_order_reference_and_ordered_items() {
        orderConfirmationPage.seeTheOrderReferenceAndOrderedItems();
    }

}
