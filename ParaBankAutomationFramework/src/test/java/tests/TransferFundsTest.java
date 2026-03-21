package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;
import pages.TransferFundsPage;

public class TransferFundsTest extends BaseTest {

    // Login method
    private void loginToApplication() {
        LoginPage login = new LoginPage(driver);
        login.login("john", "demo");  // Ensure this user has 2 accounts
    }

    // ✅ Valid Fund Transfer
    @Test
    public void verifyValidFundTransfer() {

        loginToApplication();

        HomePage home = new HomePage(driver);
        home.clickTransferFunds();

        TransferFundsPage transfer = new TransferFundsPage(driver);
        transfer.transferValidAmount("100");

        Assert.assertTrue(
                transfer.isTransferCompleted(),
                "Valid fund transfer failed"
        );
    }

   
    // ✅ Transfer Without Amount
    @Test
    public void verifyTransferWithoutAmount() {

        loginToApplication();

        HomePage home = new HomePage(driver);
        home.clickTransferFunds();

        TransferFundsPage transfer = new TransferFundsPage(driver);
        transfer.transferWithoutAmount();

        Assert.assertFalse(
                transfer.isTransferCompleted(),
                "Transfer should not succeed without amount"
        );
    }

    // ✅ Transfer With Invalid Amount
    @Test
    public void verifyTransferWithInvalidAmount() {

        loginToApplication();

        HomePage home = new HomePage(driver);
        home.clickTransferFunds();

        TransferFundsPage transfer = new TransferFundsPage(driver);
        transfer.transferWithInvalidAmount();

        Assert.assertFalse(
                transfer.isTransferCompleted(),
                "Transfer should fail for invalid amount"
        );
    }

    // ✅ Transfer With Negative Amount
    @Test
    public void verifyTransferWithNegativeAmount() {

        loginToApplication();

        HomePage home = new HomePage(driver);
        home.clickTransferFunds();

        TransferFundsPage transfer = new TransferFundsPage(driver);
        transfer.transferWithNegativeAmount();

        Assert.assertFalse(
                transfer.isTransferCompleted(),
                "Transfer should fail for negative amount"
        );
    }
}
