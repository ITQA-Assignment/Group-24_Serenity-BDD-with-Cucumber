package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.ShoppingCartPageObject;

public class ShoppingCartPage {

    ShoppingCartPageObject shoppingCartPageObject;

    @Step
    public void verifyShoppingCartPage(){shoppingCartPageObject.verifyShoppingCartPage();}

    @Step
    public void clickProceedToCheckout(){shoppingCartPageObject.clickProceedToCheckout();}


}
