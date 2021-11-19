package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;
import com.qa.utility.Xls_Reader;



public class MsitePage extends BasePage{
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;
	
	private By shareBtn = By.xpath( "//span[text()='Share E-clinic ']/parent::button");
	private By msiteLinkTxtBx = By.xpath( "//div[@class='input-copy']/input");
	private By doctorProfileBtn = By.xpath("//span[contains(@class,'drName')]/parent::div");
	private By bookAppointmentBtn= By.xpath( "//button[text()='Book Appointment ']");
	private By mobileNumTxtBx= By.xpath( "//input[@id='mobile-number']");
	private By getOtpBtn= By.xpath( "//button[text()='Get OTP']");
	private By otpTxtBx= By.xpath( "//input[@id='otp']");
	private By verifyOtpBtn = By.xpath( "//button[text()='Verify']");
	private By bookAppointmentLabel = By.xpath( "//div[text()=' Book an Appointment ']");
	private By continueBtn = By.xpath( "//button[text()='Continue ']");
	private By inClinicSlct = By.xpath( "//h4[text()='In-Clinic']/parent::div");
	private By vedioCallSlct = By.xpath( "//h4[text()='Video Call']/parent::div");
	private By currentDayAppointmentview = By.xpath( "//div[@class='time-setup-date']/ul/li[1]/div");
	private By totalSlot = By.xpath("//ul[contains(@class,'time-setup-date-seq1')]/li/div");
	private By addPatientBtn = By.xpath("//h6[text()=' Add New Patient ']");
	private By dateSelect = By.xpath( "//span[text()='10']/..//span[text()='10']/..");
	private By frstNameTxtBx = By.xpath( "//input[@id='firstname1']");
	private By lstNameTxtbx = By.xpath( "//input[@id='lastname1']");
	private By emailTxtBx = By.xpath( "//input[@id='email-address ']");
	private By genderBtn = By.xpath( "//span[text()='Male']/parent::div");
	private By datepickeropenBtn = By.xpath( "//button[contains(@class,'p-datepicker')]");
	private By relationDropDownopenBtn = By.xpath( "//span[text()='Select a Relationship']//following-sibling::div");
	private By selfRelationSlct = By.xpath( "//span[text()='Self']/parent::li//span[text()='Self']/parent::li");
	private By addnewPatientBtn = By.xpath( "//button[text()='Add Patient ']");
	private By termsAndConditionChkBx = By.xpath( "//div[@class='p-checkbox-box']/span");
	private By appointmentBookOkBtn = By.xpath( "//button[text()='OK']");
	private By proceedToPaymentBtn = By.xpath( "//button[text()='Proceed to Payment ']");

	
	
	
	
	
	
	
		public MsitePage(WebDriver driver) {
			this.driver = driver;
			testUtil = new TestUtil(driver);
			javaScriptUtil = new JavaScriptUtil(driver);
		}
		
		Xls_Reader reader = new Xls_Reader("./src/main/resources/Mankind_UserName.xlsx");
		Faker faker = new Faker();
		
		public void copyMsiteLink() {
			
			testUtil.getElement(shareBtn).click();
			String msiteUrl =testUtil.getElement(msiteLinkTxtBx).getAttribute("value");
			reader.setCellData("Sheet1", "DateRange",2, msiteUrl);
		}
		
		public void launchUrl() {
			
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			String msiteUrl = reader.getCellData("Sheet1", 9, 2);
			driver.get(msiteUrl);
		}
		
		public void patientMobilenumberLogin(String patientMobileNumber) {
			
			testUtil.doClick(bookAppointmentBtn, "Book Appointment Button");
			testUtil.dosendKeys(mobileNumTxtBx, 10, patientMobileNumber, patientMobileNumber +" Entered");
			testUtil.doClick(getOtpBtn, "getOtp Button");
			testUtil.dosendKeys(otpTxtBx, 10,"9999", "otp TxtBx");
			testUtil.doClick(verifyOtpBtn, "Verify Otp Btn");
		}
	
		public boolean patientFirstTimeLogin() {
			
			boolean bookAppointmentPage = false;
			String patientMobileNumber = "9" + faker.number().digits(9);
			patientMobilenumberLogin(patientMobileNumber);
			reader.setCellData("Sheet1", "Edit DateRange",2, patientMobileNumber);
			if(testUtil.doIsDisplayed(bookAppointmentLabel)) {
				
				 bookAppointmentPage = true;
			}
			
			return bookAppointmentPage;
		}
		
		public void slctInClinicAppointment() {
			
			testUtil.doClick(inClinicSlct, "In Clinic Block ");
			testUtil.doClick(continueBtn, "Continue Button");
		}
		
		public void slctVedioAppointment() {
		
		testUtil.doClick(vedioCallSlct, "Vedio Appointment");
		testUtil.doClick(continueBtn, "Continue Button");
		}
		
		public void selectCurrentDay() {
			
			testUtil.doClick(currentDayAppointmentview, "Current day select to view appointment");
		}
		 public String bookSlot() {
			 
			 String slotTime= "";
			 List<WebElement> availableSlot = driver.findElements(totalSlot);
			 for(WebElement selectedSlot : availableSlot ) {
				 
				 String slotType = selectedSlot.getAttribute("class");
				 System.out.println(slotType);
				 if(!slotType.contains("time-setup-time-card disabled")) {
					 
					 javaScriptUtil.clickElementByJS(selectedSlot); 
					 slotTime = selectedSlot.getText();
					 break;
				 }
			 }
			 testUtil.doClick(continueBtn, 10);
			 ExtentLogger.pass("Slot selected successfully");
			 return slotTime;
		 }
		 
		 public String enterPatientDetail() {
			 
			    testUtil.doClick(addPatientBtn, "Add Patient Button");
			    String patientFisrtName = faker.name().firstName().replace("'", "");
				String patientLastName =  faker.name().lastName().replace("'", "");
				String patientName = patientFisrtName + "  " + patientLastName;
				testUtil.dosendKeys(frstNameTxtBx, 10, patientFisrtName);
				testUtil.dosendKeys(lstNameTxtbx, 10, patientLastName);
				testUtil.dosendKeys(emailTxtBx, 10, "praveen.singh@uneecops.com");
				testUtil.doClick(genderBtn, 10);
				testUtil.doClick(datepickeropenBtn, 10);
				 Select month = new Select(driver.findElement(By.xpath("//select[1]")));
				 month.selectByIndex(faker.number().numberBetween(0, 12));
				 Select year = new Select(driver.findElement(By.xpath("//select[2]")));
				 year.selectByIndex(faker.number().numberBetween(0, 68));
				 testUtil.doClick(dateSelect, "10 select as date");
				 return patientName;
			
		 }
		 
		 
		 public void selectRelation() {
		 
			 testUtil.doClick(relationDropDownopenBtn, "Relation drop-down");
			 List<WebElement>relationOptions = driver.findElements(By.xpath("//p-dropdownitem/li"));
			 relationOptions.get(1).click();
		 }
		 
		 public void selectSelf() {
			 
			 testUtil.doClick(relationDropDownopenBtn, "Relation drop-down");
			 testUtil.doClick(selfRelationSlct, 10);
		 }
		 
		 public boolean addNewSelfPatient() {
			 
			    boolean patientadded = false;
			    patientMobilenumberLogin(reader.getCellData("Sheet1", 10, 2));
				slctInClinicAppointment();
				selectCurrentDay();
				bookSlot();
			    String patientName = enterPatientDetail();
			    selectSelf();
			    testUtil.doClick(addnewPatientBtn, "Add new patient");
			    String patientNamePath = "//h4[text()=' "+ patientName + " ']";
			    WebElement patientNameInList = driver.findElement(By.xpath(patientNamePath));
			    if(patientNameInList.isDisplayed()) {
			    	
			    	patientadded =true;
			    }
			    
			    return patientadded;
		 }
		 
		 public boolean addNewRelativePatient() {
			 
			    boolean patientadded = false;
			    patientMobilenumberLogin(reader.getCellData("Sheet1", 10, 2));
				slctInClinicAppointment();
				selectCurrentDay();
				bookSlot();
				String patientName = enterPatientDetail();
				selectRelation();
				testUtil.doClick(addnewPatientBtn, "Add new patient");
			    String patientNamePath = "//h4[text()=' "+ patientName + " ']";
			    WebElement patientNameInList = driver.findElement(By.xpath(patientNamePath));
			    if(patientNameInList.isDisplayed()) {
			    	
			    	patientadded =true;
			    }
			    
			    return patientadded;
		 }
		 
		
		public boolean inClinicAppointmentBooking() {
			
			boolean patientAppointmentView = false;
			patientMobilenumberLogin(reader.getCellData("Sheet1", 10, 2));
			slctInClinicAppointment();
			selectCurrentDay();
			bookSlot();
			String patientName = enterPatientDetail();
			selectRelation();
			testUtil.doClick(addnewPatientBtn, "Add new patient");
		    String patientNamePath = "//h4[text()=' "+ patientName + " ']";
		    WebElement patientNameInList = driver.findElement(By.xpath(patientNamePath));
		    patientNameInList.click();
		    testUtil.doClick(termsAndConditionChkBx, "terms and Condition");
		    testUtil.doClick(bookAppointmentBtn, "Book Appointment Button");
		    testUtil.doClick(appointmentBookOkBtn, "Appointment Book Confirmation Ok");
		    ((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			 String[]nameArr = patientName.split(" ");
		     String  PatientName = " " + nameArr[0];
			 String bookedPatenitAppointmentPath = "//div[contains(text(),'" + PatientName + "')]";
			 WebElement bookedPatenitAppointment = driver.findElement(By.xpath(bookedPatenitAppointmentPath));
			 if(bookedPatenitAppointment.isDisplayed()) {
				 
				 patientAppointmentView = true;
			 }
			 return patientAppointmentView;
		}
		
		public void virtualAppointmentBooking() {
			
			patientMobilenumberLogin(reader.getCellData("Sheet1", 10, 2));
			slctVedioAppointment();
			selectCurrentDay();
			bookSlot();
			String patientName = enterPatientDetail();
			selectRelation();
			testUtil.doClick(addnewPatientBtn, "Add new patient");
		    String patientNamePath = "//h4[text()=' "+ patientName + " ']";
		    WebElement patientNameInList = driver.findElement(By.xpath(patientNamePath));
		    patientNameInList.click();
		    testUtil.doClick(continueBtn, "continue Button ");
		    testUtil.doClick(termsAndConditionChkBx, "Appointment Book Confirmation Ok");
		    testUtil.doClick(proceedToPaymentBtn, "proceedToPayment button");
		}
}
