package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.ShoppingCartPageObject;
import uiTest.pageObjects.ProductAvailabilityPageObject;


public class ProductAvailabilityPage {

    ShoppingCartPageObject shoppingCart;

    ProductAvailabilityPageObject productAvailabilityPageObject ;


    @Step
    public void verifyCartPage( ){ productAvailabilityPageObject.verifyCartPage();}

    @Step
    public void verifyPriceWithQuantity( ){ productAvailabilityPageObject.verifyPriceWithQuantity();}

    @Step
    public void checkTotalPriceOfAllItems( ){ productAvailabilityPageObject.checkTotalPriceOfAllItems();}

    @Step
    public void clickDeleteButton( ){ productAvailabilityPageObject.clickDeleteButton();}





}
