package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class DronaAddPatientPage extends BasePage{
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;	
	
	
	private By patientMenu = By.xpath( "//span[text()='Patients']/..");
	private By patientHeadBtn = By.xpath( "//span[text()='Add Patient']/..");              
	private By patientFrstName = By.xpath( "//input[@placeholder='Enter First Name']");
	private By patientLstName = By.xpath( "//input[@placeholder='Enter Last Name']");
	private By patientPhoneNo = By.xpath( "//input[@formcontrolname='phoneNumber']");
	private By patientGender = By.xpath( "//span[text()='Male']");
	private By patientDob = By.xpath( "//p-calendar/span/input");
	private By referDoctorName = By.xpath( "//input[@formcontrolname='doctorName']");
	private By healthId = By.xpath( "//input[@formcontrolname='healthId']");
	private By patientEmail = By.xpath( "//input[@formcontrolname='email']");
	private By PatientAddress = By.xpath( "//input[@formcontrolname='address']");
	private By PatientCity = By.xpath( "//input[@formcontrolname='city']");
	private By PatientState = By.xpath( "//input[@formcontrolname='state']");
	private By PatientpreferredLanguage = By.xpath( "//input[@formcontrolname='preferredLanguage']");
	private By savePatientBtn = By.xpath( "//button[text()='Save']");
	private By dateSelect = By.xpath( "//span[text()='10']/..//span[text()='10']/..");
	private By liveQueueOpenBtn = By.xpath( "//span[text()='Live Queue']/following-sibling::div/span");
	private By allPatientBtn = By.xpath( "//span[text()='All Patients']/..");
	private By addNewBtn = By.xpath( "//button[@id='dropdownAddnew']");
	private By popUpOkBtn = By.xpath( "//button[text()='Ok']");
	
	
	
	
	 Faker fakeData = new Faker();
	 
   public DronaAddPatientPage(WebDriver driver) {
		
		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public void openPatientPage() {
		
		WebElement patientMenuClk = testUtil.getElement(patientMenu);
		javaScriptUtil.clickElementByJS(patientMenuClk);
		testUtil.staticWait(3000);
		 testUtil.doClick(addNewBtn, "Add New Button ");
		testUtil.doClick(patientHeadBtn, 10);	
		ExtentLogger.pass("Add new patient page opened.");
	}
	
	public String[] enterPatientDetail() {
		
		String patientFisrtName = fakeData.name().firstName().replace("'", "");
		String patientLastName =  fakeData.name().lastName().replace("'", "");
		String patientName = patientFisrtName + "  " + patientLastName;
		String patientMobileNo = fakeData.number().digits(10);
		testUtil.dosendKeys(patientFrstName, 10, patientFisrtName);
		testUtil.dosendKeys(patientLstName, 10, patientLastName);
		testUtil.dosendKeys(patientPhoneNo, 10, patientMobileNo);
		testUtil.doClick(patientGender, 10);
		javaScriptUtil.clickElementByJS(testUtil.getElement(patientDob));
		Select month = new Select(driver.findElement(By.xpath("//select[1]")));
		// List<WebElement>totalMonth = month.getOptions();
		 month.selectByIndex(fakeData.number().numberBetween(0, 12));
		 Select year = new Select(driver.findElement(By.xpath("//select[2]")));
		// List<WebElement>totalYear = month.getOptions();
		 year.selectByIndex(fakeData.number().numberBetween(0, 68));
		 testUtil.doClick(dateSelect, "10 select as date");
		testUtil.dosendKeys(referDoctorName, 10, fakeData.name().fullName());
		//testUtil.dosendKeys(healthId, 10, fakeData.number().digits(5));
	//	testUtil.dosendKeys(patientEmail, 10, patientFisrtName.toLowerCase() + "@gmail.com");
		//testUtil.dosendKeys(PatientAddress, 10, "sarvoday nagar");
	//	testUtil.dosendKeys(PatientCity, 10, "Delhi");
	//	testUtil.dosendKeys(PatientState, 10, "Delhi");		
	//	testUtil.dosendKeys(PatientpreferredLanguage, 10, "English");
		javaScriptUtil.scrollPageUp();
		testUtil.staticWait(2000);
		ExtentLogger.pass("New patient details entered.");
		String[]patientDetail = {patientName , patientMobileNo};
		System.out.println(patientDetail);;
		return patientDetail;
	}
	
	public void saveNewPatient() {	
		testUtil.doClick(savePatientBtn, 10);
		ExtentLogger.pass("New patient details saved.");
		testUtil.doClick(popUpOkBtn, "Patient Success Ok popup");
		testUtil.staticWait(5000);
		driver.navigate().refresh();
		 testUtil.staticWait(4000);
		/*
		 * List<WebElement> toastMessages =
		 * driver.findElements(By.xpath("//div[contains(@class,' p-toast')]"));
		 * for(WebElement toastMessage : toastMessages) {
		 * 
		 * toastMessage.getText(); }
		 */
	}
	
	public String[] createNewPatient() {
		
		String[]patientDetail = enterPatientDetail();
		saveNewPatient();
		return patientDetail;	
	}
	
	public boolean newPatientShowInList() {
		
		boolean patientView = false;
		openPatientPage();
		String[]patientDetail = createNewPatient();
		String patientName = patientDetail[0];
		String patientPath = "//app-patient-list/div/div/div/div/div/div/div/div[2]/label[text()='"+ patientName +"']";
		testUtil.doClick(liveQueueOpenBtn, "Live Queue Open");
		testUtil.doClick(allPatientBtn, "All Patient Button");
		testUtil.staticWait(3000);
		WebElement patientInQueue = driver.findElement(By.xpath(patientPath));
		if(patientInQueue.isDisplayed()) {
			
			patientView =true;
		}
		return patientView;
		
	}
	
	

}
