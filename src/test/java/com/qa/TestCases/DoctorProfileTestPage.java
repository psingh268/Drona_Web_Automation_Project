package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.DoctorProfilePage;
import com.qa.reports.ExtentLogger;

public class DoctorProfileTestPage extends BaseTest {
	
	DoctorProfilePage doctorProfilePage;
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 1 ,enabled = true , description = "Add Doctor About Info.")
    public void verifyAboutInfoTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();	
		doctorProfilePage.addAboutInfo();
		ExtentLogger.pass("Doctor About Info Added Successfully.");
	}	
    
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 2 ,enabled = true , description = "Add Doctor Experience Info.")
    public void verifyExperienceAddTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();	
		doctorProfilePage.addExperienceInfo();
		ExtentLogger.pass("Doctor Experience  Info Added Successfully.");
	}	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 3 ,enabled = true , description = "Add Education Info.")
    public void verifyEducationAddTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();	
		doctorProfilePage.addEducationInfo();
		ExtentLogger.pass("Doctor Education  Info Added Successfully.");
	}	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 4 ,enabled = true , description = "Add Specialization Info.")
    public void verifySpecializationAddTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();	
		doctorProfilePage.addSpecialization(1);
		ExtentLogger.pass("Doctor Specialization  Info Added Successfully.");
	}	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 5 ,enabled = true , description = "Add Services Info.")
    public void verifyServicesAddTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();	
		doctorProfilePage.addServices(1);
		ExtentLogger.pass("Doctor Services  Info Added Successfully.");
	}	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 6 ,enabled = true , description = "Add Award Info.")
    public void verifyAwardAddTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();	
		doctorProfilePage.addAwardAndRecognitionInfo();
		ExtentLogger.pass("Doctor Award  Info Added Successfully.");
	}	
	
	@FrameworkAnnotation(author= {"Ritu"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 7 ,enabled = true , description = "Delete Experience Info")
    public void verifyDeletedExperienceInfoTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();	
		//Assert.assertEquals(doctorProfilePage.deleteExperience(), true);
		doctorProfilePage.deleteExperience();
		ExtentLogger.pass("Experience  Info Deleted Successfully.");
	}	

	@FrameworkAnnotation(author= {"Ritu"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 8 ,enabled = true , description = "Delete Education Info")
    public void verifyDeletedEducationInfoTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();
		doctorProfilePage.deleteEducation();
		ExtentLogger.pass("Education  Info Deleted Successfully.");
	}	
	
	@FrameworkAnnotation(author= {"Ritu"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 9 ,enabled = true , description = "Delete Awards and Recognition Info")
    public void verifyDeletedAwardsRecognitionInfoTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();
		doctorProfilePage.deleteAwardsRecognitionInfo();
		ExtentLogger.pass("Awards and Recognition Info Deleted Successfully.");
	}	
	
	@FrameworkAnnotation(author= {"Ritu"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 9 ,enabled = true , description = "Delete Specialization Info")
    public void verifyDeletedSpecializationInfoTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();
		doctorProfilePage.deleteSpecializationInfo();
		ExtentLogger.pass("Specialization Info Deleted Successfully.");
	}	
	
	@FrameworkAnnotation(author= {"Ritu"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 10 ,enabled = true , description = "verify Change Password")
    public void verifyChangePasswordTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();
		Assert.assertEquals(doctorProfilePage.ChangePassword(), true);
		ExtentLogger.pass("Password Changed Successfully");
	}	
	

	@FrameworkAnnotation(author= {"Ritu"},category = CategoryType.DoctorProfilePage)
	@Test(priority = 11 ,enabled = true , description = "verify confirm Password Validation")
    public void verifyconfirmPasswordValidationTest() {
		
		doctorProfilePage = new DoctorProfilePage(driver);
		dronaLoginPage.dronaLoginThroghMobileNo();
		Assert.assertEquals(doctorProfilePage.ChangePasswordValidation(), true);
		ExtentLogger.pass("Confirm password validation is visible successfully");
	}	
	
	
	  @FrameworkAnnotation(author= {"Ritu"},category = CategoryType.DoctorProfilePage)
	  @Test(priority = 12 ,enabled = true , description ="verify old password Validation")
	  public void verifyOldPasswordValidationTest() {
	  doctorProfilePage = new DoctorProfilePage(driver);
	  dronaLoginPage.dronaLoginThroghMobileNo();
	  String ToastMessage = doctorProfilePage.oldPasswordValidation();
	  Assert.assertEquals(ToastMessage, "Old Password does not match.");
	  ExtentLogger.pass("Old password validation is visible successfully"); }
	 
}
