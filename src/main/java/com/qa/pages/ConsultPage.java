package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class ConsultPage extends BasePage{
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;	
	
	Faker faker = new Faker();
	
	private By SignificantView = By.xpath("//span[text()='Significant History']/../../p-header[2]/div/div/div/span[contains(@class,'symtoms-name-show')]");
	private By CustomizeDeleteInstruct = By.xpath("//p-accordiontab[@header='Instructions']/div/div[2]/div/div[2]/div[last()]/div/div/i");
	private By CustomizeDeleteInvesg = By.xpath("//p-accordiontab[@header='Investigations']/div/div[2]/div/div[2]/div[last()]/div/div/i");
	private By InvetigationCustomizeAdd = By.xpath("//p-accordiontab[@header='Investigations']/div/div/a/p-header[2]/div/div/div/input");
	private By InstructionCustomizeAdd = By.xpath("//p-accordiontab[@header='Instructions']/div/div/a/p-header[2]/div/div/div/input");
	private By AddedMedicine1 = By.xpath("//p-accordiontab[@header='Medicines']/div/div[2]/div/div[2]/div/div/label[1]");
	private By AddedMedicine2 = By.xpath("//p-accordiontab[@header='Medicines']/div/div[2]/div/div[2]/div/div/label[2]");
	private By AddedFinding =By.xpath("//p-accordiontab[@header='Examination Findings']/div/div[2]/div/div[2]/div/div/div");
	private By Addeddiagnosis =By.xpath("//p-accordiontab[@header='Diagnosis']/div/div[2]/div/div[2]/div/div/div");
	private By AddedInstructions =By.xpath("//p-accordiontab[@header='Instructions']/div/div[2]/div/div/div[1]/div/button");
	private By AddedCondition = By.xpath("//p-accordiontab[@header='Conditions']/div/div[2]/div/div/div[1]/div/button");
	private By AddedMedication = By.xpath("//p-accordiontab[@header='Current Medication']/div/div[2]/div/div/div[1]/div/button");
	private By AddedAllergy = By.xpath("//p-accordiontab[@header='Allergies']/div/div[2]/div/div/div[1]/div/button");
	private By AddedInvestigation =By.xpath("//p-accordiontab[@header='Investigations']/div/div[2]/div/div/div[1]/div/button");
	private By AddedSymptom =By.xpath("//p-accordiontab[@header='Symptoms']/div/div[2]/div/div[2]/div/div/div");
	private By DeleteSymBtn = By.xpath("//p-accordiontab[@header='Symptoms']/div/div[2]/div/div[2]/div/div/div/img[contains(@class,'img-fluid cross-img')]");
	private By DeleteDiagBtn = By.xpath("//p-accordiontab[@header='Diagnosis']/div/div[2]/div/div[2]/div/div/div/img[contains(@class,'img-fluid cross-img')]");
	private By DeleteInvestigBtn = By.xpath("//div[contains(@class,'p-checkbox-box p-highlight')]");
	private By DeleteInstructBtn = By.xpath("//div[contains(@class,'p-checkbox-box p-highlight')]");
	private By SignificantOpenBtn = By.xpath("//p-accordiontab[@header='Significant History']/div/div/a");
	private By DeleteConditionBtn = By.xpath("//span[contains(@class,'cross1')]/i");
	private By DeleteMedicationBtn = By.xpath("//p-accordiontab[@header='Current Medication']/div/div[2]/div/div/div[1]/div/button/i");
	private By DeleteAllergyBtn = By.xpath("//p-accordiontab[@header='Allergies']/div/div[2]/div/div/div[1]/div/button/i");
	private By DeleteFamilyMemberBtn = By.xpath("//p-accordiontab[@header='Family History']/div/div[2]/div/div/div/div[3]/i");
	private By DeleteMediBtn = By.xpath("//p-accordiontab[@header='Medicines']/div/div[2]/div/div[4]/div/div/div/div[2]/img");
	private By DeleteFindingBtn = By.xpath("//p-accordiontab[@header='Examination Findings']/div/div[2]/div/div[2]/div/div/div/img[contains(@class,'img-fluid cross-img')]");
	private By VitalHistory1= By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr[1]/td[2]/input");
	private By VitalHistory2= By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr[2]/td[2]/input");
	private By vitalHistoryList = By.xpath("//tbody[contains(@class,'p-datatable-tbody')]/tr/td[2]/input");
	private By Vital1 = By.xpath("//div[contains(@class,'vital_head_master ng-star-inserted')][1]/div/div/div[2]/div/input");
	private By Vital2 = By.xpath("//div[contains(@class,'vital_head_master ng-star-inserted')][2]/div/div/div[2]/div/input");
	private By AddNote = By.xpath("//div/textarea[contains(@placeholder,'Add Comments')]");
	private By VitalHistory =By.xpath("//span[text()='History']");
	private By 	EditVitalBtn = By.xpath("//div[text()=' Edit Vitals ']");
	private By 	UpdateVitalBtn = By.xpath("//button[text()='Update Vitals']");
	private By patientMenu = By.xpath( "//span[text()='Patients']/..");
	private By addTagTxtBx = By.xpath( "//input[@placeholder='Add Tag']");
	private By patientAppointment = By.xpath( "//h4[contains(text(),' Pending')]/../../../../../following-sibling::div[1]/div");
	private By chiefComplaintTxtBx = By.xpath( "//label[text()='Chief Complaint']/following-sibling::input");
	private By addVitalsBtn = By.xpath( "//div[text()=' Add Vitals ']");
	private By vitalList = By.xpath( "//div[contains(@class,'vital_head_master ng-star-inserted')]/div/div/div[2]/div/input");
	private By saveVitalsBtn = By.xpath( "//button[text()='Add Vitals']");
	private By customiseVitalsBtn = By.xpath( "//div[text()='Customise']");
	private By consultnowBtn = By.xpath( "//span[text()='Consult Now']/parent::button");
	private By SymptomsOpenBtn = By.xpath( "//p-accordiontab[@header='Symptoms']/div/div/a");
	private By examinationFindingOpenBtn = By.xpath( "//p-accordiontab[@header='Examination Findings']/div/div/a");
	private By examinationFindingList = By.xpath( "//p-accordiontab[@header='Examination Findings']/div/div[2]/div/div[3]/div/div/div/div");
	private By symptomList = By.xpath( "//p-accordiontab[@header='Symptoms']/div/div[2]/div/div[3]/div/div/div/div");
	private By medicinesOpenBtn = By.xpath( "//p-accordiontab[@header='Medicines']/div/div/a");
	private By medicineList = By.xpath( "//p-accordiontab[@header='Medicines']/div/div[2]/div/div[2]/div/div");
	private By medicineDuration = By.xpath( "//div[text()='Duration']/ancestor::div[2]/following-sibling::div/div/div/div[text()='7']");
	private By medicineDosage = By.xpath( "//div[text()='Dosage']/ancestor::div[2]/following-sibling::div[1]/div[4]/div/div[text()='2']");
	private By medicineTiming = By.xpath( "//div[text()=' Afternoon ']/img");
	private By medicinetakeSession = By.xpath( "//label[text()='After food']/preceding-sibling::div");
	private By medicineRoute = By.xpath( "//div[text()='Route']/following-sibling::div/input");
	private By medicineNote= By.xpath( "//div[text()='Note']/following-sibling::div/input");
	private By medicineSaveBtn = By.xpath( "//button[text()='Save']");
	private By diagnosisOpenBtn = By.xpath( "//p-accordiontab[@header='Diagnosis']/div/div/a");
	private By diagnosisList = By.xpath( "//p-accordiontab[@header='Diagnosis']/div/div[2]/div/div[3]/div/div/div/div");
	private By investigationsOpenBtn = By.xpath( "//p-accordiontab[@header='Investigations']/div/div/a");
	private By InvestigationList = By.xpath( "//p-accordiontab[@header='Investigations']/div/div[2]/div/div[3]/div/div/div/p-checkbox");
	private By instructionsOpenBtn = By.xpath( "//p-accordiontab[@header='Instructions']/div/div/a");
	private By instructionsList = By.xpath( "//p-accordiontab[@header='Instructions']/div/div[2]/div/div[3]/div/div/div/p-checkbox");
	private By prescriptionOpenBtn = By.xpath( "//p-accordiontab[@header='Prescription Notes']/div/div/a");
	private By prescriptionTxtBx = By.xpath( "//p-accordiontab[@header='Prescription Notes']/div/div[2]/div/div/div/textarea");
	private By SignificantTxtBx = By.xpath( "//p-accordiontab[@header='Significant History']/div/div[2]/div/div/textarea");
	private By prescriptionView = By.xpath( "//p-accordiontab[@header='Prescription Notes']/div/div/a/p-header[2]/div/div/div/span");
	private By conditionOpenBtn = By.xpath( "//p-accordiontab[@header='Conditions']/div/div/a");
	private By currentMedicationOpenBtn = By.xpath( "//p-accordiontab[@header='Current Medication']/div/div/a");
	private By familyHistoryOpenBtn = By.xpath( "//p-accordiontab[@header='Family History']/div/div/a");
	private By significantHistoryOpenBtn = By.xpath( "//p-accordiontab[@header='Significant History']/div/div/a");
	private By allergieOpenBtn = By.xpath( "//p-accordiontab[@header='Allergies']/div/div/a");
	private By conditionsList = By.xpath( "//p-accordiontab[@header='Conditions']/div/div[2]/div/div[3]/div/div/div");
	private By currentMedicationList = By.xpath( "//p-accordiontab[@header='Current Medication']/div/div[2]/div/div[3]/div/div/div/div");
	private By allergiesList = By.xpath( "//p-accordiontab[@header='Allergies']/div/div[2]/div/div[3]/div/div/div");
	private By familyHistoryList = By.xpath( "//p-accordiontab[@header=' Family History']/div/div[2]/div/div[2]/div/label");
	private By significantHistoryList = By.xpath( "//p-accordiontab[@header='Significant History']/div/div[2]/div/div/div/textarea");
	private By medicalHistoryList = By.xpath( "//span[text()='Medical History']/..");
	private By familyMemberDropDownOpen = By.xpath("//span[text()='Select Member']");
	private By familyMemberConditionDropDownOpen = By.xpath( "//div[text()='Select a Condition']/..");
	private By familyMemberType = By.xpath("//span[text()='Father']/..");
	private By familyMemberDiseaseList = By.xpath( "//p-multiselectitem/li/div/div");
	private By muliSlctCloseBtn = By.xpath( "//button[contains(@class,'p-multiselect-close')]");
	private By appointmentMenu = By.xpath("//span[text()='Appointments']/..");
	
	
	
	public ConsultPage(WebDriver driver) {
				
				this.driver = driver;
				testUtil = new TestUtil(driver);
				javaScriptUtil = new JavaScriptUtil(driver);
			}
	
	public void clkPatientMenu() {
		
		testUtil.staticWait(5000);
		WebElement appointmentMenuClk = testUtil.getElement(appointmentMenu);
		javaScriptUtil.clickElementByJS(appointmentMenuClk);
		testUtil.staticWait(5000);
		ExtentLogger.pass("Clicked on Appointment  icon in menu bar.");
	}
	
	public String addNewTag() {
		
		clkPatientMenu();
		testUtil.doClick(patientAppointment, "patient Appointment");
		testUtil.staticWait(3000);
		String tagText = faker.medical().symptoms();
		testUtil.dosendKeys(addTagTxtBx, 10, tagText, "add tag textBox");
		WebElement addTagBox = driver.findElement(addTagTxtBx);
		addTagBox.sendKeys(Keys.ENTER);	
		testUtil.staticWait(3000);
		ExtentLogger.pass("New tag Added successfully.");
		return tagText;
		
	}
	
	public boolean addNewTagVerify() {
		
		boolean addedTag = false;
		String tagText = addNewTag();
		String newTagPath = "//span[text()='"+tagText+"']";
		WebElement newAddedtag = driver.findElement(By.xpath(newTagPath));
		if(newAddedtag.isDisplayed()) {
			
			addedTag = true;
		}
		return addedTag;
		
	}

	public boolean deleteTag() {
    	 
    	 boolean Tagdeleted = false;
    	 String tagText = addNewTag();
    	 testUtil.staticWait(2000);
    	 String deleteTagPath = "//span[text()='"+ tagText +"']/following-sibling::i";
    	 WebElement deletetagBtn = driver.findElement(By.xpath(deleteTagPath));
    	 String newTagPath = "//span[text()='"+tagText+"']";
 		 WebElement newAddedtag = driver.findElement(By.xpath(newTagPath));
    	 deletetagBtn.click();
    	 ExtentLogger.pass("Delete Tag button clicked.");
    	 Tagdeleted = true;
    	 return Tagdeleted;	
     }
	 
    public void addChiefComplaint() {
    	 
    	 clkPatientMenu();
    	 testUtil.doClick(patientAppointment, "patient Appointment");
 		testUtil.staticWait(3000);
    	 String text = "patient complaint added";
    	 testUtil.dosendKeys(chiefComplaintTxtBx, 10, text, "add tag textBox");
    	 WebElement chiefComplaint = driver.findElement(chiefComplaintTxtBx) ;
    	 chiefComplaint.sendKeys(Keys.ENTER);
         testUtil.staticWait(2000);
			
     }
     
    public void addVitals() {
    	
    	 clkPatientMenu();
    	 testUtil.doClick(patientAppointment, "patient Appointment");
 		 testUtil.staticWait(3000);
 		 testUtil.doClick(addVitalsBtn, "Add Vitals");
         List<WebElement>vitalsList = driver.findElements(vitalList); 
         int count = 0;
         for(WebElement vital : vitalsList) {
        	 if(count <=1) {
        	 double vitalValue = faker.number().randomDouble(2, 1, 9);
        	 String vitalVal = String.valueOf(vitalValue);
        	 vital.sendKeys(vitalVal);
        	 vital = null;
        	 count ++;
        	 }
         }
         testUtil.doClick(saveVitalsBtn, "Vitals Save Btn");
         testUtil.staticWait(2000);
     }
     
    public void getConsultNowPage() {
    	 clkPatientMenu();
    	 testUtil.staticWait(3000);
    	 testUtil.doClick(patientAppointment, "patient Appointment");
 		 testUtil.staticWait(3000);
 		 testUtil.doClick(consultnowBtn, "Consult Now");   	 
 		testUtil.staticWait(7000);
     }
	  
    public void addSymptoms(int symptomPosition) {
		  
		  
		  testUtil.staticWait(2000);
		  List<WebElement>symptomsList = driver.findElements(symptomList);        
	      WebElement symptom = symptomsList.get(symptomPosition);
	      javaScriptUtil.clickElementByJS(symptom);
	      ExtentLogger.pass("symptoms  added successfully.");
	  }
	  
	public boolean symptomsShowingSelected() {
   	   
   	   boolean symptomsShown = false;
   	   getConsultNowPage();
   	   testUtil.staticWait(3000);
       	addSymptoms(1);
   	   try {
			WebElement selectedSymptoms = driver.findElement(By.xpath("//p-accordiontab[@header='Symptoms']/div/div[2]/div/div[2]/div/div/div"));
			   if(selectedSymptoms.isDisplayed()) {
				   symptomsShown =true;
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
   	   return symptomsShown;
      }
	  
    public void addExaminationFinding(int findingposition) {
		  
		
		  testUtil.staticWait(2000);
		  testUtil.doClick(examinationFindingOpenBtn, "examination Finding slideBar");
		  testUtil.staticWait(2000);
		  List<WebElement>examinationFindingsList = driver.findElements(examinationFindingList);        
	      WebElement finding = examinationFindingsList.get(findingposition);
	      testUtil.staticWait(2000);
	      System.out.println(finding.getText());
	      finding.click();
	      ExtentLogger.pass("finding  added successfully.");
	  }
       
    public boolean examinationFindingShowingSelected() {
    	   
    	   boolean findingShown = false;
    	   getConsultNowPage();
    	   driver.navigate().refresh();
    	   testUtil.staticWait(9000);
    	   addExaminationFinding(1);
    	   try {
			WebElement selectedFinding = driver.findElement(By.xpath("//p-accordiontab[@header='Examination Findings']/div/div[2]/div/div[2]/div/div/div"));
			   if(selectedFinding.isDisplayed()) {
				   findingShown =true;
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	   return findingShown;
       }
       
    public void addMedicine(int medicinePosition) {
  		    		 
  		  testUtil.staticWait(2000);
  		  testUtil.doClick(medicinesOpenBtn, "medicine slideBar");
  		  testUtil.staticWait(2000);
  		  List<WebElement>FindingsList = driver.findElements(medicineList);        
  	      WebElement medicine = FindingsList.get(medicinePosition);  
  	      medicine.click();
  	      testUtil.staticWait(2000);
  	      testUtil.doClick(medicineDosage, "medicineDosage");
  	      testUtil.doClick(medicineDuration, "medicineDuration");
  	      testUtil.doClick(medicineTiming, "medicineTiming");
  	      testUtil.doClick(medicinetakeSession, "medicinetakeSession");
  	      testUtil.dosendKeys(medicineRoute, 10, "1-0-1", "medicineRoute");
  	      testUtil.dosendKeys(medicineNote, 10, "Medicine timing set", "medicineNote");
  	      testUtil.doClick(medicineSaveBtn, "medicineSaveBtn");
  	      testUtil.staticWait(2000);
  	      ExtentLogger.pass("medicine  added successfully.");
  	  }
       
    public boolean medicineShowingSelected() {
    	  
    	  boolean medicineShown = false;
    	   getConsultNowPage();
    	   driver.navigate().refresh();
    	   testUtil.staticWait(9000);
    	   addMedicine(1);
    	   try {
			WebElement selectedFinding = driver.findElement(By.xpath("//div[contains(@class,'medi-name')]"));
			   if(selectedFinding.isDisplayed()) {
				   medicineShown =true;
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	   return medicineShown;
       }
        
    public void addDiagnosis(int diagnosisposition) {
		  
		  
		  testUtil.staticWait(2000);
		  testUtil.doClick(diagnosisOpenBtn, "examination Finding slideBar");
		  testUtil.staticWait(2000);
		  List<WebElement>examinationFindingsList = driver.findElements(diagnosisList);        
	      WebElement diagnosis = examinationFindingsList.get(diagnosisposition);
	      System.out.println(diagnosis.getText());
	      testUtil.staticWait(2000);
	      diagnosis.click();
	      testUtil.staticWait(2000);
	      ExtentLogger.pass("diagnosis  added successfully.");
	  }
       
    public boolean diagnosisShowingSelected() {
    	   
    	   boolean diagnosisShown = false;
    	   getConsultNowPage();
    	   driver.navigate().refresh();
    	   testUtil.staticWait(9000);
    	   addDiagnosis(1);
    	   try {
			WebElement selectedDiagnosis = driver.findElement(By.xpath("//p-accordiontab[@header='Diagnosis']/div/div[2]/div/div[2]/div/div/div"));
			   if(selectedDiagnosis.isDisplayed()) {
				   diagnosisShown =true;
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	   return diagnosisShown;
       }
       
    public void addInvestigations(int investigationsposition) {
 		  
 		  
 		  testUtil.staticWait(2000);
 		  testUtil.doClick(investigationsOpenBtn, "Investigation slideBar");
 		  List<WebElement>InvestigationsList = driver.findElements(InvestigationList);        
 	      WebElement Investigation = InvestigationsList.get(investigationsposition);
 	      Investigation.click();
 	      ExtentLogger.pass("Investigation  added successfully.");
 	  }
        
    public boolean investigationShowingSelected() {
     	   
     	   boolean investigationShown = false;
     	  getConsultNowPage();
     	 driver.navigate().refresh();
  	   testUtil.staticWait(9000);
     	   addInvestigations(1);
     	   try {
 			WebElement selectedInvestigation = driver.findElement(By.xpath("//p-accordiontab[@header='Investigations']/div/div[2]/div/div[2]/div/div/div/div/label"));
 			   if(selectedInvestigation.isDisplayed()) {
 				  investigationShown =true;
 			   }
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
     	   return investigationShown;
        }
        
    public void addInstructions(int instructionsposition) {
   		  
   		 
   		  testUtil.staticWait(2000);
   		  testUtil.doClick(instructionsOpenBtn, "instruction slideBar");
   		  List<WebElement>instructionList = driver.findElements(instructionsList);        
   	      WebElement Investigation = instructionList.get(instructionsposition);
   	   testUtil.staticWait(2000);
   	      Investigation.click();
   	   testUtil.staticWait(2000);
   	      ExtentLogger.pass("instruction added successfully.");
   	  }
          
    public boolean instructionShowingSelected() {
       	   
       	   boolean instructionShown = false;
       	 getConsultNowPage();
       	driver.navigate().refresh();
   	   testUtil.staticWait(9000);
        	addInstructions(1);
       	   try {
   			WebElement selectedInstruction = driver.findElement(By.xpath("//p-accordiontab[@header='Instructions']/div/div[2]/div/div[2]/div/div/div/div/label"));
   			   if(selectedInstruction.isDisplayed()) {
   				instructionShown =true;
   			   }
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
       	   return instructionShown;
          }
          
    public boolean addPrescriptionNotes() {
        	  
        	  boolean viewSavedPrescription = false;
        	  getConsultNowPage();
        	  driver.navigate().refresh();
          	   testUtil.staticWait(9000);
       		  testUtil.doClick(prescriptionOpenBtn, "Prescription slideBar");
              testUtil.dosendKeys(prescriptionTxtBx, 10, "add doctor prescription notes", "Prescription Notes");
              WebElement prescriptionsTxtBx = driver.findElement(prescriptionTxtBx);
              prescriptionsTxtBx.sendKeys(Keys.ENTER);
              if(testUtil.doIsDisplayed(prescriptionView)) {
            	  
            	  viewSavedPrescription =  true;
              }
              return viewSavedPrescription;
        	  
          }
   
    public boolean addSignificantNotes() {
  	  
  	  boolean viewSavedSignificant = false;
  	  getConsultNowPage();
  	 testUtil.staticWait(2000);
		  testUtil.doClick(medicalHistoryList, "Medical History");
 		  testUtil.doClick(SignificantOpenBtn, "Significant slideBar");
        testUtil.dosendKeys(SignificantTxtBx, 10, "add doctor Significant History", "Significant History");
        WebElement SignificantTxt = driver.findElement(SignificantTxtBx);
        SignificantTxt.sendKeys(Keys.ENTER);
        testUtil.doClick(SignificantOpenBtn, "Significant slideBar");
        ExtentLogger.pass("Significant history added successfully.");
        if(testUtil.doIsDisplayed(SignificantView)) {
      	  
        	viewSavedSignificant =  true;
        	 ExtentLogger.pass("Significant history visible on significant view.");
        }
        return viewSavedSignificant;
  	  
    }
          
    public void addConditions(int conditionposition) {
       		  
       		 
       		  testUtil.staticWait(2000);
       		  testUtil.doClick(medicalHistoryList, "Medical History");
       		 // testUtil.doClick(conditionOpenBtn, "condition slideBar");
       		  List<WebElement>conditionList = driver.findElements(conditionsList);        
       	      WebElement condition = conditionList.get(conditionposition);
       	      condition.click();
       	      ExtentLogger.pass("condition added successfully.");
       	  }
              
    public boolean conditionShowingSelected() {
           	   
           	   boolean conditionShown = false;
           	 getConsultNowPage();
               addConditions(1);
           	   try {
       			WebElement selectedConditions = driver.findElement(By.xpath("//p-accordiontab[@header='Conditions']/div/div[2]/div/div[2]/div/div/div"));
       			   if(selectedConditions.isDisplayed()) {
       				conditionShown =true;
       			   }
       		} catch (Exception e) {
       			e.printStackTrace();
       		}
           	   return conditionShown;
              }
             
    public void addCurrentMedication(int currentMedicationposition) {
           		  
           		  
           		  testUtil.staticWait(2000);
           		  testUtil.doClick(medicalHistoryList, "Medical History");
           		  testUtil.doClick(currentMedicationOpenBtn, "Current Medication slideBar");
           		  List<WebElement>currentMedicationsList = driver.findElements(currentMedicationList);        
           	      WebElement condition = currentMedicationsList.get(currentMedicationposition);
           	      condition.click();
           	      ExtentLogger.pass("Current Medication added successfully.");
           	  }
                  
    public boolean currentMedicationShowingSelected() {
               	   
               	   boolean currentMedicationShown = false;
               	getConsultNowPage();
                	addCurrentMedication(1);
               	   try {
           			WebElement selectedcurrentMedication = driver.findElement(By.xpath("//p-accordiontab[@header='Current Medication']/div/div[2]/div/div[2]/div/div/div"));
           			   if(selectedcurrentMedication.isDisplayed()) {
           				currentMedicationShown =true;
           			   }
           		} catch (Exception e) {
           			e.printStackTrace();
           		}
               	   return currentMedicationShown;
                  }
                 
    public void addAllergies(int allergiesposition) {
               		  
               		 
               		  testUtil.staticWait(2000);
               		  testUtil.doClick(medicalHistoryList, "Medical History");
               		  testUtil.doClick(allergieOpenBtn, "Allergies slideBar");
               		  testUtil.staticWait(2000);
               		  List<WebElement>allergieList = driver.findElements(allergiesList);        
               	      WebElement allergies = allergieList.get(allergiesposition);
               	      allergies.click();
               	      testUtil.staticWait(2000);
               	      ExtentLogger.pass("allergies added successfully.");
               	  }
                      
    public boolean allergiesShowingSelected() {
                   	   
                   	   boolean allergiesShown = false;
                    	 getConsultNowPage();
                   	   addAllergies(1);
                   	   try {
               			WebElement selectedAllergies = driver.findElement(By.xpath("//p-accordiontab[@header='Allergies']/div/div[2]/div/div[2]/div/div/div"));
               			   if(selectedAllergies.isDisplayed()) {
               				allergiesShown =true;
               			   }
               		} catch (Exception e) {
               			e.printStackTrace();
               		}
                   	   return allergiesShown;
                      }
                      
    public void addFamilymemberHistory(int allergiesposition) {
                   		  
                   		  getConsultNowPage();
                   		  testUtil.staticWait(2000);
                   		  testUtil.doClick(medicalHistoryList, "Medical History");
                   		  testUtil.doClick(familyHistoryOpenBtn, "family History Open slideBar");
                   		  testUtil.staticWait(2000);
                   		  javaScriptUtil.clickElementByJS(testUtil.getElement(familyMemberDropDownOpen));
                   		//  testUtil.doClick(familyMemberDropDownOpen, "familyMemberDropDownOpen");
                   	   	  testUtil.staticWait(1000);
                   		  testUtil.doClick(familyMemberType, "familyMemberType");
                   		  testUtil.staticWait(3000);
                   		  testUtil.doClick(familyMemberConditionDropDownOpen, "familyMemberConditionDropDownOpen");
                   		 ExtentLogger.pass("Family member added selected");
                   		  testUtil.staticWait(1000);
						  List<WebElement>familyMemberDiseasesList = driver.findElements(familyMemberDiseaseList); 
						  WebElement diasese = familyMemberDiseasesList.get(allergiesposition);
						  diasese.click();
						  ExtentLogger.pass("diasese selected.");
						  testUtil.staticWait(2000);
						  testUtil.doClick(muliSlctCloseBtn, "muliSlctCloseBtn");
						  ExtentLogger.pass("diasese added successfully.");
					
                   	  } 
                      
    public boolean VitalHistoryEdit() {
                      	
                    	  boolean Vital =false;
                    	  addVitals();
                    	  testUtil.doClick(consultnowBtn, "Consult Now"); 
                  		  testUtil.staticWait(3000);
                  		  testUtil.doClick(VitalHistory, 10);
                  		  testUtil.staticWait(3000);
                  		  List<WebElement>vitalsList = driver.findElements(vitalHistoryList); 
                          int count = 0;
                          for(WebElement vital : vitalsList) {
                       	  if(count <=1) {
                       	  double vitalValue = faker.number().randomDouble(2, 1, 9);
                       	  String vitalVal = String.valueOf(vitalValue);
                       	  vital.clear();
                       	  vital.sendKeys(vitalVal);
                       	  vital = null;
                       	  count ++;
                       	  }
                          }
                    	 
                    	  WebElement VitalFist = driver.findElement(VitalHistory1); 
                  		  String FirstVitalvalue=VitalFist.getAttribute("value");
                  		  WebElement VitalSecond = driver.findElement(VitalHistory2); 
                  		  String SecondVitalvalue=VitalSecond.getAttribute("value");
                  		  testUtil.doClick(UpdateVitalBtn, "Update Vital Btn");
                    	  testUtil.staticWait(3000);
                    	  testUtil.doClick(VitalHistory, 10);
                    	  testUtil.staticWait(3000);
                  		  WebElement VitalHistoryfirst	= driver.findElement(VitalHistory2);
                  		  String FirstVitalHisoryvalue=VitalHistoryfirst.getAttribute("value");
                  		  WebElement VitalHistorySecond	= driver.findElement(VitalHistory1);
                 		  String SecondVitalHisoryvalue=VitalHistorySecond.getAttribute("value");
                 		  if(FirstVitalvalue.equalsIgnoreCase(SecondVitalHisoryvalue) && SecondVitalvalue.equalsIgnoreCase(FirstVitalHisoryvalue))
                 		 {
                 			Vital=true;
                 		 }
                  		  
                          return Vital;      
                     }
                      
    public boolean VitalHistoryadd() {
                        	
                    	  boolean Vital =false;
                    	  addVitals();
                    	  testUtil.doClick(EditVitalBtn, "Edit Vitals");
                    	  WebElement VitalFist = driver.findElement(Vital1); 
                  		  String FirstVitalvalue=VitalFist.getAttribute("value");
                  		  WebElement VitalSecond = driver.findElement(Vital2); 
                  		  String SecondVitalvalue=VitalSecond.getAttribute("value");
                  		  testUtil.doClick(UpdateVitalBtn, "Update Vital Btn");
                    	  testUtil.staticWait(3000);
                  		  testUtil.doClick(consultnowBtn, "Consult Now"); 
                  		  testUtil.staticWait(3000);
                  		  testUtil.doClick(VitalHistory, 10);
                  		  testUtil.staticWait(3000);
                  		  WebElement VitalHistoryfirst	= driver.findElement(VitalHistory1);
                  		  String FirstVitalHisoryvalue=VitalHistoryfirst.getAttribute("value");
                  		  WebElement VitalHistorySecond	= driver.findElement(VitalHistory2);
                 		  String SecondVitalHisoryvalue=VitalHistorySecond.getAttribute("value");
                 		  if(FirstVitalvalue.equalsIgnoreCase(SecondVitalHisoryvalue) && SecondVitalvalue.equalsIgnoreCase(FirstVitalHisoryvalue))
                 		 {
                 			Vital=true;
                 		 }
                  		  
                          return Vital;      
                     }
                      
    public void EditVitals() {
                      	
                          clkPatientMenu();
                          testUtil.staticWait(3000);
                     	 testUtil.doClick(patientAppointment, "patient Appointment");
                  		 testUtil.staticWait(3000);
                          testUtil.doClick(EditVitalBtn, "Edit Vitals");
                          List<WebElement>vitalsList = driver.findElements(vitalList);        
                          for(WebElement vital : vitalsList) {
                                   	 
                          double vitalValue = faker.number().randomDouble(2, 1, 9);
                          String vitalVal = String.valueOf(vitalValue);
                          vital.sendKeys(vitalVal);
                          vital = null;
                          }
                          
                          testUtil.doClick(UpdateVitalBtn, "Update Vital Btn");
                          testUtil.staticWait(2000);
                                
                     }
     
    public void AddDocNote() {
		  
		  
		  testUtil.staticWait(2000);
		  clkPatientMenu();
	      testUtil.doClick(patientAppointment, "patient Appointment");
	 	  testUtil.staticWait(3000);    
	 	  testUtil.doClick(consultnowBtn, "Consult Now"); 
 		  testUtil.staticWait(3000);
	      driver.findElement(AddNote).sendKeys("add note text");
	      ExtentLogger.pass("clicked on doc note.");
	      WebElement textbox = driver.findElement(AddNote);
	      textbox.sendKeys(Keys.ENTER);
	      ExtentLogger.pass("Doctor Note  added successfully.");
	  }
                      
    public boolean FindingDelete()
	  {
		  
		  boolean Findingdelete =false;
		  
		  examinationFindingShowingSelected();
			  testUtil.staticWait(2000);
			  WebElement AddedFindng	= driver.findElement(AddedFinding);
			  String Finding = AddedFindng.getText().replaceAll("\\s+$", "");
			  System.out.println(Finding);
			  testUtil.doClick(DeleteFindingBtn, "Delete Finding Button");
			  testUtil.staticWait(2000);
			  ExtentLogger.pass("Delete button clicked.");
			  List<WebElement> FindingList = driver.findElements(examinationFindingList);
			  for(WebElement Findingadded : FindingList )
				 {
				  System.out.println(Findingadded.getText());
					 if(Findingadded.getText().equalsIgnoreCase(Finding)) {
						 
						 Findingdelete = true;
						 break;
					 }
				 }
							                  		  
                    return Findingdelete;      
               
	  }					
						  
    public boolean SymptomsDelete()
	  {
		  
		  boolean Symptomdelete =false;
		  
			  symptomsShowingSelected();
			  testUtil.staticWait(2000);
			  WebElement AddedSymtom	= driver.findElement(AddedSymptom);
			  String Symptom = AddedSymtom.getText().replaceAll("\\s+$", "");
			  System.out.println(Symptom);
			  testUtil.doClick(DeleteSymBtn, "Delete Button Click");
			  ExtentLogger.pass("Delete button clicked.");
			  List<WebElement> SymptomList = driver.findElements(symptomList);
			  for(WebElement Symptomadded : SymptomList )
				 {
				  System.out.println(Symptomadded.getText());
					 if(Symptomadded.getText().equalsIgnoreCase(Symptom)) {
						 
						 Symptomdelete = true;
						 break;
					 }
				 }
							                  		  
                    return Symptomdelete;      
               
	  }
					 
    public boolean diagnosisDelete()
	  {
		  
		  boolean diagnosisdelete =false;
		  
		  	  diagnosisShowingSelected();
			  testUtil.staticWait(2000);
			  WebElement Addediagnosis	= driver.findElement(Addeddiagnosis);
			  String diagnosis = Addediagnosis.getText().replaceAll("\\s+$", "");
			  System.out.println(diagnosis);
			  testUtil.staticWait(2000);
			  testUtil.doClick(DeleteDiagBtn, 10);
			  testUtil.staticWait(2000);
			  ExtentLogger.pass("Delete button clicked.");
			  List<WebElement> diagnosisListt = driver.findElements(diagnosisList);
			  for(WebElement diagnosisadded : diagnosisListt )
				 {
				  System.out.println(diagnosisadded.getText());
					 if(diagnosisadded.getText().equalsIgnoreCase(diagnosis)) {
						 
						 diagnosisdelete = true;
						 break;
					 }
				 }
							                  		  
                    return diagnosisdelete;      
               
	  }
					 
    public boolean medicineDelete()
	  {
		  
		  boolean diagnosisdelete =false;
		  
		      medicineShowingSelected();
			  testUtil.staticWait(2000);
			  WebElement AddedmedicineName	= driver.findElement(By.xpath("//div[contains(@class,'medi-name')]"));
			 // WebElement AddedmedicineType	= driver.findElement(AddedMedicine2);
			  String medicine1 = AddedmedicineName.getText();
			  String medicine =  medicine1.replaceAll("\\s+$", "");
			  String medicinedata =  medicine1.replaceAll("-", "");
			  System.out.println(medicine);
			  testUtil.staticWait(2000);
			  testUtil.doClick(DeleteMediBtn, "Delete Medicine");
			  testUtil.staticWait(2000);
			  ExtentLogger.pass("Delete button clicked.");
			  List<WebElement> medicineListt = driver.findElements(medicineList);
			  for(WebElement medicineadded : medicineListt )
				 {
				  
				  System.out.println(medicineadded.getText());
					 if(medicineadded.getText().equalsIgnoreCase(medicinedata)) {
						 
						 diagnosisdelete = true;
						 break;
					 }
				 }
							                  		  
                    return diagnosisdelete;      
               
	  }					 
						  
    public boolean investigationDelete()
	  {
		  
		  boolean investigationdelete =false;
		  
		      investigationShowingSelected();
			  testUtil.staticWait(2000);
			  WebElement AddedInvest	= driver.findElement(AddedInvestigation);
			  String Investigation = AddedInvest.getText().replaceAll("\\s+$", "");
			  System.out.println(Investigation);
			  testUtil.staticWait(2000);
			  testUtil.doClick(DeleteInvestigBtn, 10);
			  testUtil.staticWait(2000);
			  ExtentLogger.pass("Delete button clicked.");
			  String AddedInvestigationList ="//p-accordiontab[@header='Investigations']/div/div[2]/div/div[2]/div";
			  testUtil.staticWait(2000);
			  List<WebElement> InvestigationList = driver.findElements(By.xpath(AddedInvestigationList));
			  for(WebElement Investigationadded : InvestigationList )
				 {
				  System.out.println(Investigationadded.getText());
					 if(Investigationadded.getText().equalsIgnoreCase(Investigation)) {
						 
						 investigationdelete = true;
						 break;
					 }
				 }
							                  		  
                    return investigationdelete;      
               
	  }
	  					 
    public boolean InstructionsDelete()
	  {
		  
		  boolean Instructionsdelete =false;
		  
		  	  instructionShowingSelected();
			  testUtil.staticWait(2000);
			  WebElement AddedInstruct	= driver.findElement(AddedInstructions);
			  String Instructions = AddedInstruct.getText().replaceAll("\\s+$", "");
			  System.out.println(Instructions);
			  testUtil.staticWait(2000);
			  testUtil.doClick(DeleteInstructBtn, 10);
			  testUtil.staticWait(5000);
			  ExtentLogger.pass("Delete button clicked.");
			  String AddedInstructionsList ="//p-accordiontab[@header='Instructions']/div/div[2]/div/div[2]/div";
			  testUtil.staticWait(2000);
			  List<WebElement> InstructionsList = driver.findElements(By.xpath(AddedInstructionsList));
			  for(WebElement Instructionsadded : InstructionsList )
				 {
				  System.out.println(Instructionsadded.getText());
					 if(Instructionsadded.getText().equalsIgnoreCase(Instructions)) {
						 
						 Instructionsdelete = true;
						 break;
					 }
				 }
							                  		  
                    return Instructionsdelete;      
               
	  }
	  					  
    public boolean PrescriptionDelete()
						  {
							  
							  boolean viewSavedPrescription =true;
							  
							  	  addPrescriptionNotes();
								  testUtil.staticWait(2000);
								  WebElement AddedPrescription	= driver.findElement(prescriptionView);
								  String Prescription = AddedPrescription.getText();
								  System.out.println(Prescription);
								  testUtil.staticWait(2000);
								  WebElement prescriptionsTxtBx = driver.findElement(prescriptionTxtBx);
								 
								  testUtil.doClick(prescriptionOpenBtn, "Prescription slideBar");
								  prescriptionsTxtBx.sendKeys(Keys.chord(Keys.CONTROL, "a"));
								  prescriptionsTxtBx.sendKeys(Keys.DELETE);
								  prescriptionsTxtBx.sendKeys(Keys.ENTER);
								  testUtil.staticWait(5000);
								  ExtentLogger.pass("Delete button clicked.");
								  testUtil.doClick(prescriptionOpenBtn, "Prescription slideBar");
								  if(testUtil.doIsDisplayed(prescriptionView)) {
					            	  
					            	  viewSavedPrescription =  false;
					              }
								  
					              return viewSavedPrescription;
				                         
				                     
						  }
						  
    public boolean CustomizeInvestigationDelete()
						  {
							  
							  boolean investigationdelete =true;
							  testUtil.staticWait(2000);
							  WebElement SearchInvestigationPath = driver.findElement(InvetigationCustomizeAdd);
							  SearchInvestigationPath.sendKeys(Keys.chord(Keys.CONTROL, "a"));
							  SearchInvestigationPath.sendKeys(Keys.DELETE);
							  testUtil.staticWait(2000);
							  WebElement AddedInvest	= driver.findElement(AddedInvestigation);
							  String Investigation = AddedInvest.getText().replaceAll("\\s+$", "");
							  System.out.println(Investigation);
							  testUtil.staticWait(2000);
							  testUtil.doClick(CustomizeDeleteInvesg, "Customize Invetigation Delete");
							  testUtil.staticWait(2000);
						      ExtentLogger.pass("Delete button clicked.");
							  String AddedInvestigationList ="//p-accordiontab[@header='Investigations']/div/div[2]/div/div[2]/div";
							  testUtil.staticWait(2000);
							  List<WebElement> InvestigationList = driver.findElements(By.xpath(AddedInvestigationList));
							  for(WebElement Investigationadded : InvestigationList )
								 {
									  System.out.println(Investigationadded.getText());
			    						 if(Investigationadded.getText().equalsIgnoreCase(Investigation)) {
											 
											 investigationdelete = false;
											 break;
										 }
								 }
												                  		  
	                          return investigationdelete;      
				                     
						  }
						  
	public boolean CustomizeInstructionDelete()
						  {
							  
							  boolean Instructionsdelete =true;
							  testUtil.staticWait(2000);
							  WebElement AddedInstruct	= driver.findElement(AddedInstructions);
							  String Instructions = AddedInstruct.getText().replaceAll("\\s+$", "");
							  System.out.println(Instructions);
							  testUtil.staticWait(2000);
							  testUtil.doClick(CustomizeDeleteInstruct, "Customize Delete Instruction");
							  testUtil.staticWait(5000);
							  ExtentLogger.pass("Delete button clicked.");
							  String AddedInstructionsList ="//p-accordiontab[@header='Instructions']/div/div[2]/div/div[2]/div";
							  testUtil.staticWait(2000);
							  List<WebElement> InstructionsList = driver.findElements(By.xpath(AddedInstructionsList));
							  for(WebElement Instructionsadded : InstructionsList )
								 {
								  System.out.println(Instructionsadded.getText());
									 if(Instructionsadded.getText().equalsIgnoreCase(Instructions)) {
										 
										 Instructionsdelete = false;
										 break;
									 }
								 }
											                  		  
			                          return Instructionsdelete;      
			                     
						  }
      
    public boolean conditionDelete()
						  {
							  
							  boolean Conditiondelete =false;
							  
							  conditionShowingSelected();
								  testUtil.staticWait(2000);
								  WebElement AddedCondi	= driver.findElement(AddedCondition);
								  String Condition = AddedCondi.getText().replaceAll("\\s+$", "");
								  System.out.println(Condition);
								  testUtil.staticWait(2000);
								  testUtil.doClick(DeleteConditionBtn, 10);
								  testUtil.staticWait(5000);
								  ExtentLogger.pass("Delete button clicked.");
								  String AddedConditionsList ="//p-accordiontab[@header='Conditions']/div/div[2]/div/div[2]/div";
								  testUtil.staticWait(2000);
								  List<WebElement> ConditionsList = driver.findElements(By.xpath(AddedConditionsList));
								  for(WebElement Conditionsadded : ConditionsList )
									 {
									  System.out.println(Conditionsadded.getText());
										 if(Conditionsadded.getText().equalsIgnoreCase(Condition)) {
											 
											 Conditiondelete = true;
											 break;
										 }
									 }
												                  		  
				                          return Conditiondelete;      
				                     
						  }
						  
	public boolean MedicationDelete()
						  {
							  
							  boolean Medicationdelete =false;
							  
							  currentMedicationShowingSelected();
								  testUtil.staticWait(2000);
								  WebElement AddedMedicaton	= driver.findElement(AddedMedication);
								  String CurrentMedication = AddedMedicaton.getText().replaceAll("\\s+$", "");
								  System.out.println(CurrentMedication);
								  testUtil.staticWait(2000);
								  testUtil.doClick(DeleteMedicationBtn, 10);
								  testUtil.staticWait(5000);
								  ExtentLogger.pass("Delete button clicked.");
								  String AddedMedicationList ="//p-accordiontab[@header='Current Medication']/div/div[2]/div/div[2]/div/label";
								  testUtil.staticWait(5000);
								  List<WebElement> MedicationListList = driver.findElements(By.xpath(AddedMedicationList));
								  testUtil.staticWait(5000);
								  for(WebElement Medicationadded : MedicationListList )
									 {
									  String[] MedicationAdd = Medicationadded.getText().split(" ", 2);
									  System.out.println(MedicationAdd[0]);
										 if(MedicationAdd[0].equalsIgnoreCase(CurrentMedication)) {
											 
											 Medicationdelete = true;
											 break;
										 }
									 }
												                  		  
				                          return Medicationdelete;      
				                     
						  }
						  
	public boolean AllergyDelete()
	  {
		  
		  boolean AllergyDelete =false;
		  
		  allergiesShowingSelected();
			  testUtil.staticWait(2000);
			  WebElement AddedAllrgy	= driver.findElement(AddedAllergy);
			  String[] Allergy = AddedAllrgy.getText().split(" +",2);
			  System.out.println(Allergy[0]);
			  testUtil.staticWait(2000);
			  testUtil.doClick(DeleteAllergyBtn, 10);
			  testUtil.staticWait(5000);
			  ExtentLogger.pass("Delete button clicked.");
			  String AddedAllergyList ="//p-accordiontab[@header='Allergies']/div/div[2]/div/div[2]/div/label";
			  testUtil.staticWait(5000);
			  List<WebElement> AllergyList = driver.findElements(By.xpath(AddedAllergyList));
			  testUtil.staticWait(5000);
			  for(WebElement Allergyadded : AllergyList )
				 {
				  String AllergyAdd = Allergyadded.getText().trim();
				  System.out.println(AllergyAdd);
					 if(AllergyAdd.equalsIgnoreCase(Allergy[0])) {
						 
						 AllergyDelete = true;
						 break;
					 }
				 }
							                  		  
                    return AllergyDelete;      
               
	  }
	  
	public void FamilyHistoryDelete()
	  {
		  
		 
		  
		      addFamilymemberHistory(1);
			  testUtil.staticWait(2000);
			  testUtil.doClick(DeleteFamilyMemberBtn, 10);
			  testUtil.staticWait(5000);
			  ExtentLogger.pass("Delete button clicked.");
			 
	  }
	  		
	public boolean SignificantDelete()
	  {
		  
		  boolean viewSavedSignificant =false;
		  
		  addSignificantNotes();
			  testUtil.staticWait(2000);
			  WebElement AddedSignificant	= driver.findElement(SignificantView);
			  String significant = AddedSignificant.getText();
			  System.out.println(significant);
			  testUtil.staticWait(2000);
			  WebElement SignificantTxt = driver.findElement(SignificantTxtBx);
			 
			  testUtil.doClick(SignificantOpenBtn, "Significant slideBar");
			  SignificantTxt.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			  SignificantTxt.sendKeys(Keys.DELETE);
			  SignificantTxt.sendKeys(Keys.ENTER);
			  testUtil.staticWait(5000);
			  ExtentLogger.pass("Delete button clicked.");
			  testUtil.doClick(SignificantOpenBtn, "Significant slideBar");
			  if(testUtil.doIsDisplayed(SignificantView)) {
          	  
				  viewSavedSignificant =  true;
            }
			  
            return viewSavedSignificant;
                   
               
	  }
	  
      
	}


