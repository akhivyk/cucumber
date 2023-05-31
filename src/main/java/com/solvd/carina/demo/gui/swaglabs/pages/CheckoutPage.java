package com.solvd.carina.demo.gui.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='first-name']")
    private ExtendedWebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private ExtendedWebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private ExtendedWebElement zipCode;

    @FindBy(xpath = "//input[@id='continue']")
    private ExtendedWebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void inputFirstName(String fName) {
        firstName.type(fName);
    }

    public void inputLastName(String lName) {
        lastName.type(lName);
    }

    public void inputZipCode(String zip) {
        zipCode.type(zip);
    }

    public CheckoutSecondPage clickContinue() {
        continueButton.click();
        return new CheckoutSecondPage(driver);
    }
}
