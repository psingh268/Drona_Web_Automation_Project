package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.DronaQRCodePage;
import com.qa.reports.ExtentLogger;

public class QrCodeTestPage extends BaseTest{
	
	DronaQRCodePage dronaQRCodePage;

	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.QrCode)
	@Test(priority = 1 ,enabled = false , description = "verify Patient login successfully and add patient patient page comes up")
    public void verifyPatientLoginFirstTimeTroughQrCode() {
		
		dronaLoginPage.dronaLoginQRCodeUser();
		dronaQRCodePage = new DronaQRCodePage(driver);
		dronaQRCodePage.launchUrl();
		Assert.assertEquals(dronaQRCodePage.qrCodeLogin(), true);
		ExtentLogger.pass("Patient login successfull and add patient patient page comes up.");
	}	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.QrCode)
	@Test(priority = 2 ,enabled = false , description = "verify Self Patient Created")
    public void verifySelfPatientCreate() {
		
		dronaLoginPage.dronaLoginQRCodeUser();
		dronaQRCodePage = new DronaQRCodePage(driver);
		dronaQRCodePage.launchUrl();
		Assert.assertEquals(dronaQRCodePage.addNewSelfPatient(), true);
		ExtentLogger.pass("New Self Patient Created.");
	}	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.QrCode)
	@Test(priority = 3 ,enabled = true , description = "verify Relative Patient Created")
    public void verifyRelativePatientCreate() {
		
		dronaLoginPage.dronaLoginQRCodeUser();
		dronaQRCodePage = new DronaQRCodePage(driver);
		dronaQRCodePage.launchUrl();
		Assert.assertEquals(dronaQRCodePage.addNewPatientRelative(), true);
		ExtentLogger.pass("New Relative Patient Created.");
	}	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.QrCode)
	@Test(priority = 4 ,enabled = true , description = "verify patient walkinBooking.")
    public void verifyPatientWalkinBooking() {
		
		dronaLoginPage.dronaLoginQRCodeUser();
		dronaQRCodePage = new DronaQRCodePage(driver);
		dronaQRCodePage.launchUrl();
		Assert.assertEquals(dronaQRCodePage.walkinBooking(), true);
		ExtentLogger.pass("New Relative Patient Created.");
	}	
}
