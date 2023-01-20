package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicallyLoadElementTest extends CrossBrowserTest {

    @AfterMethod
    public void navigateToLandingPage() {
        driver.get("https://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/"));
    }
    @Test
    public void renderElementToWebPageTest() {
        DynamicallyLoadedPage dynamicallyLoadedPage = PageFactory.initElements(driver, DynamicallyLoadedPage.class);
        Assert.assertTrue(dynamicallyLoadedPage.renderElementToWebPage());
    }

    @Test
    public void hiddenElementInWebPageTest() {
        DynamicallyLoadedPage dynamicallyLoadedPage = PageFactory.initElements(driver, DynamicallyLoadedPage.class);
        Assert.assertTrue(dynamicallyLoadedPage.findHiddenElementInPage());
    }
}
