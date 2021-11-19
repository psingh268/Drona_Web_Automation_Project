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

public class DronaQRCodePage extends BasePage{
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;	
	private static String qrCodeURL ;
	DronaLoginPage loginPage;
	
	
	private By mobileNoTxtBx = By.xpath("//input[@id = 'mobile-number']");
	private By getOTPBtn = By.xpath("//button[text() = 'Get OTP']");
	private By otpTxtBx = By.xpath("//input[@id = 'otp']");
	private By verifyOtpBtn = By.xpath("//button[text()= 'Verify']");
	private By dateSelect = By.xpath( "//span[text()='10']/..//span[text()='10']/..");
	private By frstNameTxtBx = By.xpath( "//input[@id='firstname1']");
	private By lstNameTxtbx = By.xpath( "//input[@id='lastname1']");
	private By emailTxtBx = By.xpath( "//input[@id='email-address ']");
	private By genderBtn = By.xpath( "//span[text()='Male']/parent::div");
	private By datepickeropenBtn = By.xpath( "//button[contains(@class,'p-datepicker')]");
	private By relationDropDownopenBtn = By.xpath( "//span[text()='Select a Relationship']//following-sibling::div");
	private By selfRelationSlct = By.xpath( "//span[text()='Self']/parent::li//span[text()='Self']/parent::li");
	private By addnewPatientBtn = By.xpath( "//button[text()='Add Patient ']");
	private By termsAndConditionChkBx = By.xpath( "//div[@class='p-checkbox-box']");
	private By addPatientBtn = By.xpath("//h6[text()=' Add New Patient ']");
	private By addPatientPage = By.xpath("//h4[text()='Who is the Patient?']");
	
	
	
	Faker fakeData = new Faker();
	Xls_Reader reader = new Xls_Reader("./src/main/resources/Mankind_UserName.xlsx");
	
	
	public DronaQRCodePage(WebDriver driver) {
		
		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public void doctorLogin() {
		
		loginPage = new DronaLoginPage(driver);
		loginPage.dronaLoginThroughUserName(reader.getCellData("Sheet1", 13, 2));
		testUtil.staticWait(5000);
	}
	
	public void launchUrl() {
		
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String qrCodeUrl = reader.getCellData("qrcode", 1, 3);
		driver.get(qrCodeUrl);
		ExtentLogger.pass(" QR code URL launch Successfully.");
	}
	
	public String qrCodeLoginFirstTime(String mobileNumber) {
		
		testUtil.dosendKeys(mobileNoTxtBx, 10, mobileNumber, "patient number entered");
		testUtil.doClick(getOTPBtn, "getOTPBtn");
		testUtil.dosendKeys(otpTxtBx, 10, "9999", "OTP entered");
		testUtil.doClick(verifyOtpBtn, "verifyOtpBtn");
		return mobileNumber;
	}
    
	public boolean qrCodeLogin() {
		
		boolean addpatientPageQR = false ;
		String mobileNumber =  "9" + fakeData.number().digits(9);
		mobileNumber = qrCodeLoginFirstTime(mobileNumber);
		reader.setCellData("qrcode", "firstPatientMobileNumber",3, mobileNumber);
		if(testUtil.doIsDisplayed(addPatientPage)) {
			
			addpatientPageQR = true;
		}
		return addpatientPageQR;
	}
		
	 public String enterPatientDetail() {
		 
		    String patientFisrtName = fakeData.name().firstName().replace("'", "");
			String patientLastName =  fakeData.name().lastName().replace("'", "");
			String patientName = patientFisrtName + "  " + patientLastName;
			testUtil.dosendKeys(frstNameTxtBx, 10, patientFisrtName);
			testUtil.dosendKeys(lstNameTxtbx, 10, patientLastName);
			testUtil.dosendKeys(emailTxtBx, 10, "praveen.singh@uneecops.com");
			testUtil.doClick(genderBtn, 10);
			testUtil.doClick(datepickeropenBtn, 10);
			 Select month = new Select(driver.findElement(By.xpath("//select[1]")));
			 month.selectByIndex(fakeData.number().numberBetween(0, 12));
			 Select year = new Select(driver.findElement(By.xpath("//select[2]")));
			 year.selectByIndex(fakeData.number().numberBetween(0, 68));
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
	 
 public void addPatientBtn() {
		 
	     javaScriptUtil.scrollPageDown();
	     testUtil.staticWait(2000);
	     javaScriptUtil.clickElementByJS(testUtil.getElement(termsAndConditionChkBx));
		 testUtil.doClick(addnewPatientBtn, "addnewPatientBtn");
	 }

	 
	 public boolean addNewSelfPatient() {
		 
		    boolean patientadded = false;
		    qrCodeLoginFirstTime(reader.getCellData("qrcode", 2, 3));
		    String patientName = enterPatientDetail();
		    selectSelf();
		    addPatientBtn();
		    String patientNamePath = "//h4[text()=' "+ patientName + " ']";
		    WebElement patientNameInList = driver.findElement(By.xpath(patientNamePath));
		    if(patientNameInList.isDisplayed()) {
		    	
		    	patientadded =true;
		    }
		    
		    return patientadded;
	 }
	 public boolean addNewPatientRelative() {
		 
		    boolean patientadded = false;
		    qrCodeLoginFirstTime(reader.getCellData("qrcode", 2, 3));
		    testUtil.doClick(addPatientBtn, "addPatientBtn");
		    String patientName = enterPatientDetail();
		    selectRelation();
		    addPatientBtn();
		    String patientNamePath = "//h4[text()=' "+ patientName + " ']";
		    WebElement patientNameInList = driver.findElement(By.xpath(patientNamePath));
		    if(patientNameInList.isDisplayed()) {
		    	
		    	patientadded =true;
		    }
		    
		    return patientadded;
	 }
	 
	 public String slctPatient(int patientNumber) {
		 
		 
		 List<WebElement>patientList = driver.findElements(By.xpath("//div[contains(@class,'patient-list-card1')]/div/div/div[2]/h4"));
		 WebElement patient = patientList.get(patientNumber);
		 String patientName = patient.getText();
		 javaScriptUtil.clickElementByJS(patient);
		 return patientName;
	 }
	 
	 public boolean walkinBooking() {
		 
		 boolean patientAppointmentView = false;
		 qrCodeLoginFirstTime(reader.getCellData("qrcode", 2, 3));
		 String patientContact = slctPatient(1);
		 String bookedPatenitAppointmentPath = "//div[contains(text(),'" + patientContact + "')]";
		 WebElement bookedPatenitAppointment = driver.findElement(By.xpath(bookedPatenitAppointmentPath));
			if (bookedPatenitAppointment.isDisplayed()) {

				patientAppointmentView = true;
			}
			return patientAppointmentView;	 
	 }
	 
}
