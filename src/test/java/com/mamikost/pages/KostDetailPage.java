package com.mamikost.pages;

import com.mamikost.helpers.SeleniumHelper;
import com.mamikost.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * @author regiewby on 13/03/22
 * @project technical-test-mamikost
 */
public class KostDetailPage {

    WebDriver webDriver;
    SeleniumHelper seleniumHelper;

    public KostDetailPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
        seleniumHelper = new SeleniumHelper(webDriver);
    }

    @FindBy(className = "booking-input-checkin__input")
    private WebElement txtCheckinDate;

    @FindBy(className = "booking-rent-type__input")
    private WebElement ddlBookingRentType;

    @FindBy(xpath = "//div[@data-path='rdb_monthlyBookingOption']")
    private WebElement rdbMonthly;

    @FindBy(xpath = "//div[@data-path='rdb_weeklyBookingOption']")
    private WebElement rdbWeekly;

    @FindBy(xpath = "//div[@data-path='rdb_yearlyBookingOption']")
    private WebElement rdbAnually;

    @FindBy(className = "day__month_btn")
    private WebElement btnDayMonth;

    @FindBy(className = "cell day")
    private WebElement btnCellDay;

    @FindBy(xpath = "//div[@class='btn-item-secondary']")
    private WebElement btnAjukanSewa;

    @FindBy(xpath = "//div[@class='onboarding-ftue-content']")
    private WebElement modalNotif;

    @FindBy(xpath = "//a[@class='btn-secondary']")
    private WebElement btnSayaMengerti;

    @FindBy(xpath = "//div[@class='booking-input-checkin-modal__action']")
    private WebElement modalCheckin;

    @FindBy(xpath = "//div[@class='booking-input-checkin-modal__action']/button")
    private WebElement btnAjukanSewaOnModal;

    @FindBy(id = "optInText")
    private WebElement btnPushNotif;

    @FindBy(xpath = "//div[@class='detail-kost-overview__availability-icon']")
    private WebElement iconFullyBooked;

    @FindBy(xpath = "//*[@class='detail-kost-overview__availability-text--recommendation']")
    private WebElement labelMessageAvailability;

    public void verifyKostDetailPage() {
        seleniumHelper.waitUntilElementIsVisible(txtCheckinDate);
    }

    public void inputCheckinDate(String timeCondition) throws InterruptedException {
        Utility utility = new Utility();
        String localDateTime = utility.getDateTime("dd-MMM-yy", "tomorrow");
        String localDate = localDateTime.split("-")[0];

        seleniumHelper.scrollIntoView(txtCheckinDate);
        txtCheckinDate.click();
        Thread.sleep(1000);
        String dateLocator = "//span[contains(text(),'"+localDate+"')]/ancestor::div[@class='date-wrapper__cell-parent']";
        WebElement date = webDriver.findElement(By.xpath(dateLocator));
        seleniumHelper.waitUntilElementIsVisible(date);
        seleniumHelper.waitUntilElementIsClickable(date);
        date.click();
    }

    public void selectBookingRentType(String bookingRentType) {
        if (bookingRentType.equalsIgnoreCase("per bulan")) {
            rdbMonthly.click();

        } else if (bookingRentType.equalsIgnoreCase("per tahun")) {
            rdbAnually.click();

        } else if (bookingRentType.equalsIgnoreCase("per minggu")) {
            rdbWeekly.click();
        }
    }

    private void handleNotifModal(){
        if (modalNotif.isDisplayed()){
            btnSayaMengerti.click();
        }
    }

    private void handleModalCheckin(){
        if (modalCheckin.isDisplayed()){
            btnAjukanSewaOnModal.click();
        }
    }

    public Boolean verifyIconFullyBooked(){
        seleniumHelper.scrollIntoView(iconFullyBooked);
        String locator = "//div[@class='detail-kost-overview__availability-icon']";
        int size = webDriver.findElements(By.xpath(locator)).size();
        return size > 0;
    }

    public String verifyMessageFullyBooked(){
        return labelMessageAvailability.getText().trim();
    }

    public void clickBtnAjukanSewa() throws InterruptedException, AWTException {

        Thread.sleep(1000);
        handleNotifModal();
        btnPushNotif.click();
        seleniumHelper.scrollIntoView(btnAjukanSewa);
        seleniumHelper.waitUntilElementIsClickable(btnAjukanSewa);
        btnAjukanSewa.click();


        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F12);
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_F12);

        robot.keyPress(KeyEvent.VK_F12);
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_F12);

    }
}
