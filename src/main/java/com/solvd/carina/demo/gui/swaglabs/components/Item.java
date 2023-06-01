package com.solvd.carina.demo.gui.swaglabs.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Item extends AbstractUIObject {
    @FindBy(xpath = ".//div[@class = 'inventory_item_name']")
    private ExtendedWebElement itemName;

    @FindBy(xpath = ".//div[@class = 'inventory_item_desc']")
    private ExtendedWebElement itemInfo;

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = ".//button[contains(@id, 'add-to-cart')]")
    private ExtendedWebElement addItemToCart;

    @FindBy(xpath = ".//button[contains(@id, 'remove')]")
    private ExtendedWebElement removeItemFromCart;

    public Item(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemInfo() {
        return itemInfo.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public void addItemToCart() {
        addItemToCart.click();
    }

    public void removeItemFromCart() {
        removeItemFromCart.click();
    }
}
