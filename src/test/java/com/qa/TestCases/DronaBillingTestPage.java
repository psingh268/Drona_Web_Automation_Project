package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.BillingPage;
import com.qa.reports.ExtentLogger;

public class DronaBillingTestPage extends BaseTest{
	
	BillingPage billingPage;
	
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.BillingPage)
	@Test(priority = 1 ,enabled = true , description = "Verify Add new Item In Bill Page ")
    public void verifyNewBillItem() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		billingPage = new BillingPage(driver);
		Assert.assertEquals(billingPage.verifyNewAddItem(), true);
		ExtentLogger.pass("New item added in bill screen.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.BillingPage)
	@Test(priority = 2 ,enabled = true , description = "Verify Delete Item In Bill Page ")
    public void verifyBillItemDelete() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		billingPage = new BillingPage(driver);
		Assert.assertEquals(billingPage.verifyDeleteItem(), true);
		ExtentLogger.pass("New item deleted in bill screen.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.BillingPage)
	@Test(priority = 3 ,enabled = true , description = "Verify new bill created.")
    public void verifynewBillCreate() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		billingPage = new BillingPage(driver);
		Assert.assertEquals(billingPage.billGenerated(), true);
		
		ExtentLogger.pass("New Bill created or shown in billing screen.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.BillingPage)
	@Test(priority = 4 ,enabled = true , description = "Bill record and status changed to paid.")
    public void verifyrecordBill() {
		
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		billingPage = new BillingPage(driver);
		Assert.assertEquals(billingPage.billRecorded(), true);
		ExtentLogger.pass("Bill recorded and status changed to paid..");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.BillingPage)
	@Test(priority = 5 ,enabled = true , description = "Verify bill created in consult Page.")
    public void verifyConsultPageBillGenerate() {
		
	
		dronaLoginPage.dronaLoginThroghMobileNo();
		billingPage = new BillingPage(driver);
		billingPage.consultPageBillGenerate();
		ExtentLogger.pass("New Bill created or shown in billing screen.");
	}

	

}
