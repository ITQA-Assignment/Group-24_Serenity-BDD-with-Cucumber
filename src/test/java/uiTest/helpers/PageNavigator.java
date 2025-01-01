package uiTest.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uiTest.pageObjects.HomePageObject;

public class PageNavigator {

    private static PageNavigator instance;
    private final HomePageObject homePageObject;
    private final TestHelper testHelper;

    private PageNavigator(){
        WebDriver webDriver = null;
        homePageObject = new HomePageObject();
        testHelper = TestHelper.getInstance(webDriver);
    }

    public static PageNavigator getInstance() {
        if (instance == null) {
            instance = new PageNavigator();
        }
        return instance;
    }

    public void navigateToHomePage(){
        testHelper.findElementUsingId("_desktop_logo").click();
        homePageObject.verifyHomePageAfterSignIn();
    }

    public void navigateToMultiOptionItemPage(){
        this.navigateToHomePage();
        testHelper.findElementUsingSelector("#category-3 > a").click();
        testHelper.findElementUsingSelector("#js-product-list > div.products.row > div:nth-child(1) > article > div > div.thumbnail-top > a").click();
    }

    public void navigateToHomeAccessoriesPage(){
        this.navigateToHomePage();
        testHelper.findElementUsingSelector("#category-6 > a").click();
        testHelper.findElementUsingSelector("#subcategories > ul > li:nth-child(2) > div.subcategory-image > a").click();
    }

    public void navigateToMyWishListsPage(){
        this.navigateToHomePage();
        this.navigateToYourAccountPage();
        testHelper.findElementUsingSelector("#wishlist-link").click();
    }

    public void navigateToSingleOptionItemPage(){
        this.navigateToHomePage();
        testHelper.findElementUsingSelector("#category-6 > a").click();
        testHelper.findElementUsingSelector("#js-product-list > div.products.row > div:nth-child(7) > article > div > div.thumbnail-top > a").click();
    }

    public void navigateToYourAccountPage(){
        this.navigateToHomePage();
        testHelper.findElementUsingSelector("#_desktop_user_info > div > a.account").click();
    }
}
