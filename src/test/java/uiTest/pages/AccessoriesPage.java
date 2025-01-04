package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.pageObjects.AccessoriesPageObject;

public class AccessoriesPage {

    AccessoriesPageObject accessoriesPageObject;

    @Step
    public void verifyAccessoriesPage(){
        accessoriesPageObject.verifyAccessoriesPage();
    }

    @Step
    public void clickSortByDropdown(){
        accessoriesPageObject.clickSortByDropdown();
    }

    @Step
    public void selectAToZOptionFromSortByDropdown() {
        accessoriesPageObject.selectAToZOptionFromSortByDropdown();
    }

    @Step
    public void verifyAccessoriesSorted() {
        accessoriesPageObject.verifyAccessoriesSorted();
    }

    @Step
    public void selectStudioDesignFromBrand(){
        accessoriesPageObject.selectStudioDesignFromBrand();
    }
    @Step
    public void verifyFilteredByBrand(String brandName) {
        accessoriesPageObject.verifyFilteredByBrand(brandName);
    }
}

