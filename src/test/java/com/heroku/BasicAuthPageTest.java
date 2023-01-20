package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicAuthPageTest extends CrossBrowserTest {

    @BeforeTest
    public void setupTestForAuthentication() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(3) > a")).click();
    }

    @AfterTest
    public void tearDownForAuthentication() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 0)
    public void basicAuthTest()  {
        BasicAuthPage basicAuthPage = PageFactory.initElements(driver, BasicAuthPage.class);
        String expectedPageHeaderOnSuccessfulLogin = basicAuthPage.getPageHeader();
        String actualPageHeaderOnSuccessfulLogin = "Congratulations! You must have the proper credentials.";
        Assert.assertEquals(expectedPageHeaderOnSuccessfulLogin, actualPageHeaderOnSuccessfulLogin, "Login successful !");
    }
}