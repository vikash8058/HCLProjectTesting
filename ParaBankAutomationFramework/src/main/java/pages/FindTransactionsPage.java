package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTransactionsPage extends BasePage {

    public FindTransactionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(linkText = "Find Transactions")
    WebElement findTransactionsLink;

    @FindBy(id = "amount")
    WebElement amountField;

    @FindBy(xpath = "//button[text()='Find Transactions']")
    WebElement findButton;

    @FindBy(id = "transactionTable")
    WebElement transactionTable;

    // Actions
    public void openFindTransactionsPage() {
        findTransactionsLink.click();
    }

    public void searchByAmount(String amount) {
        amountField.clear();
        amountField.sendKeys(amount);
        findButton.click();
    }

    public boolean isTransactionDisplayed() {
        return transactionTable.isDisplayed();
    }
}