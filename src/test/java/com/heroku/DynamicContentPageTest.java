package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicContentPageTest extends CrossBrowserTest {

    @BeforeTest
    public void setupTestForAuthentication()  {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(12) > a")).click();
    }

    @AfterTest
    public void tearDownForAuthentication()  {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void DynamicContentTest()  {
        DynamicContentPage dynamicContentPage = PageFactory.initElements(driver, DynamicContentPage.class);
        String actualText = dynamicContentPage.getUrl();
        String expectedText = dynamicContentPage.getUrlAfterPageRefresh();
        Assert.assertNotEquals(actualText, expectedText, "Dynamic text detected");
    }
}