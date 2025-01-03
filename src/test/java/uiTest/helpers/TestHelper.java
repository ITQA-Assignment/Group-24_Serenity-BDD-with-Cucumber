package uiTest.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestHelper {

    private static TestHelper instance;
    private final WebDriver driver;
    private final FluentWait<WebDriver> fluentWait;
    private static final int ELEMENT_WAIT_TIMEOUT = 20;

    private final WebDriverWait wait;

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

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

            WebElement iframe = fluentWait.until(driver -> {
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

    public String getElementTextContent(WebElement element){
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].textContent.trim()", element);
    }

    public double priceExtractor(String price) {

        price = price.replaceAll("[^\\d.,]", "").trim();
        Pattern pattern = Pattern.compile("\\d{1,3}(?:,\\d{3})*(\\.\\d+)?");
        Matcher matcher = pattern.matcher(price);

        if (matcher.find()) {
            String value = matcher.group();
            value = value.replace(",", "");
            return Double.parseDouble(value);
        } else {
            throw new IllegalStateException("No match found in the price string: " + price);
        }
    }

    public void waitForJQuery() {
        try {
            wait.until(driver -> {
                try {
                    return ((JavascriptExecutor) driver)
                            .executeScript("return jQuery.active == 0");
                } catch (Exception e) {
                    return true;
                }
            });

        } catch (Exception e) {
            System.out.println("Page load wait timeout - continuing anyway: " + e.getMessage());
        }
    }


}