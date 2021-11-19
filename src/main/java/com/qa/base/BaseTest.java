package com.qa.base;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.pages.DronaLoginPage;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class BaseTest {

		public BasePage basePage;
		public Properties prop;
		public WebDriver driver;
		public DronaLoginPage dronaLoginPage;
		
		@BeforeTest
		public void flushDownload()
		{
				try {

					File file = new File(System.getProperty("user.dir") + "/allure-results");
					if (file != null && file.isDirectory()) {
						FileUtils.cleanDirectory(file);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

		@BeforeMethod
		public void setUp() {

			basePage = new BasePage();
			prop = basePage.init_prop();
			String browser = prop.getProperty("browser");
			driver = basePage.init_driver(browser);
			dronaLoginPage = new DronaLoginPage(driver);
			driver.get(prop.getProperty("url"));

		}

		@AfterMethod
		public void tearDown() throws InterruptedException {
			Thread.sleep(5000);
			/*
			 * JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver); WebElement
			 * homeIcon = driver.findElement(By.xpath("//span[text()='Home']/.."));
			 * javaScriptUtil.clickElementByJS(homeIcon);
			 */
			driver.quit();
		}

}
