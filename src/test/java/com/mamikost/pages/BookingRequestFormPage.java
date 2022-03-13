package com.mamikost.pages;

import com.mamikost.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author regiewby on 13/03/22
 * @project technical-test-mamikost
 */
public class BookingRequestFormPage {

    WebDriver webDriver;
    SeleniumHelper seleniumHelper;

    public BookingRequestFormPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
        seleniumHelper = new SeleniumHelper(webDriver);
    }

    @FindBy(className = "bg-c-button booking-request-form__submit-btn hidden-xs bg-c-button--primary bg-c-button--lg bg-c-button--block")
    private WebElement btnSubmitRequestBooking;

    @FindBy(id = "bookingFormConfirmation")
    private WebElement cbAgreementLetter;

    @FindBy(className = "bg-c-button bg-c-button--primary bg-c-button--lg bg-c-button--block")
    private WebElement btnKirimPengajuan;


    public void clickBtnSubmitReqBooking(){
        seleniumHelper.scrollIntoView(btnSubmitRequestBooking);
        btnSubmitRequestBooking.click();
    }

    public void checkAgreementLetter(){
        cbAgreementLetter.click();
    }

    public void clickBtnKirimPengajuan(){
        seleniumHelper.waitUntilElementIsVisible(btnKirimPengajuan);
        btnKirimPengajuan.click();
    }
}
