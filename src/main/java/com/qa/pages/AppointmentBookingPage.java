package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class AppointmentBookingPage extends BasePage {

	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;

	DronaAddPatientPage dronaAddPatientPage;

	private By patientMenu = By.xpath("//span[text()='Patients ']/..");
	private By appointmentMenu = By.xpath("//span[text()='Appointments']/..");
	private By AppointmentHeadBtn = By.xpath("//span[text()='Add Appointment']/..");
	private By WalkinBtn = By.xpath("//span[text()='Add Walk-in']/..");
	private By totalSlot = By.xpath("//li[contains(@class,'isAvailble')]");
	private By nxtBtn = By.xpath("//span[text()='Next']/..");
	private By continueBtn = By.xpath("//button[text()='Continue']");
	
	private By patientSearch = By
			.xpath("//input[@placeholder='Search']");
	private By addPatientBtn = By.xpath("//span[text()='Add New Patient']");
	private By patientMobileNoSearch = By.xpath("//input[@placeholder='Name']");
	private By slctPatientFromSearch = By.xpath("//span[contains(@class,'Pname-v2')]");
	private By followUpChkBxSlct = By.xpath("//span[text()='Follow Up']");
	private By notesTxtBx = By.xpath("//div[text()='Notes']/following-sibling::textarea");
	private By confirmAppointmentBtn = By.xpath("//button[text()='Confirm Appointment']");
	private By rescheduleconfirmAppointmentBtn = By.xpath("//span[text()='Confirm Appointment']/..");	
	private By confirmAppointmentOkPopUp = By.xpath("//button[text()='Ok ']");	
	private By appointmentCount = By.xpath("//h4[contains(text(),' Appointments')]");
	private By appointmentTime = By
			.xpath("//div[contains(@class,'row')]/div[4]/div[contains(@class,'slots-time')]/div/span[1]");
	private By bookedSlot = By.xpath("//div[contains(@class,'row')]/div[4]/div");
	private By virtualSlotBtn = By.xpath("//span[text()='Virtual']/..");
	private By threeDotBtn = By.xpath("//div[@class='dropdown']/i[@id='dropdownMenuLink'][1]");
	private By addNewBtn = By.xpath("//button[@id='dropdownAddnew']");
	private By confirmWalkinBtn = By.xpath("//span[text()='Add Walk-In']/parent::button");
	private By rescheduleSlotTime = By.xpath("//ul[contains(@class,'slot')]/div[15]/div/li");
	private By nextDay = By.xpath("//span[contains(text(),'Today')]/ancestor::a/../following-sibling::div/div/a");
	private By cancelAppointmentChkBx = By
			.xpath("//label[text()='Patient not available']/preceding-sibling::p-radiobutton");
	private By cancelAppointmentBtn = By.xpath("//button[text()='Yes, Cancel']");
	private By checkedINBtn = By.xpath("//span[contains(text(),'Check In')]/..");
	private By patientSearchName = By.xpath("//input[@placeholder='Enter Patient Name']");
	private By firstAppointmentPath = By
			.xpath("//h4[contains(text(),'Appointments')]/../../../following-sibling::div[1]/div");
	private By firstcheckedInAppointmentPath = By
			.xpath("//h4[contains(text(),' Checked In')]/../../../../../following-sibling::div[1]/div");
	private By secondAppointmentPath = By
			.xpath("//h4[contains(text(),'Appointments')]/../../../following-sibling::div[2]/div");
	private By upperAppointment = By.xpath("//h4[contains(text(),'Pending')]/../../../../../following-sibling::div[1]/div/div[2]/div/div[1]");
	private By lowerAppointment = By.xpath("//h4[contains(text(),'Pending')]/../../../../../following-sibling::div[2]/div/div[2]/div/div[1]");
	private By firstDragAppointment = By.xpath("//div[@pdraggable='vital'][1]");
	private By secondDragAppointment = By.xpath("//div[@pdraggable='vital'][2]");
	private By reorderBtn = By.xpath("//h4[contains(text(),' Reorder ')]");
	private By doneBtn = By.xpath("//h4[contains(text(),' Done ')]");
	
	
	

	public AppointmentBookingPage(WebDriver driver) {

		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	public void headBookAppointmentClick() {

		testUtil.doClick(addNewBtn, "Add New Button ");
		WebElement AppointmentBookBtn = testUtil.getElement(AppointmentHeadBtn);
		javaScriptUtil.clickElementByJS(AppointmentBookBtn);
		ExtentLogger.pass("Clicked on Book appointment.");
	}

	public void walkinClick() {

		testUtil.doClick(addNewBtn, "Add New Button ");
		WebElement AppointmentBookBtn = testUtil.getElement(WalkinBtn);
		javaScriptUtil.clickElementByJS(AppointmentBookBtn);
		ExtentLogger.pass("Clicked on Add Walkin Btn.");
	}

	public void virtualSlotSectionBtn() {

		WebElement virtualSectionSelect = testUtil.getElement(virtualSlotBtn);
		javaScriptUtil.clickElementByJS(virtualSectionSelect);
		ExtentLogger.pass("Clicked on virtual slot section Button.");

	}

	public void clkChkdInBtn() {

		testUtil.doClick(checkedINBtn, "Checked In Btn");
	}

	public void checkedInAppointment() {

		testUtil.doClick(firstAppointmentPath, "First Appointment");
		clkChkdInBtn();
		testUtil.doClick(secondAppointmentPath, "Second Appointment");
		clkChkdInBtn();
	}

	public void patientMenuClick() {

		testUtil.staticWait(5000);
		WebElement patientMenuClk = testUtil.getElement(patientMenu);
		javaScriptUtil.clickElementByJS(patientMenuClk);
		testUtil.staticWait(5000);
		ExtentLogger.pass("Clicked on patient icon in menu bar.");
	}

	public void AppointmentMenuClick() {

		testUtil.staticWait(5000);
		WebElement appointmentMenuClk = testUtil.getElement(appointmentMenu);
		javaScriptUtil.clickElementByJS(appointmentMenuClk);
		testUtil.staticWait(5000);
		ExtentLogger.pass("Clicked on Appointment  icon in menu bar.");
	}

	public String bookSlot(int slotNumber) {

		String slotTime = "";
		List<WebElement> availableSlot = driver.findElements(totalSlot);
		for (WebElement selectedSlot : availableSlot) {

			String slotType = selectedSlot.getAttribute("class");
			System.out.println(slotType);
			if (!slotType.contains("isNtAvailble ")) {

				javaScriptUtil.clickElementByJS(selectedSlot);
				slotTime = selectedSlot.getText();
				break;
			}
		}
		testUtil.doClick(continueBtn, 10);
		ExtentLogger.pass("Slot selected successfully");
		return slotTime;
	}

	public String addNewPatient() {

		testUtil.dosendKeys(patientSearch, 10, "pr");
		testUtil.doClick(addPatientBtn, 10);
		dronaAddPatientPage = new DronaAddPatientPage(driver);
		String[] patientDetail = dronaAddPatientPage.enterPatientDetail();
		String PatientContact = patientDetail[0];
		dronaAddPatientPage.saveNewPatient();
		ExtentLogger.pass("New patient added successfully.");
		return PatientContact;
	}

	public void patientSearch(String patientContactNo) {

		testUtil.dosendKeys(patientSearch, 10, "pr");
		testUtil.staticWait(1000);
		testUtil.doClearText(patientSearchName);
		testUtil.dosendKeys(patientSearchName, 10, patientContactNo);
		testUtil.doClick(slctPatientFromSearch, 10);
		try {
			testUtil.doClick(continueBtn, 10);
		} catch (Exception e) {
			
			testUtil.doClick(nxtBtn, 10);
		}
		ExtentLogger.pass("New patient searched and selected for appointment.");
	}

	public void enterAppointmentPurpose() {

		// testUtil.doClick(followUpChkBxSlct, 10);
		javaScriptUtil.clickElementByJS(testUtil.getElement(followUpChkBxSlct));
		testUtil.dosendKeys(notesTxtBx, 10, "Appointment booking");
		ExtentLogger.pass("Appointment booking purpose entered");
		try {
			testUtil.doClick(confirmAppointmentBtn, 10);
		} catch (Exception e) {
			testUtil.doClick(rescheduleconfirmAppointmentBtn, 10);
			e.printStackTrace();
		}
		testUtil.doClick(confirmAppointmentOkPopUp, "confirmAppointmentOkPopUp");
		ExtentLogger.pass("Appointment confirmed.");
	}

	public void confirmWalkin() {

		javaScriptUtil.clickElementByJS(testUtil.getElement(followUpChkBxSlct));
		testUtil.dosendKeys(notesTxtBx, 10, "Appointment booking");
		ExtentLogger.pass("Appointment booking purpose entered");
		testUtil.doClick(confirmWalkinBtn, 10);
		ExtentLogger.pass("Walkin confirmed.");
	}

	public void AppointmentBooking() {

		patientMenuClick();
		testUtil.staticWait(3000);
		headBookAppointmentClick();
		bookSlot(6);
		String PatientContact = addNewPatient();
		headBookAppointmentClick();
		bookSlot(6);
		patientSearch(PatientContact);
		enterAppointmentPurpose();
	}

	public boolean AppointmentBookingByHeadMenu() {

		boolean patientAppointmentView = false;
		AppointmentMenuClick();
		headBookAppointmentClick();
		bookSlot(6);
		String PatientContact = addNewPatient();
		headBookAppointmentClick();
		bookSlot(6);
		patientSearch(PatientContact);
		enterAppointmentPurpose();
		testUtil.staticWait(3000);
		String[] nameArr = PatientContact.split(" ");
		String PatientName = " " + nameArr[0];
		String bookedPatenitAppointmentPath = "//div[contains(text(),'" + PatientName + "')]";
		WebElement bookedPatenitAppointment = driver.findElement(By.xpath(bookedPatenitAppointmentPath));
		if (bookedPatenitAppointment.isDisplayed()) {

			patientAppointmentView = true;
		}
		return patientAppointmentView;

	}

	public boolean AppointmentBookingVirtual() {

		boolean patientAppointmentView = false;
		AppointmentMenuClick();
		headBookAppointmentClick();
		testUtil.staticWait(2000);
		virtualSlotSectionBtn();
		testUtil.staticWait(2000);
		bookSlot(1);
		String PatientContact = addNewPatient();
		headBookAppointmentClick();
		testUtil.staticWait(2000);
		virtualSlotSectionBtn();
		testUtil.staticWait(2000);
		bookSlot(1);
		patientSearch(PatientContact);
		enterAppointmentPurpose();
		String[] nameArr = PatientContact.split(" ");
		String PatientName = " " + nameArr[0];
		String bookedPatenitAppointmentPath = "//div[contains(text(),'" + PatientName + "')]";
		WebElement bookedPatenitAppointment = driver.findElement(By.xpath(bookedPatenitAppointmentPath));
		if (bookedPatenitAppointment.isDisplayed()) {

			patientAppointmentView = true;
		}
		return patientAppointmentView;

	}

	public boolean VerifyappointmentBookingCount() {

		boolean appointmentCountsverify = false;
		AppointmentMenuClick();
		String appointmentCounts = testUtil.doGetText(appointmentCount);
		appointmentCounts = appointmentCounts.substring(14).replace(")", "");
		int counts = Integer.parseInt(appointmentCounts);
		headBookAppointmentClick();
		bookSlot(6);
		String PatientContact = addNewPatient();
		headBookAppointmentClick();
		bookSlot(6);
		patientSearch(PatientContact);
		enterAppointmentPurpose();
		testUtil.staticWait(5000);
		String countsAfterBooking = testUtil.doGetText(appointmentCount);
		countsAfterBooking = countsAfterBooking.substring(14).replace(")", "");
		int updatedCount = Integer.parseInt(countsAfterBooking);
		if (counts == updatedCount - 1) {
			appointmentCountsverify = true;
		}
		return appointmentCountsverify;
	}

	public boolean verifyBookedSlot() {

		boolean bookedappointment = false;
		AppointmentMenuClick();
		headBookAppointmentClick();
	//	String appointmentSlotTime = testUtil.doGetText(appointmentTime);
		bookSlot(3);
		String PatientContact = addNewPatient();
		headBookAppointmentClick();
		String slotTime = bookSlot(3);
		slotTime = slotTime + " ";
		patientSearch(PatientContact);
		enterAppointmentPurpose();
		testUtil.staticWait(5000);
		headBookAppointmentClick();
		String slotPath = "//span[text()='" + slotTime + "']/parent::div/..";
		WebElement bookedAppointmentSlot = driver.findElement(By.xpath(slotPath));
		String slotType = bookedAppointmentSlot.getAttribute("class");
		if (slotType.contains("isNtAvailble ")) {

			bookedappointment = true;
		}

		return bookedappointment;
	}

	public void threeDotBtnClk(String PatientContact) {

		String threeDotBtnPath = "//div[contains(text(),'" + PatientContact	+ "')]/parent::div/../following-sibling::div[2]/div/i";
		WebElement threeDotBtn = driver.findElement(By.xpath(threeDotBtnPath));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(threeDotBtn));
		threeDotBtn.click();
	}

	public boolean rescheduleAppointment() {

		boolean appointmentReschedule = false;
		 AppointmentMenuClick();
		 testUtil.doClick(nextDay, "Next Day ");	
		 testUtil.staticWait(3000);
		 headBookAppointmentClick();
		 bookSlot(6);
		 String PatientContact = addNewPatient();
         testUtil.doClick(nextDay, "Next Day ");
		 testUtil.staticWait(3000);
		 headBookAppointmentClick();
		 bookSlot(6);
		 patientSearch(PatientContact); 
		 enterAppointmentPurpose();
		 testUtil.staticWait(5000);
		 driver.navigate().refresh();
		 testUtil.staticWait(3000);
		 testUtil.doClick(nextDay, "Next Day ");
		 String[] patientNameArr = PatientContact.split(" ");
		 String PatientFirstName = patientNameArr[0];
		 threeDotBtnClk(PatientFirstName);
		 testUtil.staticWait(3000);
		String reschedulePath = "//div[contains(text(),'" + PatientFirstName + "')]/parent::div/../following-sibling::div[2]/div/div/a[text()='Reschedule Appointment']";
		WebElement rescheduleBtn = driver.findElement(By.xpath(reschedulePath));
		javaScriptUtil.clickElementByJS(rescheduleBtn);
		javaScriptUtil.scrollPageDown();
		String slotTime = testUtil.doGetText(rescheduleSlotTime);
		System.out.println(slotTime);
		testUtil.doClick(rescheduleSlotTime, slotTime);
		testUtil.doClick(nxtBtn, 10);
		enterAppointmentPurpose();
		testUtil.staticWait(5000);
		testUtil.doClick(nextDay, "Next Day ");
		testUtil.staticWait(3000);
		String[] nameArr = PatientContact.split(" ");
		// PatientContact = nameArr[0] + " " +nameArr[1];
		String rescheduleAppointmentTimePath = "//div[contains(text(), '" + PatientFirstName + " ')]/parent::div/../following-sibling::div/div/div[text()=' In Clinic ']/preceding-sibling::div";
		WebElement rescheduleAppointment = driver.findElement(By.xpath(rescheduleAppointmentTimePath));
		String rescheduleAppointmentTime = rescheduleAppointment.getText();
		System.out.println(rescheduleAppointmentTime);
		if (slotTime.equalsIgnoreCase(rescheduleAppointmentTime)) {

			appointmentReschedule = true;
		}
		return appointmentReschedule;
	}

	public boolean walkinBooking() {

		boolean patientAppointmentView = false;
		AppointmentMenuClick();
		walkinClick();
		String PatientContact = addNewPatient();
		walkinClick();
		patientSearch(PatientContact);
		confirmWalkin();
		testUtil.staticWait(3000);
		String[] nameArr = PatientContact.split(" ");
		PatientContact = nameArr[0] + "  " + nameArr[1];
		String bookedPatenitAppointmentPath = "//div[contains(text(),'" + PatientContact + "')]";
		WebElement bookedPatenitAppointment = driver.findElement(By.xpath(bookedPatenitAppointmentPath));
		if (bookedPatenitAppointment.isDisplayed()) {

			patientAppointmentView = true;
		}
		return patientAppointmentView;

	}

	public boolean cancelAppointment() {

		boolean patientAppointmentCancel = false;
		AppointmentMenuClick();
		headBookAppointmentClick();
		testUtil.doClick(rescheduleSlotTime, "slotTime");
		testUtil.doClick(continueBtn, 10);
		String PatientContact = addNewPatient();
		headBookAppointmentClick();
		testUtil.doClick(rescheduleSlotTime, "slotTime");
		testUtil.doClick(continueBtn, 10);
		patientSearch(PatientContact);
		enterAppointmentPurpose();
		testUtil.staticWait(5000);
		 String[] patientNameArr = PatientContact.split(" ");
		 String PatientFirstName = patientNameArr[0];
		 threeDotBtnClk(PatientFirstName);
		 testUtil.staticWait(4000);
		String cancelPath = "//div[contains(text(),'" + PatientFirstName + "')]/parent::div/../following-sibling::div[2]/div/div/a[text()='Cancel Appointment']";
		WebElement cancelBtn = driver.findElement(By.xpath(cancelPath));
		javaScriptUtil.clickElementByJS(cancelBtn);
		testUtil.staticWait(3000);
		testUtil.doClick(cancelAppointmentChkBx, "cancelAppointmentChkBx");
		testUtil.doClick(cancelAppointmentBtn, cancelPath);
		testUtil.staticWait(3000);
		String cancelAppointmentPath = "//h4[contains(text(),' Cancelled Appointments')]/parent::div/../../following-sibling::div/div/div[2]/div/div[contains(text(),'"+ PatientContact + "')]";
		if (testUtil.doIsDisplayed(By.xpath(cancelAppointmentPath))) {

			patientAppointmentCancel = true;
		}
		return patientAppointmentCancel;
	}
	
	public boolean reorderFunctionality() {
		
		boolean appointmentReordered = false;
		String upperAppointmentPatientName = testUtil.getText(upperAppointment, "upperAppointmentPatientName");
		ExtentLogger.pass("Upper appointment is  : " + upperAppointmentPatientName);
		String lowerAppointmentPatientName = testUtil.getText(lowerAppointment, "lowerAppointmentPatientName");
		ExtentLogger.pass("lower appointment is  : " + lowerAppointmentPatientName);
		testUtil.doClick(reorderBtn, "Reorder Btn");
		WebElement sourceElement = testUtil.getElement(firstDragAppointment);
		WebElement destinationElement = testUtil.getElement(secondDragAppointment);
		JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				                    + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				                    + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				                    + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				                    + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				                    + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				                    + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				                    + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				                    + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				                    + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				                    + "var dropEvent = createEvent('drop');\n"
				                    + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				                    + "var dragEndEvent = createEvent('dragend');\n"
				                    + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				                    + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				                    + "simulateHTML5DragAndDrop(source,destination);", sourceElement, destinationElement);
				ExtentLogger.pass("Appointment Drag and Drop successfully.");
		testUtil.doClick(doneBtn, "Done Btn");
		String updatedAppointmentPatientName = testUtil.getText(upperAppointment, "upperAppointmentPatientName");
		if(updatedAppointmentPatientName.equalsIgnoreCase(lowerAppointmentPatientName)) {
			
			appointmentReordered = true;
		}
		return appointmentReordered;
	}

}
