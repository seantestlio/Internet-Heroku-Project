package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DigestAuthPageTest extends CrossBrowserTest {

    @BeforeTest
    public void goToHomePage()  {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(8) > a")).click();
    }

    @AfterTest
    public void tearDownForAuthentication()  {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void digestAuthLoginTest()  {
        DigestAuthPage digestAuthPage = PageFactory.initElements(driver, DigestAuthPage.class);
        String actualPageHeader = "Congratulations! You must have the proper credentials.";
        String expectedPageHeader = digestAuthPage.getPageHeader();
        Assert.assertEquals(expectedPageHeader, actualPageHeader, "Login successful !");
    }
}