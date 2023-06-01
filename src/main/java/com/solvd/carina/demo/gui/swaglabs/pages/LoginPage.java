package com.solvd.carina.demo.gui.swaglabs.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "user-name")
    private ExtendedWebElement username;

    @FindBy(id = "password")
    private ExtendedWebElement password;

    @FindBy(id = "login-button")
    private ExtendedWebElement buttonLogIn;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(username);
    }

    public void clickLoginButton() {
        buttonLogIn.click();
    }

    public HomePage openHomePage() {
        clickLoginButton();
        return new HomePage(driver);
    }

    public void inputUsername(String userName) {
        username.type(userName);
    }

    public void inputPassword(String pass) {
        password.type(pass);
    }
}
