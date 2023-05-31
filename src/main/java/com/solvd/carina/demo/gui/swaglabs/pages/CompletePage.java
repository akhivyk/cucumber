package com.solvd.carina.demo.gui.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends AbstractPage {
    @FindBy(xpath = "//button[@id='back-to-products']")
    private ExtendedWebElement homePageButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private ExtendedWebElement successHeader;

    public CompletePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/checkout-complete.html");
    }

    public HomePage backToHomePage() {
        homePageButton.click();
        return new HomePage(driver);
    }

    public String getSuccessHeader() {
        return successHeader.getText();
    }
}
