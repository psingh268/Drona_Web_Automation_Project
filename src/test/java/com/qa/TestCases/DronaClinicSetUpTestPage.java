package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.DronaClinicSetUpPage;

import io.qameta.allure.Description;

public class DronaClinicSetUpTestPage extends BaseTest {

	DronaClinicSetUpPage dronaClinicSetUpPage;

	/*
	 * @FrameworkAnnotation(author = { "Praveen" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Test(priority = 1, enabled = false, description =
	 * "verify day toggle is getting ON/Off on click") public void
	 * verifyDaySwitchTest() {
	 * 
	 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
	 * dronaLoginPage.dronaLoginThroghMobileNo();
	 * dronaClinicSetUpPage.editClinicBtnClk();
	 * dronaClinicSetUpPage.inClincTimingSetUpBtnClk();
	 * dronaClinicSetUpPage.verifyDaySwitch(); }
	 * 
	 * @FrameworkAnnotation(author = { "Praveen" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Test(priority = 2, enabled = false, description =
	 * "On copy to all click time should be copied on all open days.") public void
	 * verifyCopyToAllTimeForOpenDay() {
	 * 
	 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
	 * dronaLoginPage.dronaLoginThroghMobileNo();
	 * dronaClinicSetUpPage.editClinicBtnClk();
	 * dronaClinicSetUpPage.virtualTimingSetUpBtnClk();
	 * dronaClinicSetUpPage.verifyDaySwitch();
	 * dronaClinicSetUpPage.setTimeToscheduleSetup("10:00 AM","11:00 PM"); String[]
	 * MondaySetTime = dronaClinicSetUpPage.verifyCopyToAllfunctionality();
	 * Assert.assertEquals(MondaySetTime[0], "10");
	 * Assert.assertEquals(MondaySetTime[1], "11"); }
	 * 
	 * @FrameworkAnnotation(author = { "Praveen" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Test(priority = 3, enabled = false, description =
	 * "InClinic time setup scheduled successfully.") public void
	 * verifyInClinicSetUp() {
	 * 
	 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
	 * dronaLoginPage.dronaLoginThroghMobileNo();
	 * dronaClinicSetUpPage.editClinicBtnClk();
	 * dronaClinicSetUpPage.firstinClincTimingSetUpBtnClk();
	 * dronaClinicSetUpPage.verifyDaySwitch();
	 * dronaClinicSetUpPage.setTimeToscheduleSetup("08:00 AM","07:00 PM");
	 * dronaClinicSetUpPage.copyTimeForAllDay();
	 * dronaClinicSetUpPage.selectDateFromDatePicker();
	 * dronaClinicSetUpPage.EnterSlotOrFeeDetail();
	 * dronaClinicSetUpPage.followUpValidDays(); dronaClinicSetUpPage.SetUpSave(); }
	 * 
	 * @FrameworkAnnotation(author = { "Ritu" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Description("verify Duplicate InClinic Timing")
	 * 
	 * @Test(priority = 9, enabled = false, description =
	 * "verify Duplicate InClinic Timing") public void
	 * verifyDuplicateInClinicTiming() {
	 * 
	 * 
	 * dronaLoginPage.dronaLoginThroghMobileNo(); dronaClinicSetUpPage = new
	 * DronaClinicSetUpPage(driver);
	 * Assert.assertEquals(dronaClinicSetUpPage.verifyduplicateClinictime(), true);
	 * 
	 * }
	 * 
	 * @FrameworkAnnotation(author = { "Ritu" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Description("Verify Different Clinic and Doctor Timeing Validation")
	 * 
	 * @Test(priority = 10, enabled = false, description =
	 * "Verify Different Clinic and Doctor Timing Validation") public void
	 * verifyDifferentClinicandDocTimeingValidation() {
	 * 
	 * 
	 * dronaLoginPage.dronaLoginThroghMobileNo(); dronaClinicSetUpPage = new
	 * DronaClinicSetUpPage(driver);
	 * Assert.assertEquals(dronaClinicSetUpPage.VerifyClinicDocTimeValidation(),
	 * true); }
	 * 
	 * @FrameworkAnnotation(author = { "Praveen" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Test(priority = 5, enabled = false, description =
	 * "Verify date period edit functionality") public void
	 * verifyInclinicScheduleDatePeriodEdit() {
	 * 
	 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
	 * dronaLoginPage.dronaLoginThroghMobileNo();
	 * dronaClinicSetUpPage.editClinicBtnClk();
	 * Assert.assertEquals(dronaClinicSetUpPage.editDatePeriod(), true);
	 * 
	 * }
	 * 
	 * @FrameworkAnnotation(author = { "Praveen" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Test(priority = 6 ,enabled = true , description =
	 * "Verify slot length edit functionality.") public void
	 * verifyInclinicSlotLengthEdit() {
	 * 
	 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
	 * dronaLoginPage.dronaLoginThroghMobileNo();
	 * dronaClinicSetUpPage.editClinicBtnClk();
	 * Assert.assertEquals(dronaClinicSetUpPage.editSlotLength(), true);
	 * 
	 * }
	 * 
	 * @FrameworkAnnotation(author = { "Praveen" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Test(priority = 4, enabled = false, description =
	 * "Virtual time setup scheduled successfully.") public void
	 * verifyvirtualScheduleSetUp() {
	 * 
	 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver); //
	 * dronaLoginPage.dronaLoginThroghMobileNo();
	 * dronaClinicSetUpPage.editClinicBtnClk();
	 * dronaClinicSetUpPage.firstvirtualTimingSetUpBtnClk();
	 * dronaClinicSetUpPage.verifyDaySwitch();
	 * dronaClinicSetUpPage.setTimeToscheduleSetup("08:30 PM","09:00 PM");
	 * dronaClinicSetUpPage.copyTimeForAllDay();
	 * dronaClinicSetUpPage.selectDateFromDatePicker();
	 * dronaClinicSetUpPage.EnterSlotOrFeeDetail();
	 * dronaClinicSetUpPage.followUpValidDays(); dronaClinicSetUpPage.SetUpSave(); }
	 * 
	 * 
	 * 
	 * @FrameworkAnnotation(author = { "Praveen" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Test(priority = 7 ,enabled = false , description =
	 * "Verify consulation fee edit functionality.") public void
	 * verifyConsulationFeeEdit() {
	 * 
	 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
	 * dronaLoginPage.dronaLoginThroghMailId();
	 * dronaClinicSetUpPage.editClinicBtnClk();
	 * Assert.assertEquals(dronaClinicSetUpPage.editConsulationFee(), true); }
	 * 
	 * @FrameworkAnnotation(author = { "Praveen" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Test(priority = 8 ,enabled = false , description =
	 * "Verify followUp fee edit functionality.") public void
	 * verifyFollowUpFeeEdit() {
	 * 
	 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
	 * dronaLoginPage.dronaLoginThroghMailId();
	 * dronaClinicSetUpPage.editClinicBtnClk();
	 * Assert.assertEquals(dronaClinicSetUpPage.editFollowUpFee(), true); }
	 * 
	 * @FrameworkAnnotation(author = { "Ritu" }, category =
	 * CategoryType.CLINICSETUPPAGE)
	 * 
	 * @Description("Verify New Slot validation in editing same card if Appointment Exist for Current card"
	 * )
	 * 
	 * @Test(priority = 11, enabled = false, description =
	 * "Verify New Slot validation in editing same card if Appointment Exist for Current card"
	 * ) public void verifyNewSlotValidation() {
	 * 
	 * 
	 * dronaLoginPage.dronaLoginThroghMobileNo(); dronaClinicSetUpPage = new
	 * DronaClinicSetUpPage(driver);
	 * Assert.assertEquals(dronaClinicSetUpPage.verifyNewCardSlotValidation(),
	 * true); }
	 */
 
}
