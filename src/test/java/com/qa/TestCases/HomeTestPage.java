package com.qa.TestCases;

import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.HomePage;
import com.qa.reports.ExtentLogger;

import junit.framework.Assert;

public class HomeTestPage extends BaseTest{
	
	    HomePage homePage;
		
		@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.HomePage)
		@Test(priority = 1 ,enabled = false , description = "Verify New Patient count is showing in new Enrollment.")
	    public void verifyNewPatientCount() {
			
			homePage = new HomePage(driver);
			dronaLoginPage.dronaLoginThroghMobileNo();
			Assert.assertEquals(homePage.newEnrollments(), true);
			ExtentLogger.pass("Enrollment counts get updated after new patient added.");
		}
		
		@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.HomePage)
		@Test(priority = 2 ,enabled = false , description = "Verify Todays Appointment counts get updated on new appointment Booking.")
	    public void verifyTodaysAppointmentCount() {
			
			homePage = new HomePage(driver);
			dronaLoginPage.dronaLoginThroghMobileNo();
			Assert.assertEquals(homePage.totalTodayAppointment(), true);
			ExtentLogger.pass("Appointment counts get updated on new new appointment booking.");
		}
		
		@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.HomePage)
		@Test(priority = 3 ,enabled = true , description = "Verify only active appointment counts should shown in live queue.")
	    public void verifyLiveQueueCount() {
			
			homePage = new HomePage(driver);
			dronaLoginPage.dronaLoginThroghMobileNo();
			Assert.assertEquals(homePage.liveQueue(), true);
			ExtentLogger.pass("Verify only active appointment counts should shown in live queue.");
		}

}
