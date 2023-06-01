package com.solvd.carina.demo.gui.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutSecondPage extends AbstractPage {
    @FindBy(xpath = "//button[@id='finish']")
    private ExtendedWebElement finishButton;

    public CheckoutSecondPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/checkout-step-two.html");
    }

    public CompletePage clickFinishButton() {
        finishButton.click();
        return new CompletePage(driver);
    }
}
