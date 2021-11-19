package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;
import com.qa.utility.Xls_Reader;
import io.qameta.allure.Step;

public class DronaLoginPage extends BasePage {
	
	private WebDriver driver;
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;	
	DronaAddClinicPage dronaAddClinicPage;
	DronaClinicSetUpPage dronaClinicSetUpPage;
	Faker faker = new Faker();
	
	   private By userNameTxtBx = By.xpath( "//input[@formcontrolname ='userName']");
	   private By continueBtn = By.xpath( "//span[text()='Continue']/..");
	   private By passwordTxtBx = By.xpath( "//input[@placeholder='Enter your password']");
	   private By loginBtn = By.xpath( "//span[text()='Verify']/..");
	   private By frstNameTxtBx = By.xpath( "//input[@formcontrolname ='firstName']");
	   private By lastNameTxtBx = By.xpath( "//input[@formcontrolname ='lastName']");
	   private By phoneNumberTxtBx = By.xpath( "//input[@formcontrolname ='phoneNumber']");
	   private By signUpPasswordTxtBx = By.xpath( "//input[@placeholder='New Password*']");
	   private By confirmPasswordTxtBx = By.xpath( "//input[@placeholder ='Re-enter New Password*']");
	   private By signUpBtn = By.xpath( "//span[text()='Sign Up']/..");
	   private By emailAddressTxtBx = By.xpath( "//input[@formcontrolname ='emailAddress']");
	   private By otpTxtBx = By.xpath( "//input[@formcontrolname='otpValidat']");
	   private By otpVerifyBtn = By.xpath( "//span[text()='Verify']/..");
	   private By specialityDropDownClk = By.xpath( "//span[text()='Select a speciality']/following-sibling::div");
	   private By specialitySlct = By.xpath( "//span[text()='Medical Genetics']/..");
	   private By genderSlct = By.xpath( "//span[text()='Male']/..");
	   private By stateDropDwnClk = By.xpath( "//span[text()='Select a state']/following-sibling::div");
	   private By registrationNoTxtBx = By.xpath( "//input[@formcontrolname ='registrationNumber']");
	   private By stateSlct = By.xpath( "//span[text()='Delhi']/..");
	   private By forgetPasswordLnk = By.xpath( "//a[text()='Forgot Password?']");
	   private By registerNoTxtBx = By.xpath( "//input[@formcontrolname ='inputUser']");
	   private By doneBtn = By.xpath( "//span[text()='Done']/..");
	   private By resetBtn = By.xpath( "//span[text()='Reset']/..");
	   private By promoCodeTxtBox = By.xpath( "//input[@placeholder='Enter Promo Code']");
	   private By applyBtn = By.xpath( "//div[text()='Apply']");
	   private By promoCodeSubmitBtn = By.xpath( "//span[text()='Submit']/..");
	   private By promoCodeContinueBtn = By.xpath( "//span[text()='Continue']/..");
	   private By becomeAMemberBtn = By.xpath( "//span[text()='Become a Member']/..");
	   private By applyPromoCodeLnk = By.xpath( "//span[text()='Apply Promo']");
	   private By ProfileBtn = By.xpath("//div[contains(text(),'Dr. ')]");
	   private By SignOutBtn = By.xpath( "//span[text()='Log Out']/parent::button");
	   private By BecomeaMemberBtn = By.xpath("//span[text()='Become a Member']");
	   private By ApplyPromo = By.xpath("//span[text()='Apply Promo']");
	   private By addClinicLabel = By.xpath("//span[text()='Home']");
	   private By getStartedLabel = By.xpath("//div[text()='Get Started']");
	   private By logoutYesBtn = By.xpath("//span[text()='Yes']/..");
	   private By resetPassword = By.xpath("//p-password[@placeholder='New Password*']/div/input");
	   private By confirmRestPassword = By.xpath("//p-password[@placeholder='Re-enter New Password*']/div/input");
	   private By qualificationTxtBx = By.xpath("//input[@formcontrolname='education']");
	 
	 

	   public DronaLoginPage(WebDriver driver) {
			this.driver = driver;
			testUtil = new TestUtil(this.driver);
			javaScriptUtil = new JavaScriptUtil(driver);
			dronaAddClinicPage = new DronaAddClinicPage(driver);
			dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
	   }
	   
	   Xls_Reader reader = new Xls_Reader("./src/main/resources/Mankind_UserName.xlsx");
	   
	   public void dronaLoginThroughUserName(String username) {
			testUtil.dosendKeys(userNameTxtBx, 10, username);
			testUtil.doClick(continueBtn,10);
			testUtil.dosendKeys(passwordTxtBx, 10, reader.getCellData("Sheet1", 1, 2));
			testUtil.staticWait(2000);
			WebElement loginclk = driver.findElement(loginBtn);
			javaScriptUtil.clickElementByJS(loginclk);
			testUtil.staticWait(2000);
		}
	   
	   public void dronaLoginThroghMobileNo()
		{		
			String userMobileNo = reader.getCellData("Sheet1", 0, 2);
			dronaLoginThroughUserName(userMobileNo);	
			testUtil.staticWait(5000);
		//	ExtentLogger.pass("Doctor enter the mobile number and password.");
		}
	   public void dronaLoginThroghMailId()
		{
			String userEmailId =  reader.getCellData("Sheet1", 6, 2);
			dronaLoginThroughUserName(userEmailId);				
			ExtentLogger.pass("Doctor enter the Mail Id and password.");
		}
	   
	   public void dronaLoginQRCodeUser()
	 		{
	 			String userEmailId =  reader.getCellData("qrcode", 0, 3);
	 			dronaLoginThroughUserName(userEmailId);				
	 			ExtentLogger.pass("Doctor enter the mobile number and password.");
	 		}
		
		public void verifyOtp() {
			
			testUtil.dosendKeys(otpTxtBx, 10, "9999");		
			testUtil.doClick(otpVerifyBtn, 10);
		}
		
		
		public void AddProfessionalDetails() {
			
			testUtil.dosendKeys(qualificationTxtBx, 10, faker.educator().course());
			testUtil.doClick(specialityDropDownClk, 10);
			testUtil.doClick(specialitySlct, 10);
			testUtil.doClick(genderSlct, 10);
			testUtil.doClick(stateDropDwnClk, 10);
			testUtil.doClick(stateSlct, 10);
			javaScriptUtil.scrollPageDown();
			testUtil.dosendKeys(registrationNoTxtBx, 10, faker.number().digits(8));
			testUtil.doClick(continueBtn, 10);
			ExtentLogger.pass("Doctor enter the all required professional details.");
		}
		
	
		 public void dronaEmailIdSignUp() {
			
			testUtil.dosendKeys(userNameTxtBx, 10, reader.getCellData("Sheet1", 4, 2));
			testUtil.doClick(continueBtn, 10);
			testUtil.dosendKeys(frstNameTxtBx, 10, "praveen");
			testUtil.dosendKeys(lastNameTxtBx, 10, "chauhan");
			testUtil.dosendKeys(phoneNumberTxtBx, 10, reader.getCellData("Sheet1", 5, 2));
			testUtil.dosendKeys(signUpPasswordTxtBx, 10, "Test@123");
			testUtil.dosendKeys(confirmPasswordTxtBx, 10, "Test@123");
			testUtil.doClick(signUpBtn, 10);
			testUtil.staticWait(5000);
			verifyOtp();
			AddProfessionalDetails();
			testUtil.staticWait(3000);
			applyPromoCode(reader.getCellData("Sheet1", 5, 2));
			ExtentLogger.pass("Doctor entered name , phone number and set password.");
			testUtil.staticWait(3000);
			 String ClinicName = dronaAddClinicPage.addClinicInformation();
			  dronaAddClinicPage.saveAndContinue();
			  dronaAddClinicPage.selectSlotDuration();
			  dronaAddClinicPage.selectClinicDay(" Sun");
			  dronaAddClinicPage.setClinicTime(" Morning Slot" , "1" , "10:00 AM");				  
			  dronaAddClinicPage.setClinicTime(" Morning Slot" ,"3" , "01:00 PM");
			  dronaAddClinicPage.setClinicTime(" Evening Slot" , "1", "01:30 PM");
			  dronaAddClinicPage.setClinicTime(" Evening Slot" , "3" , "11:00 PM");
			  dronaAddClinicPage.saveAndContinue();
			  dronaAddClinicPage.enterConsultationFeeInClinic("100");
			  dronaAddClinicPage.enterFollowUpFeeInClinic("50");
			  dronaAddClinicPage.enterFollowUpDaysInClinic("5");
			  dronaAddClinicPage.samevirtualFeeChkBoxChkd();
			  dronaAddClinicPage.saveAndContinue();
		}
		
		public void applyPromoCode(String mobileNumber) {
			
			testUtil.doClick(becomeAMemberBtn, "Become a member Btn");
		//	testUtil.doClick(applyPromoCodeLnk, "Apply promo code link");
			GetPromoCode promocode = new GetPromoCode();
		//	String promoCode = promocode.getPromoCode(mobileNumber);
			String promoCode = "DRONATEST@26211518";
			ExtentLogger.pass(promoCode + " Promocode generated.");
			testUtil.dosendKeys(promoCodeTxtBox, 10, promoCode, "promocode entered.");
			testUtil.doClick(applyBtn, promoCode);
			testUtil.doClick(promoCodeSubmitBtn, "promo code submit btn");
			testUtil.doClick(promoCodeContinueBtn, 10);
		}
		
		public void enterSignUpDetails(String userMobileNumber , String userPassword ) {
			  
			   
		      testUtil.dosendKeys(userNameTxtBx, 10, userMobileNumber);
	          testUtil.doClick(continueBtn, 10);						
			  testUtil.dosendKeys(frstNameTxtBx, 10, "praveen");
			  testUtil.dosendKeys(lastNameTxtBx, 10, "chauhan");
			  testUtil.dosendKeys(emailAddressTxtBx, 10,"praveen@gmail.com");
			  testUtil.dosendKeys(signUpPasswordTxtBx, 10, userPassword);
			  testUtil.dosendKeys(confirmPasswordTxtBx, 10, userPassword);
			  testUtil.doClick(signUpBtn, 10);				   
		      verifyOtp();
		      testUtil.staticWait(3000);
	    	  AddProfessionalDetails();
	    	  testUtil.staticWait(3000);
	    	  applyPromoCode(userMobileNumber);		
		}
		
		
	       public void dronaMobileNoSignUp() {
			      
	    	      String userMobileNumber = reader.getCellData("Sheet1", 2, 2);
	    	      enterSignUpDetails(userMobileNumber , "Test@123" );
			      ExtentLogger.pass("Doctor entered name , email ID and set password.");
				  String ClinicName = dronaAddClinicPage.addClinicInformation();
				  dronaAddClinicPage.saveAndContinue();
				  dronaAddClinicPage.selectSlotDuration();
				  dronaAddClinicPage.selectClinicDay(" Sun");
				  dronaAddClinicPage.setClinicTime(" Morning Slot" , "1" , "10:00 AM");				  
				  dronaAddClinicPage.setClinicTime(" Morning Slot" ,"3" , "01:00 PM");
				  dronaAddClinicPage.setClinicTime(" Evening Slot" , "1", "01:30 PM");
				  dronaAddClinicPage.setClinicTime(" Evening Slot" , "3" , "11:00 PM");
				  dronaAddClinicPage.saveAndContinue();
				  dronaAddClinicPage.enterConsultationFeeInClinic("100");
				  dronaAddClinicPage.enterFollowUpFeeInClinic("50");
				  dronaAddClinicPage.enterFollowUpDaysInClinic("5");
				  dronaAddClinicPage.samevirtualFeeChkBoxChkd();
				  dronaAddClinicPage.saveAndContinue();
		   }
	    
	       public void verifyForgetPassword(String userId,String RegisteredMobileNo) {
	    	   
	    	   testUtil.dosendKeys(userNameTxtBx, 10, userId);
	 	       testUtil.doClick(continueBtn, 10);
	    	   testUtil.doClick(forgetPasswordLnk, 10);
	    	   ExtentLogger.pass("Doctor clicked on forgetPassword Link");
	    	  // testUtil.dosendKeys(registerNoTxtBx, 10, RegisteredMobileNo);
	    	   testUtil.doClick(doneBtn, 10);
	    	   testUtil.staticWait(3000);
	    	   verifyOtp();
	    	   testUtil.staticWait(3000);
	    	   testUtil.dosendKeys(resetPassword, 10, "Praveen@123");
	   		   testUtil.dosendKeys(confirmRestPassword, 10, "Praveen@123");
	   		   ExtentLogger.pass("Doctor reset the password");
	   		   testUtil.doClick(resetBtn, 10);
	       }
	       

	       public boolean verifyForgetPasswordMobileNo(){
	    	   
	    	   boolean clinicLabelShown = false;
	    	   verifyForgetPassword(reader.getCellData("Sheet1", 0, 2),reader.getCellData("Sheet1", 0, 2));
	    	   testUtil.staticWait(3000);
	    	    testUtil.dosendKeys(passwordTxtBx, 10, reader.getCellData("Sheet1", 1, 2));
				testUtil.staticWait(2000);
				WebElement loginclk = driver.findElement(loginBtn);
				javaScriptUtil.clickElementByJS(loginclk);
	    	   testUtil.staticWait(5000);
	    	   if(testUtil.doIsDisplayed(addClinicLabel)) {
	    		   
	    		   clinicLabelShown = true;
	    	   }
	    	   
	    	   return clinicLabelShown;
	       }
	       
	       public boolean verifyForgetPasswordemailId(){
	    	   
	    	   boolean clinicLabelShown = false;
	    	   verifyForgetPassword(reader.getCellData("Sheet1", 4, 2),reader.getCellData("Sheet1", 5, 2));
	    	   testUtil.staticWait(3000);
	    	   testUtil.dosendKeys(passwordTxtBx, 10, reader.getCellData("Sheet1", 1, 2));
				testUtil.staticWait(2000);
				WebElement loginclk = driver.findElement(loginBtn);
				javaScriptUtil.clickElementByJS(loginclk);
	    	   testUtil.staticWait(5000);
	    	   if(testUtil.doIsDisplayed(addClinicLabel)) {
	    		   
	    		   clinicLabelShown = true;
	    	   }
	    	   
	    	   return clinicLabelShown;
	       }
	       
	      
	       public boolean dronaDoctorSignOut() {
	    	   
	    	   boolean getStartedPage = false;
	    	   testUtil.staticWait(5000);
	 	       testUtil.doClick(ProfileBtn, 15);
	 	       ExtentLogger.pass("Doctor clicked on Profile Link");
	    	   testUtil.doClick(SignOutBtn, 15);
	    	   testUtil.doClick(logoutYesBtn, "Logout Confirmation Yes");
	    	   ExtentLogger.pass("Doctor clicked on SignOut Button");
	    	   testUtil.staticWait(3000);
               if(testUtil.doIsDisplayed(getStartedLabel)) {
	    		   
            	   getStartedPage = true;
	    	   }
	    	   
	    	   return getStartedPage;
	       }
}
