package com.mamikost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author regiewby on 12/03/22
 * @project technical-test-mamikost
 */
public class LoginPage {

    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[@class='nav-login-button']")
    private WebElement btnMasuk;

    @FindBy(xpath = "//img[@alt='login-tenant']")
    private WebElement btnPencariKos;

    @FindBy(name = "Nomor Handphone")
    private WebElement txtNomorHandphone;

    @FindBy(name = "Password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary btn-mamigreen login-button track-login-tenant']")
    private WebElement btnLogin;

    @FindBy(xpath = "//div/img[@alt='login-tenant']")
    private WebElement imgTenant;

    @FindBy(xpath = "//div[@class='form-login login-modal__body']")
    private WebElement modalLogin;

    public void loginTenant(String phoneNumber, String password) throws InterruptedException {
        btnMasuk.click();
        imgTenant.click();
        txtNomorHandphone.sendKeys(phoneNumber);
        txtPassword.sendKeys(password);
        btnLogin.click();
        Thread.sleep(3000);
    }

    public void verifyModalLoginIsExist(){
        Boolean isExist =  modalLogin.isDisplayed();
        Assert.assertTrue(modalLogin.isDisplayed());
    }
}
