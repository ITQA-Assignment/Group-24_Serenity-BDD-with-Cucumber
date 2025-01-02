package uiTest.pages;

import uiTest.pageObjects.HomeAccessoriesPageObject;
import net.serenitybdd.annotations.Step;

public class HomeAccessoriesPage {

    private final HomeAccessoriesPageObject homeAccessoriesPageObject;

    public HomeAccessoriesPage() {
        this.homeAccessoriesPageObject = new HomeAccessoriesPageObject();
    }

    @Step
    public int getInStockCount() {
        return homeAccessoriesPageObject.getInStockCount();
    }

    @Step
    public void addProductToCart(String productName, int quantity) {
        homeAccessoriesPageObject.selectProduct(productName);
        homeAccessoriesPageObject.setQuantity(quantity);
        homeAccessoriesPageObject.clickAddToCart();
    }

    @Step
    public void clickContinueShopping() {
        homeAccessoriesPageObject.clickContinueShopping();
    }
}

