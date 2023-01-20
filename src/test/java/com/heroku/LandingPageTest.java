package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class LandingPageTest extends CrossBrowserTest {
    @BeforeClass
    public void beforeClass() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void landingPageLoadTest() {
        WebElement pageHeaderElm = driver.findElement(By.cssSelector("#content > h2"));
        Assert.assertEquals(pageHeaderElm.getText(), "Available Examples");
    }
}
