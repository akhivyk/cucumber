package com.solvd.carina.demo.gui.swaglabs.pages;

import com.solvd.carina.demo.gui.swaglabs.components.Item;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//div[@class = 'inventory_item']")
    private List<Item> itemList;

    @FindBy(xpath = ".//select[@class='product_sort_container']")
    private ExtendedWebElement sortContainer;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/inventory.html");
    }

    public Item selectItem(String itemName) {
        return itemList.stream()
                .filter(e -> e.getItemName().contains(itemName.trim()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item " + itemName + " not found"));
    }

    public List<Item> getAllItems() {
        return itemList;
    }

    public CartPage openCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }
}
