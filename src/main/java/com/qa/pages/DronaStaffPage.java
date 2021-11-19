package com.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;
import com.qa.utility.Xls_Reader;

public class DronaStaffPage extends BasePage{
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;	
	Faker fakeData = new Faker();
	public static String staffUrl = "http://104.211.137.89/DronaAngularAppTest/getStarted" ;
	DronaLoginPage loginPage ;
	BillingPage billingPage;
	
	private By editClinicBtn = By.xpath( "//button[text()='Edit Clinic']");
	private By settingBtn = By.xpath( "//span[text()='Settings']/parent::a");
	private By addAssistentBtn = By.xpath( "//span[text()='Add Assistant']/parent::button");
	private By firstNameTxtBx = By.xpath( "//input[@formcontrolname='firstName']");
	private By lastNameTxtBx = By.xpath( "//input[@formcontrolname='lastName']");
	private By phoneNumberTxtBx = By.xpath( "//input[@formcontrolname='phoneNumber']");
	private By emailTxtBx = By.xpath( "//input[@formcontrolname='email']");
	private By addStaffBtn = By.xpath( "//button[text()='Add']");
	private By deleteConfirmationBtn = By.xpath( "//button[text()='Yes, Delete']");
	private By updateDetailBtn = By.xpath( "//button[text()='Update']");
	private By userNameTxtBx = By.xpath( "//input[@formcontrolname ='userName']");
	private By continueBtn = By.xpath( "//span[text()='Continue']/..");
	private By passwordTxtBX = By.xpath( "//input[@placeholder='Password']");
	private By confirmPasswordTxtBX = By.xpath( "//input[@placeholder='Re-enter New Password']");
	private By signUpBtn = By.xpath( "//span[text()='Sign Up']/..");
	private By homeBtn = By.xpath( "//span[text()='Home']");
	private By editClinicPopUpValidationMsg = By.xpath("//div[text()='You have no permission to access clinic ']");
	private By clinicDetailEditBtn = By.xpath( "//div[contains(@class,'clinic-info-box ')]/div/div[3]/div/img");
	private By InClinicEditCard = By.xpath("//div[contains(text(),' In-Clinic Consultation ')]/parent::div/../../following-sibling::div/div[1]/div/div/following-sibling::div/div/img");
	private By VirtualClinicCard = By.xpath( "//div[contains(text(),' Virtual Consultation ')]/parent::div/../../following-sibling::div/div[1]/div/div/following-sibling::div/div/img");
	private By medicalHistory = By.xpath( "//span[text()='Medical History']/..");
	private By appointmentMenu = By.xpath("//span[text()='Appointments']/..");
	private By upperAppointment = By.xpath("//h4[contains(text(),'Pending')]/../../../../../following-sibling::div[1]/div/div[2]/div/div[1]");
	private By messageMenuBar = By.xpath("//span[text()='Messages']");
	private By billPopUpValidationMsg = By.xpath("//div[text()='You have no permission to access Bills']");
	private By uploadFileValidationMsg = By.xpath("//div[text()='You have no permission to access Files']");
	private By billingMenu = By.xpath("//span[text()='Bills']/parent::a");
	private By createBillBtn = By.xpath("//button[text()='Create Bill']");
	private By fileMenu = By.xpath("//span[text()='Files']/parent::a");
	private By uploadFileBtn = By.xpath("//button[text()=' Upload File']");
	private By assistantProfileMenubar = By.xpath("//div[contains(@class,'content_Selectbox_drName')]");
	private By assistantEditBtn = By.xpath("//div[text()=' Edit ']");
	private By assistantFrstNameBtn = By.xpath("//input[@formcontrolname='firstName']");
	private By assistantLastNameBtn = By.xpath("//input[@formcontrolname='lastName']");
	private By assistantSaveBtn = By.xpath("//button[text()='Save']");
	private By assistantname = By.xpath("//div[contains(@class,'dr-pro-name')]");
	private By saveBillBtn = By.xpath("//button[text()='Save Bill']");
	private By editClinicLabel = By.xpath("//div[text()=' Edit Clinic Information ']");
	private By browseFileBtn = By.xpath("//button[text()=' Browse Files']");
	private By secondAppointmentPath = By.xpath("//h4[contains(text(),'Appointments')]/../../../following-sibling::div[1]/div");
	private By checkedINBtn = By.xpath("//span[contains(text(),'Check In')]/..");
	private By consultNowBtnDisable = By.xpath("//button[contains(@class,'consult-now-bth drona-Primary_v2_disabled')]");
	private By browsefileBtn = By.xpath("//button[text()=' Browse Files']");
	
	
	
	
	Xls_Reader reader = new Xls_Reader("./src/main/resources/Mankind_UserName.xlsx");
	
	String accessCheckBox = "//label[text()='%replaceable%']/preceding-sibling::p-checkbox";
	
	public DronaStaffPage(WebDriver driver) {
		
		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	
	}	
	public void getSettingPage() {
		
		testUtil.doClick(editClinicBtn, "edit Clinic Btn");
		testUtil.staticWait(3000);
		testUtil.doClick(settingBtn, "Setting Btn");		
	}
	public String[] addAssistntDetail() {
		
		String firstName = fakeData.name().firstName().replaceAll("'", "");
		String lastName =  fakeData.name().lastName().replaceAll("'", "");
		String phoneNumber = "9" + fakeData.number().digits(9);
		String email = firstName.toLowerCase() + "@gmail.com";
		testUtil.dosendKeys(firstNameTxtBx, 10, firstName,firstName +  " name entered");
		testUtil.dosendKeys(lastNameTxtBx, 10, lastName, lastName +  " name entered");
		testUtil.dosendKeys(phoneNumberTxtBx, 10, phoneNumber,phoneNumber +  "  entered");
		testUtil.dosendKeys(emailTxtBx, 10, email,email +  " entered");
		String staffName = firstName + " " + lastName;
		String []staffDetail = {staffName, phoneNumber};
		return staffDetail;
	}
	public boolean addAssitant() {
		
		boolean staffShown = false;
		getSettingPage();
	    testUtil.doClick(addAssistentBtn, "Add Assistent");
	    String[] staffdetail = addAssistntDetail();
	    String staffName = staffdetail[0];
		testUtil.doClick(addStaffBtn, "Add Staff");
		String staffNamePath = "//div[text()=' " +staffName + " ']";
		WebElement StaffName = driver.findElement(By.xpath(staffNamePath));
		if(StaffName.isDisplayed()) {
			staffShown = true;
		}
		return staffShown;
	}
	
	public boolean deleteAssistant() {
		
		boolean staffDelete = false;
		getSettingPage();
	    testUtil.doClick(addAssistentBtn, "Add Assistent");
	    String[] staffdetail = addAssistntDetail();
	    String staffName = staffdetail[0];
		testUtil.doClick(addStaffBtn, "Add Staff");
		String staffNamePath = "//div[text()=' " +staffName + " ']";
		WebElement StaffName = driver.findElement(By.xpath(staffNamePath));
		String staffDeletePath = "//div[text()=' " +staffName + " ']/parent::div/../../following-sibling::div/div/div/div[text()=' Delete ']/preceding-sibling::i";
		WebElement StaffDeleteBtn = driver.findElement(By.xpath(staffDeletePath));
		javaScriptUtil.clickElementByJS(StaffDeleteBtn);
		testUtil.doClick(deleteConfirmationBtn, "Delete Confirmation");
		testUtil.staticWait(8000);
		try {
			if(!StaffName.isDisplayed()) {
				
				ExtentLogger.fail("Staff Still Shown.");
			}
		} catch (Exception e) {
			
			staffDelete = true;
			ExtentLogger.pass("Staff Deleted.");
			e.printStackTrace();
		}
		return staffDelete;
	}
	
	public HashMap<String,String> editAssistantDetails() {
		
		HashMap<String,String>editDetails = new HashMap<>();		
		getSettingPage();
	    testUtil.doClick(addAssistentBtn, "Add Assistent");
	    String[] staffdetail = addAssistntDetail();
	    String staffName = staffdetail[0];
		testUtil.doClick(addStaffBtn, "Add Staff");
		testUtil.staticWait(3000);
		String staffEditPath = "//div[text()=' " +staffName + " ']/parent::div/../../following-sibling::div/div/div/div[text()=' Edit ']/preceding-sibling::img";
		WebElement StaffEditBtn = driver.findElement(By.xpath(staffEditPath));
		javaScriptUtil.clickElementByJS(StaffEditBtn);
		testUtil.staticWait(3000);
		String updatedfirstName = fakeData.name().firstName().replaceAll("'", "");
		String updatedlastName =  fakeData.name().lastName().replaceAll("'", "");
		String updatedphoneNumber = "9" + fakeData.number().digits(9);
		String updatedemail = updatedfirstName.toLowerCase() + "@gmail.com";
		testUtil.dosendKeys(firstNameTxtBx, 10, updatedfirstName,updatedfirstName +  " name entered");
		testUtil.dosendKeys(lastNameTxtBx, 10, updatedlastName, updatedlastName +  " name entered");
		testUtil.dosendKeys(phoneNumberTxtBx, 10, updatedphoneNumber,updatedphoneNumber +  "  entered");
		testUtil.dosendKeys(emailTxtBx, 10, updatedemail,updatedemail +  " entered");
		testUtil.doClick(updateDetailBtn, "Update Details");
		testUtil.staticWait(3000);
		String updatedStaffName = updatedfirstName + " " + updatedlastName;
		String updatedStaffEditPath = "//div[text()=' " +updatedStaffName + " ']/parent::div/../../following-sibling::div/div/div/div[text()=' Edit ']/preceding-sibling::img";
		WebElement updatedStaffEditBtn = driver.findElement(By.xpath(updatedStaffEditPath));
		javaScriptUtil.clickElementByJS(updatedStaffEditBtn);
		testUtil.staticWait(3000);
		String savedFirstName = testUtil.getElement(firstNameTxtBx).getAttribute("value");
		String savedLastName = testUtil.getElement(lastNameTxtBx).getAttribute("value");
		String savedPhoneNumber =testUtil.getElement(phoneNumberTxtBx).getAttribute("value");
		String savedEmailId = testUtil.getElement(emailTxtBx).getAttribute("value");
		editDetails.put(updatedfirstName, savedFirstName);
		editDetails.put(updatedlastName, savedLastName);
		editDetails.put(updatedphoneNumber, savedPhoneNumber);
		editDetails.put(updatedemail, savedEmailId);
		return editDetails;
	}
	
	public boolean staffLoginFirstTime() {		
		
		  boolean staffLogin = false;
		  testUtil.staticWait(4000);
		  getSettingPage();
		  testUtil.doClick(addAssistentBtn, "Add Assistent");
		  String[] staffdetail = addAssistntDetail(); 
		  String staffName = staffdetail[0]; 
		  String staffMobileNumber = staffdetail[1];
		  testUtil.doClick(addStaffBtn, "Add Staff");
		  testUtil.staticWait(3000);
		 ((JavascriptExecutor) driver).executeScript("window.open()");
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.get(staffUrl);
		 testUtil.dosendKeys(userNameTxtBx, 10, staffMobileNumber);
		 testUtil.doClick(continueBtn,10);
		 loginPage = new DronaLoginPage(driver);
		 loginPage.verifyOtp();
		 testUtil.dosendKeys(passwordTxtBX, 10, "Praveen@123");
		 testUtil.dosendKeys(confirmPasswordTxtBX, 10, "Praveen@123");
		 testUtil.doClick(signUpBtn,10);
		 ExtentLogger.pass("Password Set Successfully.");
		 testUtil.staticWait(3000);
		 reader.setCellData("Sheet1", "Assistant Name",2, staffName);
		 reader.setCellData("Sheet1", "Assistant Mobile",2, staffMobileNumber);
		 if(testUtil.getElement(homeBtn).isDisplayed()){
			 
			 staffLogin = true;
		 }
		 
		 return staffLogin;
	}
	
	public void staffLogin() {
		
		loginPage = new DronaLoginPage(driver);
		loginPage.dronaLoginThroughUserName(reader.getCellData("Sheet1", 13, 2));
		testUtil.staticWait(5000);
	}
	
	public void editClinicDetailBtnClick() {
		
		testUtil.doClick(editClinicBtn, "editClinicBtn");
		testUtil.doClick(clinicDetailEditBtn, "clinicDetailEditBtn");
	}
	
	public void timingSetupEditBtnClicked(By locator) {
		
		testUtil.doClick(editClinicBtn, "editClinicBtn");
		testUtil.doClick(locator, "timingEditBtn");
	}
	
	public boolean noEditClinicAccess(By locator) {
		
		boolean editValidation = false;
		timingSetupEditBtnClicked(locator);
		if(testUtil.doIsDisplayed(editClinicPopUpValidationMsg)){	
		
			editValidation = true;
		}
		return editValidation;
	}
	
    public boolean noEditDetailsAccess() {
    	
    	boolean clinicAccess = noEditClinicAccess(clinicDetailEditBtn);
    	return clinicAccess;
		
			}
   public boolean noEditInClinicTimingAccess() {
    	
    	boolean clinicAccess = noEditClinicAccess(InClinicEditCard);
    	return clinicAccess;
		
			}
   public boolean noEditVirtualTimmingAccess() {
	
	   boolean clinicAccess = noEditClinicAccess(VirtualClinicCard);
       return clinicAccess;
	
		}
   public void AppointmentMenuClick() {

		testUtil.staticWait(5000);
		WebElement appointmentMenuClk = testUtil.getElement(appointmentMenu);
		javaScriptUtil.clickElementByJS(appointmentMenuClk);
		testUtil.staticWait(5000);
		testUtil.doClick(upperAppointment, "Clicked on appointment");
		ExtentLogger.pass("Clicked on Appointment  icon in menu bar.");
	}
   
   public boolean medicalHistoryNotAccess() {
	   
	   boolean medicalHistoryDisplay = false;
	   AppointmentMenuClick();  
	   
		try {
			testUtil.getElement(medicalHistory).isDisplayed();	   
				medicalHistoryDisplay = false;
		} catch (Exception e) {
			
			medicalHistoryDisplay = true;
			e.printStackTrace();
		}
	  
	   
	   return medicalHistoryDisplay;
	   
   }
   
     public boolean messageMenu() {
	   
	   boolean messageMenu = false;	   
		try {
			testUtil.getElement(messageMenuBar).isDisplayed();	   
			messageMenu = false;
		} catch (Exception e) {
			
			messageMenu = true;
			e.printStackTrace();
		}	   
	   return messageMenu;
	   
   }
     
     public void clkCreateBill() {
    	 
    	 testUtil.doClick(billingMenu, "Bill Menu ");
    	 testUtil.doClick(createBillBtn, "Create Bill Btn");   	 
     }
     
     public void clkUploadFile() {
    	 
    	 testUtil.doClick(fileMenu, "File Menu");
    	 testUtil.doClick(uploadFileBtn, "Upload File");   	 
     }
     
     public boolean noBillCreateAccess() {
 		
 		boolean BillValidation = false;
 		AppointmentMenuClick();
 		clkCreateBill();
 		if(testUtil.doIsDisplayed(billPopUpValidationMsg)){	
 		
 			BillValidation = true;
 		}
 		return BillValidation;
 	}
     
     public boolean noFileUploadAccess() {
 		
 		boolean fileValidation = false;
 		AppointmentMenuClick();
 		clkUploadFile();
 		if(testUtil.doIsDisplayed(uploadFileValidationMsg)){	
 		
 			fileValidation = true;
 		}
 		return fileValidation;
 	}
     
     public boolean assistantNameEdit() {
    	 
    	 boolean assistantnameUpdated = false;
    	 testUtil.doClick(assistantProfileMenubar, "assistantProfileMenubar");
    	 testUtil.doClick(assistantEditBtn, "assistantEditBtn");
    	 String frstName = fakeData.name().firstName();
    	 String lastName = fakeData.name().lastName();
    	 testUtil.dosendKeys(firstNameTxtBx, 10, frstName, frstName);
    	 testUtil.dosendKeys(lastNameTxtBx, 10, lastName, lastName);
    	 testUtil.doClick(assistantSaveBtn, "assistantSaveBtn");
    	 String updatedAssistantNameInProfile = testUtil.doGetText(assistantname).replace(" ", "");
    	 String updatedAssistantName = frstName + lastName ;
    	 if(updatedAssistantNameInProfile.equalsIgnoreCase(updatedAssistantName)) {
    		 
    		 assistantnameUpdated = true;
    	 }
    	 return assistantnameUpdated;
     }
     
     public void accessCheckboxChecked(String accessFeature) {
    	 getSettingPage();
    	 String staffName = reader.getCellData("Sheet1", 12, 2);
    	 String staffEditPath = "//div[text()=' " +staffName + " ']/parent::div/../../following-sibling::div/div/div/div[text()=' Edit ']/preceding-sibling::img";
    	 WebElement StaffEditBtn = driver.findElement(By.xpath(staffEditPath));
 		 javaScriptUtil.clickElementByJS(StaffEditBtn);
 		 String accessCheckBoxXpath = testUtil.getXpath(accessCheckBox, accessFeature);
 		 testUtil.doClick(By.xpath(accessCheckBoxXpath), accessFeature);
 		 testUtil.doClick(updateDetailBtn, "Update Details");
 	}
     
     public boolean medicalHistoryaccessCheck() {
    	 
    	 boolean medicalHistoryDisplay = false;
 		 accessCheckboxChecked("Patient Medical History");
 		 ((JavascriptExecutor) driver).executeScript("window.open()");
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.get(staffUrl);
		 staffLogin();
		 AppointmentMenuClick();
			if (testUtil.getElement(medicalHistory).isDisplayed()){
					   
					medicalHistoryDisplay = true;
			} 		   
		   return medicalHistoryDisplay;		   
     }	
     
    public void createBillaccessCheck() {
    	 
 		 accessCheckboxChecked("Billing");
 		 ((JavascriptExecutor) driver).executeScript("window.open()");
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.get(staffUrl);
		 staffLogin();
		 AppointmentMenuClick();
		 clkCreateBill();
		 testUtil.staticWait(3000);
		 billingPage = new BillingPage(driver);
		 billingPage.addItem();
		 testUtil.doClick(saveBillBtn, "save bill btn");
     }	
    
    public boolean updateClinicDetailAccess() {
    	
    	 boolean clinicDetailsEdit = false ; 
    	 accessCheckboxChecked("Clinic Details");
 		 ((JavascriptExecutor) driver).executeScript("window.open()");
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.get(staffUrl);
		 staffLogin();
		 editClinicDetailBtnClick();
			   if(testUtil.doIsDisplayed(editClinicLabel)) {
			 clinicDetailsEdit = true;
		} 		   
	   return clinicDetailsEdit;
    }
    
    
    public boolean messageMenuAccess() {
    	
   	 boolean messageMenuAccess = false ; 
   	 accessCheckboxChecked("Messages");
		 ((JavascriptExecutor) driver).executeScript("window.open()");
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.get(staffUrl);
		 staffLogin();
			   if(testUtil.doIsDisplayed(messageMenuBar)) {
				   messageMenuAccess = true;
		} 		   
	   return messageMenuAccess;
   }
    public boolean fileUploadAcess() {
    	
      	 boolean fileUploadAccess = false ; 
      	 accessCheckboxChecked("Patient Files");
   		 ((JavascriptExecutor) driver).executeScript("window.open()");
   		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
   		 driver.switchTo().window(tabs.get(1));
   		 driver.get(staffUrl);
   		 staffLogin();
   	    AppointmentMenuClick();
   	    testUtil.staticWait(2000);
    	 clkUploadFile();
    	 testUtil.staticWait(2000);
   			   if(testUtil.doIsDisplayed(browseFileBtn)) {
   				fileUploadAccess = true;
   		} 		   
   	   return fileUploadAccess;
      }

      public void checkedIn() {
    	
    	testUtil.staticWait(5000);
		WebElement appointmentMenuClk = testUtil.getElement(appointmentMenu);
		javaScriptUtil.clickElementByJS(appointmentMenuClk);
		testUtil.staticWait(5000);
    	testUtil.doClick(secondAppointmentPath, "Clicked on first appointment");
    	testUtil.doClick(checkedINBtn, "checked in button clicked.");
    }
      
      public boolean consultnowBtnDisable() {
    	  
    	  boolean consultnowBtn = false;
    	  AppointmentMenuClick();
    	  if(testUtil.doIsDisplayed(consultNowBtnDisable)) {
    		  
    		  consultnowBtn = true;
    	  }
    	  
    	  return consultnowBtn;
      }
      
}
