package com.heroku;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicallyLoadedPage extends BasePage {
    @FindBy(css = "#content > ul:nth-child(4) > li:nth-child(14) > a:nth-child(1)")
    protected WebElement dynamicLoadingElement;
    @FindBy(css = ".example > a:nth-child(5)")
    protected WebElement hiddenElementExampleInPage;
    @FindBy(css = ".example > a:nth-child(8)")
    protected WebElement renderedElementExampleInPage;
    @FindBy(css = "#start > button:nth-child(1)")
    protected WebElement startButtonToRenderElement;
    @FindBy(css = "#finish > h4:nth-child(1)")
    protected WebElement elementRenderedToElement;

    public DynamicallyLoadedPage(WebDriver driver) {
        super(driver);
    }

    public boolean renderElementToWebPage() {
        dynamicLoadingElement.click();
        try {
            renderedElementExampleInPage.click();
        }catch (NoSuchElementException e){}
        startButtonToRenderElement.click();
        return elementRenderedToElement.getText().equals("Hello World!");
    }

    public boolean findHiddenElementInPage () {
        dynamicLoadingElement.click();
        hiddenElementExampleInPage.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(startButtonToRenderElement));
        return elementRenderedToElement.getAttribute("textContent").equals("Hello World!");
    }
}
