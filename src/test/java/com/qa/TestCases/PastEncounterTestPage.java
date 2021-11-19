package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.PastEncounterPage;
import com.qa.reports.ExtentLogger;

public class PastEncounterTestPage extends BaseTest{
	
	PastEncounterPage pastEncounterPage;
	
	/*
	 * @FrameworkAnnotation(author= {"Praveen"},category =
	 * CategoryType.AppointmentBooking)
	 * 
	 * @Test(priority = 1 ,enabled = true , description =
	 * "Verify Repeat Functionality in Past Encounter.") public void
	 * verifyPastEncounterRepeat() {
	 * 
	 * dronaLoginPage.dronaLoginThroghMobileNo(); pastEncounterPage = new
	 * PastEncounterPage(driver);
	 * Assert.assertEquals(pastEncounterPage.verifyPastEncounterDuplicate(), true);
	 * ExtentLogger.pass("Repeat Functionality in Past Encounter."); }
	 */
}
