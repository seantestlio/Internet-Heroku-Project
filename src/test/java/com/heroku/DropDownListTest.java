package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class DropDownListTest extends CrossBrowserTest {

    @BeforeClass
    public void navigateToDropDownListPageTest() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(11) > a")).click();
    }
    @AfterClass
    public void afterTestAddRemoveButtons() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void selectOption1InDropDownListTest() {
        DropDownList dropDownList = PageFactory.initElements(driver, DropDownList.class);
        Assert.assertEquals("Option 1", dropDownList.selectOption1InDropDownList(), "Option1 is Selected");
    }
    @Test
    public void selectOption2InDropDownListTest() {
        DropDownList dropDownList = PageFactory.initElements(driver, DropDownList.class);
        Assert.assertEquals("Option 2", dropDownList.selectOption2InDropDownList(), "Option2 is Selected");
    }
}
