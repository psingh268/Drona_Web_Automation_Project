package com.qa.TestCases;

import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.reports.ExtentLogger;

import junit.framework.Assert;

public class DronaLoginTestPage extends BaseTest{
	
		
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.lOGINPAGE)
	@Test(priority = 1 ,enabled = true , description = "Verify user signup Through mobile no.")
    public void verifyDronaSignUpThroughMobileNoTest() {
				
		dronaLoginPage.dronaMobileNoSignUp();	
		ExtentLogger.pass("Doctor signup done through mobile number.");
		
	}	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.lOGINPAGE)
	@Test(priority = 2 ,enabled = false , description="verify user signup through EmailId")
    public void verifyDronaSignUpThroughEmailIdTest() {
		
		dronaLoginPage.dronaEmailIdSignUp();	
		ExtentLogger.pass("Doctor signup done through email Id.");
		
	}
	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.lOGINPAGE)
	@Test(priority = 3 ,enabled = false , description="Verify forget password functionality for mobile no.")
	public void verifyForgetPasswordResetForMobileNoTest() {
		
		Assert.assertEquals(dronaLoginPage.verifyForgetPasswordMobileNo(), true);		
		ExtentLogger.pass("Doctor reset the password for mobile number user.");
		
	}
	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.lOGINPAGE)
	@Test(priority = 4 ,enabled = false , description="verify forget password functionality for MailId ")
	public void verifyForgetPasswordResetForEmailIdTest() {
		
		Assert.assertEquals(dronaLoginPage.verifyForgetPasswordemailId(), true);
		ExtentLogger.pass("Doctor reset the password for Email Id user.");
		
	}
	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.lOGINPAGE)
	@Test(priority = 5,enabled = false ,  description="verify user login Through mobile no.")
	public void verifyDronaLoginThroughMobileNoTest() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();	
		ExtentLogger.pass("Doctor login successfull through mobile number.");
		
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.lOGINPAGE)
	@Test(priority = 6,enabled = false , description = "verify User login through EmailId.")
	public void verifyDronaLoginThroughEmailIdTest() {
		
		dronaLoginPage.dronaLoginThroghMailId();
		ExtentLogger.pass("Doctor login successfull through mobile number.");
		
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.lOGINPAGE)
	@Test(priority = 7,enabled = false , description = "verify Logout Functionality.")
	public void verifyDronaLogoutTest() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();	
		Assert.assertEquals(dronaLoginPage.dronaDoctorSignOut(), true);		
		ExtentLogger.pass("Doctor logout successfully.");		
	}
	
	

}
