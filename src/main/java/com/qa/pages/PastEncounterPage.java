package com.qa.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class PastEncounterPage extends BasePage{
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;	
	AppointmentBookingPage appointmentBookingPage;
	String bookedPatenitAppointmentPath;
	ConsultPage consultPage;

	private By consultnowBtn = By.xpath( "//span[text()='Consult Now']/..");
	private By previewBtn = By.xpath("//li[text()=' Preview']");
	private By appointmentCompleteBtn = By.xpath("//button[text()='Complete']");
	private By viewAllBtn = By.xpath("//span[text()='[View All]']");
	private By duplicateRxBtn = By.xpath("//div[text()='Duplicate Rx']");
	private By comleteConsultationOkBtn = By.xpath("//button[text()='Ok']");
	
	
	
	
	
	public PastEncounterPage(WebDriver driver) {
		
		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
		 appointmentBookingPage = new AppointmentBookingPage(driver);
	}
	
	 public String openConsultPage() {
		
		
	     appointmentBookingPage.AppointmentMenuClick();
         appointmentBookingPage.headBookAppointmentClick();
         appointmentBookingPage.bookSlot(6);
		 String PatientContact = appointmentBookingPage.addNewPatient();		
		 appointmentBookingPage.headBookAppointmentClick();
		 appointmentBookingPage.bookSlot(6);
		 appointmentBookingPage.patientSearch(PatientContact);
		 appointmentBookingPage.enterAppointmentPurpose();
		 testUtil.staticWait(5000);
	 	 String[]nameArr = PatientContact.split(" ");
	     String  PatientName = " " + nameArr[0];
		 String bookedPatenitAppointmentPath = "//div[contains(text(),'" + PatientName + "')]";
		 WebElement bookedPatenitAppointment = driver.findElement(By.xpath(bookedPatenitAppointmentPath));
		 javaScriptUtil.clickElementByJS(bookedPatenitAppointment);
		 appointmentBookingPage.clkChkdInBtn();
		 testUtil.staticWait(3000);
		 String checkedInAppointmentPAth = "//h4[contains(text(),' Checked In')]/ancestor::div[5]/following-sibling::div/child::div/div[2]/div/div[contains(text(),'" + PatientName + "')]";
		 WebElement checkedInAppointment =  driver.findElement(By.xpath(checkedInAppointmentPAth)); 
		 javaScriptUtil.clickElementByJS(checkedInAppointment);
		 return PatientContact;
		 
	}

	/*
	 * public ArrayList<WebElement> addCosultaion() {
	 * 
	 * testUtil.doClick(consultnowBtn,"consultnowBtn"); consultPage = new
	 * ConsultPage(driver); consultPage.addSymptoms(1); testUtil.staticWait(2000);
	 * consultPage.addDiagnosis(1); testUtil.staticWait(2000);
	 * consultPage.addMedicine(1); testUtil.staticWait(2000);
	 * consultPage.addInstructions(1); testUtil.staticWait(2000);
	 * consultPage.addInvestigations(1); testUtil.staticWait(2000);
	 * consultPage.addExaminationFinding(1); testUtil.staticWait(2000);
	 * consultPage.getprescriptionNote(); javaScriptUtil.scrollPageUp(); WebElement
	 * prescriptionNotesVal = testUtil.getElement(By.
	 * xpath("//span[text()='Prescription Notes']/parent::p-header/following-sibling::p-header/div/div/div/span"
	 * )); WebElement symptomsVal = testUtil.getElement(By.xpath(
	 * "//span[text()='Symptoms']/parent::p-header/following-sibling::p-header/div/div/div/span"
	 * )); WebElement diagnosisVal = testUtil.getElement(By.xpath(
	 * "//span[text()='Diagnosis']/parent::p-header/following-sibling::p-header/div/div/div/span"
	 * )); WebElement MedicineVal = testUtil.getElement(By.xpath(
	 * "//span[text()='Medicines']/parent::p-header/following-sibling::p-header/div/div/div/span/div"
	 * )); WebElement InstructionVal = testUtil.getElement(By.xpath(
	 * "//span[text()='Instructions']/parent::p-header/following-sibling::p-header/div/div[2]/div/label/ul/li"
	 * )); WebElement examinationFindingsVal = testUtil.getElement(By.
	 * xpath("//span[text()='Examination Findings']/parent::p-header/following-sibling::p-header/div/div/div/span"
	 * )); WebElement investigationVal = testUtil.getElement(By.xpath(
	 * "//span[text()='Investigations']/parent::p-header/following-sibling::p-header/div/div[2]/div/label/ul/li"
	 * )); List<WebElement> consultation =
	 * Arrays.asList(symptomsVal,diagnosisVal,MedicineVal,InstructionVal,
	 * investigationVal,examinationFindingsVal,prescriptionNotesVal);
	 * ArrayList<WebElement> consultationList = new ArrayList<>();
	 * consultationList.addAll(consultation); return consultationList; }
	 */
     public void completeAppointment() {
    	 
    	 testUtil.doClick(previewBtn, "Preview Button");
    	 testUtil.staticWait(3000);
    	 testUtil.doClick(appointmentCompleteBtn, "Appointment Complete Button");
    	 testUtil.staticWait(2000);
    	 testUtil.doClick(comleteConsultationOkBtn, "comleteConsultationOkBtn");
    	 testUtil.staticWait(2000);
     }
     
     public void BookSecondAppointment(String PatientName) {
    	 
 
 		 appointmentBookingPage.headBookAppointmentClick();
 		 appointmentBookingPage.bookSlot(6);
 		 appointmentBookingPage.patientSearch(PatientName.replace(" ", ""));
 		 appointmentBookingPage.enterAppointmentPurpose();
 		 testUtil.staticWait(3000);	 	
 		 String bookedPatenitAppointmentPath = "//div[contains(text(),'" + PatientName + "')]";
 		 WebElement bookedPatenitAppointment = driver.findElement(By.xpath(bookedPatenitAppointmentPath));
 		 javaScriptUtil.clickElementByJS(bookedPatenitAppointment);
 		 appointmentBookingPage.clkChkdInBtn();
 		 testUtil.staticWait(3000);
 		 String checkedInAppointmentPAth = "//h4[contains(text(),' Checked In')]/ancestor::div[5]/following-sibling::div/child::div/div[2]/div/div[contains(text(),'" + PatientName + "')]";
 		 WebElement checkedInAppointment =  driver.findElement(By.xpath(checkedInAppointmentPAth));
 		 javaScriptUtil.clickElementByJS(checkedInAppointment);
     }
     
     public void openPastEncounter() {
    	 
    	 testUtil.doClick(consultnowBtn,"consultnowBtn");
    	 testUtil.doClick(viewAllBtn,"viewAllBtn");
    	 testUtil.doClick(duplicateRxBtn,"consultnowBtn");
    	 testUtil.staticWait(3000);
    	 
     }
     
		/*
		 * public boolean verifyPastEncounterDuplicate() {
		 * 
		 * boolean cosultationCopied = false; String patientContact = openConsultPage();
		 * ArrayList<WebElement>consultationList = addCosultaion();
		 * completeAppointment(); BookSecondAppointment( patientContact) ;
		 * openPastEncounter(); for(WebElement consult: consultationList) {
		 * 
		 * if(consult.isDisplayed()) {
		 * 
		 * ExtentLogger.pass(consult.getText() + " is showing"); consult = null; }
		 * cosultationCopied = true; } return cosultationCopied; }
		 */
}
