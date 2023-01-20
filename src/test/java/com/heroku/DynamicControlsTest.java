package com.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class DynamicControlsTest extends CrossBrowserTest {
    protected DynamicControlsPage dynamicControlsPage;
    @BeforeClass
    public void isGalleryTabPresentTest () {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(13) > a")).click();
    }
    @Test (priority = 1)
    public void removeCheckBoxTest () {
        dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
        dynamicControlsPage.removeCheckBox();
        Assert.assertEquals(dynamicControlsPage.getCheckBoxGoneMessage(), "It's gone!");
    }
    @Test (priority = 2, enabled = true)
    public void addCheckBoxTest ()  {
        dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
        dynamicControlsPage.addCheckBox();
        Assert.assertEquals(dynamicControlsPage.getCheckBoxBackMessage(), "It's back!");
    }
    @Test (priority = 3, enabled = true)
    public void enableInputFieldTest () {
        dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
        dynamicControlsPage.enableInputField();
        Assert.assertEquals(dynamicControlsPage.getInputFieldEnableMessage(), "It's enabled!");
    }
    @Test (priority = 4, enabled = true)
    public void disableInputFieldTest () {
        dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
        dynamicControlsPage.disableInputField();
        Assert.assertEquals(dynamicControlsPage.getInputFieldDisableMessage(), "It's disabled!");
    }
}
