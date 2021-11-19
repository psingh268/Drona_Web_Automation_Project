package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import com.qa.base.BasePage;
import com.qa.utility.JavaScriptUtil;
import com.qa.utility.TestUtil;

public class CommunityPage extends BasePage{
	
	
	private TestUtil testUtil;
	private JavaScriptUtil javaScriptUtil;		
	Faker faker = new Faker();
	
	private By communityMenu = By.xpath( "//span[text()='Community']/..");
	private By startExploringBtn = By.xpath( "//span[text()='Start Exploring']/..");
	private By settingBtn = By.xpath( "//span[text()='All']/ancestor::div[13]/div/div/div/div/div/span");
	private By covidPostSlctIcon = By.xpath( "//div[text()='COVID-19']/../following-sibling::div/div[text()=' + ']");
	private By childPsychologyPostSlctIcon = By.xpath( "//div[text()='Child Psychology']/../following-sibling::div/div[text()=' + ']");
	private By saveBtn = By.xpath( "//span[text()='Save']/..");
	private By likeIcon = By.xpath( "//div[contains(@class,'news-bg mtb-12 ')][1]/div/div/div[2]/div/div[2]/div[1]/div/i");
	
	
    public CommunityPage(WebDriver driver) {
			
			this.driver = driver;
			testUtil = new TestUtil(driver);
			javaScriptUtil = new JavaScriptUtil(driver);
		}
    public void getCommunityPage() {
    	
    	testUtil.staticWait(5000);
    	testUtil.doClick(communityMenu, "Community Menu");
    	
    	
    }
    public void setPost() {
    	try {
    		if(testUtil.doIsDisplayed(startExploringBtn)) {
			testUtil.doClick(startExploringBtn, "startExploring");
			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	testUtil.doClick(settingBtn, "SettingBtn");
    	try {
			testUtil.doClick(covidPostSlctIcon, "covidPostSlctIcon");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	try {
			testUtil.doClick(childPsychologyPostSlctIcon, "childPsychologyPostSlctIcon");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	testUtil.doClick(saveBtn, "Save Button");
    	testUtil.staticWait(3000);
    }
     public void doLikeOnPost() {
    	 
    	 testUtil.doClick(likeIcon	, "like Icon");
    	 testUtil.staticWait(2000);
    	 String BkgColor = testUtil.getElement(likeIcon).getCssValue("background-color");
    	 System.out.println(BkgColor);
    	 
    	 
     }

}
