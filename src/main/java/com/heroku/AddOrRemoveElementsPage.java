package com.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddOrRemoveElementsPage extends BasePage {

    @FindBy(css = "#content > h3")
    protected WebElement pageHeader;
    @FindBy(css = "#page-footer > div > div")
    protected WebElement pageFooter;

    @FindBy(css = "#page-footer > div > div > a")
    protected WebElement elementalSeleniumLink;

    @FindBy(css = "body > div:nth-child(2) > a > img")
    protected WebElement forkMeOnGitHubImageLink;

    @FindBy(css = "#content > div > button")
    protected WebElement addElementButton;

    @FindBy(css = "#elements > button")
    protected WebElement deleteButton;

    String elementalSeleniumUrl = "http://elementalselenium.com";
    String internetGitHubUrl = "https://github.com/saucelabs/the-internet";

    public AddOrRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader() {
        pauseScreen();
        return pageHeader.getText();
    }

    public String getPageFooter() {
        pauseScreen();
        return pageFooter.getText();
    }

    public boolean addElementInAddOrRemoveElementsPage() {
        clickOnElement(addElementButton);
        pauseScreen();
        return deleteButton.isDisplayed();
    }

    public boolean deleteElementInAddOrRemoveElementsPage() {
        clickOnElement(deleteButton);
        pauseScreen();
        try {
            if (!deleteButton.isDisplayed()) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void clickOnElement(WebElement element) {
        webDriverWaitForVisibility(element);
        element.click();
    }

    public void webDriverWaitForVisibility(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void pauseScreen() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
