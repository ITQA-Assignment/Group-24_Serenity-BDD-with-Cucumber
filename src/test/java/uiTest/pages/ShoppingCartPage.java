package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.HomePageObject;
import uiTest.pageObjects.ShoppingCartPageObject;

public class ShoppingCartPage {

    ShoppingCartPageObject shoppingCartPageObject ;

    @Step
    public void verifyShoppingCartPage(){shoppingCartPageObject.verifyShoppingCartPage();}

    @Step
    public void clickProceedToCheckout(){shoppingCartPageObject.clickProceedToCheckout();}

    @Step
    public void enterQuantity( ){ shoppingCartPageObject.enterQuantity(10);}

    @Step
    public void clickAddToCart( ){ shoppingCartPageObject.clickAddToCart(10);}

    @Step
    public void clickContinueShopping( ){ shoppingCartPageObject.clickContinueShopping();}

    //@Step
    //public void clickCartIcon( ){ shoppingCartPageObject.clickCartIcon();}

    @Step
    public void verifyCartPage() {shoppingCartPageObject.verifyCartPage();}

    @Step
    public  void verifyPriceWithQuantity(){shoppingCartPageObject.verifyPriceWithQuantity();}
    @Step
    public  void checkTotalPriceOfAllItems(){shoppingCartPageObject.checkTotalPriceOfAllItems();}

    @Step
    public void clickIncreaseButton(){shoppingCartPageObject.clickIncreaseButton();}

    @Step
    public void deleteItem(){shoppingCartPageObject.deleteItem();}

    @Step
    public void  makeQuantityZero(){shoppingCartPageObject. makeQuantityZero();}
}

