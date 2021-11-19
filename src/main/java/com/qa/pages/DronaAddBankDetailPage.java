package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

   public class DronaAddBankDetailPage extends BasePage {
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;
	DronaClinicSetUpPage dronaClinicSetUpPage;
	
	private By addBankDetailBtn = By.xpath("//div[text()=' Add Bank Details ']/span");
	private By nameOnAccountTxtBx = By.xpath("//input[@formcontrolname='nameOnAccount']");
	private By accountNumberTxtBx = By.xpath("//input[@formcontrolname='accountNumber']");
	private By confirmAccountNumberTxtBx = By.xpath("//input[@formcontrolname='confirmAccountNumber']");
	private By ifscCodeTxtBx = By.xpath("//input[@formcontrolname='ifscCode']");
	private By  accountTypeBtn = By.xpath("//p-radiobutton[@name='accountType'][@value='2']");
	private By addBankAccountBtn = By.xpath("//button[text()='Add Bank Account']");
	private By addUpiDetailBtn = By.xpath("//div[text()=' Add UPI Details ']/span");
	
	
    public DronaAddBankDetailPage(WebDriver driver) {
		
		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	 Faker fakeData = new Faker();
	 
	
	 
		/*
		 * public void addBankDetail() {
		 * 
		 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
		 * dronaClinicSetUpPage.editClinicBtnClk(); javaScriptUtil.scrollPageDown();
		 * testUtil.staticWait(2000); testUtil.doClick(addBankDetailBtn,
		 * "add BankDetail Btn"); testUtil.dosendKeys(nameOnAccountTxtBx, 10,
		 * fakeData.name().fullName(), "name on account");
		 * testUtil.dosendKeys(accountNumberTxtBx, 10, "9876543219876543",
		 * "Account number"); testUtil.dosendKeys(confirmAccountNumberTxtBx, 10,
		 * "9876543219876543", "Confirm Account number");
		 * testUtil.dosendKeys(ifscCodeTxtBx, 10, "ICIC1234", "Ifc number");
		 * testUtil.doClick(accountTypeBtn, "current account type");
		 * testUtil.doClick(addBankAccountBtn, "add bank  account "); }
		 * 
		 * public void addUpiDetail() {
		 * 
		 * dronaClinicSetUpPage = new DronaClinicSetUpPage(driver);
		 * dronaClinicSetUpPage.editClinicBtnClk(); javaScriptUtil.scrollPageDown();
		 * testUtil.staticWait(2000); testUtil.doClick(addUpiDetailBtn,
		 * "add BankDetail Btn"); }
		 */
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
