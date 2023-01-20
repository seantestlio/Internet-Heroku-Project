package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList extends BasePage {

    public DropDownList(WebDriver driver) {
        super(driver);
    }

    public String selectOption1InDropDownList() {
        pauseScreen();
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByIndex(1);
        String option = dropDown.getFirstSelectedOption().getText();
        pauseScreen();
        return option;

    }

    public String selectOption2InDropDownList() {
        pauseScreen();
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByIndex(2);
        String option = dropDown.getFirstSelectedOption().getText();
        pauseScreen();
        return option;
    }

    public void pauseScreen() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
