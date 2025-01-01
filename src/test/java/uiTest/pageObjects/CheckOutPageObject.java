package uiTest.pageObjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckOutPageObject extends PageObject {
    private TestHelper testHelper;

    private boolean isAgreementChecked = false;

    public CheckOutPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyCheckoutPage(){
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingId("checkout-payment-step");

        Assert.assertTrue(element!=null);

    }

    public void verifyPersonalInfoAutoCompletion(){
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingId("checkout-personal-information-step");
        boolean isStepComplete = element.getAttribute("class").contains("-complete");

        Assert.assertTrue(isStepComplete);
    }

    public void selectPredefinedAddress(){
        testHelper.switchToIFrame("framelive");

        testHelper.findElementUsingId("id_address_delivery-address-2").click();
        testHelper.findElementUsingSelector("#checkout-addresses-step > div > div > form > div.clearfix > button").click();

    }

    public double selectShippingMethodAndGetCost(){
        testHelper.switchToIFrame("framelive");
        testHelper.findElementUsingId("delivery_option_2").click();
        WebElement element = testHelper.findElementUsingSelector(" #js-delivery > div > div.delivery-options > div:nth-child(4) > label > div > div.col-sm-3.col-xs-12 > span");
        String deliveryMethodCost = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent.trim()", element);

        testHelper.findElementUsingSelector("#js-delivery > button").click();

        if (deliveryMethodCost != "Free"){
            return testHelper.priceExtractor(deliveryMethodCost);
        }else {
            return 0.0;
        }
    }

    public double getTotalPrice(){
        testHelper.switchToIFrame("framelive");
        WebElement element = testHelper.findElementUsingSelector("#js-checkout-summary > div.card-block.cart-summary-totals.js-cart-summary-totals > div > span.value");
        String total = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent.trim()", element);
        return testHelper.priceExtractor(total);
    }

    public double getSubtotalPrice(){
        testHelper.switchToIFrame("framelive");
        WebElement element = testHelper.findElementUsingSelector("#cart-subtotal-products > span.value");
        String subtotal = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent.trim()", element);
        return testHelper.priceExtractor(subtotal);
    }

    public double getShippingCost(){
        testHelper.switchToIFrame("framelive");
        WebElement element = testHelper.findElementUsingSelector("#cart-subtotal-shipping > span.value");
        String shipping = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent.trim()", element);
        return testHelper.priceExtractor(shipping);
    }

    public void selectPaymentOption(){
        testHelper.switchToIFrame("framelive");
        testHelper.findElementUsingId("payment-option-3").click();
    }

    public String getPlaceOrderButtonAvailability(){
        WebElement element = testHelper.findElementUsingSelector("#payment-confirmation > div.ps-shown-by-js > button");
        boolean isButtonDisabled = element.getAttribute("disabled") != null || element.getAttribute("class").contains("disabled");
        return isButtonDisabled ? "disabled" : "enabled";
    }

    public void checkAgreement(){
        testHelper.findElementUsingId("conditions_to_approve[terms-and-conditions]").click();
        isAgreementChecked = !isAgreementChecked;
    }

    public boolean isAgreementChecked(){return isAgreementChecked;}

    public void clickPlaceOrderButton(){
        testHelper.findElementUsingSelector("#payment-confirmation > div.ps-shown-by-js > button").click();
    }



}
