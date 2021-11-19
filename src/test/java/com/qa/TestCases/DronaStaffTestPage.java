package com.qa.TestCases;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.AppointmentBookingPage;
import com.qa.pages.DronaStaffPage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.TestUtil;

public class DronaStaffTestPage extends BaseTest{
	
	//TO run this class we have 2 pending or 2 Apponitment status appointment.
	
	DronaStaffPage dronaStaffPage;
	AppointmentBookingPage appointmentBookingPage;
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 1 ,enabled = true , description = "Verify Add Staff and Shown In Staff List.")
    public void verifyAddStaff() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		assertEquals(dronaStaffPage.addAssitant(), true);
		ExtentLogger.pass("Add Staff and Shown In Staff List");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 2 ,enabled = true , description = "Verify Delete Staff and not Shown In Staff List.")
    public void verifyDeleteStaff() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		assertEquals(dronaStaffPage.deleteAssistant(), true);
		ExtentLogger.pass("Delete Staff and Not Shown In Staff List");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 3 ,enabled = true , description = "Verify Edit Staff.")
    public void verifyEditStaff() {
		
		HashMap<String,String> editStaffDetails = new HashMap<>();
		SoftAssert softAssert = new SoftAssert();
 		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		editStaffDetails = dronaStaffPage.editAssistantDetails();
		for(Map.Entry entry:editStaffDetails.entrySet()){
			softAssert.assertEquals(entry.getKey(), entry.getValue(), entry.getKey() +" Or " + entry.getValue() + " Not Matched.");
		}
		softAssert.assertAll();
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 4 ,enabled = true , description = "Verify Staff Login")
    public void verifyStaffLogin() {
			
 		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		assertEquals(dronaStaffPage.staffLoginFirstTime(), true);
		ExtentLogger.pass("Verify Staff password Set Or Staff Login");
	
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 5 ,enabled = true , description = "Verify Clinic details access")
    public void verifyNoAccessEditClickDetails() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.noEditDetailsAccess(), true);
		ExtentLogger.pass("Assistant is not able to edit clinic details if not have access.");
	
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 6 ,enabled = true , description = "Verify InClinic timing access")
    public void verifyNoAccessEditClickInClinicTimming() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.noEditInClinicTimingAccess(), true);
		ExtentLogger.pass("Assistant is not able to edit In clinic timming if not have access.");
	
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 7 ,enabled = true , description = "Verify virtual clinic timing access")
    public void verifyNoAccessEditClinicVirtualTimming() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.noEditVirtualTimmingAccess(), true);
		ExtentLogger.pass("Assistant is not able to edit virtual clinic timming if not have access.");
	
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 8 ,enabled = true , description = "Verify Medical history validation if assistant have not access.")
    public void verifyNoAccessMedicalHistory() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.medicalHistoryNotAccess(), true);
		ExtentLogger.pass("Assistant is not able to view medical History if not have access.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 9 ,enabled = true , description = "Verify Message validation if assistant have not access.")
    public void verifyNoAccessMessage() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.messageMenu(), true);
		ExtentLogger.pass("Assistant is not able to view message if not have access.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 10 ,enabled = true , description = "Verify Bill validation if assistant have not access.")
    public void verifyNoAccessCreateBill() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.noBillCreateAccess(), true);
		ExtentLogger.pass("Assistant is not able to create bill if not have access.");
	
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 11 ,enabled = true , description = "Verify File Upload validation if assistant have not access.")
    public void verifyNoAccessFileUpload() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.noFileUploadAccess(), true);
		ExtentLogger.pass("Assistant is not able to upload file if not have access.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 24 ,enabled = true , description = "Verify Assistant Name Edit by assistant")
    public void verifyAssistantNameEdit() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.assistantNameEdit(), true);
		ExtentLogger.pass("Assistant name edited successfully.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 12 ,enabled = true , description = "Verify medical history access.")
    public void verifymedicalHistoryAccess() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		assertEquals(dronaStaffPage.medicalHistoryaccessCheck(), true);
		ExtentLogger.pass("Medical history shown to the assistant if assistant have access.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 13 ,enabled = true , description = "Verify create bill access")
    public void verifyCreateBillAccess() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.createBillaccessCheck();
		ExtentLogger.pass("Assistant is able to create bill if assistant have access.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 14 ,enabled = true , description = "Verify clinic details access.")
    public void verifyClinicDetailsAccess() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		assertEquals(dronaStaffPage.updateClinicDetailAccess(), true);
		ExtentLogger.pass("assistant is able to edit the bill  if assistant have access.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 15 ,enabled = true , description = "Verify message Menu Access")
    public void verifyMessageMenuAccess() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		assertEquals(dronaStaffPage.messageMenuAccess(), true);
		ExtentLogger.pass("assistant is able to do message  if assistant have access.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 16 ,enabled = true , description = "Verify File Upload Access")
    public void verifyFileUploadAccess() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		dronaStaffPage = new DronaStaffPage(driver);
		assertEquals(dronaStaffPage.fileUploadAcess(), true);
		ExtentLogger.pass("assistant is able to do file upload  if assistant have access.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 17 ,enabled = true , description = "Verify Appointment booking and Add patient through Assistant.")
    public void verifyAssistantAppointmentBooking() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		assertEquals(appointmentBookingPage.AppointmentBookingByHeadMenu(), true);
		ExtentLogger.pass("assistant is able to add new patient or create appointment.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 18 ,enabled = true , description = "Verify walkin booking through Assistant.")
    public void verifyAssistantWalkinBooking() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		assertEquals(appointmentBookingPage.walkinBooking(), true);
		ExtentLogger.pass("assistant is able to book new walkin.");
	}
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 19 ,enabled = true , description = "Verify Virtual appointment booking through Assistant.")
    public void verifyAssistantVirtualBooking() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		appointmentBookingPage = new AppointmentBookingPage(driver);
		assertEquals(appointmentBookingPage.AppointmentBookingVirtual(), true);
		ExtentLogger.pass("assistant is able to book new virtual appointment.");
	}
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 20 ,enabled = true , description = "Verify appointment checkedIn through Assistant.")
    public void verifyCheckedInAppointment() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		dronaStaffPage.checkedIn();
		ExtentLogger.pass("assistant is able to do appointment checkedIn.");
	}

	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Staff)
	@Test(priority = 21 ,enabled = true , description = "Verify consult now button is disable for assistant")
    public void verifyAssistantDisableConsultnow() {
		
		dronaStaffPage = new DronaStaffPage(driver);
		dronaStaffPage.staffLogin();
		assertEquals(dronaStaffPage.consultnowBtnDisable(), true);
		ExtentLogger.pass("consult now button is disable for assistant.");
	}

}
