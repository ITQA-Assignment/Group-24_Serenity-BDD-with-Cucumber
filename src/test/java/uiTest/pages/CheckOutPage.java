package uiTest.pages;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import uiTest.pageObjects.CheckOutPageObject;

public class CheckOutPage {

    CheckOutPageObject checkOutPageObject;

    private double shippingMethodCost=0.0;

    @Step
    public void verifyCheckoutPage(){ checkOutPageObject.verifyCheckoutPage(); }

    @Step
    public void verifyPersonalInfoAutoCompletion(){ checkOutPageObject.verifyPersonalInfoAutoCompletion();}

    @Step
    public void selectPredefinedAddress(){ checkOutPageObject.selectPredefinedAddress(); }

    @Step
    public void selectShippingMethod(){ this.shippingMethodCost = checkOutPageObject.selectShippingMethodAndGetCost(); }

    @Step
    public void verifyTotalPriceWithShipping(){
        double subtotalPrice = checkOutPageObject.getSubtotalPrice();
        double shippingCost = checkOutPageObject.getShippingCost();
        double totalPrice = checkOutPageObject.getTotalPrice();

        Assert.assertTrue((shippingCost == this.shippingMethodCost) && Math.round(totalPrice)== Math.round(subtotalPrice+shippingCost));
    }

    @Step
    public void selectPaymentOption(){checkOutPageObject.selectPaymentOption();}

    @Step
    public void verifyTheUncheckedAgreement(){
        boolean isAgreementChecked = checkOutPageObject.isAgreementChecked();
        Assert.assertTrue(isAgreementChecked == false);
    }

    @Step
    public void verifyDesabledPlaceOrderButton(){
        String placeOrderButtonAvailability = checkOutPageObject.getPlaceOrderButtonAvailability();
        Assert.assertTrue(placeOrderButtonAvailability == "disabled");
    }

    @Step
    public void checkAgreement(){checkOutPageObject.checkAgreement();}

    @Step
    public void verifyEnabledPlaceOrderButton(){
        String placeOrderButtonAvailability = checkOutPageObject.getPlaceOrderButtonAvailability();
        Assert.assertTrue(placeOrderButtonAvailability == "enabled");
    }

    @Step
    public void clickPlaceOrderButton(){checkOutPageObject.clickPlaceOrderButton();}

    public void clickProceedToCheckout() {
    }
}
