package starter.stepdefinitions.ui;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import uiTest.pages.*;

import java.util.List;

public class PostOrderActions {

    @Steps
    UserAccountPage userAccountPage;

    @Steps
    OrderConfirmationPage orderConfirmationPage;

    @Steps
    OrderHistoryPage orderHistoryPage;

    @Steps
    OrderDetailsPage orderDetailsPage;

    @Steps
    CheckOutPage checkOutPage;

    @Steps
    ShoppingCartPage shoppingCartPage;

    private String lastOrderReference;

    private List<String> orderedItems;

    private String userRedirection;

    @Given("user in the user account page knowing the order reference and ordered items")
    public void user_in_the_user_account_page_knowing_the_order_reference_and_ordered_items() {
        userAccountPage.verifyUserAccountPage();
        lastOrderReference = orderConfirmationPage.getOrderReferencce();
        orderedItems = orderConfirmationPage.getOrderedItemList();
    }

    @When("user click order history and details card")
    public void user_click_order_history_and_details_card() {
        userAccountPage.clickOrderHistoryAndDetails();
    }

    @Then("user navigate to the order history page")
    public void user_navigate_to_the_order_history_page() {
        orderHistoryPage.verifyOrderHistoryPage();
    }

    @When("user can see all the past order reference numbers")
    public void user_can_see_all_the_past_order_reference_numbers() {
        orderHistoryPage.getAllRecordedReferences();
    }

    @Then("user can verify the last order is recorded successfully")
    public void user_can_verify_the_last_order_is_recorded_successfully() {
        orderHistoryPage.verifyLastOrderIsRecorded(lastOrderReference);
    }

    @When("user click the details link for the referenced order")
    public void user_click_the_details_link_for_the_referenced_order() {
        orderHistoryPage.clickDetailsLink(lastOrderReference);
    }

    @Then("user navigate to the order details page")
    public void user_navigate_to_the_order_details_page() {
        orderDetailsPage.verifyOrderDetailsPage();
    }

    @When("user select a product within add a message section")
    public void user_select_a_product_within_add_a_message_section() {
        orderDetailsPage.selectAProductInMessageSection();
    }

    @Then("user see the error notification")
    public void user_see_the_error_notification() {
        orderDetailsPage.checkForMessageSendErrorMessage();
    }

    @And("user type a message inside the text area within add a message section")
    public void user_type_a_message_inside_the_text_area_within_add_a_message_section() {
        orderDetailsPage.typeAMessageInMessageSection();
    }

    @And("user click send button")
    public void user_click_send_button() {
        orderDetailsPage.clickSendButtonInMessageSection();
    }

    @Then("user can verify the message is added successfully")
    public void user_can_verify_the_message_is_added_successfully() {
        orderDetailsPage.verifyTheMessageIsAdded();
    }

    @And("user click the reorder link for the referenced order")
    public void user_click_the_reorder_link_for_the_referenced_order() {
        orderHistoryPage.clickReorderLink(lastOrderReference);
    }

    @Then("user is redirected to either the checkout page or the cart page based on the availability of reorder stock")
    public void user_is_redirected_to_either_the_checkout_page_or_the_cart_page_based_on_the_availability_of_reorder_stock() {
        if (checkOutPage.booleanVerifyCheckoutPage()) {
            this.userRedirection = "checkout";
        } else if (shoppingCartPage.booleanVerifyShoppingCartPage()) {
            this.userRedirection = "shoppingCart";
        } else {
            throw new AssertionError("Neither Checkout Page nor Shopping Cart Page was found.");
        }
    }

    @Then("if user is redirected to the checkout page, the same referenced order items should be displayed")
    public void if_user_is_redirected_to_the_checkout_page_the_same_referenced_order_items_should_be_displayed() {

        try{
            if(userRedirection=="checkout"){
                checkOutPage.verifyTheCheckoutItems(orderedItems);
            }else{throw new IllegalAccessException();}
        }catch (Exception e){System.out.println("User is not in the Checkout Page. Insufficient stock. The Reorder is unsuccessful!");}
    }

    @Then("if user is redirected to the cart page, the user should see the error message for insufficient stock")
    public void if_user_is_redirected_to_the_cart_page_the_user_should_see_the_error_message_for_insufficient_stock() {

        try{
            if(userRedirection=="shoppingCart"){
                shoppingCartPage.verifyUnsuccessfulReorder();
            }else{throw new IllegalAccessException();}
        }catch (Exception e){System.out.println("User is not in the checkout Page. The Reorder is successful!");}
    }
}
