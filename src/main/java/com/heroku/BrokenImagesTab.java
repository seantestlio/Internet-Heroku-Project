package com.heroku;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenImagesTab extends BasePage{

    @FindBy (css = "#content > div > h3")
    protected WebElement pageHeader;

    public BrokenImagesTab(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader() {
        return pageHeader.getText();
    }
}
