package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.AppointmentBookingPage;
import com.qa.reports.ExtentLogger;

public class BookAppointmentTestPage extends BaseTest{
	
	AppointmentBookingPage appointmentBookingPage;
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 1 ,enabled = false , description = "Verify Booked appointment is shown in booked appointment list.")
    public void verifyAppointmentBooking() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		Assert.assertEquals(appointmentBookingPage.AppointmentBookingByHeadMenu(), true);
		ExtentLogger.pass("Booked appointment is shown in appointment list.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 2 ,enabled = false , description = "Verify Booked appointment count.")
    public void verifyBookedAppointmentCount() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		Assert.assertEquals(appointmentBookingPage.VerifyappointmentBookingCount(), true);
		ExtentLogger.pass("Booked appointment is shown in appointment list.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 3 ,enabled = false , description = "Verify Booked appointment Slot is in disable mode.")
    public void verifyBookedAppointmentSlot() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		Assert.assertEquals(appointmentBookingPage.verifyBookedSlot(), true);
		ExtentLogger.pass("Booked appointments are in disable mode.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 4 ,enabled = false , description = "Verify virtual Appointment booking")
    public void verifyVirtualAppointmentBooking() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		Assert.assertEquals(appointmentBookingPage.AppointmentBookingVirtual(), true);
		ExtentLogger.pass("Virtual Appointment Booked successfully");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 5 ,enabled = false , description = "Verify Re-Schedule Appointment booking")
    public void verifyRescheduleAppointmentBooking() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		Assert.assertEquals(appointmentBookingPage.rescheduleAppointment(), true);		
		ExtentLogger.pass(" Appointment Re-shedule successfully");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 6 ,enabled = false , description = "Verify Walkin booked successfully.")
    public void verifyWalkinBooking() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		Assert.assertEquals(appointmentBookingPage.walkinBooking(), true);
		ExtentLogger.pass("Verify Walkin booked successfully.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 7 ,enabled = false , description = "Verify Cancel appointment.")
    public void verifyCancelAppointment() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		Assert.assertEquals(appointmentBookingPage.cancelAppointment(), true);
		ExtentLogger.pass("Verify appointment canceled successfully.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 8 ,enabled = false , description = "Verify Only Enable Slots are selectable for Appointment.")
    public void verifyEnableSLotSelectable() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		appointmentBookingPage.AppointmentMenuClick();
		appointmentBookingPage.headBookAppointmentClick();
		appointmentBookingPage.bookSlot(1);
		ExtentLogger.pass("Verify Slot selected successfully.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 9 ,enabled = false , description = "Verify Checked In Appointment.")
    public void verifyCheckedInAppointment() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		appointmentBookingPage.AppointmentMenuClick();
		appointmentBookingPage.checkedInAppointment();
		ExtentLogger.pass("Verify Appointment CheckIn Successfully.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.AppointmentBooking)
	@Test(priority = 10 ,enabled = true , description = "Verify Appointment reorder functionality.")
    public void verifyReorderAppointment() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		appointmentBookingPage.AppointmentMenuClick();
		appointmentBookingPage.reorderFunctionality();
		ExtentLogger.pass("Appointment reordered Successfully.");
	}

}
