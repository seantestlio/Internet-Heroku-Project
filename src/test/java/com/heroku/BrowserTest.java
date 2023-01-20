package com.heroku;

import dataProvider.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserTest extends ConfigReader  {

    protected static RemoteWebDriver driver;
    protected static String platform = System.getenv("platform");
    protected static String browser = System.getenv("browser");
    protected static String operatingSystem = System.getenv("os");
    protected static String version = System.getenv("version");
//    protected static String platform = System.getProperty("platform");
//    protected static String browser = System.getProperty("browser");
//    protected static String operatingSystem = System.getProperty("os");
//    protected static String  version = System.getProperty("version");
    protected URL url = null;

    public void setBrowser ()  {
        if (platform.equalsIgnoreCase("sauceLabs"))  {

            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName(operatingSystem);
            browserOptions.setBrowserVersion(version);
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("build", "selenium-build-MJ68O");
            sauceOptions.put("test name", "The Internet - SauceLabsTest");
            browserOptions.setCapability("sauce:options", sauceOptions);

            try {
                url = new URL("https://oauth-qa.salesfloor-a49a6:e635969e-7e04-44fb-8cc2-a5958061d7d1@ondemand.us-west-1.saucelabs.com:443/wd/hub");
                driver = new RemoteWebDriver(url, browserOptions);
            } catch (MalformedURLException e)  {
                System.out.println(e.getMessage());
            }
        } else if (platform.equalsIgnoreCase("lambdaTest"))  {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName(operatingSystem);
            browserOptions.setBrowserVersion(version);
            HashMap<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("username", "thasnimj.jalal");
            ltOptions.put("accessKey", "vtqluZDU7sW2oB7xUOZKgPlW2wQQwgMrxq78P5otRYF86xV0q3");
            ltOptions.put("video", true);
            ltOptions.put("project", "The Internet - LambdaTest");
            ltOptions.put("name", "Test 1");
            ltOptions.put("selenium_version", "4.0.0");
            ltOptions.put("w3c", true);
            browserOptions.setCapability("LT:Options", ltOptions);

            try {
                url = new URL("https://thasnimj.jalal:vtqluZDU7sW2oB7xUOZKgPlW2wQQwgMrxq78P5otRYF86xV0q3@hub.lambdatest.com/wd/hub");
                driver = new RemoteWebDriver(url, browserOptions);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }

        } else if (platform.equalsIgnoreCase("local"))  {
            if (browser.equalsIgnoreCase("chrome"))  {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("firefox"))  {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("edge"))  {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

            } else {
                System.out.println("Chosen browser is unavailable");
            }
        }

        driver.manage().window().maximize();
        driver.get(getBaseURL());
    }

    @AfterSuite
    public void tearDown()  {
        System.out.println("Are we closing driver?");
        driver.close();
    }
}