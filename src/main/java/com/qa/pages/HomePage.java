package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.base.BasePage;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class HomePage extends BasePage {
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;	
	
	AppointmentBookingPage appointmentBookingPage;
	DronaAddPatientPage dronaAddPatientPage;
	
	
	
	private By todaysAppointment = By.xpath( "//label[text()='Today’s Appointments']/preceding-sibling::label");
	private By newEnrollments = By.xpath( "//label[text()='New Enrollments']/preceding-sibling::label");
	private By todayFinacial = By.xpath( "//label[text()='New Enrollments']/../following-sibling::div/label[1]");
	private By patientInQueue = By.xpath( "//label[text()='Patients in queue']/../preceding-sibling::div/div/label/span");
	private By liveAppointment = By.xpath("//h4[text()='Appointments ']/parent::div/div");
	private By patientMenu = By.xpath( "//span[text()='Patients']/..");
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public boolean totalTodayAppointment() {
		
		boolean todaysAppointmentInAnalytic = false;
		String todayAppointment = testUtil.doGetText(todaysAppointment);
		int count = Integer.parseInt(todayAppointment);
		System.out.println(count);
		testUtil.doClick(patientMenu, "Patient Menu Clicked");
		appointmentBookingPage = new AppointmentBookingPage(driver);
		appointmentBookingPage.AppointmentBookingByHeadMenu();
		WebElement homeIcon =  driver.findElement(By.xpath("//span[text()='Home']/.."));
		javaScriptUtil.clickElementByJS(homeIcon);
		testUtil.staticWait(3000);
		String updatedAppointmentCount = testUtil.doGetText(todaysAppointment);
		int updatedCount =  Integer.parseInt(updatedAppointmentCount);
		if(updatedCount == count+1) {
			
			todaysAppointmentInAnalytic = true;
		}
		return todaysAppointmentInAnalytic;				
	}
	
	public boolean newEnrollments() {
		
		boolean newEnrollmentUpdate = false;
		String newEnrollment = testUtil.doGetText(newEnrollments);
		int count = Integer.parseInt(newEnrollment);
		System.out.println(count);
		dronaAddPatientPage = new DronaAddPatientPage(driver);
		dronaAddPatientPage.openPatientPage();
		dronaAddPatientPage.createNewPatient();
		WebElement homeIcon =  driver.findElement(By.xpath("//span[text()='Home']/.."));
		javaScriptUtil.clickElementByJS(homeIcon);
		testUtil.staticWait(3000);
		String updateEnrollment = testUtil.doGetText(newEnrollments);
		int updatedCount =  Integer.parseInt(updateEnrollment);
		if(updatedCount == count+1) {
			
			 newEnrollmentUpdate = true;
		}
		return newEnrollmentUpdate;
	}
	
	public boolean liveQueue() {
		
		boolean liveQueueAppointment = false;
		String liveAppointmentCount = testUtil.doGetText(patientInQueue);
		int count = Integer.parseInt(liveAppointmentCount);
		System.out.println(count);
		WebElement homeIcon =  driver.findElement(By.xpath("//span[text()='Home']/.."));
		javaScriptUtil.clickElementByJS(homeIcon);
		testUtil.staticWait(3000);
		List<WebElement> totalLiveAppointment = driver.findElements(liveAppointment);
		int totalAppointments = totalLiveAppointment.size();
		if(totalAppointments == count) {
			
			liveQueueAppointment = true;
		}
		return  liveQueueAppointment;
	}

	
}
