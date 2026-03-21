package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TransferFundsPage extends BasePage {

    WebDriverWait wait;

    public TransferFundsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By amountField = By.id("amount");
    private By fromAccountDropdown = By.id("fromAccountId");
    private By toAccountDropdown = By.id("toAccountId");
    private By transferButton = By.xpath("//input[@value='Transfer']");

    // Confirmation locators
    private By successHeading = By.xpath("//h1[contains(text(),'Transfer Complete')]");
    private By successMessage = By.xpath("//p[contains(text(),'has been transferred')]");

    // Perform Valid Transfer
    public void transferValidAmount(String amount) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));

        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);

        Select fromAccount = new Select(driver.findElement(fromAccountDropdown));
        Select toAccount = new Select(driver.findElement(toAccountDropdown));

        if (fromAccount.getOptions().size() < 2) {
            throw new RuntimeException("Need at least 2 accounts to perform transfer.");
        }

        fromAccount.selectByIndex(0);
        toAccount.selectByIndex(1);

        driver.findElement(transferButton).click();
    }

    // Without Amount
    public void transferWithoutAmount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        driver.findElement(amountField).clear();
        driver.findElement(transferButton).click();
    }

    // Invalid Amount
    public void transferWithInvalidAmount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys("abc");
        driver.findElement(transferButton).click();
    }

    // Negative Amount
    public void transferWithNegativeAmount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys("-100");
        driver.findElement(transferButton).click();
    }

    // Verify Transfer Success
    public boolean isTransferCompleted() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successHeading));
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
