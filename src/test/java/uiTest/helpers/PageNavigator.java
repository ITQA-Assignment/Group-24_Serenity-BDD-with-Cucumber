package uiTest.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uiTest.pageObjects.HomePageObject;

public class PageNavigator {

    HomePageObject homePageObject;
    TestHelper testHelper;

    public void PageNavigator(WebDriver webDriver){
        testHelper = TestHelper.getInstance(webDriver);
    }

    public void navigateToHomePage(){
        WebElement element = testHelper.findElementUsingSelector("   #_desktop_logo > h1 > a");
        element.click();
        homePageObject.verifyHomePageAfterSignIn();
    }

    public void navigateToMultiOptionItemPage(){
        this.navigateToHomePage();

    }

    public void navigateToHomeAccessoriesPage(){
        this.navigateToHomePage();

    }

    public void navigateToMyWishListsPage(){
        this.navigateToHomePage();

    }

    public void navigateToSingleOptionItemPage(){
        this.navigateToHomePage();

    }

    public void navigateToYourAccountPage(){
        this.navigateToHomePage();

    }
}
