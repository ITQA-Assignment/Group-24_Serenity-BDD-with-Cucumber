package uiTest.pageObjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import uiTest.helpers.TestHelper;

import java.util.List;
import java.util.stream.Collectors;

public class CheckOutPageObject extends PageObject {
    private final TestHelper testHelper;

    private boolean isAgreementChecked = false;


    public CheckOutPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyCheckoutPage(){
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingId("checkout-payment-step");
        Assert.assertNotNull(element);
    }

    public boolean booleanVerifyCheckoutPage(){
        try {
            testHelper.switchToIFrame("framelive");
            WebElement element = testHelper.findElementUsingId("checkout-payment-step");
            return element != null;
        } catch (Exception e) {
            return false;
        }
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
        String deliveryMethodCost = testHelper.getElementTextContent(element);

        testHelper.findElementUsingSelector("#js-delivery > button").click();

        if (!deliveryMethodCost.equals("Free")){
            return testHelper.priceExtractor(deliveryMethodCost);
        }else {
            return 0.0;
        }
    }

    public double getTotalPrice(){
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingSelector("#js-checkout-summary > div.card-block.cart-summary-totals.js-cart-summary-totals > div > span.value");
        String total = testHelper.getElementTextContent(element);

        return testHelper.priceExtractor(total);
    }


    public double getShippingCost(){
        testHelper.switchToIFrame("framelive");

        WebElement element = testHelper.findElementUsingSelector("#cart-subtotal-shipping > span.value");
        String shipping = testHelper.getElementTextContent(element);

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


    public List<String> getCheckoutItems() {

        testHelper.findElementUsingSelector("#js-checkout-summary > div:nth-child(1) > div.cart-summary-products.js-cart-summary-products > p:nth-child(2) > a").click();
        List<WebElement> orderedItems = getDriver().findElements(By.cssSelector("#cart-summary-product-list > ul > li"));

        return
                orderedItems.stream()
                .map(item -> {
                    String productName = item.findElement(By.cssSelector("div.media-body > span.product-name > a")).getText().trim();
                    List<WebElement> options = item.findElements(By.cssSelector("div.product-line-info"));
                    String formattedOptions = options.stream()
                            .map(option -> {
                                String label = option.findElement(By.cssSelector(".label")).getText().trim().replace(":", "");
                                String value = option.findElement(By.cssSelector(".value")).getText().trim();
                                return label + ": " + value;
                            })
                            .collect(Collectors.joining(" - "));

                    String quantity = item.findElement(By.cssSelector("span.product-quantity")).getText().trim().replace("x", "");
                    String fullProductName = formattedOptions.isEmpty() ? productName : productName + " (" + formattedOptions + ")";
                    return fullProductName + " x" + quantity;

                })
                .collect(Collectors.toList());
    }

}
