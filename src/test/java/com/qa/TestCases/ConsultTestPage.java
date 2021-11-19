package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.ConsultPage;
import com.qa.pages.CustomizeConsultation;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class ConsultTestPage extends BaseTest{
	
	ConsultPage consultPage;
	CustomizeConsultation customizeConsultation;
	JavaScriptUtil javaScriptUtil;
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 1 ,enabled = true , description = "Verify new added Tag in consult page.")
    public void verifyAddNewTag() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.addNewTagVerify(), true);
		ExtentLogger.pass("New tag added successfully.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 2 ,enabled = true , description = "Verify new tag deleted .")
    public void verifyDeleteTag() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.deleteTag(), true);
		ExtentLogger.pass("New tag deleted successfully.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 3 ,enabled = true , description = "Verify Chief Complaint added .")
    public void verifyaddChiefComplaint() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		consultPage.addChiefComplaint();
		ExtentLogger.pass("Chief Complaint added successfully.");
	}
    
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 4 ,enabled = true , description = "Verify Add vitals .")
    public void verifyaddVitals() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		consultPage.addVitals();
		ExtentLogger.pass("Vitals added successfully.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 5 ,enabled = true , description = "Verify Add symptoms .")
    public void verifyaddSymptoms() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.symptomsShowingSelected(), true);
		ExtentLogger.pass("symptoms saved and shown as selected.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 6 ,enabled = true , description = "Verify add examination finding .")
    public void verifyaddExaminationFinding() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.examinationFindingShowingSelected(), true);
		ExtentLogger.pass("Examination Finding saved and shown as selected.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 7 ,enabled = true , description = "Verify Add medicine.")
    public void verifyaddMedicineFinding() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.medicineShowingSelected(), true);
		ExtentLogger.pass("Medicine saved and shown as selected.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 8 ,enabled = true , description = "Verify Add diagnosis .")
    public void verifyadddiagnosis() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.diagnosisShowingSelected(), true);
		ExtentLogger.pass("diagnosis saved and shown as selected.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 9 ,enabled = true , description = "Verify Add Investigation .")
    public void verifyaddInvestigation() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.investigationShowingSelected(), true);
		ExtentLogger.pass("Investigation saved and shown as selected.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 10 ,enabled = true , description = "Verify Add Instruction.")
    public void verifyaddInstruction() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.instructionShowingSelected(), true);
		ExtentLogger.pass("Instruction saved and shown as selected.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 11 ,enabled = true , description = "Verify Add prescripion.")
    public void verifyaddPrescription() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.addPrescriptionNotes(), true);
		ExtentLogger.pass("prescription saved and shown as selected.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 12 ,enabled = true , description = "Verify Add condition.")
    public void verifyaddcondition() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.conditionShowingSelected(), true);
		ExtentLogger.pass("condition saved and shown as selected.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 13 ,enabled = true , description = "Verify Add Current Medication.")
    public void verifyaddCurrentMedication() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.currentMedicationShowingSelected(), true);
		ExtentLogger.pass("Current Medication saved and shown as selected.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 14 ,enabled = true , description = "Verify Add Allergies.")
    public void verifyaddAllergies() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		Assert.assertEquals(consultPage.allergiesShowingSelected(), true);
		ExtentLogger.pass("Allergies saved and shown as selected.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 15 ,enabled = true , description = "Verify Add Family Member.")
    public void verifyaddFamilyMemberHistory() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		consultPage.addFamilymemberHistory(1);
		ExtentLogger.pass("family history saved and shown as selected.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 16 ,enabled = true , description = "Verify Customize Symptoms.")
    public void verifyaddcustomizeSymptoms() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		consultPage.getConsultNowPage();
		customizeConsultation = new CustomizeConsultation(driver);
		String consultationName =  customizeConsultation.addCustomizeConsultation("symptoms");
		Assert.assertEquals(customizeConsultation.saveCustomizeConsultation(consultationName), true);
		ExtentLogger.pass("Customize Symptoms added and shown.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 17 ,enabled = true , description = "Verify Customize finding.")
    public void verifyaddcustomizeFinding() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		consultPage.getConsultNowPage();
		customizeConsultation = new CustomizeConsultation(driver);
		customizeConsultation.openConsultaionSlides("Examination Findings");
		String consultationName =  customizeConsultation.addCustomizeConsultation("finding");
		Assert.assertEquals(customizeConsultation.saveCustomizeConsultation(consultationName), true);
		ExtentLogger.pass("Customize Finding added and shown.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 18 ,enabled = true , description = "Verify Customize diagnosis.")
    public void verifyaddcustomizeDiagnosis() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		consultPage.getConsultNowPage();
		customizeConsultation = new CustomizeConsultation(driver);
		customizeConsultation.openConsultaionSlides("Diagnosis");
		String consultationName =  customizeConsultation.addCustomizeConsultation("diagnosis");
		Assert.assertEquals(customizeConsultation.saveCustomizeConsultation(consultationName), true);
		ExtentLogger.pass("Customize diagnosis added and shown.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 19 ,enabled = true , description = "Verify Customize investigations.")
    public void verifyaddcustomizeInvestigation() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		consultPage.getConsultNowPage();
		customizeConsultation = new CustomizeConsultation(driver);
		customizeConsultation.openConsultaionSlides("Investigations");
		String consultationName =  customizeConsultation.addCustomizeConsultation("investigations");
		Assert.assertEquals(customizeConsultation.saveCustomizeConsultation(consultationName), true);
		ExtentLogger.pass("Customize investigations added and shown.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.ConsultPage)
	@Test(priority = 20 ,enabled = true , description = "Verify Customize instructions.")
    public void verifyaddcustomizeInstruction() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		consultPage = new ConsultPage(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
		consultPage.getConsultNowPage();
		javaScriptUtil.scrollPageDown();
		customizeConsultation = new CustomizeConsultation(driver);
		customizeConsultation.openConsultaionSlides("Instructions");
		String consultationName =  customizeConsultation.addCustomizeConsultation("instructions");
		Assert.assertEquals(customizeConsultation.saveCustomizeConsultation(consultationName), true);
		ExtentLogger.pass("Customize instructions added and shown.");
	}

}
