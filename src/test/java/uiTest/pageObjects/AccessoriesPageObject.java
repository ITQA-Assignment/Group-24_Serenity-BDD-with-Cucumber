package uiTest.pageObjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import uiTest.helpers.TestHelper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class AccessoriesPageObject extends PageObject {
    private final TestHelper testHelper;
    public AccessoriesPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    public void verifyAccessoriesPage(){
        WebElement element = testHelper.findElementUsingSelector("#wrapper > div > nav > ol > li:nth-child(2) > span");
        String breadcrumbItem = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].textContent.trim()", element);
        Assert.assertEquals("Couldnt verify the Accessories Page", "Accessories", breadcrumbItem);
    }

    public void clickSortByDropdown(){
        testHelper.findElementUsingSelector("#js-product-list-top > div.col-lg-7 > div > div.col-xs-8.col-sm-7.col-md-9.products-sort-order.dropdown > button").click();
    }
    public void selectStudioDesignFromBrand(){
        WebElement studioDesignFilter = testHelper.findElementUsingSelector("label[for='facet_label_5']"); // Adjust based on actual DOM
        studioDesignFilter.click();
        testHelper.waitForJQuery();
    }

    public void selectAToZOptionFromSortByDropdown() {
        testHelper.findElementUsingSelector("#js-product-list-top > div.col-lg-7 > div > div.col-xs-8.col-sm-7.col-md-9.products-sort-order.dropdown.open > div > a:nth-child(3)").click();
        testHelper.waitForJQuery();
    }

    public void verifyAccessoriesSorted() {

        List<WebElement> extractedProducts = getDriver().findElements(By.cssSelector(".product-title a"));
        List<String> extractedNames = extractedProducts.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedNames = extractedNames.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals("Accessories are not sorted alphabetically", sortedNames, extractedNames);
    }
    public void verifyFilteredByBrand(String brandName) {
        List<WebElement> productBrands = getDriver().findElements(By.cssSelector("#facet_72814 > li:nth-child(2) > label"));
        boolean allMatch = productBrands.stream()
                .allMatch(el -> el.getText().contains(brandName));

        Assert.assertTrue("Some products are not from the selected brand: " + brandName, allMatch);
    }

}