package com.qa.utility;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;
import com.qa.reports.ExtentLogger;
import com.qa.utility.JavaScriptUtil;

public class TestUtil {
	
	private WebDriver driver;
	private JavaScriptUtil jsUtil;

	public TestUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(this.driver);
	}
	
	public void staticWait(int time)
    {
   	 try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
		}
    }

	public By getLocator(String value) {
		return By.id(value);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if(BasePage.highlight.equals("true")) {
			jsUtil.flash(element);
		}
		return element;
	}

	public void dosendKeys(By locator,int timeout , String value ) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}
   public void doClick(By locator , String elementName) {
	   
	    WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement ele = driver.findElement(locator);
		ele.click();	
		ExtentLogger.pass( elementName + " Clicked ");
	}
       public String getText(By locator , String elementName) {
		
		WebElement ele = driver.findElement(locator);
		String value = ele.getText();	
		ExtentLogger.pass( elementName + "text value is: " + value );
		return value;
	}
	
	public void dosendKeys(By locator,int timeout , String value ,String elementName) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement ele = driver.findElement(locator);
		ele.clear();
		ele.sendKeys(value);
		ExtentLogger.pass(value + " Entered in " + elementName);
	}
	
	public void doClearText(By locator) {
		getElement(locator).clear();
	}
	
	public void doClick(By locator,int timeout ) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
	}

	public void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}
	public void doActionsClick(WebElement ele) {
		Actions action = new Actions(driver);
		action.click(ele).perform();
	}

	public void doSendKeysWithMoveToElement(By locator, String value) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).sendKeys(value).build().perform();
	}

	public void doClickWithMoveToElement(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	

	public boolean doIsDisplayed(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return getElement(locator).isDisplayed();
	}

	public int getElementsCount(String tagName) {
		return driver.findElements(By.tagName(tagName)).size();
	}

	public List<String> getAttributesList(String tagName, String attributeName) {

		List<String> attrList = new ArrayList<String>();

		List<WebElement> elementList = driver.findElements(By.tagName(tagName));
		for (WebElement e : elementList) {
			String text = e.getAttribute(attributeName);
			attrList.add(text);
		}

		return attrList;
	}

	public void doClickFromList(By locator, String linkText) {
		List<WebElement> footerList = getElements(locator);

		for (int i = 0; i < footerList.size(); i++) {
			String text = footerList.get(i).getText();
			if (text.equals(linkText)) {
				footerList.get(i).click();
				break;
			}
		}
	}

	// ***************************Drop Down Utils
	// ***********************************

	public void doSelectDropDownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);

	}

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	public void selectDropDownValueWithoutSelectClass(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);

		for (WebElement e : optionsList) {

			String text = e.getText();

			if (text.equals(value)) {
				e.click();
				break;
			}

		}
	}

	// ***************************** wait utils ************************

	public List<WebElement> visibilityOfAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public int getPageLinksCount(By locator, int timeOut) {
		return visibilityOfAllElements(locator, timeOut).size();
	}

	public String waitForTitlePresent(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}

	public String waitForTitlePresent(String titleValue, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}

	public Alert waitForAlertToBePresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public boolean waitForUrl(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(urlValue));
	}

	public WebElement waitForElementToBeLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement waitForElementWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This is custom dynamic wait to find the webelement
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement retryingElement(By locator) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < 30) {

			try {
				element = driver.findElement(locator);
				break;
			}

			catch (StaleElementReferenceException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {

				}
			}

			catch (NoSuchElementException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {

				}

				System.out.println("element is not found in attempt : " + (attempts + 1));
			}

			attempts++;
		}

		return element;

	}
	public String dateCheck(String date) {
		String finalDate = "";
		try {
			String dateNew = date;

			String[] date1 = dateNew.trim().split("-");
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatter2 = new SimpleDateFormat("dd MMM yyyy");
			Date fromDate1 = formatter1.parse(date1[0].trim());
			Date fromDate2 = formatter1.parse(date1[1].trim());

			String toDate1 = formatter2.format(fromDate1);

			String toDate2 = formatter2.format(fromDate2);

			finalDate = toDate1 + " - " + toDate2;

		} catch (Exception e) {
			System.out.println(e);

		}
		return finalDate;
	}
	
	public static String getXpath(String xpath , String value) {
		
		return xpath.replace("%replaceable%", value);
		
	}
   public static String getXpath(String xpath , String value , String value2) {
		
		return xpath.replace("%replaceable%", value).replace("%index%",value2 );
		
	}

}
