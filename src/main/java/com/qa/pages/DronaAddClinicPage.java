package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;
import com.qa.utility.Xls_Reader;

public class DronaAddClinicPage extends BasePage {

	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;
	DronaLoginPage dronaLoginPage;
	
	private By selectCityTxtBx = By.xpath("//input[@placeholder='Select a city']");
	private By selectState = By.xpath("//span[text()='Delhi']/..");
	private By clinicNameTxtBx = By.xpath("//input[@formcontrolname='clinicName']");
	private By assistantNumberTxtBx = By.xpath("//input[@formcontrolname='assistantNumber']");
	private By saveAndContinueBtn = By.xpath("//span[text()='Save & Continue']/parent::button");
	private By consulationFeeInClincTxtBx = By.xpath("//h4[text()='In-Clinic Consultation']/../../following-sibling::div[1]/div/label[text()='Consultation Fee*']/following-sibling::div/input");
	private By followUpFeeInClinicTxtBx = By.xpath("//h4[text()='In-Clinic Consultation']/../../following-sibling::div[1]/div/label[text()='Follow-up Fee']/following-sibling::div/input");
	private By followUpDaysInClinicTxtBx = By.xpath("//h4[text()='In-Clinic Consultation']/../../following-sibling::div[1]/div/label[text()='Follow-up Valid for (Days)']/following-sibling::div/input");
	private By slotLngthDropDownBtn = By.xpath("//h4[contains(text(),'Slot Duration')]/../../following-sibling::div/div/p-dropdown/div/div[2]/span");
	private By selectSlotLngth = By.xpath("//span[text()='5 mins']/parent::li");
	private By consulationFeeVirtualTxtBx = By.xpath("//h4[text()='Virtual Consultation']/../../following-sibling::div[1]/div/label[text()='Consultation Fee*']/following-sibling::div/input");
	private By followUpFeeVirtualTxtBx = By.xpath("//h4[text()='Virtual Consultation']/../../following-sibling::div[1]/div/label[text()='Follow-up Fee']/following-sibling::div/input");
	private By followUpDaysVirtualTxtBx = By.xpath("//h4[text()='Virtual Consultation']/../../following-sibling::div[1]/div/label[text()='Follow-up Valid for (Days)']/following-sibling::div/input");
	private By sameAsInClinicChkBx = By.xpath("//div[contains(@class,'checkbox')]/p-checkbox");
	private By setUpClinicLabel = By.xpath("//div[text()=' Setup Your Clinic ']");
	
	
	
	
	String clinicOpenDay = "//div[text()='%replaceable%']/preceding-sibling::i";
	String timeSlotDropDown = "//span[text()='%replaceable%']/../../../following-sibling::div/div/ul/li[%index%]/p/p-calendar/following-sibling::i";
	String slotTimeTxtBx = "//span[text()='%replaceable%']/../../../following-sibling::div/div/ul/li[%index%]/p/p-calendar/span/input";
	
	
	Xls_Reader reader = new Xls_Reader("./src/main/resources/Mankind_UserName.xlsx");

	public DronaAddClinicPage(WebDriver driver) {

		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	Faker fakeData = new Faker();
	
	
	public String addClinicInformation(){
		
		 String clinicName = "Drona "+ fakeData.medical().hospitalName() ;
		 testUtil.dosendKeys(clinicNameTxtBx, 10, clinicName );
		 ExtentLogger.pass("Enter Clinic Name : " + clinicName );
		 testUtil.dosendKeys(selectCityTxtBx, 10, "Delhi");
		 testUtil.doClick(selectState, 10);
		 ExtentLogger.pass("Select the state");
		 testUtil.staticWait(3000);
		 testUtil.dosendKeys(assistantNumberTxtBx, 10, "8808726972" );
		 return clinicName;
	}
	
	public boolean addClinicInfoPageComeAfterDoSignUp() {
		
		boolean setUpClinicLabelview = false;
		dronaLoginPage = new DronaLoginPage(driver);
		String mobilenumber = "9" + fakeData.number().digits(9);
		dronaLoginPage.enterSignUpDetails(mobilenumber, "Praveen@123");
		reader.setCellData("Sheet1", "ClinicNumber",2, mobilenumber);
		if(testUtil.getElement(setUpClinicLabel).isDisplayed()) {
			
			setUpClinicLabelview = true;
		}
		 return setUpClinicLabelview;
	}
	
	public void saveAndContinue() {
		
		testUtil.doClick(saveAndContinueBtn, "saveAndContinueBtn");
	}
    
	public void selectSlotDuration() {
		
		testUtil.doClick(slotLngthDropDownBtn, "slotLngthDropDownBtn");
		testUtil.doClick(selectSlotLngth, "selectSlotLngth");
	}
	
    public void selectClinicDay(String day) {
		
		String openDayXpath = testUtil.getXpath(clinicOpenDay, day);
		testUtil.doClick(By.xpath(openDayXpath), day);
	}
    
    public void opentimerDropDown(String slotPhase , String index) {
    	
    	String opentimerDropDownXpath = testUtil.getXpath(timeSlotDropDown, slotPhase , index);
    	testUtil.doClick(By.xpath(opentimerDropDownXpath), slotPhase);
    }
	
    public void setClinicTime(String slotPhase , String index , String slotTime) {
    	
    	String setClinicTimeXpath = testUtil.getXpath(slotTimeTxtBx, slotPhase , index);
    	testUtil.dosendKeys(By.xpath(setClinicTimeXpath), 10, slotTime, slotTime);
    	
    }
    
    public void enterConsultationFeeInClinic(String consultationFee) {
    	
    	testUtil.dosendKeys(consulationFeeInClincTxtBx, 10, consultationFee, consultationFee + " Entered");
    }
    
    public void enterFollowUpFeeInClinic(String followUpFee) {
    	
    	testUtil.dosendKeys(followUpFeeInClinicTxtBx, 10, followUpFee, followUpFee + " Entered");
    }
 
    public void enterFollowUpDaysInClinic(String followUpDays) {
 	
 	    testUtil.dosendKeys(followUpDaysInClinicTxtBx, 10, followUpDays, followUpDays + " Entered");    
    }
    
    public void samevirtualFeeChkBoxChkd() {
    	
    	testUtil.doClick(sameAsInClinicChkBx , "sameAsInClinicChkBx");
    }
    
    

	

}
