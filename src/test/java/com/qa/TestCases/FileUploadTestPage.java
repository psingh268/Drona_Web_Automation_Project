package com.qa.TestCases;

import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.qa.base.BaseTest;
import com.qa.pages.FileUploadPage;
import com.qa.reports.ExtentLogger;

public class FileUploadTestPage extends BaseTest{
	
	FileUploadPage fileUploadPage;
	
	@FrameworkAnnotation(author= {"Praveen"},category = CategoryType.FileUpload)
	@Test(priority = 1 ,enabled = true , description = "Verify Doctor can drag and drop file.")
    public void verifyDragandDropFile() {
		
		dronaLoginPage.dronaLoginThroghMobileNo();
		fileUploadPage = new FileUploadPage(driver);
		fileUploadPage.fileUploadPage();
		ExtentLogger.pass("File draged and uploded.");
	}
}
