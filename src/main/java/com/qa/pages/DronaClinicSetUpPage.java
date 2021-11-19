package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;
import com.qa.utility.Xls_Reader;

public class DronaClinicSetUpPage extends BasePage {

	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;

	DronaAddClinicPage dronaAddClinicPage;
	AppointmentBookingPage appointmentBookingPage;
	DronaAddPatientPage dronaAddPatient;

	private By patientMenu = By.xpath("//span[text()='Patients']/..");
	private By EditCard = By.xpath(
			"//div[contains(text(),' In-Clinic Consultation ')]/parent::div/../../following-sibling::div/div[1]/div/div/following-sibling::div/div/img");
	private By patientHeadBtn = By.xpath("//button[contains(@class,'Pateints_Search_head')]");
	private By AddPatient = By.xpath("//span[text()='Add Patient']");
	private By HomeBtn = By.xpath("//span[text()='Home']");
	private By CopyAll = By.xpath("//li[text()='Copy to all']");
	private By ToastDuplicateMessage = By
			.xpath("//div[text()='Date range is conflicting with other setup date range']/ancestor::p-toastitem");
	private By ToastTimeConflictMessage = By
			.xpath("//div[text()='Doctor timings conflicting with clinic timings']/ancestor::p-toastitem");
	private By EditBtn = By.xpath("//div[text()=' Edit ']");
	private By editClinicBtn = By.xpath("//button[text()='Edit Clinic']");
	private By inClinicSetUpScheduleBtn = By
			.xpath("//div[contains(text(),' In-Clinic Consultation ')]/../../following-sibling::div/div/img");
	private By firtsInClinicSetUpScheduleBtn = By.xpath(
			"//div[contains(text(),' In-Clinic Consultation ')]/../../../following-sibling::div[2]/div/div/button[text()='Set-Up Timings']");
	private By firtsVirtualSetUpScheduleBtn = By.xpath(
			"//div[contains(text(),' Virtual Consultation ')]/../../../following-sibling::div[2]/div/div/button[text()='Set-Up Timings']");
	private By virtualClinicSetUpScheduleBtn = By
			.xpath("//div[contains(text(),' Virtual Consultation ')]/../../following-sibling::div/div/img");
	private By sndytoggleClk = By.xpath("//div[@class='p-col-6 dayValue']/div[1]/div[2]/p-inputswitch");
	private By dateRangeTxtBx = By.xpath("//input[@name='daterange']");
	private By slctCurrentDate = By
			.xpath("//div[@class='calendar left ng-star-inserted']/div/table/tbody/tr/td[contains(@class,'today')]");
	private By NextDate = By.xpath(
			"//div[@class='calendar left ng-star-inserted']/div/table/tbody/tr/td[contains(@class,'today')]/following-sibling::td");
	private By lftHndCalendar = By.xpath("//div[@class='calendar left ng-star-inserted']");
	private By copyToAllBtn = By.xpath("//span[text()='Copy to All']/..");
	private By mndyStartTimeTxtBx = By
			.xpath("//a[text()='Monday']/../following-sibling::div[2]/div/div[1]/p/p-calendar/span/input");
	private By mndyEndTimeTxtBx = By
			.xpath("//a[text()='Monday']/../following-sibling::div[2]/div/div[2]/p/p-calendar/span/input");
	private By mndyStartTime = By.xpath(
			"//a[text()='Monday']/../following-sibling::div[2]/div/div[1]/p/p-calendar/span/div/div/div[1]/span");
	private By mndyEndTime = By.xpath(
			"//a[text()='Monday']/../following-sibling::div[2]/div/div[2]/p/p-calendar/span/div/div/div[1]/span");
	
	
	private By selectSlotLngthEdit = By.xpath("//span[text()='5']/parent::li");
	private By followUpDaysIncreaseBtn = By.xpath("//div[text()='Follow-up Valid for*']/button[2]");
	private By followUpDaysDecreaseBtn = By.xpath("//div[text()='Follow-up Valid for*']/button[1]");
	
	private By saveBtn = By.xpath("//span[text()='Save']/..");
	private By virtualSetUpScheduleBtn = By
			.xpath("//label[text()='Virtual Consult Timings']/parent::div/../../../following-sibling::div/button");
	private By setScheduleDateLabel = By.xpath(
			"//div[contains(text(),' In-Clinic Consultation ')]/parent::div/../../following-sibling::div/div[1]/div/div/div/div");
	private By InclinicEditClick = By.xpath("//div[@class='in_clinic']/div/div/div/div[3]/label/img");
	private By selectScheduleEndDate = By
			.xpath("//div[@class='calendar right ng-star-inserted']/div/table/tbody/tr[2]/td[1]/span[text()='1']");
	private By selectScheduleEndDateForEdit = By
			.xpath("//div[@class='calendar right ng-star-inserted']/div/table/tbody/tr[1]/td/span[text()='2']");
	private By newCrardStartDate = By
			.xpath("//div[@class='calendar right ng-star-inserted']/div/table/tbody/tr[1]/td/span[text()='3']");
	private By newCardEndDate = By
			.xpath("//div[@class='calendar right ng-star-inserted']/div/table/tbody/tr[1]/td/span[text()='4']");
	private By caledarOkBtn = By.xpath("//button[text()='ok']");
	private By slotLengthLabel = By
			.xpath("//div[@class='in_clinic']/div[2]/div/div/div/div[text()='Slot Length :']/following-sibling::div");
	private By slotDropDownClk = By.xpath("//p-dropdown[@name='slots']/div/div[2]/span");
	private By consulationFeeLabel = By.xpath(
			"//div[@class='in_clinic']/div[2]/div/div/div/div[text()='Consultation Fee :']/following-sibling::div");
	private By editConsulationFeeTxtBx = By
			.xpath("//div[text()='Consultation Fee*']/parent::div/following-sibling::div[1]/div/span/input");
	private By editFollowUpFeeTxtBx = By
			.xpath("//div[text()='Consultation Fee*']/parent::div/following-sibling::div[2]/div/span/input");
	private By followUpFeeLabel = By.xpath(
			"//div[@class='in_clinic']/div[2]/div/div/div/div[contains(text(),'Follow-up')]/following-sibling::div");
	private By CopyTiming = By.xpath("//span[text()='Copy to All']");
	private By Cardmessage = By.xpath("//span[text()='Confirmation']/../following::div");
	private By YesBtn = By.xpath("//span[text()='Yes']");
	
	
	private By consulationFeeInClincTxtBx = By.xpath("//h4[text()='In-Clinic Consultation']/../../following-sibling::div[1]/div/label[text()='Consultation Fee*']/following-sibling::div/input");
	private By followUpFeeInClinicTxtBx = By.xpath("//h4[text()='In-Clinic Consultation']/../../following-sibling::div[1]/div/label[text()='Follow-up Fee']/following-sibling::div/input");
	private By followUpDaysInClinicTxtBx = By.xpath("//h4[text()='In-Clinic Consultation']/../../following-sibling::div[1]/div/label[text()='Follow-up Valid for (Days)']/following-sibling::div/input");
	private By slotLngthDropDownBtn = By.xpath("//h4[contains(text(),'Slot Duration')]/../../following-sibling::div/div/p-dropdown/div/div[2]/span");
	private By selectSlotLngth = By.xpath("//span[text()='5 mins']/parent::li");
	private By consulationFeeVirtualTxtBx = By.xpath("//h4[text()='Virtual Consultation']/../../following-sibling::div[1]/div/label[text()='Consultation Fee*']/following-sibling::div/input");
	private By followUpFeeVirtualTxtBx = By.xpath("//h4[text()='Virtual Consultation']/../../following-sibling::div[1]/div/label[text()='Follow-up Fee']/following-sibling::div/input");
	private By followUpDaysVirtualTxtBx = By.xpath("//h4[text()='Virtual Consultation']/../../following-sibling::div[1]/div/label[text()='Follow-up Valid for (Days)']/following-sibling::div/input");
	private By sameAsInClinicChkBx = By.xpath("//div[contains(@class,'checkbox')]/p-checkbox");
	
	
	String clinicOpenDay = "//div[text()='%replaceable%']/preceding-sibling::i";
	String timeSlotDropDown = "//span[text()='%replaceable%']/../../../following-sibling::div/div/ul/li[%index%]/p/p-calendar/following-sibling::i";
	String slotTimeTxtBx = "//span[text()='%replaceable%']/../../../following-sibling::div/div/ul/li[%index%]/p/p-calendar/span/input";
	
	
	Xls_Reader reader = new Xls_Reader("./src/main/resources/Mankind_UserName.xlsx");

	public DronaClinicSetUpPage(WebDriver driver) {
		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
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
    	
    	String opentimerDropDownXpath = testUtil.getXpath(clinicOpenDay, slotPhase , index);
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
    
    
    
    
    
    
    

	/*
	 * public void editClinicBtnClk() {
	 * 
	 * testUtil.staticWait(3000); testUtil.doClick(editClinicBtn, 10);
	 * ExtentLogger.pass("Click on edit clinic button."); }
	 * 
	 * public void inClincTimingSetUpBtnClk() {
	 * 
	 * testUtil.doClick(inClinicSetUpScheduleBtn, 10);
	 * ExtentLogger.pass("Click on In Clinic setUp Schedule button"); }
	 * 
	 * public void virtualTimingSetUpBtnClk() { testUtil.staticWait(2000);
	 * javaScriptUtil.scrollPageDown(); testUtil.staticWait(2000);
	 * testUtil.doClick(virtualClinicSetUpScheduleBtn, 10);
	 * ExtentLogger.pass("Click on Virtual setUp Schedule button."); }
	 * 
	 * public void firstinClincTimingSetUpBtnClk() {
	 * 
	 * testUtil.doClick(firtsInClinicSetUpScheduleBtn, 10);
	 * ExtentLogger.pass("Click on In Clinic setUp Schedule button"); }
	 * 
	 * public void firstvirtualTimingSetUpBtnClk() { testUtil.staticWait(2000);
	 * javaScriptUtil.scrollPageDown(); testUtil.staticWait(2000);
	 * testUtil.doClick(firtsVirtualSetUpScheduleBtn, 10);
	 * ExtentLogger.pass("Click on Virtual setUp Schedule button."); }
	 * 
	 * public void verifyDaySwitch() {
	 * 
	 * javaScriptUtil.scrollPageUp(); javaScriptUtil.scrollPageUp();
	 * javaScriptUtil.scrollPageUp(); List<WebElement> dayOpenCloseSwitchs =
	 * getDriver().findElements( By.
	 * xpath("//div[@class='p-col-7 dayValue ng-star-inserted']/div/div/div/div[2]/p-inputswitch"
	 * )); for (WebElement daySwitch : dayOpenCloseSwitchs) {
	 * 
	 * testUtil.doActionsClick(daySwitch); ExtentLogger.pass("Open All days"); }
	 * 
	 * }
	 * 
	 * public void setTimeToscheduleSetup(String inTime, String outTime) {
	 * 
	 * 
	 * testUtil.doActionsClick(sndytoggleClk); testUtil.staticWait(2000);
	 * 
	 * WebElement sndyTimeTxtBx1 = getDriver().findElement( By.xpath(
	 * "//a[text()='Sunday']/../following-sibling::div[2]/div/div[1]/p/p-calendar/span/input"
	 * )); sndyTimeTxtBx1.sendKeys(Keys.CONTROL + "a");
	 * sndyTimeTxtBx1.sendKeys(Keys.DELETE); testUtil.staticWait(2000);
	 * System.out.println(reader.getCellData("Sheet1", 7, 2)); WebElement
	 * sndyTimeTxtBx2 = getDriver().findElement( By.xpath(
	 * "//a[text()='Sunday']/../following-sibling::div[2]/div/div[2]/p/p-calendar/span/input"
	 * )); javaScriptUtil.scrollPageUp(); sndyTimeTxtBx1.sendKeys(inTime);
	 * ExtentLogger.pass("Set the clinic start time.");
	 * sndyTimeTxtBx1.sendKeys(Keys.ESCAPE); testUtil.staticWait(2000);
	 * sndyTimeTxtBx2.sendKeys(Keys.CONTROL + "a");
	 * sndyTimeTxtBx2.sendKeys(Keys.DELETE); testUtil.staticWait(4000);
	 * sndyTimeTxtBx2.sendKeys(outTime);
	 * ExtentLogger.pass("Set the clinic End time.");
	 * sndyTimeTxtBx2.sendKeys(Keys.ESCAPE);
	 * 
	 * }
	 * 
	 * public void selectDateFromDatePicker() {
	 * 
	 * testUtil.staticWait(2000); javaScriptUtil.scrollPageDown(); WebElement
	 * dateRangeTxtbx = testUtil.getElement(dateRangeTxtBx);
	 * javaScriptUtil.clickElementByJS(dateRangeTxtbx); testUtil.staticWait(2000);
	 * WebElement todayDate = testUtil.getElement(slctCurrentDate);
	 * javaScriptUtil.clickElementByJS(todayDate); testUtil.staticWait(2000);
	 * WebElement tomorrowDate = testUtil.getElement(NextDate);
	 * javaScriptUtil.clickElementByJS(tomorrowDate); testUtil.staticWait(2000);
	 * ExtentLogger.pass("Set the clinic schedule start date.");
	 * testUtil.doActionsClick(caledarOkBtn); }
	 * 
	 * public void selectNewCardDateFromDatePicker() {
	 * 
	 * testUtil.staticWait(2000); javaScriptUtil.scrollPageDown(); WebElement
	 * dateRangeTxtbx = testUtil.getElement(dateRangeTxtBx);
	 * javaScriptUtil.clickElementByJS(dateRangeTxtbx); testUtil.staticWait(2000);
	 * WebElement todayDate = testUtil.getElement(newCrardStartDate);
	 * javaScriptUtil.clickElementByJS(todayDate); testUtil.staticWait(2000);
	 * WebElement tomorrowDate = testUtil.getElement(newCardEndDate);
	 * javaScriptUtil.clickElementByJS(tomorrowDate); testUtil.staticWait(2000);
	 * ExtentLogger.pass("Set the clinic schedule start date.");
	 * testUtil.doActionsClick(caledarOkBtn); }
	 * 
	 * public void copyTimeForAllDay() {
	 * 
	 * 
	 * JavascriptExecutor executor = (JavascriptExecutor)getDriver();
	 * executor.executeScript("document.body.style.zoom = '1.1'");
	 * testUtil.staticWait(3000); testUtil.clickElementByJSWithwait(copyToAllBtn,
	 * 10); WebElement copyToAllBtn = getDriver().findElement(By.
	 * cssSelector("div.p-col-2.ahrs.ng-star-inserted > span"));
	 * javaScriptUtil.clickElementByJS(copyToAllBtn);
	 * 
	 * javaScriptUtil.scrollPageUp(); testUtil.doClick(CopyTiming, 10);
	 * ExtentLogger.pass("Click on copy to all button."); }
	 * 
	 * public String[] verifyCopyToAllfunctionality() {
	 * 
	 * copyTimeForAllDay(); testUtil.staticWait(2000); WebElement mndyStartTimeTxtbx
	 * = testUtil.getElement(mndyStartTimeTxtBx);
	 * javaScriptUtil.clickElementByJS(mndyStartTimeTxtbx); String MondayStartTime =
	 * testUtil.doGetText(mndyStartTime); getDriver() .findElement(By .xpath(
	 * "//a[text()='Monday']/../following-sibling::div[2]/div/div[1]/p/p-calendar/span/input"
	 * )) .sendKeys(Keys.ESCAPE); testUtil.staticWait(2000); WebElement
	 * mndyEndTimeTxtbx = testUtil.getElement(mndyEndTimeTxtBx);
	 * javaScriptUtil.clickElementByJS(mndyEndTimeTxtbx); String MondayEndTime =
	 * testUtil.doGetText(mndyEndTime); String[] MondaySetTime = { MondayStartTime,
	 * MondayEndTime }; System.out.println(MondaySetTime);
	 * ExtentLogger.pass("verify that start time or End time on copy to all click."
	 * ); return MondaySetTime; }
	 * 
	 * public void EnterSlotOrFeeDetail() {
	 * 
	 * WebElement slotLngthDropDownclk = testUtil.getElement(slotLngthDropDownBtn);
	 * javaScriptUtil.clickElementByJS(slotLngthDropDownclk); WebElement
	 * selectSlotLngthClk = testUtil.getElement(selectSlotLngth);
	 * javaScriptUtil.clickElementByJS(selectSlotLngthClk);
	 * ExtentLogger.pass("Select the slot length");
	 * testUtil.dosendKeys(consulationFeeTxtBx, 10, "1");
	 * ExtentLogger.pass("Enter the consulationFee");
	 * testUtil.dosendKeys(followUpFeeTxtBx, 10, "1");
	 * ExtentLogger.pass("Enter the followUpFee"); }
	 * 
	 * public void followUpValidDays() {
	 * 
	 * WebElement followUpDaysIncreaseclk =
	 * testUtil.getElement(followUpDaysIncreaseBtn);
	 * javaScriptUtil.clickElementByJS(followUpDaysIncreaseclk);
	 * javaScriptUtil.clickElementByJS(followUpDaysIncreaseclk);
	 * ExtentLogger.pass("Update the followUp Days"); }
	 * 
	 * public void SetUpSave() {
	 * 
	 * javaScriptUtil.scrollPageUp(); // testUtil.staticWait(2000);
	 * testUtil.doClick(saveBtn, 10); // WebElement SaveBtnClk =
	 * testUtil.getElement(saveBtn); // javaScriptUtil.clickElementByJS(SaveBtnClk);
	 * ExtentLogger.pass("Click on SetUp save Button."); //
	 * testUtil.staticWait(2000); }
	 * 
	 * public String dateconvrt(String date) {
	 * 
	 * String[] arrStr = date.split("-"); String updatedString = arrStr[1];
	 * updatedString = updatedString.replaceAll(" ", ""); String convrtdStrng =
	 * updatedString.substring(0, 2); return convrtdStrng; }
	 * 
	 * 
	 * public boolean editDatePeriod() {
	 * 
	 * boolean dateEdited = false;
	 * 
	 * testUtil.doClick(EditCard, 10); testUtil.staticWait(2000);
	 * javaScriptUtil.scrollPageDown(); javaScriptUtil.scrollPageDown(); WebElement
	 * dateRangeTxtbx = testUtil.getElement(dateRangeTxtBx);
	 * javaScriptUtil.clickElementByJS(dateRangeTxtbx); testUtil.staticWait(2000);
	 * WebElement todayDate = testUtil.getElement(slctCurrentDate);
	 * javaScriptUtil.clickElementByJS(todayDate);
	 * ExtentLogger.pass("Set the clinic schedule start date."); WebElement
	 * ScheduleEndDate = testUtil.getElement(selectScheduleEndDateForEdit);
	 * javaScriptUtil.clickElementByJS(ScheduleEndDate);
	 * ExtentLogger.pass("Set the clinic schedule End date.");
	 * testUtil.staticWait(2000); testUtil.doActionsClick(caledarOkBtn);
	 * testUtil.staticWait(2000); SetUpSave(); testUtil.staticWait(3000); String
	 * editedSetScheduleDate = testUtil.doGetText(setScheduleDateLabel); String
	 * editedDate = dateconvrt(editedSetScheduleDate);
	 * System.out.println(editedDate); if (editedDate.equalsIgnoreCase("02")) {
	 * dateEdited = true; ExtentLogger.pass("Date Edited successfully."); } return
	 * dateEdited; }
	 * 
	 * public boolean editSlotLength() {
	 * 
	 * boolean editSlotLength = false; testUtil.doClick(EditCard, 10);
	 * testUtil.staticWait(2000); javaScriptUtil.scrollPageDown();
	 * testUtil.staticWait(2000); WebElement slotLngthDropDownclk =
	 * testUtil.getElement(slotDropDownClk);
	 * javaScriptUtil.clickElementByJS(slotLngthDropDownclk); WebElement
	 * selectSlotLngthClk = testUtil.getElement(selectSlotLngthEdit);
	 * javaScriptUtil.clickElementByJS(selectSlotLngthClk);
	 * ExtentLogger.pass("Select the slot length"); testUtil.staticWait(2000);
	 * SetUpSave(); String slotLength = testUtil.doGetText(slotLengthLabel);
	 * System.out.println(slotLength); ExtentLogger.pass("Verify the slot length.");
	 * if (slotLength.equalsIgnoreCase("15 mins")) { editSlotLength = true;
	 * ExtentLogger.pass("Slot Edited successfully."); } return editSlotLength; }
	 * 
	 * public boolean editConsulationFee() {
	 * 
	 * boolean consulationFeeEdited = false; testUtil.doClick(InclinicEditClick,
	 * 10); testUtil.staticWait(2000); javaScriptUtil.scrollPageDown();
	 * testUtil.doClearText(editConsulationFeeTxtBx); testUtil.staticWait(2000);
	 * ExtentLogger.pass("Clear the previous consulationFee");
	 * testUtil.staticWait(2000);
	 * testUtil.doActionsSendKeys(editConsulationFeeTxtBx, "1800");
	 * ExtentLogger.pass("Enter the new consulationFee");
	 * testUtil.doClick(editFollowUpFeeTxtBx, 10); testUtil.staticWait(2000);
	 * SetUpSave(); String consulationFee = testUtil.doGetText(consulationFeeLabel);
	 * consulationFee = consulationFee.substring(1);
	 * System.out.println(consulationFee);
	 * ExtentLogger.pass("Verify the edited consulation fee"); if
	 * (consulationFee.equalsIgnoreCase("1400")) { consulationFeeEdited = true;
	 * ExtentLogger.pass("consulation fee Edited successfully."); } return
	 * consulationFeeEdited; }
	 * 
	 * public boolean editFollowUpFee() {
	 * 
	 * boolean FollowUpFeeEdited = false; testUtil.doClick(InclinicEditClick, 10);
	 * testUtil.staticWait(2000); javaScriptUtil.scrollPageDown();
	 * 
	 * testUtil.doClearText( editFollowUpFeeTxtBx); testUtil.staticWait(2000);
	 * 
	 * ExtentLogger.pass("Clear the previous consulationFee");
	 * testUtil.staticWait(2000); WebElement FollowUpFeeTxtBx =
	 * testUtil.getElement(editFollowUpFeeTxtBx);
	 * javaScriptUtil.javaScriptSendKeys(FollowUpFeeTxtBx, "1500");
	 * ExtentLogger.pass("Enter the new consulationFee"); testUtil.staticWait(2000);
	 * SetUpSave(); String FollowUpFee = testUtil.doGetText(followUpFeeLabel);
	 * FollowUpFee = FollowUpFee.substring(1); System.out.println(FollowUpFee);
	 * ExtentLogger.pass("Verify the edited consulation fee"); if
	 * (FollowUpFee.equalsIgnoreCase("1500")) { FollowUpFeeEdited = true;
	 * ExtentLogger.pass("consulation fee Edited successfully."); } return
	 * FollowUpFeeEdited; }
	 * 
	 * public boolean verifyduplicateClinictime() {
	 * 
	 * boolean Toast = false;
	 * 
	 * editClinicBtnClk(); inClincTimingSetUpBtnClk(); verifyDaySwitch();
	 * setTimeToscheduleSetup("08:00 PM", "09:00 PM"); copyTimeForAllDay();
	 * selectDateFromDatePicker(); EnterSlotOrFeeDetail(); followUpValidDays();
	 * SetUpSave(); try {
	 * 
	 * if (testUtil.doIsDisplayed(ToastDuplicateMessage)) {
	 * 
	 * Toast = true; } } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); System.out.println("Error popup is not showing"); }
	 * return Toast;
	 * 
	 * }
	 * 
	 * public boolean VerifyClinicDocTimeValidation() {
	 * 
	 * boolean Toast = false; editClinicBtnClk(); inClincTimingSetUpBtnClk();
	 * verifyDaySwitch(); setTimeToscheduleSetup("07:00 AM", "07:40 AM");
	 * copyTimeForAllDay(); selectNewCardDateFromDatePicker();
	 * EnterSlotOrFeeDetail(); followUpValidDays(); SetUpSave();
	 * 
	 * try {
	 * 
	 * if (testUtil.doIsDisplayed(ToastTimeConflictMessage)) {
	 * 
	 * Toast = true; } } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); System.out.println("Error popup is not showing"); }
	 * return Toast;
	 * 
	 * }
	 * 
	 * public boolean verifyNewCardSlotValidation() {
	 * 
	 * boolean Toast = false;
	 * 
	 * 
	 * testUtil.staticWait(3000); appointmentBookingPage = new
	 * AppointmentBookingPage(driver); appointmentBookingPage.AppointmentBooking();
	 * testUtil.staticWait(3000); testUtil.doClick(HomeBtn, 10);
	 * testUtil.staticWait(2000); editClinicBtnClk(); testUtil.doClick(EditCard,
	 * "Edit button"); setTimeToscheduleSetup("08:00 AM", "08:20 PM");
	 * copyTimeForAllDay(); SetUpSave(); String[] DateRange =
	 * driver.findElement(Cardmessage).getText().split(","); String PopUpDate =
	 * DateRange[1]; String UpdatedFormatableDate = testUtil.dateCheck(PopUpDate);
	 * testUtil.doClick(YesBtn, 10); testUtil.staticWait(2000); String CardTimePath
	 * =
	 * "//div[contains(text(),' In-Clinic Consultation ')]/parent::div/../../following-sibling::div/div/div/div/div/div[text()= '"
	 * + UpdatedFormatableDate + " ']"; WebElement bookedPatenitAppointment =
	 * driver.findElement(By.xpath(CardTimePath));
	 * 
	 * if (bookedPatenitAppointment.isDisplayed()) {
	 * 
	 * Toast = true; } return Toast;
	 * 
	 * }
	 */
}
