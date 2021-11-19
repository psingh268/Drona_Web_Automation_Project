package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;
import com.qa.utility.Xls_Reader;

public class BillingPage extends BasePage {

	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;
	Faker faker = new Faker();

	private By billingMenu = By.xpath("//span[text()='Bills']/parent::a");
	private By createBillBtn = By.xpath("//button[text()='Create Bill']");
	private By addItemBtn = By.xpath("//button[text()=' Add item']");
	private By billingDropDownOpenBtn = By.xpath("//span[text()='Select Item']/following-sibling::div");
	private By patientAppointment = By.xpath("//h4[contains(text(),'Pending')]/../../../../../following-sibling::div[1]/div");
	private By appointmentMenu = By.xpath("//span[text()='Appointments']/..");
	private By billItemConsultation = By.xpath("//div[text()='Consultation']/../..");
	private By billNewItemButton = By.xpath("//span[text()='Create a new item']/../..");
	private By newItemTxtBx = By.xpath("//input[contains(@placeholder,'Type an item name')]");
	private By quantityTxtBx = By.xpath("//tr[2]/td[3]/input");
	private By priceTxtBx = By.xpath("//tr[2]/td[5]/input");
	private By deleteItemBtn = By.xpath("//tbody/tr[2]/td[9]/div/i");
	private By saveBillBtn = By.xpath("//button[text()='Save Bill']");
	private By bilPopupLabel = By.xpath("//div[contains(text(),'Created ')]");
	private By closeBtn = By.xpath("//button[text()='Close']");
	private By recordPaymentBtn = By.xpath("//a[text()='Record Payment']");
	private By recordPaymentPopUpBtn = By.xpath("//button[text()='Record Payment']");
	private By recordPaymentSaveBtn = By.xpath("//button[text()='Cancel']/following-sibling::button");
	private By patientNewAppointment = By.xpath("//h4[contains(text(),'Pending')]/../../../../../following-sibling::div[2]/div");
	private By consultnowBtn = By.xpath("//span[text()='Consult Now']/parent::button");
	private By previewBtn = By.xpath("//li[text()=' Preview']");
	private By addNewBillBtn = By.xpath("//button[text()='Add New Bill']");
	private By printrecipintBtn = By.xpath("//a[text()='Print Reciept']");
	 
	Xls_Reader reader = new Xls_Reader("./src/main/resources/Mankind_UserName.xlsx");

	public BillingPage(WebDriver driver) {

		this.driver = driver;
		testUtil = new TestUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	public void clkPatientMenu() {

		testUtil.staticWait(3000);
		testUtil.doClick(appointmentMenu, "Appointment  menu");
		testUtil.doClick(patientAppointment, "patient Appointment");
		testUtil.staticWait(3000);
	}

	public void getBillPage() {
		testUtil.doClick(billingMenu, "Bill menu");
		testUtil.doClick(createBillBtn, "Create Bill Button");
		testUtil.staticWait(2000);
	}

	public void addItem() {

		testUtil.doClick(addItemBtn, "Add Item Button");
		testUtil.staticWait(2000);
		javaScriptUtil.clickElementByJS(testUtil.getElement(billingDropDownOpenBtn));
		testUtil.staticWait(2000);
		testUtil.doClick(billItemConsultation, "Bill item Consultation");
		testUtil.staticWait(2000);
	}

	public String addNewBillItem() {

		testUtil.doClick(addItemBtn, "Add Item Button");
		testUtil.doClick(billingDropDownOpenBtn, "billing DropDownOpen Btn");
		testUtil.doClick(billNewItemButton, "Bill New Item Button");
		String itemName =  faker.medical().medicineName();
		testUtil.dosendKeys(newItemTxtBx, 10, itemName, "Add new bill item");
		testUtil.dosendKeys(quantityTxtBx, 10, "2", "quantity");
		testUtil.dosendKeys(priceTxtBx, 10, "500", "price");
		return itemName;
	}

	public boolean verifyNewAddItem() {

		boolean rowAdded = false;
		clkPatientMenu();
		getBillPage();
		addItem();
		List<WebElement> totalItemList = driver.findElements(By.xpath("//tbody/tr"));
		int totalRow = totalItemList.size();
		addNewBillItem();
		totalItemList = driver.findElements(By.xpath("//tbody/tr"));
		int newRowCount = totalItemList.size();
		if (newRowCount == totalRow + 1) {

			rowAdded = true;
		}
		return rowAdded;
	}

	public boolean verifyDeleteItem() {

		boolean rowDeleted = false;
		clkPatientMenu();
		getBillPage();
		addItem();
		addNewBillItem();
		List<WebElement> totalItemList = driver.findElements(By.xpath("//tbody/tr"));
		int totalRow = totalItemList.size();
		testUtil.doClick(deleteItemBtn, "Item delete");
		totalItemList = driver.findElements(By.xpath("//tbody/tr"));
		int newRowCount = totalItemList.size();
		if (newRowCount == totalRow - 1) {

			rowDeleted = true;
		}

		return rowDeleted;
	}

	public boolean billGenerated() {

		boolean billGenerated = false;
		clkPatientMenu();
		testUtil.doClick(billingMenu, "Bill menu");
		testUtil.doClick(createBillBtn, "Create Bill Button");
		testUtil.staticWait(2000);
		addItem();
//		 addNewBillItem();
		testUtil.doClick(saveBillBtn, "Save Bill Button");
		testUtil.staticWait(2000);
		String billLabel = testUtil.doGetText(bilPopupLabel);
		String[] billText = billLabel.split(" ");
		String billNumber = billText[1].replace("#", "").replace(" ", "");
		System.out.println(billNumber);
		reader.setCellData("Sheet1", "Bill",2, billNumber);
//		testUtil.doClick(closeBtn, "Close popup Button");
		testUtil.staticWait(2000);
		List<WebElement> billList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		for (WebElement bill : billList) {
			if (bill.getText().equalsIgnoreCase(billNumber)) {

				billGenerated = true;
			}
		}
		return billGenerated;
	}

	public boolean billRecorded() {

		boolean paymentPaid = false;
		String billNumber = reader.getCellData("Sheet1", 11, 2);
		
		  clkPatientMenu(); testUtil.doClick(billingMenu, "Bill menu"); String billPath
		  = "//tbody/tr/td[text()='" + billNumber + "']/following-sibling::td/span/i";
		  WebElement billRow = driver.findElement(By.xpath(billPath)); billRow.click();
		  testUtil.staticWait(2000);
		  String recordPaymentPath = "//td[text()='" +	  billNumber + "']/following-sibling::td/div/a[text()='Record Payment']";
		  WebElement recordPayment = driver.findElement(By.xpath(recordPaymentPath));
		  javaScriptUtil.clickElementByJS(recordPayment); testUtil.staticWait(2000);
		  testUtil.doClick(recordPaymentSaveBtn, "Record Payment Save Button");
		  testUtil.staticWait(3000);
		  String statusPath = "//tbody/tr/td[text()='" + billNumber + "']/following-sibling::td[3]";
		  WebElement billStatus = driver.findElement(By.xpath(statusPath));
	      String status = billStatus.getText();
		if (status.equalsIgnoreCase("Paid")) {

			paymentPaid = true;
		}

		return paymentPaid;
	}

	public void consultPageBillGenerate() {

		testUtil.staticWait(5000);
		testUtil.doClick(appointmentMenu, "Appointment menu");
		testUtil.staticWait(3000);
		testUtil.doClick(patientNewAppointment, "Patient appointment ");
		testUtil.doClick(consultnowBtn, "Bill menu");
		testUtil.staticWait(2000);
		testUtil.doClick(previewBtn, "Bill menu");
		testUtil.doClick(addNewBillBtn, "Bill menu");
		addItem();
		String itemName = addNewBillItem();
		testUtil.doClick(saveBillBtn, "Save Bill Button");
		testUtil.doClick(recordPaymentPopUpBtn, "record Payment PopUp Btn");
		testUtil.doClick(recordPaymentSaveBtn, 10);
		testUtil.doClick(printrecipintBtn, "print recipnt btn");
		
	}

}
