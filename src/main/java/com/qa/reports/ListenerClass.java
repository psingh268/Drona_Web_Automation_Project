package com.qa.reports;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.annotations.FrameworkAnnotation;

public class ListenerClass  implements ITestListener, ISuiteListener{
	
	@Override
	public void onStart(ISuite suite) {
			ExtentReport.initReports();
	}

	
	@Override
	public void onFinish(ISuite suite) {
			ExtentReport.flushReports();
			
	}

	/**
	 * Starts a test node for each testng test
	 * @see com.tmb.reports.ExtentReport
	 * @see com.tmb.annotations.FrameworkAnnotation
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.category());
	}

	/**
	 * Marks the test as pass and logs it in the report
	 * @see com.tmb.reports.ExtentLogger
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");
	}

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 * @see com.tmb.reports.ExtentLogger
	 * @see com.tmb.utils.ScreenshotUtils
	 */
	@Override
	public void onTestFailure(ITestResult result) {
	
			ExtentLogger.fail(result.getMethod().getMethodName() +" is failed");
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		
	}

	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.tmb.reports.ExtentLogger
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() +" is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * For now, we are not using this.
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
		
	}

}
