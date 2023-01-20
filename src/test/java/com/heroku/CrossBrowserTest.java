package com.heroku;
import dataProvider.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;
public class CrossBrowserTest extends ConfigReader  {

    protected static WebDriver driver;
//    protected static String platform = System.getenv("platform");
//    protected static String browser = System.getenv("browser");
//    protected static String operatingSystem = System.getenv("os");
//    protected static String  version = System.getenv("version");
    protected static String platform = System.getProperty("platform");
    protected static String browser = System.getProperty("browser");
    protected static String operatingSystem = System.getProperty("os");
    protected static String  version = System.getProperty("version");
    protected URL url;
    @BeforeSuite
    public void browserSetup () {
        if (platform.equalsIgnoreCase("sauceLab")) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                if (browser.equalsIgnoreCase("safari")) {
                    caps.setCapability("browserName", "safari");
                    caps.setCapability("version", version);
                } else {
                    caps.setCapability("browserName", browser);
                    caps.setCapability("version", version);
                }
                caps.setCapability("platform", operatingSystem);
                caps.setCapability("name", "Internet Project");

                url = new URL("https://" + getSauceLabUserName() +":"+ getSauceLabAccessKey() + getSauceLabUrl());
                driver = new RemoteWebDriver(url, caps);
                driver.get("https://the-internet.herokuapp.com/");
            } catch(MalformedURLException e){
                throw new RuntimeException(e);
            }
        } else if (platform.equalsIgnoreCase("LambdaTest")) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                if (browser.equalsIgnoreCase("safari")) {
                    capabilities.setCapability("browserName", "safari");
                    capabilities.setCapability("version", version);
                } else {
                    capabilities.setCapability("browserName", browser);
                    capabilities.setCapability("version", version);
                }
                capabilities.setCapability("platform", operatingSystem);
                capabilities.setCapability("build", "Internet Project 1.0");
                capabilities.setCapability("name", "Internet Project");
                driver = new RemoteWebDriver(new URL("https://" + getLambdaTestUserName() + ":" + getLambdaTestAccessKey() + getLambdaURL()), capabilities);
                driver.get("https://the-internet.herokuapp.com/");
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (platform.equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        } else {
            System.out.println("Browser is not supported");
            return;
        }
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("Are we closing driver?");
        driver.quit();
    }
}
