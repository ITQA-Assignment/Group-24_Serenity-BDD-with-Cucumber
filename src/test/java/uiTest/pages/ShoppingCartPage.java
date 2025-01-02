package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.HomePageObject;
import uiTest.pageObjects.ShoppingCartPageObject;

public class ShoppingCartPage {

    HomePageObject homePageObject;

    ShoppingCartPageObject shoppingCartPageObject ;

    @Step
    public void verifyShoppingCartPage( ){ shoppingCartPageObject.verifyShoppingCartPage();}

    @Step
    public void selectSize( ){ shoppingCartPageObject.selectSize("S");}

    @Step
    public void selectColor( ){ shoppingCartPageObject.selectColor("Black");}

    @Step
    public void enterQuantity( ){ shoppingCartPageObject.enterQuantity(300);}

    @Step
    public void clickAddToCart( ){ shoppingCartPageObject.clickAddToCart(300);}

    @Step
    public void verifyAddToCartMessage( ){ shoppingCartPageObject.verifyAddToCartMessage("Product successfully added to your shopping cart");}

    @Step
    public void clickContinueShoppingButton( ){ shoppingCartPageObject.clickContinueShoppingButton();}

    @Step
    public void enterQuantityAgain( ){ shoppingCartPageObject.enterQuantityAgain(300);}

    @Step
    public void  notifyMeWhenAvailable( ){ shoppingCartPageObject. notifyMeWhenAvailable();}

    @Step
    public void  clickHomeTab( ){ shoppingCartPageObject. clickHomeTab();}


    @Step
    public void  selectDifferentProduct( ){ shoppingCartPageObject. selectDifferentProduct();}

    @Step
    public void  proceedToCheckout( ){ shoppingCartPageObject. proceedToCheckout();}

    @Step
    public void  verifyCartPage( ){ shoppingCartPageObject. verifyCartPage();}




}
