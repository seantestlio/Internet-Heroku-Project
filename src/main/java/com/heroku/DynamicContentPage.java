package com.heroku;

import org.openqa.selenium.WebDriver;

public class DynamicContentPage extends BasePage  {

    public DynamicContentPage(WebDriver driver)  {
        super(driver);
    }

    public String getUrl()  {
        return "https://the-internet.herokuapp.com/dynamic_content";
    }

    public String getUrlAfterPageRefresh()  {
        return "https://the-internet.herokuapp.com/dynamic_content?with_content=static";
    }
}