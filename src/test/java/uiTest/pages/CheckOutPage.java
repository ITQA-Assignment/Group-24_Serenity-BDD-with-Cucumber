package uiTest.pages;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import uiTest.pageObjects.CheckOutPageObject;

import java.util.List;

public class CheckOutPage {

    CheckOutPageObject checkOutPageObject;

    private double shippingMethodCost = 0.0;
    private double totalPriceBeforeAddedShippingMethod;

    @Step
    public void verifyCheckoutPage(){ checkOutPageObject.verifyCheckoutPage(); }

    @Step
    public void verifyPersonalInfoAutoCompletion(){ checkOutPageObject.verifyPersonalInfoAutoCompletion();}

    @Step
    public void selectPredefinedAddress(){ checkOutPageObject.selectPredefinedAddress(); }

    @Step
    public void selectShippingMethod(){
        this.totalPriceBeforeAddedShippingMethod = checkOutPageObject.getTotalPrice();
        this.shippingMethodCost = checkOutPageObject.selectShippingMethodAndGetCost();

    }

    @Step
    public void verifyTotalPriceWithShipping(){

        double shippingCost = checkOutPageObject.getShippingCost();
        double totalPrice = Math.round(checkOutPageObject.getTotalPrice() * 100.0) / 100.0;

        double expectedTotalPrice = totalPriceBeforeAddedShippingMethod + shippingCost;
        expectedTotalPrice =  Math.round(expectedTotalPrice * 100.0) / 100.0;

        Assert.assertTrue(this.shippingMethodCost == shippingCost && expectedTotalPrice == totalPrice);
    }

    @Step
    public void selectPaymentOption(){checkOutPageObject.selectPaymentOption();}

    @Step
    public void verifyTheUncheckedAgreement(){
        boolean isAgreementChecked = checkOutPageObject.isAgreementChecked();
        Assert.assertFalse(isAgreementChecked);
    }

    @Step
    public void verifyDisabledPlaceOrderButton(){
        String placeOrderButtonAvailability = checkOutPageObject.getPlaceOrderButtonAvailability();
        Assert.assertSame("disabled", placeOrderButtonAvailability);
    }

    @Step
    public void checkAgreement(){checkOutPageObject.checkAgreement();}

    @Step
    public void verifyEnabledPlaceOrderButton(){
        String placeOrderButtonAvailability = checkOutPageObject.getPlaceOrderButtonAvailability();
        Assert.assertSame("enabled", placeOrderButtonAvailability);
    }

    @Step
    public void clickPlaceOrderButton(){checkOutPageObject.clickPlaceOrderButton();}


    public void clickProceedToCheckout() {
    }

    @Step
    public void verifyTheCheckoutItems(List<String> orderedItems){
        List<String> checkoutItems = checkOutPageObject.getCheckoutItems();
        Assert.assertTrue(checkoutItems.containsAll(orderedItems));
    }

}
