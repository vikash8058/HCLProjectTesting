package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ===== Locators =====

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsLink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement allProductsTitle;

    @FindBy(id = "search_product")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='productinfo text-center']")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]//i[1]")
    private WebElement firstViewProduct;

    @FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]")
    private WebElement firstAddToCart;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    private WebElement searchedProductsTitle;

    // ===== Methods =====

    public void clickProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(productsLink));
        productsLink.click();
    }

    public boolean isProductsPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(allProductsTitle));
        return allProductsTitle.isDisplayed();
    }

    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public boolean isSearchResultDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchedProductsTitle));
        return searchedProductsTitle.isDisplayed();
    }

    public int getProductCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        return productList.size();
    }

    public void clickFirstViewProduct() {

        wait.until(ExpectedConditions.visibilityOf(firstViewProduct));

        // Scroll into view
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", firstViewProduct);

        wait.until(ExpectedConditions.elementToBeClickable(firstViewProduct));

        // JS click (stable)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", firstViewProduct);
    }
    public void clickFirstAddToCart() {

        wait.until(ExpectedConditions.visibilityOf(firstAddToCart));

        // Scroll to element
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", firstAddToCart);

        // JS click for stability
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", firstAddToCart);

        // Wait for modal popup
        wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn));

        // Click Continue Shopping
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", continueShoppingBtn);
    }

}
