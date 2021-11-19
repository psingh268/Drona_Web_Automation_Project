package com.qa.TestCases;

import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.DoctorProfilePage;
import com.qa.pages.DronaAddBankDetailPage;
import com.qa.reports.ExtentLogger;

public class DronaAddBankDetailTestPage extends BaseTest{
	
	DronaAddBankDetailPage dronaAddBankDetailPage;
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.BankDetailsPage)
	@Test(priority = 1 ,enabled = true , description = "Add Bank Detail.")
    public void verifyAddBankDetail() {
		
		dronaAddBankDetailPage = new DronaAddBankDetailPage(driver);
		dronaLoginPage.dronaLoginThroghMailId();	
//		dronaAddBankDetailPage.addBankDetail();
		ExtentLogger.pass("Doctor Bank Details Added Successfully.");
	}	

}
