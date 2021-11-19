package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class PrescriptionFormatPage extends BasePage{
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;	
	ConsultPage consultPage;
	
	
	Faker faker = new Faker();
	
	private By patientAppointment = By.xpath( "//h4[contains(text(),' Checked In')]/../../../../../following-sibling::div[2]/div");
	private By patientMenu = By.xpath( "//span[text()='Patients']/..");
	private By consultnowBtn = By.xpath( "//span[text()='Consult Now']/parent::button");
	private By selectedSymptoms = By.xpath("//p-accordiontab[@header='Symptoms']/div/div[2]/div/div[2]/div/label[text()=' Cold']");
	private By examinationFindingOpenBtn = By.xpath( "//p-accordiontab[@header='Examination Findings']/div/div/a");
	private By selectedExaminationFinding = By.xpath("//p-accordiontab[@header='Examination Findings']/div/div[2]/div/div[2]/div/label[text()='ChestPain']");
	private By medicineName = By.xpath("//span[text()='Medicines']/../following-sibling::p-header/div/div/div/span/div/div/div[1]");
	private By medicineDays = By.xpath("//span[text()='Medicines']/../following-sibling::p-header/div/div/div/span/div/div/div[3]");
	private By selectedDiagnosis = By.xpath("//p-accordiontab[@header='Diagnosis']/div/div[2]/div/div[2]/div/label[text()=' Vomiting ']");
	private By diagnosisOpenBtn = By.xpath( "//p-accordiontab[@header='Diagnosis']/div/div/a");
	private By selectedInvestigation = By.xpath("//p-accordiontab[@header='Investigations']/div/div[2]/div/div[2]/div[1]/div/div/p-checkbox");
	private By selectedInstruction = By.xpath("//p-accordiontab[@header='Instructions']/div/div[2]/div/div[2]/div[2]/div/div/p-checkbox");
	private By selectedPrescriptionNotes = By.xpath("//span[text()='Prescription Notes']/../following-sibling::p-header/div/div/div/span");
	private By symptoms = By.xpath("//div[text()=' • Cold    ']");
	private By finding = By.xpath("//div[text()=' • ChestPain']");
	private By diagnosis = By.xpath("//div[text()=' Vomiting ']");
	private By medicineNam = By.xpath("//span[contains(text(),'Clexane 40mg')]");
	private By medicineDay = By.xpath("//span[text()='7 days']");
	private By prescriptionNote = By.xpath("//div[text()='• add doctor prescription notes ']");
	private By instruction = By.xpath("//div[text()=' • Diet & Exercise as adviced ']");
	private By investigation = By.xpath("//div[text()=' CBC(Complete Blood Count) , ']");
	private By previewBtn = By.xpath("//li[text()=' Preview']");
	private By investigationsOpenBtn = By.xpath( "//p-accordiontab[@header='Investigations']/div/div/a");
	private By instructionOpenBtn = By.xpath( "//p-accordiontab[@header='Instructions']/div/div/a");
	private By prescriptionOpenBtn = By.xpath( "//p-accordiontab[@header='Prescription Notes']/div/div/a");
	private By prescriptionTxtBx = By.xpath( "//p-accordiontab[@header='Prescription Notes']/div/div[2]/div/div/div/textarea");
	
	 public PrescriptionFormatPage(WebDriver driver) {
			
			this.driver = driver;
			testUtil = new TestUtil(driver);
			javaScriptUtil = new JavaScriptUtil(driver);
		}
	 
	 public void clkPatientMenu() {
			
			testUtil.staticWait(5000);
			testUtil.doClick(patientMenu, "Patient menu");
			testUtil.doClick(patientAppointment, "patient Appointment");
			testUtil.staticWait(3000);
			testUtil.doClick(consultnowBtn, "ConsultNow Button");
			testUtil.staticWait(3000);
		}
	 
	 public boolean verfiyPrescriptionDetail() {
		 
		 boolean prescriptionDetails = false;
		 clkPatientMenu();
		 testUtil.staticWait(3000);
		 testUtil.doClick(previewBtn, "Preview");
		 testUtil.staticWait(3000);
		 if(testUtil.doIsDisplayed(symptoms) && testUtil.doIsDisplayed(finding) && testUtil.doIsDisplayed(medicineNam)
			&& testUtil.doIsDisplayed(medicineDay) && testUtil.doIsDisplayed(diagnosis)  && testUtil.doIsDisplayed(investigation)
			&& testUtil.doIsDisplayed(instruction) && testUtil.doIsDisplayed(prescriptionNote)) {
					 
			 prescriptionDetails = true;
				 }
		 
		 return prescriptionDetails;
	 }
	 
	 public void addSymptoms() {
		 testUtil.doClick(selectedSymptoms, "Symptoms");
		 testUtil.staticWait(3000);
		 testUtil.doClick(previewBtn, "Preview");
		 testUtil.staticWait(3000);
		 
	 }
	 public boolean verifySymptoms() {
		 
		 boolean symptomsShown = false;
		 clkPatientMenu();
		 addSymptoms();
		 if(testUtil.doIsDisplayed(symptoms)) {
			 
			 symptomsShown = true;
		 }
		 return symptomsShown;
	 }
	 
    public boolean verifyExaminationFinding() {
		 
		 boolean examinationFindingShown = false;
		 clkPatientMenu();
		 testUtil.doClick(examinationFindingOpenBtn, "examinationFindingOpenBtn");
		 testUtil.doClick(selectedExaminationFinding, "Examiniation Finding");
		 testUtil.staticWait(3000);
		 testUtil.doClick(previewBtn, "Preview");
		 testUtil.staticWait(3000);
		 if(testUtil.doIsDisplayed(finding)) {
			 
			 examinationFindingShown = true;
		 }
		 return examinationFindingShown;
	 }
    public boolean verifyMedicine() {
    	
    	boolean medicineNameShown = false;
    	
    	clkPatientMenu();
    	consultPage = new ConsultPage(driver);
    	consultPage.addMedicine(0);
    	 testUtil.staticWait(3000);
		 testUtil.doClick(previewBtn, "Preview");
		 testUtil.staticWait(3000);
		 if(testUtil.doIsDisplayed(medicineNam) && testUtil.doIsDisplayed(medicineDay)) {
			 
			 medicineNameShown = true;
		 }
		 return medicineNameShown;
	 }
    public boolean verifyDiagnosis() {
		 
		 boolean diagnosisShown = false;
		 clkPatientMenu();
		 testUtil.doClick(diagnosisOpenBtn, "diagnosisOpenBtn");
		 testUtil.doClick(selectedDiagnosis, "Diagnosis");
		 testUtil.staticWait(3000);
		 testUtil.doClick(previewBtn, "Preview");
		 testUtil.staticWait(3000);
		 if(testUtil.doIsDisplayed(diagnosis)) {
			 
			 diagnosisShown = true;
		 }
		 return diagnosisShown;
	 }	
    public boolean verifyInvestigation() {
		 
		 boolean investigationShown = false;
		 clkPatientMenu();
		 testUtil.doClick(investigationsOpenBtn, "investigationOpenBtn");
		 testUtil.doClick(selectedInvestigation, "Investigation");
		 testUtil.staticWait(3000);
		 testUtil.doClick(previewBtn, "Preview");
		 testUtil.staticWait(3000);
		 if(testUtil.doIsDisplayed(investigation)) {
			 
			 investigationShown = true;
		 }
		 return investigationShown;
	 }	
    	
    public boolean verifyInstruction() {
		 
		 boolean instructionShown = false;
		 clkPatientMenu();
		 testUtil.doClick(instructionOpenBtn, "InstructionOpenBtn");
		 testUtil.staticWait(1000);
		 testUtil.doClick(selectedInstruction, "Instruction");
		 testUtil.staticWait(3000);
		 testUtil.doClick(previewBtn, "Preview");
		 testUtil.staticWait(3000);
		 if(testUtil.doIsDisplayed(instruction)) {
			 
			 instructionShown = true;
		 }
		 return instructionShown;
	 }	
    public boolean verifyPrescriptionNotes() {
  	  
  	  boolean viewSavedPrescription = false;
  	  clkPatientMenu();
 	  testUtil.staticWait(2000);
 	  testUtil.doClick(prescriptionOpenBtn, "Prescription slideBar");
      testUtil.dosendKeys(prescriptionTxtBx, 10, "add doctor prescription notes", "Prescription Notes");
        WebElement prescriptionsTxtBx = driver.findElement(prescriptionTxtBx);
        prescriptionsTxtBx.sendKeys(Keys.ENTER);
        javaScriptUtil.scrollPageUp();
        testUtil.staticWait(3000);
		 testUtil.doClick(previewBtn, "Preview");
		 testUtil.staticWait(3000);
        if(testUtil.doIsDisplayed(prescriptionNote)) {
      	  
      	  viewSavedPrescription =  true;
        }
        return viewSavedPrescription;
  	  
    }	
    
    public void AddConsultationDetais() {
    	
    	
    }
    

}
