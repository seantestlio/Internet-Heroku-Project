package com.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends BasePage {
    @FindBy (css = "#checkbox-example > button")
    protected WebElement removeCheckBoxButton;
    @FindBy (css = "#checkbox-example > button")
    protected WebElement addCheckBoxButton;
    @FindBy (css = "#checkbox-example > p")
    protected WebElement checkBoxGoneMessage;
    @FindBy (css = "#checkbox-example > p")
    protected WebElement checkBoxBackMessage;
    @FindBy (css = "#input-example > button")
    protected WebElement enableInputField;
    @FindBy (css = "#input-example > button")
    protected WebElement disableInputField;
    @FindBy (css = "#input-example > p")
    protected WebElement inputFieldEnableMessage;
    @FindBy (css = "#input-example > p")
    protected WebElement inputFieldDisableMessage;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }
    public void removeCheckBox () {
        removeCheckBoxButton.click();
    }
    public String getCheckBoxGoneMessage () {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkbox-example > p")));
        return checkBoxGoneMessage.getText();
    }

    public void addCheckBox () {
        addCheckBoxButton.click();
    }
    public String getCheckBoxBackMessage () {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkbox-example > p")));
        return checkBoxBackMessage.getText();
    }

    public void enableInputField () {
        enableInputField.click();
    }
    public String getInputFieldEnableMessage () {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-example > p")));
        return inputFieldEnableMessage.getText();
    }
    public void disableInputField () {
        disableInputField.click();
    }
    public String getInputFieldDisableMessage () {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-example > p")));
        return inputFieldDisableMessage.getText();
    }
}
