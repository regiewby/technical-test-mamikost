package com.mamikost.steps;

import com.mamikost.factories.DriverFactory;
import com.mamikost.helpers.SeleniumHelper;
import com.mamikost.pages.BookingRequestFormPage;
import com.mamikost.pages.KostDetailPage;
import com.mamikost.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;

/**
 * @author regiewby on 12/03/22
 * @project technical-test-mamikost
 */
public class BookingKostStep {

    WebDriver webDriver = DriverFactory.getInstance().getDriver();
    KostDetailPage kostDetailPage = new KostDetailPage(webDriver);
    BookingRequestFormPage bookReqForm = new BookingRequestFormPage(webDriver);

    @Given("user logged in as a tenant with credential {string} and {string}")
    public void user_logged_in_as_a_tenant_with_credential_and(String string, String string2) throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginTenant(string, string2);
    }

    @Given("user navigates to kost Detail Page by url {string}")
    public void user_navigates_to_kost_detail_page_by_url(String string) {
        SeleniumHelper seleniumHelper = new SeleniumHelper(webDriver);
        seleniumHelper.goToUrl(string);
    }

    @When("user enters {string} into the text input checkin")
    public void user_enters_into_the_text_input_checkin(String string) throws InterruptedException {
        kostDetailPage.inputCheckinDate(string);
    }

    @When("user inputs {string} into DDL booking rent type")
    public void user_inputs_into_ddl_booking_rent_type(String string) {
        kostDetailPage.selectBookingRentType(string);
    }

    @When("user submit booking request")
    public void user_submit_booking_request() throws InterruptedException {
        kostDetailPage.clickBtnAjukanSewa();
    }

    @When("user submit booking request form")
    public void user_submit_booking_request_form() {
        bookReqForm.clickBtnSubmitReqBooking();
    }

    @When("user checks agreement letter on kost information page")
    public void user_checks_agreement_letter_on_kost_information_page() {
        bookReqForm.checkAgreementLetter();
    }

    @When("user clicks button kirim pengajuan ke pemilik")
    public void user_clicks_button_kirim_pengajuan_ke_pemilik() {
        bookReqForm.clickBtnKirimPengajuan();
    }

    @Then("user should be directed to booking success page")
    public void user_should_be_directed_to_booking_success_page() {
        System.out.println();
    }

    @Then("message {string} should be visible")
    public void message_should_be_visible(String string) {
        System.out.println(string);
    }

    @Then("button lihat status pengajuan should be visible")
    public void lihat_status_pengajuan_should_be_visible(String string) {
        System.out.println(string);
    }

    @Then("icon kamar penuh will be shown")
    public void icon_kamar_penuh_will_be_shown() {
        boolean isExist  = kostDetailPage.verifyIconFullyBooked();
        Assert.assertTrue(isExist);
    }

    @Then("modal login will be shown")
    public void modal_login_will_be_shown() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.verifyModalLoginIsExist();
    }
}
