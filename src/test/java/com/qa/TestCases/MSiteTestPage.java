package com.qa.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.MsitePage;
import com.qa.reports.ExtentLogger;

public class MSiteTestPage extends BaseTest{
	
    MsitePage msitepage;
    
    
	
    @FrameworkAnnotation(author= {"Praveen"},category = CategoryType.MSite)
	@Test(priority = 1 ,enabled = true , description = "M-Site Url launched")
    public void verifylaunchTheMsiteUrl() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		msitepage = new MsitePage(driver);
		msitepage.copyMsiteLink();
		msitepage.launchUrl();
		String title = driver.getTitle();
        assertEquals(title, "DrOnAPatientMsite");
		ExtentLogger.pass("M-site Url launched Successfully");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.MSite)
	@Test(priority = 2 ,enabled = true , description = "Veirfy Patient Login On M-site Url"/*, dependsOnMethods = { "verifylaunchTheMsiteUrl" }*/)
    public void verifypatientLoginMsite() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		msitepage = new MsitePage(driver);
		msitepage.launchUrl();
		assertEquals(msitepage.patientFirstTimeLogin(), true);	 
		ExtentLogger.pass("Patient Login successfull");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.MSite)
	@Test(priority = 3 ,enabled = true , description = "Veirfy Add new Self Patient"/*, dependsOnMethods = { "verifylaunchTheMsiteUrl" }*/)
    public void verifyaddSelfpatient() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		msitepage = new MsitePage(driver);
		msitepage.launchUrl();
		assertEquals(msitepage.addNewSelfPatient(), true);	 
		ExtentLogger.pass("Patient Added successfull");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.MSite)
	@Test(priority = 4 ,enabled = true , description = "Veirfy Add new Relative Patient"/*, dependsOnMethods = { "verifylaunchTheMsiteUrl" }*/)
    public void verifyaddRelativepatient() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		msitepage = new MsitePage(driver);
		msitepage.launchUrl();
		assertEquals(msitepage.addNewRelativePatient(), true);	 
		ExtentLogger.pass("Relative Patient Added successfull");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.MSite)
	@Test(priority = 5 ,enabled = true , description = "Verify In-Clinic Appointment Booking.")
    public void verifyInClinicAppointmentBooking() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		msitepage = new MsitePage(driver);
		msitepage.launchUrl();
		assertEquals(msitepage.inClinicAppointmentBooking(), true);	 		
		ExtentLogger.pass("Appointment Booked successfully and shown in appointment list.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.MSite)
	@Test(priority = 5 ,enabled = true , description = "Verify Virtual Appointment Booking.")
    public void verifyVirtualAppointmentBooking() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		msitepage = new MsitePage(driver);
		msitepage.launchUrl();
		msitepage.virtualAppointmentBooking();	
		ExtentLogger.pass("Virtual Appointment Booked successfully.");
	}


}
