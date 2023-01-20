package com.heroku;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlerts extends BasePage {
    @FindBy (css = "#content > div > ul > li:nth-child(1) > button")
    protected WebElement jsAlert;
    @FindBy (css = "#content > div > ul > li:nth-child(2) > button" )
    protected WebElement jsConfirm;
    @FindBy (css = "#content > div > ul > li:nth-child(3) > button")
    protected WebElement jsPrompt;
    @FindBy (css = "#result")
    protected WebElement result;

    public JavaScriptAlerts(WebDriver driver) {
        super(driver);
    }

    public void acceptJsAlert () {
        jsAlert.click();
        driver.switchTo().alert().accept();
    }
    public void cancelJsConfirm () {
        jsConfirm.click();
        driver.switchTo().alert().dismiss();
    }
    public void enterTextInJsPrompt () throws InterruptedException {
        jsPrompt.click();
        driver.switchTo().alert().sendKeys("Hello JS");
        driver.switchTo().alert().accept();
    }
    public String getResultText () {
        return result.getText();
    }
}
