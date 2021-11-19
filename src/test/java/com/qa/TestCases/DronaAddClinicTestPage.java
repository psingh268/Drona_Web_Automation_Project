package com.qa.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.DronaAddClinicPage;
import com.qa.reports.ExtentLogger;

public class DronaAddClinicTestPage extends BaseTest{
	
	DronaAddClinicPage dronaAddClinicPage;
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.CLINICADDPAGE)
	@Test(priority = 1 ,enabled = true , description = "Verify clinic setup page comes up after do signup.")
    public void verifyCreateClinicTest() {
		
		dronaAddClinicPage = new DronaAddClinicPage(driver);
		Assert.assertEquals(dronaAddClinicPage.addClinicInfoPageComeAfterDoSignUp(), true);
		ExtentLogger.pass("clinic setup page comes up after do signup");
	}	
	
}
	
/*
 * @FrameworkAnnotation(author= {"Praveen"},category =
 * CategoryType.CLINICADDPAGE)
 * 
 * @Test(priority = 2 ,enabled = false , description =
 * "Add Clinic functionality.") public void verifyAddClinicTest() {
 * 
 * dronaAddClinicPage = new DronaAddClinicPage(driver);
 * dronaLoginPage.dronaLoginThroghMobileNo(); dronaAddClinicPage.addnewClinic();
 * ExtentLogger.pass("Clinic Added successfully."); }
 * 
 * @FrameworkAnnotation(author= {"Praveen"},category =
 * CategoryType.CLINICADDPAGE)
 * 
 * @Test(priority = 3 ,enabled = false , description = "create multiple clinic")
 * public void verifymultipleClinicTest() {
 * 
 * dronaAddClinicPage = new DronaAddClinicPage(driver); //
 * dronaLoginPage.dronaLoginThroghMailId();
 * dronaAddClinicPage.addMultipleClinic();
 * ExtentLogger.pass("Clinic created successfully."); }
 * 
 * @FrameworkAnnotation(author= {"Ritu"},category = CategoryType.CLINICADDPAGE)
 * 
 * @Test(priority = 4 ,enabled = true , description =
 * "Verify clinic name updated successfully.") public void
 * verifyEditClinicNameTest() {
 * 
 * dronaAddClinicPage = new DronaAddClinicPage(driver); //
 * dronaLoginPage.dronaLoginThroghMobileNo();
 * Assert.assertEquals(dronaAddClinicPage.verifyClinicNameEdit(), true);
 * ExtentLogger.pass("Clinic Name edited successfully."); }
 * 
 * @FrameworkAnnotation(author= {"Ritu"},category = CategoryType.CLINICADDPAGE)
 * 
 * @Test(priority = 5 ,enabled = true , description =
 * "Verify clinic Primary number updated.") public void
 * verifyEditPrimaryNumberTest() {
 * 
 * dronaAddClinicPage = new DronaAddClinicPage(driver); //
 * dronaLoginPage.dronaLoginThroghMobileNo();
 * Assert.assertEquals(dronaAddClinicPage.verifyClinicPrimaryNumberEdit(),
 * true); ExtentLogger.pass("Primary Number edited successfully."); }
 * 
 * @FrameworkAnnotation(author= {"Ritu"},category = CategoryType.CLINICADDPAGE)
 * 
 * @Test(priority = 6 ,enabled = true , description =
 * "Verify clinic Number updated.") public void verifyEditClinicNumberTest() {
 * 
 * dronaAddClinicPage = new DronaAddClinicPage(driver); //
 * dronaLoginPage.dronaLoginThroghMobileNo();
 * Assert.assertEquals(dronaAddClinicPage.verifyClinicClinicNumberEdit(), true);
 * ExtentLogger.pass("Clinic Number edited successfully."); }
 * 
 * @FrameworkAnnotation(author= {"Ritu"},category = CategoryType.CLINICADDPAGE)
 * 
 * @Test(priority = 7 ,enabled = false , description =
 * "Verify PinCode, City and Status updated.") public void
 * verifyEditAddressTest() {
 * 
 * dronaAddClinicPage = new DronaAddClinicPage(driver);
 * dronaLoginPage.dronaLoginThroghMobileNo();
 * 
 * Assert.assertEquals(dronaAddClinicPage.verifyClinicClinicNumberEdit(), true);
 * ExtentLogger.pass("Clinic Number edited successfully."); } }
 */
