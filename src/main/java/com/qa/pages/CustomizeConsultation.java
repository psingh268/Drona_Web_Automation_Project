package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class CustomizeConsultation extends BasePage{
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;
	ConsultPage consultPage;
	
	Faker faker = new Faker();
	
	private By patientAppointment = By.xpath( "//h4[contains(text(),' Checked In')]/../../../../../following-sibling::div[1]/div");
	
	private String searchConsultation = "//input[contains(@placeholder,'%replaceable%')]";	
	private String selectedConsultation ="//button[contains(text(),'%replaceable%')]";
	private String openConsultationSlide ="//p-accordiontab[@header='%replaceable%']/div/div/a";
	
	public CustomizeConsultation(WebDriver driver) {
		
		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public void openConsultaionSlides(String consultation) {
		
		String openConsultationXpath = testUtil.getXpath(openConsultationSlide, consultation);
		testUtil.doClick(By.xpath(openConsultationXpath), consultation);
	}
	
	public String addCustomizeConsultation(String consultation) {
		
		String consultationType = faker.medical().symptoms();
		String searchConsultationXpath = testUtil.getXpath(searchConsultation, consultation);
		testUtil.dosendKeys(By.xpath(searchConsultationXpath), 10, consultationType, consultation + " entered");
		driver.findElement(By.xpath(searchConsultationXpath)).sendKeys(Keys.ENTER);
		ExtentLogger.pass(consultationType + " as a " + consultation + " added");
		return consultationType;
	}
	
	public boolean saveCustomizeConsultation(String consultationName) {
		
		boolean consultationAdded = false;
		String selectedConsultationXpath = testUtil.getXpath(selectedConsultation, consultationName);
		WebElement seletedConsultationName = driver.findElement(By.xpath(selectedConsultationXpath));
		if(seletedConsultationName.isDisplayed()) {
			
			consultationAdded =true;
		}
		
		return consultationAdded;
	}
  
	
}
