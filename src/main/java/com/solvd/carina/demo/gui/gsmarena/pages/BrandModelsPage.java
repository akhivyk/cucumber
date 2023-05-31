package com.solvd.carina.demo.gui.gsmarena.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.solvd.carina.demo.gui.gsmarena.components.ModelItem;

public class BrandModelsPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='review-body']//li")
    private List<ModelItem> models;

    public BrandModelsPage(WebDriver driver) {
        super(driver);
    }

    public ModelInfoPage selectModel(String modelName) {
        for (ModelItem model : models) {
            if (model.readModel().equalsIgnoreCase(modelName)) {
                return model.openModelPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);
    }
}