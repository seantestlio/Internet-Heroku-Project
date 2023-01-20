package com.heroku;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DisappearingElementsPage extends BasePage {
    @FindBy (css = "#content > div > ul > li:nth-child(5) > a")
    protected WebElement galleryTab;

    public DisappearingElementsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isGalleryTabPresent() {
        return galleryTab.isDisplayed();
    }
}
