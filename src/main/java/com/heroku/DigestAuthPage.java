package com.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigestAuthPage extends BasePage  {

    protected String userName = "admin";
    protected String password = "admin";
    protected String url = "https://" + userName + ":"  + password
                            + "@the-internet.herokuapp.com/digest_auth";

    public DigestAuthPage (WebDriver driver)  {
        super(driver);
    }

    public String getPageHeader()  {
        driver.get(url);
        return driver.findElement(By.cssSelector("#content > div > p")).getText();
    }
}