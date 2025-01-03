package uiTest.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import uiTest.helpers.TestHelper;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;


public class MultiOptionProductPageObject extends PageObject {
    private final TestHelper testHelper;

    public MultiOptionProductPageObject() {
        this.testHelper = TestHelper.getInstance(getDriver());
    }

    @FindBy(id = "comment_title")
    private WebElement titleField;

    @FindBy(id = "comment_content")
    private WebElement reviewField;

    public WebElement getTitleField() {
        return titleField;
    }

    public WebElement getReviewField() {
        return reviewField;
    }

    // Verifies that the user is on the Multi Option Product Page
    public void verifyMultiOptionProductPage(){
        testHelper.switchToIFrame("framelive");
        WebElement element = testHelper.findElementUsingSelector("#add-to-cart-or-refresh > div.product-variants.js-product-variants > div");
        Assert.assertNotNull(element);
    }

    // Verifies that the user clicks on Write Your Review Button
    public void clickWriteYourReview(){
        testHelper.findElementUsingSelector("#add-to-cart-or-refresh > div.product-additional-info.js-product-additional-info > div.product-comments-additional-info > button").click();
    }

    //Verifies that the user is on the Write Your Review Modal
    public void verifyWriteYourReviewModal(){
        WebElement element = testHelper.findElementUsingId("post-product-comment-modal");
        String displayStyle = element.getCssValue("display").trim();

        Assert.assertEquals("The Write Your Review modal is not displayed.", "block", displayStyle);
    }

    // Clear the Title field
    public void emptyTitleField() {
        getTitleField().clear();
    }

    // Clear the Review field
    public void emptyReviewField() {
        getReviewField().clear();
    }

    // Verifies that the user clicks Send Button
    public void clickSend(){
        testHelper.findElementUsingSelector("#post-product-comment-form > div:nth-child(6) > div.col-sm-6.post-comment-buttons > button.btn.btn-comment.btn-comment-big").click();
    }

    public boolean isFieldsHighlighted(WebElement field) {
        return field.getAttribute("class").contains("error");
    }

    // Verifies that the both fields are highlighted in red for empty fields submissions
    public void verifyReviewAndTitleFieldsHighlighted() {
        boolean isTitleHighlighted = isFieldsHighlighted(getTitleField());
        boolean isReviewHighlighted = isFieldsHighlighted(getReviewField());

        assertTrue("Title field is not highlighted in red.", isTitleHighlighted);
        assertTrue("Review field is not highlighted in red.", isReviewHighlighted);
    }

    // Verifies that the review field is highlighted in red
    public void verifyReviewFieldHighlighted() {
        boolean isReviewHighlighted = isFieldsHighlighted(getReviewField());

        assertTrue("Review field is not highlighted in red.", isReviewHighlighted);
    }

    // Verifies that the title field is highlighted in red
    public void verifyTitleFieldHighlighted() {
        boolean isTitleHighlighted = isFieldsHighlighted(getTitleField());
        assertTrue("Title field is not highlighted in red.", isTitleHighlighted);
    }

    // Verifies that the user fills the title field
    public void fillTitleField(String title) {
        getTitleField().sendKeys(title);
    }

    // Verifies that the user fills the review field
    public void fillReviewField(String review) {
        getReviewField().sendKeys(review);
    }

    // Verifies that the "Review Sent" message is displayed
    public void verifyReviewSentMessageDisplayed() {
        WebElement element = testHelper.findElementUsingSelector("#product-comment-posted-modal > div > div > div.modal-header > p");
        String modalHeaderText = testHelper.getElementTextContent(element);

        Assert.assertEquals("Couldn't verify the 'Review Sent' text", "Review sent", modalHeaderText);
    }

    // Verifies that the "Review Sent" message is closed
    public void verifyReviewSentMessageClosed() {
        testHelper.findElementUsingSelector("#product-comment-posted-modal > div > div > div.modal-body > div.post-comment-buttons > button").click();
    }

}
