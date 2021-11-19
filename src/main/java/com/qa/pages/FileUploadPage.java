	package com.qa.pages;

	import java.io.File;
	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Date;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;

	import com.github.javafaker.Faker;
	import com.qa.base.BasePage;
	import com.qa.reports.ExtentLogger;
	import com.qa.utility.JavaScriptUtil;
	import com.qa.utility.TestUtil;

	public class FileUploadPage extends BasePage{
		
		private TestUtil testUtil;
		private JavaScriptUtil javaScriptUtil;	
		PrescriptionFormatPage prescriptionFormatPage;
		DronaAddPatientPage dronaAddPatientPage;
		AppointmentBookingPage appointmentBookingPage;
		ConsultPage consultpage;
		
		
		private By fileLink = By.xpath("//span[text()='Files']/parent::a");
		private By patientAppointment = By.xpath( "//h4[contains(text(),' Checked In')]/../../../../../following-sibling::div[1]/div");
		private By FileTitleTxt = By.xpath("//tbody/tr/td[2]");
		private By FileBtn = By.xpath("//span[text()='Files']");
		private By AddPatient = By.xpath("//span[text()='Add Patient']");
		private By UploadBtn = By.xpath("//button[text()=' Upload File']");
		private By BrowseBtn = By.xpath("//button[text()=' Browse Files']");
		private By Title = By.xpath("//input[@placeholder='Enter the title']");
		private By SaveFile = By.xpath("//button/span[text()='Save File']");
		private By DateCreatedOn = By.xpath("//label[text()='Date Created On']/../div/p-calendar/span/input");
		private By DateSelect = By.xpath("//span[text()='15']/..//span[text()='15']/..");
		private By Dropdown = By.xpath("//p-dropdownitem/li[@role='option']/span[@class='ng-star-inserted']");
		private By SaveAs = By.xpath("//label[text()='Save as']/../div/p-dropdown/div/span");
		private By AddFileBtn = By.xpath("//span[text()=' Add ']");
		private By appointmentMenu = By.xpath("//span[text()='Appointments']/..");
		
		
		
		Faker fakeData = new Faker();
		
		
		
		
		Faker faker = new Faker();
		
	        	public FileUploadPage(WebDriver driver) {
					
		        	this.driver = driver;
					testUtil = new TestUtil(driver);
					javaScriptUtil = new JavaScriptUtil(driver);
		}
		
	        	public void fileUploadPage() {
	        		
	        		prescriptionFormatPage = new PrescriptionFormatPage(driver);
	        		prescriptionFormatPage.clkPatientMenu();
	        		testUtil.doClick(fileLink, "File link");
	        		
	        	}
	        	
	        	/*public void PatientCreateAppointment(){
	        		
					  dronaAddPatientPage = new DronaAddPatientPage(driver);
					  dronaAddPatientPage.openPatientPage(); 
					  testUtil.staticWait(3000);
					  testUtil.doClick(AddPatient, 10); 
					  String PatientContact = dronaAddPatientPage.AddPatient();
					  System.out.println(PatientContact);
					  dronaAddPatientPage.saveNewPatient(); 
					  testUtil.staticWait(3000);
					  appointmentBookingPage = new AppointmentBookingPage(driver);
					  appointmentBookingPage.AppointmentBooking(PatientContact);
					  testUtil.staticWait(3000);
					 
	        	}*/
		
	        	public boolean fileUpload() throws IOException {
	        		
	        		boolean FileUploaded = false;
	        		testUtil.staticWait(3000);
	        		//PatientCreateAppointment();
					prescriptionFormatPage = new PrescriptionFormatPage(driver);
	        		prescriptionFormatPage.clkPatientMenu();
	        		testUtil.doClick(fileLink, "File link");
	        		testUtil.staticWait(1000);
				    testUtil.doClick(UploadBtn, 10); 
				    testUtil.doClick(BrowseBtn, 10);
					testUtil.staticWait(3000); 
					Runtime.getRuntime().exec("D:\\Files.exe");		
	        		testUtil.staticWait(3000);
	        		String FileTitle=fakeData.book().title();
					testUtil.dosendKeys(Title, 10, FileTitle , "Title");
					testUtil.doClick(SaveFile, 10);
	        		testUtil.staticWait(3000);  
	        		String NewUploadedFilePath ="//div[contains(@class,'upld-list-box pointer ng-star-inserted')]/div/div[2]/div/h4[text()='"+FileTitle+" ']";
	        		String TitleOnScreen =  driver.findElement(By.xpath(NewUploadedFilePath)).getText();
	        				if(TitleOnScreen.equalsIgnoreCase(FileTitle.concat(" New")))
	        		{
	        			FileUploaded=true;
	        		}
	        		return FileUploaded;
	        	}
	        	
	        	public boolean fileUploadfromAppointment() throws IOException {
	        		
	        		boolean FileUploaded = false;
	        		testUtil.staticWait(3000);
	        		WebElement appointmentMenuClk = testUtil.getElement(appointmentMenu);
	        		javaScriptUtil.clickElementByJS(appointmentMenuClk);
	        		testUtil.staticWait(5000);
	        		ExtentLogger.pass("Clicked on Appointment  icon in menu bar.");
	        		testUtil.doClick(patientAppointment, "patient Appointment");
	         		testUtil.staticWait(3000);
	        		testUtil.doClick(FileBtn, "File Button");
	        		testUtil.staticWait(1000);
				    testUtil.doClick(UploadBtn, 10); 
				    testUtil.doClick(BrowseBtn, 10);
					testUtil.staticWait(3000); 
					Runtime.getRuntime().exec("D:\\Files.exe");		
	        		testUtil.staticWait(3000);
	        		String FileTitle=fakeData.book().title();
					testUtil.dosendKeys(Title, 10, FileTitle , "Title");
					testUtil.doClick(SaveFile, 10);
	        		testUtil.staticWait(3000);  
	        		List<WebElement> NewUploadedFilePath = driver.findElements(FileTitleTxt);
					for (WebElement select : NewUploadedFilePath) {
						if (FileTitle.equalsIgnoreCase(select.getText())) {
							
	        			FileUploaded=true;
	        		}
					}
	        		return FileUploaded;
	        	}
	        	
	        		public boolean DeleteUploadedFile() throws IOException {
	        		
	        		boolean FileUploaded = true;
	        		//testUtil.staticWait(3000);
	        		//PatientCreateAppointment();
					prescriptionFormatPage = new PrescriptionFormatPage(driver);
	        		prescriptionFormatPage.clkPatientMenu();
	        		testUtil.doClick(fileLink, "File link");
	        		testUtil.staticWait(1000);
	        		testUtil.doClick(UploadBtn, 10);
	        		testUtil.doClick(BrowseBtn, 10);
	        		testUtil.staticWait(3000);
	        		Runtime.getRuntime().exec("D:\\Files.exe");		
	        		testUtil.staticWait(3000);
	        		String FileTitle=fakeData.book().title();
	        		testUtil.dosendKeys(Title, 10, FileTitle , "Title");
	        		testUtil.doClick(SaveFile, 10);
	        		testUtil.staticWait(3000);
	        		String ThreeDotClickPath ="//h4[text()='"+FileTitle+" ']/ancestor::div[@class='upld-list-box pointer ng-star-inserted']/div/div[3]/div/i";
	        		WebElement ThreeDotClick = driver.findElement(By.xpath(ThreeDotClickPath));
	        		ThreeDotClick.click();
	        		String DeleteBtn = "//h4[text()='"+FileTitle+" ']/ancestor::div[@class='upld-list-box pointer ng-star-inserted']/div/div[3]/div/div/a[2]";
	        		testUtil.doClick(By.xpath(DeleteBtn), 10);
	        		ExtentLogger.pass("Clicked on Delete button"); 
	        		String FilePath ="//div[contains(@class,'upld-list-box')]/div/div[2]/div/h4";
	        		String FileUploadPath = "//div[contains(@class,'upld-list-box')]/div/div[2]/div/h4[text()='"+FileTitle+" ']";
	        		List<WebElement> FileUploadTitle = driver.findElements(By.xpath(FilePath));
	           	   for(WebElement TitleOnScreen : FileUploadTitle) {
	           		 String updatedTitle=TitleOnScreen.getText();
	           		 if(updatedTitle.equalsIgnoreCase(FileTitle.concat(" New")))
	           		 {
	           			FileUploaded =false;
	               		 ExtentLogger.pass("File not deleted successfully"); 
	               		 break;
	           		 }
	           		 
	           		
	           	   }
	           	 return FileUploaded;
	        		
	        }
	        		public boolean DeleteUploadedFilefromAppointment() throws IOException {
	            		
	            		boolean FileUploaded = true;
	            		WebElement appointmentMenuClk = testUtil.getElement(appointmentMenu);
	            		javaScriptUtil.clickElementByJS(appointmentMenuClk);
	            		testUtil.staticWait(5000);
	            		ExtentLogger.pass("Clicked on Appointment  icon in menu bar.");
	            		testUtil.doClick(patientAppointment, "patient Appointment");
	             		testUtil.staticWait(3000);
	            		testUtil.doClick(FileBtn, "File Button");
	            		testUtil.staticWait(1000);
	            		testUtil.doClick(UploadBtn, 10);
	            		testUtil.doClick(BrowseBtn, 10);
	            		testUtil.staticWait(3000);
	            		Runtime.getRuntime().exec("D:\\Files.exe");		
	            		testUtil.staticWait(3000);
	            		String[] FileTitle=fakeData.book().title().split("\\s");
	            		String FileTit = FileTitle[0];
	            		testUtil.dosendKeys(Title, 10, FileTit , "Title");
	            		testUtil.doClick(SaveFile, 10);
	            		testUtil.staticWait(3000);
	            		String ThreeDotClickPath ="//tbody/tr/td[2][text()='"+FileTit+"']/../div";
	            		WebElement ThreeDotClick = driver.findElement(By.xpath(ThreeDotClickPath));
	            		ThreeDotClick.click();
	            		String DeleteBtn = "//tbody/tr/td[2][text()='"+FileTit+"']/../div/div/a[2]";
	            		testUtil.doClick(By.xpath(DeleteBtn), 10);
	            		ExtentLogger.pass("Clicked on Delete button"); 
	            		List<WebElement> NewUploadedFilePath = driver.findElements(FileTitleTxt);
	    				for (WebElement select : NewUploadedFilePath) {
	    					if (FileTit.equalsIgnoreCase(select.getText())) {
	    						
	            			FileUploaded=false;
	            			ExtentLogger.pass("File not deleted successfully"); 
	            		}
	    				}
	            		return FileUploaded;
	               	   
	            }
	            		
	        		
	        		public boolean EditAllFields() throws IOException {
	            		
	            		boolean FileUploaded = false;
	            		//testUtil.staticWait(3000);
	            		//PatientCreateAppointment();
	    				prescriptionFormatPage = new PrescriptionFormatPage(driver);
	            		prescriptionFormatPage.clkPatientMenu();
	            		testUtil.doClick(fileLink, "File link");
	            		testUtil.staticWait(1000);
	            		testUtil.doClick(UploadBtn, 10);
	            		testUtil.staticWait(2000);
	            		testUtil.doClick(BrowseBtn, 10);
	            		testUtil.staticWait(3000);
	            		Runtime.getRuntime().exec("D:\\Files.exe");		
	            		testUtil.staticWait(3000);
	            		String FileTitle=fakeData.book().title();
	            		testUtil.dosendKeys(Title, 10, FileTitle , "Title");
	            		 testUtil.staticWait(3000);
	            		testUtil.doClick(SaveFile, 10);
	            		testUtil.staticWait(3000);
	            		String ThreeDotClickPath ="//h4[text()='"+FileTitle+" ']/ancestor::div[@class='upld-list-box pointer ng-star-inserted']/div/div[3]/div/i";
	            		WebElement ThreeDotClick = driver.findElement(By.xpath(ThreeDotClickPath));
	            		ThreeDotClick.click();
	            		String EditBtn = "//h4[text()='"+FileTitle+" ']/ancestor::div[@class='upld-list-box pointer ng-star-inserted']/div/div[3]/div/div/a[1]";
	            		testUtil.doClick(By.xpath(EditBtn), 10);
	            		ExtentLogger.pass("Clicked on Edit button"); 
	            		testUtil.doClick(AddFileBtn, 10);
	            		testUtil.staticWait(3000);
	            		testUtil.staticWait(3000);
	            		String EditFileTitle=fakeData.book().title();
	            		testUtil.dosendKeys(Title, 10, EditFileTitle , "Title");
	            		testUtil.doClick(DateCreatedOn, 10);
	            		testUtil.doClick(DateSelect, "10 select as date");
	            		testUtil.doClick(SaveAs, 10);
	            		List<WebElement> UpdatedFileSaveAs = driver.findElements(Dropdown);
	            		String FileSave = "Other Attachments";
	            			for (WebElement select : UpdatedFileSaveAs) {
	            				if (FileSave.equalsIgnoreCase(select.getText())) {
	            					select.click();
	            					break;
	            				}
	            			}
	            		 String DateCreated =  testUtil.getElement(DateCreatedOn).getAttribute("value");
	            		 String[] str = {FileSave,DateCreated,EditFileTitle};
	            		 List<String> FileDetail = new ArrayList<>();//empty list
	            		 FileDetail.addAll(Arrays.asList(str));
	            		 System.out.println(FileDetail);
	            		 testUtil.staticWait(3000);
	            		testUtil.doClick(SaveFile, 10);
	            		 testUtil.staticWait(3000);
	            		String UpdatedThreeDotClickPath ="//h4[text()='"+EditFileTitle+" ']/ancestor::div[@class='upld-list-box pointer ng-star-inserted']/div/div[3]/div/i";
	            		WebElement UpdatedThreeDotClick = driver.findElement(By.xpath(UpdatedThreeDotClickPath));
	            		UpdatedThreeDotClick.click();
	            		 testUtil.staticWait(3000);
	            		String UpdatedEditBtn = "//h4[text()='"+EditFileTitle+" ']/ancestor::div[@class='upld-list-box pointer ng-star-inserted']/div/div[3]/div/div/a[1]";
	            		testUtil.doClick(By.xpath(UpdatedEditBtn), 10);
	            		ExtentLogger.pass("Clicked on Edit button again to verify values"); 
	            		testUtil.staticWait(3000);
	            		String UpdatedFileTitle =  testUtil.getElement(Title).getAttribute("value");
	            		testUtil.staticWait(3000);
	            		 String UpdatedDate =  testUtil.getElement(DateCreatedOn).getAttribute("value");
	            		 testUtil.staticWait(3000);
	            		 String UpdatedSaveAs =  testUtil.getElement(SaveAs).getText();
	            		 testUtil.staticWait(3000);
	            		 String[] Updatedstr = {UpdatedSaveAs,UpdatedDate,UpdatedFileTitle};
	            		 List<String> UpdatedFileDetail = new ArrayList<>();//empty list
	            		 UpdatedFileDetail.addAll(Arrays.asList(Updatedstr));
	            		 System.out.println(UpdatedFileDetail);
	            	     if(FileDetail.equals(UpdatedFileDetail)){
	            	    	 
	            	    	 FileUploaded =true;
	            	     }
	                           
	               	 return FileUploaded;
	            		
	            }
	        	
	        		public boolean EditAllFieldsonAppointment() throws IOException {
	            		
	            		boolean FileUploaded = false;
	            		testUtil.staticWait(3000);
	            		WebElement appointmentMenuClk = testUtil.getElement(appointmentMenu);
	            		javaScriptUtil.clickElementByJS(appointmentMenuClk);
	            		testUtil.staticWait(5000);
	            		ExtentLogger.pass("Clicked on Appointment  icon in menu bar.");
	            		testUtil.doClick(patientAppointment, "patient Appointment");
	             		testUtil.staticWait(3000);
	            		testUtil.doClick(FileBtn, "File Button");
	            		testUtil.staticWait(1000);
	            		testUtil.doClick(UploadBtn, 10);
	            		testUtil.staticWait(2000);
	            		testUtil.doClick(BrowseBtn, 10);
	            		testUtil.staticWait(3000);
	            		Runtime.getRuntime().exec("D:\\Files.exe");		
	            		testUtil.staticWait(3000);
	            		String[] FileTitle=fakeData.book().title().split("\\s");
	            		String FileTit = FileTitle[0];
	            		testUtil.dosendKeys(Title, 10, FileTit , "Title");
	            		testUtil.doClick(SaveFile, 10);
	            		testUtil.staticWait(3000);
	            		String ThreeDotClickPath ="//tbody/tr/td[2][text()='"+FileTit+"']/../div";
	            		WebElement ThreeDotClick = driver.findElement(By.xpath(ThreeDotClickPath));
	            		ThreeDotClick.click();
	            		String EditBtn = "//tbody/tr/td[2][text()='"+FileTit+"']/../div/div/a[1]";
	            		testUtil.doClick(By.xpath(EditBtn), 10);
	            		ExtentLogger.pass("Clicked on Edit button"); 
	            		testUtil.doClick(AddFileBtn, 10);
	            		testUtil.staticWait(3000);
	            		Runtime.getRuntime().exec("D:\\SecondFile.exe");
	            		testUtil.staticWait(3000);
	            		String EditFileTitle=fakeData.name().firstName();
	            		testUtil.dosendKeys(Title, 10, EditFileTitle , "Title");
	            		testUtil.doClick(DateCreatedOn, 10);
	            		testUtil.doClick(DateSelect, "10 select as date");
	            		testUtil.doClick(SaveAs, 10);
	            		List<WebElement> UpdatedFileSaveAs = driver.findElements(Dropdown);
	            		String FileSave = "Other Attachments";
	            			for (WebElement select : UpdatedFileSaveAs) {
	            				if (FileSave.equalsIgnoreCase(select.getText())) {
	            					select.click();
	            					break;
	            				}
	            			}
	            		 String DateCreated =  testUtil.getElement(DateCreatedOn).getAttribute("value");
	            		 String[] str = {FileSave,DateCreated,EditFileTitle};
	            		 List<String> FileDetail = new ArrayList<>();//empty list
	            		 FileDetail.addAll(Arrays.asList(str));
	            		 System.out.println(FileDetail);
	            		 testUtil.staticWait(3000);
	            		testUtil.doClick(SaveFile, 10);
	            		 testUtil.staticWait(3000);
	            		String UpdatedThreeDotClickPath ="//tbody/tr/td[2][text()='"+EditFileTitle+"']/../div";
	            		WebElement UpdatedThreeDotClick = driver.findElement(By.xpath(UpdatedThreeDotClickPath));
	            		UpdatedThreeDotClick.click();
	            		 testUtil.staticWait(3000);
	            		String UpdatedEditBtn = "//tbody/tr/td[2][text()='"+EditFileTitle+"']/../div/div/a[1]";
	            		testUtil.doClick(By.xpath(UpdatedEditBtn), 10);
	            		ExtentLogger.pass("Clicked on Edit button again to verify values"); 
	            		testUtil.staticWait(3000);
	            		String UpdatedFileTitle =  testUtil.getElement(Title).getAttribute("value");
	            		testUtil.staticWait(3000);
	            		 String UpdatedDate =  testUtil.getElement(DateCreatedOn).getAttribute("value");
	            		 testUtil.staticWait(3000);
	            		 String UpdatedSaveAs =  testUtil.getElement(SaveAs).getText();
	            		 testUtil.staticWait(3000);
	            		 String[] Updatedstr = {UpdatedSaveAs,UpdatedDate,UpdatedFileTitle};
	            		 List<String> UpdatedFileDetail = new ArrayList<>();//empty list
	            		 UpdatedFileDetail.addAll(Arrays.asList(Updatedstr));
	            		 System.out.println(UpdatedFileDetail);
	            	     if(FileDetail.equals(UpdatedFileDetail)){
	            	    	 
	            	    	 FileUploaded =true;
	            	     }
	                           
	               	 return FileUploaded;
	            		
	            }
	        		public boolean MultipleFileUpload() throws IOException {
	            		
	            		boolean FileUploaded = false;
	            		//testUtil.staticWait(3000);
	            		//PatientCreateAppointment();
	    				prescriptionFormatPage = new PrescriptionFormatPage(driver);
	            		prescriptionFormatPage.clkPatientMenu();
	            		testUtil.staticWait(1000);
	            		testUtil.doClick(fileLink, "File link");
	            		testUtil.staticWait(1000);
	    			    testUtil.doClick(UploadBtn, 10); 
	    			    testUtil.doClick(BrowseBtn, 10);
	    			    testUtil.staticWait(3000);
	    			    Runtime.getRuntime().exec("D:\\Files.exe");
	    			    testUtil.staticWait(3000);
	    			    testUtil.doClick(AddFileBtn, 10);
	            		testUtil.staticWait(3000);
	            		Runtime.getRuntime().exec("D:\\SecondFile.exe");
	            		testUtil.staticWait(3000);
	    				String FileTitle=fakeData.book().title();
	    				testUtil.dosendKeys(Title, 10, FileTitle , "Title");
	    				testUtil.doClick(SaveFile, 10);
	            		testUtil.staticWait(3000);  
	            		String NewUploadedFilePath ="//div[contains(@class,'upld-list-box pointer ng-star-inserted')]/div/div[2]/div/h4[text()='"+FileTitle+" ']";
	            		String TitleOnScreen =  driver.findElement(By.xpath(NewUploadedFilePath)).getText();
	            				if(TitleOnScreen.equalsIgnoreCase(FileTitle.concat(" New")))
	            		{
	            			FileUploaded=true;
	            		}
	            		return FileUploaded;
	            	}
	        		
	        		public boolean MultipleFileUploadfromAppointment() throws IOException {
	            		
	            		boolean FileUploaded = false;
	            		testUtil.staticWait(3000);
	            		WebElement appointmentMenuClk = testUtil.getElement(appointmentMenu);
	            		javaScriptUtil.clickElementByJS(appointmentMenuClk);
	            		testUtil.staticWait(5000);
	            		ExtentLogger.pass("Clicked on Appointment  icon in menu bar.");
	            		testUtil.doClick(patientAppointment, "patient Appointment");
	             		testUtil.staticWait(3000);
	            		testUtil.doClick(FileBtn, "File Button");
	            		testUtil.staticWait(1000);
	    			    testUtil.doClick(UploadBtn, 10); 
	    			    testUtil.doClick(BrowseBtn, 10);
	    			    testUtil.staticWait(3000);
	    			    Runtime.getRuntime().exec("D:\\Files.exe");
	    			    testUtil.staticWait(3000);
	    			    testUtil.doClick(AddFileBtn, 10);
	            		testUtil.staticWait(3000);
	            		Runtime.getRuntime().exec("D:\\SecondFile.exe");
	            		testUtil.staticWait(3000);
	    				String FileTitle=fakeData.name().firstName();
	    				
	    				testUtil.dosendKeys(Title, 10, FileTitle , "Title");
	    				testUtil.doClick(SaveFile, 10);
	            		testUtil.staticWait(5000);  
	            		List<WebElement> NewUploadedFilePath = driver.findElements(FileTitleTxt);
	    				for (WebElement select : NewUploadedFilePath) {
	    					if (FileTitle.equalsIgnoreCase(select.getText())) {
	    						
	            			FileUploaded=true;
	            			
	            		}
	    				}
	            		return FileUploaded;
	            	}
	        		
	        		
	}


