package uiTest.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class TestHelper {

    private static TestHelper instance;
    private final WebDriver driver;
    public final FluentWait<WebDriver> fluentWait;
    private static final int ELEMENT_WAIT_TIMEOUT = 20;
    private WebElement iframe;

    private TestHelper(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(ELEMENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    public static TestHelper getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new TestHelper(driver);
        }
        return instance;
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void switchToIFrame(String frameId) {

            this.switchToDefaultContent();

            iframe = fluentWait.until(driver -> {
                try {
                    return driver.findElement(By.id(frameId));
                } catch (Exception e) {
                    return null;
                }
            });

            if (iframe == null) {
                throw new TimeoutException("Frame not found: " + frameId);
            }

            driver.switchTo().frame(iframe);
    }

    public WebElement findElementUsingXpath(String xpath) {

        return fluentWait.until(driver -> {
            try {
                return driver.findElement(By.xpath(xpath));
            } catch (Exception e) {
                throw new RuntimeException("Failed to find element: " + xpath, e);
            }
        });
    }

    public WebElement findElementUsingId(String id) {

            return fluentWait.until(driver -> {
                try {
                    return driver.findElement(By.id(id));
                } catch (Exception e) {
                    throw new RuntimeException("Failed to find element: " + id, e);
                }
            });
    }

    public WebElement findElementUsingSelector(String cssSelector) {

        return fluentWait.until(driver -> {
            try {
                String script = "return document.querySelector('" + cssSelector + "')";
                return (WebElement) ((JavascriptExecutor) driver).executeScript(script);
            } catch (Exception e) {
                throw new RuntimeException("Failed to find element: " + cssSelector, e);
            }
        });
    }

}