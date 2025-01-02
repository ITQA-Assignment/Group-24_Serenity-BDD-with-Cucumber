package uiTest.pages;

import net.serenitybdd.annotations.Step;
import uiTest.helpers.PageNavigator;
import uiTest.pageObjects.MultiOptionProductPageObject;

public class MultiOptionProductPage {

    MultiOptionProductPageObject multiOptionProductPageObject;

    PageNavigator navigator;

    @Step
    public void verifyMultiOptionProductPage(){
        navigator = PageNavigator.getInstance();
        navigator.navigateToMultiOptionProductPage();
        multiOptionProductPageObject.verifyMultiOptionProductPage();
    }

    public void clickWriteYourReview(){
        multiOptionProductPageObject.clickWriteYourReview();
    }

    public void verifyWriteYourReviewModal(){
        multiOptionProductPageObject.verifyWriteYourReviewModal();
    }

    public void verifyEmptyTitleAndReviewFields(){
        multiOptionProductPageObject.emptyTitleField();
        multiOptionProductPageObject.emptyReviewField();
    }

    public void verifyEmptyReviewFields(){
        multiOptionProductPageObject.emptyReviewField();
    }

    public void verifyEmptyTitleField(){
        multiOptionProductPageObject.emptyTitleField();
    }

    public void clickSend(){
        multiOptionProductPageObject.clickSend();
    }

    public void verifyReviewAndTitleFieldsHighlighted(){
        multiOptionProductPageObject.verifyReviewAndTitleFieldsHighlighted();
    }

    public void verifyReviewFieldHighlighted(){
        multiOptionProductPageObject.verifyReviewFieldHighlighted();
    }

    public void verifyTitleFieldHighlighted(){
        multiOptionProductPageObject.verifyTitleFieldHighlighted();
    }

    public void fillTitleField(String title){
        multiOptionProductPageObject.fillTitleField(title);
    }

    public void fillReviewField(String review){
        multiOptionProductPageObject.fillReviewField(review);
    }

    public void verifyReviewSentMessageDisplayed(){
        multiOptionProductPageObject.verifyReviewSentMessageDisplayed();
    }

    public void verifyReviewSentMessageClosed(){
        multiOptionProductPageObject.verifyReviewSentMessageClosed();
    }

}
