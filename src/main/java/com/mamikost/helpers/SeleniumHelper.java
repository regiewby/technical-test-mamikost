package com.mamikost.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author regiewby on 13/03/22
 * @project technical-test-mamikost
 */
public class SeleniumHelper {

    WebDriver webDriver;
    public SeleniumHelper(WebDriver driver) {
        this.webDriver = driver;
    }

    public void waitUntilElementIsVisible(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementIsClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void goToUrl(String url){
        webDriver.navigate().to(url);
    }

    public void scrollIntoView(WebElement target){
        JavascriptExecutor je = (JavascriptExecutor) webDriver;
        je.executeScript("arguments[0].scrollIntoView(true);",target);
    }

    public Boolean elementShouldBeExistOnPage(WebElement webElement){
       int size = webDriver.findElements((By) webElement).size();
        return size > 0;
    }

}
