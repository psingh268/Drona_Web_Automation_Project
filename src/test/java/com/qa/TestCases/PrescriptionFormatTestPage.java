package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.PrescriptionFormatPage;
import com.qa.reports.ExtentLogger;

public class PrescriptionFormatTestPage extends BaseTest{
	
	PrescriptionFormatPage prescriptionFormatPage;
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.PrescriptionFormat)
	@Test(priority = 1 ,enabled = true , description = "Verify Symptoms are showing in prescription format form. ")
    public void verifySymptomsInPrescriptionFormat() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		prescriptionFormatPage = new PrescriptionFormatPage(driver);
		Assert.assertEquals(prescriptionFormatPage.verifySymptoms(), true);	
		ExtentLogger.pass("Symptoms are showing in prescription format form");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.PrescriptionFormat)
	@Test(priority = 2 ,enabled = true , description = "Verify examination finding are showing in prescription format form. ")
    public void verifyExaminiationFindingInPrescriptionFormat() {
		
	//	dronaLoginPage.dronaLoginThroghMobileNo();
		prescriptionFormatPage = new PrescriptionFormatPage(driver);
		Assert.assertEquals(prescriptionFormatPage.verifyExaminationFinding(), true);	
		ExtentLogger.pass("examination finding are showing in prescription format form.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.PrescriptionFormat)
	@Test(priority = 3 ,enabled = true , description = "Verify medicine are showing in prescription format form. ")
    public void verifyMedicineInPrescriptionFormat() {
		
	//	dronaLoginPage.dronaLoginThroghMobileNo();
		prescriptionFormatPage = new PrescriptionFormatPage(driver);
		Assert.assertEquals(prescriptionFormatPage.verifyMedicine(), true);	
		ExtentLogger.pass("Medicine are showing in prescription format form.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.PrescriptionFormat)
	@Test(priority = 4 ,enabled = true , description = "Verify diagnosis are showing in prescription format form. ")
    public void verifydiagnosisInPrescriptionFormat() {
		
	//	dronaLoginPage.dronaLoginThroghMobileNo();
		prescriptionFormatPage = new PrescriptionFormatPage(driver);
		Assert.assertEquals(prescriptionFormatPage.verifyDiagnosis(), true);	
		ExtentLogger.pass("diagnosis are showing in prescription format form.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.PrescriptionFormat)
	@Test(priority = 5 ,enabled = true , description = "Verify Investigation are showing in prescription format form. ")
    public void verifyInvestigationInPrescriptionFormat() {
		
	//	dronaLoginPage.dronaLoginThroghMobileNo();
		prescriptionFormatPage = new PrescriptionFormatPage(driver);
		Assert.assertEquals(prescriptionFormatPage.verifyInvestigation(), true);	
		ExtentLogger.pass("Investigation are showing in prescription format form.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.PrescriptionFormat)
	@Test(priority = 6 ,enabled = true , description = "Verify Instruction are showing in prescription format form. ")
    public void verifyInstructionInPrescriptionFormat() {
		
	//	dronaLoginPage.dronaLoginThroghMobileNo();
		prescriptionFormatPage = new PrescriptionFormatPage(driver);
		Assert.assertEquals(prescriptionFormatPage.verifyInstruction(), true);	
		ExtentLogger.pass("Instruction are showing in prescription format form.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.PrescriptionFormat)
	@Test(priority = 7 ,enabled = true , description = "Verify Prescription Note are showing in prescription format form. ")
    public void verifyPrescriptionNoteInPrescriptionFormat() {
		
	//	dronaLoginPage.dronaLoginThroghMobileNo();
		prescriptionFormatPage = new PrescriptionFormatPage(driver);
		Assert.assertEquals(prescriptionFormatPage.verifyPrescriptionNotes(), true);	
		ExtentLogger.pass("Prescription Note are showing in prescription format form.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.PrescriptionFormat)
	@Test(priority = 8 ,enabled = true , description = "Verify On re-login Prescription Details are showing in prescription format form. ")
    public void verifyPrescriptionDetailsOnReLoginInPrescriptionFormat() {
		
	//	dronaLoginPage.dronaLoginThroghMobileNo();
		prescriptionFormatPage = new PrescriptionFormatPage(driver);
		Assert.assertEquals(prescriptionFormatPage.verfiyPrescriptionDetail(), true);	
		ExtentLogger.pass("On re-login Prescription Details are showing in prescription format form..");
	}

}
