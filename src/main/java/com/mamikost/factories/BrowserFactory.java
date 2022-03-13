package com.mamikost.factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author regiewby on 12/03/22
 * @project technical-test-mamikost
 */
public class BrowserFactory {

    public WebDriver launchBrowser(String browser) {

        WebDriver webDriver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
//            chromeOptions.addArguments("--auto-open-devtools-for-tabs");
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("headless chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("disable-gpu");
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            webDriver = new FirefoxDriver(options);
            webDriver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("headless firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("disable-gpu");
            webDriver = new FirefoxDriver(options);
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }
}