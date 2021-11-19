package com.qa.TestCases;

import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.CommunityPage;
import com.qa.reports.ExtentLogger;

public class CommunityTestPage extends BaseTest {
	
	CommunityPage communityPage;

	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.Community)
	@Test(priority = 1 ,enabled = true , description = "Verify Symptoms are showing in prescription format form. ")
    public void verifySymptomsInPrescriptionFormat() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		communityPage = new CommunityPage(driver);
		communityPage.getCommunityPage();
		communityPage.setPost();
		communityPage.doLikeOnPost();
		ExtentLogger.pass("Symptoms are showing in prescription format form");
	}
	}
