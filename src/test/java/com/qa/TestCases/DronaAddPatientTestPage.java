package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.DronaAddPatientPage;
import com.qa.reports.ExtentLogger;

public class DronaAddPatientTestPage extends BaseTest{
	
    DronaAddPatientPage dronaAddPatientPage;
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ADDPATIENT)
	@Test(priority = 1 ,enabled = false , description = "Verify create new patient functionality.")
    public void verifyCreateNewPatient() {
		
		dronaAddPatientPage = new DronaAddPatientPage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaAddPatientPage.openPatientPage();
		dronaAddPatientPage.createNewPatient();
		ExtentLogger.pass("New Patient added successfully.");
	}	
    
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ADDPATIENT)
	@Test(priority = 2 ,enabled = true , description = "Verify new create patient view in patient List.")
    public void verifyNewPatientViewInPatientList() {
		
		dronaAddPatientPage = new DronaAddPatientPage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();
		Assert.assertEquals(dronaAddPatientPage.newPatientShowInList(), true);
		ExtentLogger.pass("New Patient shown in patient list .");
	}	
}
