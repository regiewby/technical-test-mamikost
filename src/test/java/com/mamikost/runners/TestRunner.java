package com.mamikost.runners;

import com.mamikost.factories.BrowserFactory;
import com.mamikost.factories.DriverFactory;
import com.mamikost.utilities.PropertiesOps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

/**
 * @author regiewby on 12/03/22
 * @project technical-test-mamikost
 */

@CucumberOptions(
        features = "features",
        glue={"com.mamikost.steps"},
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-report.json"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Parameters("browserType")
    @BeforeMethod
    public void setupBrowser(String browserType) {
        String url = PropertiesOps.getPropertyValueByKey("BASE_URL");
        BrowserFactory bf = new BrowserFactory();

        DriverFactory.getInstance().setDriver(bf.launchBrowser(browserType));
        WebDriver webDriver = DriverFactory.getInstance().getDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
    }

    @AfterMethod
    public void teardownBrowser() {
        DriverFactory.getInstance().closeBrowser();
    }
}