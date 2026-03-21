package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    private static final int TIMEOUT = 10;

    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element) );
    }

    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}