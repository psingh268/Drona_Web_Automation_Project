package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class DoctorProfilePage extends BasePage{
	
		
		private TestUtil testUtil;
		private JavaScriptUtil javaScriptUtil;
		
		private By workAndExperienceBtn = By.xpath("//span[text()='Work & Experience']");
		private By BasicInfo = By.xpath("//span[text()='Basic Details']");
		private By ChangePasswordBtn = By.xpath("//div[text()='Change Password ']");
		private By doctorProfileBtn = By.xpath("//span[contains(@class,'drName')]/parent::div");
		private By aboutPlusBtn = By.xpath("//span[text()='About']/parent::p-header/following-sibling::p-header/div/div/i");
		private By aboutInfoTxtBx = By.xpath("//textarea[@formcontrolname='AboutDoctor']");
		private By saveBtn = By.xpath("//button[text()=' Save ']");
		private By ExpSaveBtn = By.xpath("//button[text()='Save']");
		private By educationPlusBtn = By.xpath("//span[text()='Education']/parent::p-header/following-sibling::p-header/div/div/i");
		private By experiencePlusBtn = By.xpath("//span[text()='Experience']/parent::p-header/following-sibling::p-header/div/div/i");
		private By specialisationPlusBtn = By.xpath("//span[text()='Specialization']/parent::p-header/following-sibling::p-header/div/div/i");
		private By awardsPlusBtn = By.xpath("//span[text()='Awards & Recognitions']/parent::p-header/following-sibling::p-header/div/div/i");
		private By servicesPlusBtn = By.xpath("//span[text()='Services']/parent::p-header/following-sibling::p-header/div/div/i");
		private By aboutTitleTxtBx = By.xpath("//input[@formcontrolname='title']");
		private By aboutCompanyTxtBx = By.xpath("//input[@formcontrolname='company']");
		private By aboutLocationTxtBx = By.xpath("//input[@formcontrolname='location']");
		private By aboutstartDateTxtBx = By.xpath("//input[@formcontrolname='startDate']");
		private By aboutendDateTxtBx = By.xpath("//input[@formcontrolname='endDate']");
		private By universityTxtBx = By.xpath("//input[@formcontrolname='university']");
		private By degreeTxtBx = By.xpath("//input[@formcontrolname='degree']");
		private By fieldOfStudyTxtBx = By.xpath("//input[@formcontrolname='fieldOfStudy']");
		private By startYearTxtBx = By.xpath("//input[@formcontrolname='startYear']");
		private By endYearTxtBx = By.xpath("//input[@formcontrolname='endYear']");
		private By suggestionBox = By.xpath("//div[@class='suggest-box']");
		private By awardProviderTxtBx = By.xpath("//input[@formcontrolname='Provider']");
		private By awardYearTxtBx = By.xpath("//input[@formcontrolname='YearOfRecognition']");
		private By awardTitleTxtBx = By.xpath("//input[@formcontrolname='Title']");
		private By DeleteBtn = By.xpath("//button[text()='Delete']");
		private By ExperienceBtnHover = By.xpath("//span[text()='Experience']");
		private By ExperienceInfoArea = By.xpath("//div[@class='p-toggleable-content ng-tns-c104-11 ng-trigger ng-trigger-tabContent']");
		private By EducationBtnHover = By.xpath("//span[text()='Education']");
		private By AwardsBtnHover = By.xpath("//span[text()='Awards & Recognitions']");
		private By specialisationEditBtn = By.xpath("");
		private By CurrentPass = By.xpath("//input[@placeholder='Enter current password']");
		private By NewPass = By.xpath("//input[@placeholder='Create new password']");
		private By RetypePass = By.xpath("//input[@placeholder='Re-type new password']");
		private By ConfirmPassBtn = By.xpath("//button[text()='Confirm Password']");
		private By PasswordVlidation = By.xpath("//app-success-pop-up/div/div/img");
		private By confirmvalidation = By.xpath("//div[text()='Passwords must match with New Password']");
		private By ToastMessageoldpassword = By.xpath("//p-toast/div/p-toastitem/div/div/div/div[2][text()='Old Password does not match.']");
		
		public DoctorProfilePage(WebDriver driver) {
			
			this.driver = driver;
			testUtil = new TestUtil(driver);
			javaScriptUtil = new JavaScriptUtil(driver);
		}
		
		 Faker fakeData = new Faker();
		 
		 public void workAndExperienceClk() {
			 
			 javaScriptUtil.clickElementByJS(testUtil.getElement(doctorProfileBtn));
		 	  testUtil.staticWait(4000);
			 testUtil.doClick(workAndExperienceBtn, "work And Experience"); 
		 }
		
		 public void addAboutInfo() {
			 
			 workAndExperienceClk();
			 testUtil.doClick(aboutPlusBtn, "About Plus");
			 String text = fakeData.company().name();
			 testUtil.dosendKeys(aboutInfoTxtBx, 10, text, "About info");
			  testUtil.staticWait(3000);
			 testUtil.doClick(saveBtn, "save Btn");
		 }
		 
		 public String addEducationInfo() {
	  		 
	  		 workAndExperienceClk();
	  		 testUtil.doClick(educationPlusBtn, "education Plus");
	  		 String University = fakeData.university().name();
	  		 testUtil.dosendKeys(universityTxtBx, 10, University, "University");
	  		 String Degree = fakeData.educator().course();
	  		 testUtil.dosendKeys(degreeTxtBx, 10, Degree, "Degree");
	  		 String Medical = fakeData.medical().diseaseName();
	  		 testUtil.dosendKeys(fieldOfStudyTxtBx, 10, Medical, "Field of study");
	  		String Location = fakeData.address().fullAddress();
	  		testUtil.dosendKeys(aboutLocationTxtBx, 10, Location, "location");
			 testUtil.dosendKeys(startYearTxtBx, 10, "2011", "start date");
			 testUtil.dosendKeys(endYearTxtBx, 10, "2014", "end date");
	  		 testUtil.doClick(ExpSaveBtn, "save Btn");
	  		return Degree;
	  	 }
		 
	     public String addExperienceInfo() {
			 
			 workAndExperienceClk();
			 testUtil.doClick(experiencePlusBtn, "experience Plus");
			 String title = fakeData.educator().university();
			 testUtil.dosendKeys(aboutTitleTxtBx, 10, title, "title");
			 String Company = fakeData.company().name();
			 testUtil.dosendKeys(aboutCompanyTxtBx, 10, Company , "company");
			 String Location = fakeData.address().fullAddress();
			 testUtil.dosendKeys(aboutLocationTxtBx, 10, Location, "location");
			 testUtil.dosendKeys(aboutstartDateTxtBx, 10, "2015", "start date");
			 testUtil.dosendKeys(aboutendDateTxtBx, 10, "2016", "end date");
			 testUtil.doClick(ExpSaveBtn, "save Btn");
			 return title;
		 }
	     
	     public void addSpecialization(int specializationPosition) {
	  	   
	  	   workAndExperienceClk();
	  	   testUtil.staticWait(3000);
	  	   testUtil.doClick(specialisationPlusBtn, "specialization Plus");
	  	   //testUtil.doClick(aboutLocationTxtBx, "specialization Edit");
	  	   List<WebElement> specializationList = driver.findElements(suggestionBox);
	  	   WebElement specialization = specializationList.get(specializationPosition);
	  	   specialization.click();
	  	   testUtil.doClick(ExpSaveBtn, "save Btn");
	     }
	     
	      public void addServices(int servicesPosition) {
	  	   
	  	   workAndExperienceClk();
	  	   testUtil.staticWait(3000);
	  	   testUtil.doClick(servicesPlusBtn, "Services Plus");
	  	   List<WebElement> servicesList = driver.findElements(suggestionBox);
	  	   WebElement Service = servicesList.get(servicesPosition);
	  	   Service.click();
	  	   testUtil.doClick(ExpSaveBtn, "save Btn");
	     }
	      public String addAwardAndRecognitionInfo() {
	   		 
	   		 workAndExperienceClk();
	   		 testUtil.doClick(awardsPlusBtn, "award Plus");
	   		 String title = fakeData.medical().diseaseName().concat("specialist");
	   		 testUtil.dosendKeys(awardTitleTxtBx, 10, title, "Award Title");
	   		String college = fakeData.university().name();
	   		 testUtil.dosendKeys(awardProviderTxtBx, 10, college, "Award Provider");
	   		 testUtil.dosendKeys(awardYearTxtBx, 10, "2018", "Award year");
	   		 testUtil.doClick(ExpSaveBtn, "save Btn");
	   		 return title;
	   	 }
	       //Code By Ritu
	       public void deleteExperience() {
	    	   try
	    	   {
	    	 // Boolean Experience= false;
	    	  String title = addExperienceInfo();
	    	  testUtil.staticWait(5000);
	    	  testUtil.doClick(ExperienceBtnHover, 10);
	    	  String editTitlePath = "//div[text()='"+ title +"']/parent::div/following-sibling::div/div/i";
	    	  WebElement editExperienceBtn = driver.findElement(By.xpath(editTitlePath));
	    	  testUtil.staticWait(3000);
	    	  testUtil.doActionsClick(editExperienceBtn);
	    	  testUtil.staticWait(3000);
	    	  testUtil.doClick(DeleteBtn,"Delete Experience");
	    	  ExtentLogger.pass("Delete button clicked.");
	    	 // String UpdatedTitle = testUtil.getElement(ExperienceInfoArea).getText();
	    	/*  if (title.equalsIgnoreCase(UpdatedTitle)) {
	    		 return  Experience= true;
	    	  }
	    	  return Experience;
	    	   */
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	   
	       }
	       
	       //Code by Ritu
	       public void deleteEducation() {
	    	   
	    	   try{
	    	 
	    	  String Degree = addEducationInfo();
	    	  testUtil.staticWait(3000);
	    	  testUtil.doClick(EducationBtnHover, 10);
	    	  String editDegreePath = "//div[text()='"+ Degree +"']/parent::div/following-sibling::div/div/i";
	    	  WebElement editEducationBtn = driver.findElement(By.xpath(editDegreePath));
	    	  testUtil.staticWait(3000);
	    	  testUtil.doActionsClick(editEducationBtn);
	    	  testUtil.staticWait(3000);
	    	  testUtil.doClick(DeleteBtn,"Delete Education");
	    	  ExtentLogger.pass("Delete button clicked.");
	    	 
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	   
	       }
	      
	     //Code by Ritu
	       public void deleteAwardsRecognitionInfo() {
	    	   
	    	   try{
	    	 
	    	  String title = addAwardAndRecognitionInfo();
	    	  testUtil.staticWait(3000);
	    	  testUtil.doClick(AwardsBtnHover, 10);
	    	  String edittitlePath = "//div[text()='"+ title +"']/parent::div/following-sibling::div/div/i";
	    	  WebElement editAwardsBtn = driver.findElement(By.xpath(edittitlePath));
	    	  testUtil.staticWait(3000);
	    	  testUtil.doActionsClick(editAwardsBtn);
	    	  testUtil.staticWait(3000);
	    	  testUtil.doClick(DeleteBtn,"Delete Education");
	    	  ExtentLogger.pass("Delete button clicked.");
	    	 
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	   
	       }
	       
	     //Code by Ritu
	       public void deleteSpecializationInfo() {
	    	   
	    	   try{
	    	 
	    	  String title = addAwardAndRecognitionInfo();
	    	  testUtil.staticWait(3000);
	    	  testUtil.doClick(AwardsBtnHover, 10);
	    	  String edittitlePath = "//div[text()='"+ title +"']/parent::div/following-sibling::div/div/i";
	    	  WebElement editAwardsBtn = driver.findElement(By.xpath(edittitlePath));
	    	  testUtil.staticWait(3000);
	    	  testUtil.doActionsClick(editAwardsBtn);
	    	  testUtil.staticWait(3000);
	    	  testUtil.doClick(DeleteBtn,"Delete Education");
	    	  ExtentLogger.pass("Delete button clicked.");
	    	 
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	   
	       }
	       
	       public boolean ChangePassword() {
	  		 
	    	  boolean PasswordChange =false;
	    	 javaScriptUtil.clickElementByJS(testUtil.getElement(doctorProfileBtn));
	 	 	 testUtil.staticWait(4000);
	 		 testUtil.doClick(BasicInfo, "Basic Info");
	  		 testUtil.doClick(ChangePasswordBtn, "experience Plus");
	  		 String Number = fakeData.number().digits(1);
	  		 String Text = fakeData.name().firstName();
	  		 String SpecialChar="@";
	  		 String Password = Text.concat(SpecialChar).concat(Number);
	  		 testUtil.staticWait(3000);
	  		 testUtil.dosendKeys(CurrentPass, 20, "ritu@12","Current Password" );
	  		 testUtil.dosendKeys(NewPass, 10, Password, "New Password");
	  		 testUtil.dosendKeys(RetypePass, 10, Password, "Re Type New Password");
	  		 testUtil.doClick(ConfirmPassBtn, "Confirm Password");
	  		
	  		WebElement PasswordValidation = driver.findElement(PasswordVlidation);
			if (PasswordValidation.isDisplayed()) {

				PasswordChange = true;
			}
	  		 return PasswordChange;
	  	 }
	       

	       public boolean ChangePasswordValidation() {
	    		 
	     	  boolean PasswordChange =false;
	     	 javaScriptUtil.clickElementByJS(testUtil.getElement(doctorProfileBtn));
	  	 	 testUtil.staticWait(4000);
	  		 testUtil.doClick(BasicInfo, "Basic Info");
	   		 testUtil.doClick(ChangePasswordBtn, "experience Plus");
	   		 String Number = fakeData.number().digits(1);
	   		 String Text = fakeData.name().firstName();
	   		 String SpecialChar="@";
	   		 String Password = Text.concat(SpecialChar).concat(Number);
	   		 testUtil.staticWait(3000);
	   		 testUtil.dosendKeys(CurrentPass, 20, "Gwenn@7","Current Password" );
	   		 testUtil.dosendKeys(NewPass, 10, Password, "New Password");
	   		 testUtil.dosendKeys(RetypePass, 10, "Gwenn@7", "Re Type New Password");
	   		 testUtil.doClick(ConfirmPassBtn, "Confirm Password");
	   		
	   		WebElement confirmPasswordvalidation = driver.findElement(confirmvalidation);
	 		if (confirmPasswordvalidation.isDisplayed()) {

	 			PasswordChange = true;
	 		}
	   		 return PasswordChange;
	   	 }
	       
			
			  public String oldPasswordValidation() {
			  
			  javaScriptUtil.clickElementByJS(testUtil.getElement(doctorProfileBtn));
			  testUtil.staticWait(4000); 
			  testUtil.doClick(BasicInfo, "Basic Info");
			  testUtil.doClick(ChangePasswordBtn, "experience Plus"); 
			  String Password ="password"; testUtil.staticWait(3000); 
			  testUtil.dosendKeys(CurrentPass, 20,"Gwenn@7","Current Password" ); 
			  testUtil.dosendKeys(NewPass, 10, Password, "New Password"); 
			  testUtil.dosendKeys(RetypePass, 10, Password,"Re Type New Password"); 
			  testUtil.doClick(ConfirmPassBtn,"Confirm Password");
			  String ToastMessage = driver.findElement(ToastMessageoldpassword).getText();
		      System.out.println(ToastMessage);	
		      return ToastMessage;
		     
			  }
			 
	}


