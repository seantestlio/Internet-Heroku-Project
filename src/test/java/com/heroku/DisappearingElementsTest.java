package com.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DisappearingElementsTest extends CrossBrowserTest {

    @BeforeClass
    public void beforeClass() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void isGalleryTabPresentTest (){
        driver.findElement(By.cssSelector("#content > ul > li:nth-child(9) > a")).click();
        DisappearingElementsPage disappearingElementsPage = PageFactory.initElements(driver, DisappearingElementsPage.class);
        try {
            Assert.assertTrue(disappearingElementsPage.isGalleryTabPresent());
        } catch (NoSuchElementException e) {
            System.out.println("Gallery Tab is not present");
        }
    }
}
