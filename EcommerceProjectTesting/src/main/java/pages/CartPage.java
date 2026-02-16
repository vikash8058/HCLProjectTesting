package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	// Cart link (header)
	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	private WebElement cartLink;

	// Cart page title
	@FindBy(xpath = "//li[@class='active']")
	private WebElement cartPageTitle;

	// Product name inside cart
	@FindBy(xpath = "//td[@class='cart_description']/h4/a")
	private WebElement productName;

	// Product price
	@FindBy(xpath = "//td[@class='cart_price']/p")
	private WebElement productPrice;

	// Quantity
	@FindBy(xpath = "//td[@class='cart_quantity']/button")
	private WebElement productQuantity;

	// Total price
	@FindBy(xpath = "//td[@class='cart_total']/p")
	private WebElement totalPrice;

	// Remove product button
	@FindBy(xpath = "//a[@class='cart_quantity_delete']")
	private WebElement removeButton;

	// Empty cart message
	@FindBy(xpath = "//b[contains(text(),'Cart is empty')]")
	private WebElement emptyCartMessage;

	// ================= METHODS =================

	public void clickCart() {
		cartLink.click();
	}

	public boolean isCartPageDisplayed() {
		return cartPageTitle.isDisplayed();
	}

	public String getProductName() {
		return productName.getText();
	}

	public String getProductPrice() {
		return productPrice.getText();
	}

	public String getProductQuantity() {
		return productQuantity.getText();
	}

	public String getTotalPrice() {
		return totalPrice.getText();
	}

	public void clickRemoveProduct() {
		removeButton.click();
	}

	public boolean isCartEmptyMessageDisplayed() {
		return emptyCartMessage.isDisplayed();
	}
}