package com.solvd.carina.demo.gui.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(xpath = ".//button[@id='continue-shopping']")
    private ExtendedWebElement continueShopping;

    @FindBy(xpath = "//button[@id='checkout']")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/cart.html");
    }

    public HomePage back() {
        continueShopping.click();
        return new HomePage(driver);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public CheckoutPage openCheckoutPage() {
        clickCheckoutButton();
        return new CheckoutPage(driver);
    }
}
