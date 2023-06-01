package com.solvd.carina.demo.cucumber.steps;

import com.solvd.carina.demo.gui.swaglabs.binary.Order;
import com.solvd.carina.demo.gui.swaglabs.binary.User;
import com.solvd.carina.demo.gui.swaglabs.pages.*;
import com.solvd.carina.demo.gui.swaglabs.services.OrderService;
import com.solvd.carina.demo.gui.swaglabs.services.UserService;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class SwagLabsOrdersSteps extends CucumberRunner {
    private HomePage homePage = null;

    private CheckoutSecondPage checkoutSecondPage = null;

    private static final String EXPECTED_HEADER = "Thank you for your order!";

    private static final long USER_ID = 1;

    private static final User USER = UserService.getUser(USER_ID);

    @Given("^I am logged in with user credentials from the database")
    public void loginWithUserCredentialsFromDatabase() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

        loginPage.inputUsername(USER.getLogin());
        loginPage.inputPassword(USER.getPassword());

        homePage = loginPage.openHomePage();
    }

    @When("^I add the orders stored in the database for the mentioned user$")
    public void addOrdersFromDatabase() {
        List<Order> userOrders = OrderService.getUserOrders(USER_ID);
        Assert.assertFalse(userOrders.isEmpty(), "Empty user orders");
        for (Order userOrder : userOrders) {
            homePage.selectItem(userOrder.getItem()).addItemToCart();
        }
    }

    @And("^I proceed to checkout$")
    public void proceedToCheckout() {
        CartPage cartPage = homePage.openCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");

        CheckoutPage checkoutPage = cartPage.openCheckoutPage();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page is not opened");
        checkoutPage.inputFirstName(USER.getFirstName());
        checkoutPage.inputLastName(USER.getLastName());
        checkoutPage.inputZipCode(USER.getZipCode().toString());

        checkoutSecondPage = checkoutPage.clickContinue();
        Assert.assertTrue(checkoutSecondPage.isPageOpened(), "Second checkout page is not opened");
    }

    @Then("^the ordering should be successful$")
    public void verifyOrderingSuccess() {
        CompletePage completePage = checkoutSecondPage.clickFinishButton();
        Assert.assertTrue(completePage.isPageOpened(), "Complete page is not opened");
        Assert.assertEquals(completePage.getSuccessHeader(), EXPECTED_HEADER, "Order is not successful");
    }
}
