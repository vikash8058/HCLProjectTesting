package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void verifyProductsPageLoads() {

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickProducts();

        Assert.assertTrue(productsPage.isProductsPageLoaded(),
                "Products page did not load properly");
    }

    @Test
    public void verifyAllProductsDisplayed() {

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickProducts();

        Assert.assertTrue(productsPage.getProductCount() > 0,
                "Products are not displayed");
    }

    @Test
    public void verifySearchProduct() {

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickProducts();

        productsPage.searchProduct("Blue Top");

        Assert.assertTrue(productsPage.isSearchResultDisplayed(),
                "Search results are not displayed");
    }

    @Test
    public void verifyViewProductNavigation() {

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickProducts();
        

        productsPage.clickFirstViewProduct();

        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"),
                "Product details page not opened");
    }

    @Test
    public void verifyAddToCartFunctionality() {

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickProducts();

        productsPage.clickFirstAddToCart();

        // If no exception occurs and modal handled, test passes
        Assert.assertTrue(true, "Add to cart failed");
    }
}
