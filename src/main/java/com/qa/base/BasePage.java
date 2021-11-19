package com.qa.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.qa.utility.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static String highlight;
	public static JavascriptExecutor jsDriver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser) {
		System.out.println("browser value is : " + browser);

		highlight = prop.getProperty("highilight");
		optionsManager = new OptionsManager(prop);

		if (browser.equalsIgnoreCase("chrome")) {
			/*
			 * WebDriverManager.chromedriver().setup(); tlDriver.set(new
			 * ChromeDriver(optionsManager.getChromeOptions()));
			 */
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("--incognito");
			 */
			//driver = new ChromeDriver(options);
			tlDriver.set(new ChromeDriver());
			jsDriver =  (JavascriptExecutor)driver;

			
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			
		}

		else if (browser.equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());
		}

		else {
			System.out.println("Please pass the correct browser value : " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return getDriver();
	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
     public String getScreenshot() {
		
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir") + "/screenshots/DronaWebTestScreenprint_" + dateName + ".png";
       File destination=new File(screenshotpath);
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		return screenshotpath;
	}


    
}
