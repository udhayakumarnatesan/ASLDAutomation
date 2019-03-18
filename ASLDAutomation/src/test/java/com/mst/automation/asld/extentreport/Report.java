package com.mst.automation.asld.extentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	
	static ExtentHtmlReporter extentHtmlReporter;
	static ExtentReports extentReport;
	static ExtentTest parentTest;
	static ExtentTest childTest;

	public static void beginReport() {
		extentHtmlReporter = new ExtentHtmlReporter("D:\\Udhaya\\Eclipse-workspace new\\ASLDAutomation\\src\\test\\resources\\Reports\\ExtentReport.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentHtmlReporter);

		extentReport.setSystemInfo("OS", "Windows");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("User Name", "Udhayakumar");
		extentReport.setSystemInfo("Selenium Version", "3.0");
		extentReport.setSystemInfo("Java Version", "1.8");

		extentHtmlReporter.config().setDocumentTitle("Automation Report");
		extentHtmlReporter.config().setReportName("ASLD Automation Report");
		extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
	}

	public static void beginTest(String testName, String description, String author, String testCategory) {
		parentTest = extentReport.createTest(testName, description);
		parentTest.assignAuthor(author);
		parentTest.assignCategory(testCategory);
	}

	public static void testStepStatus(String testStep, String status, String description) throws Exception {
		childTest = parentTest.createNode(testStep);

		if (status.equalsIgnoreCase("Pass")) {
			childTest.log(Status.PASS, description);
		} else if (status.equalsIgnoreCase("Fail")) {
			childTest.log(Status.FAIL, description);
		} else if (status.equalsIgnoreCase("Skip")) {
			childTest.log(Status.SKIP, description);
		} else {
			throw new Exception("Invalid Status");
		}

	}

	public static void checkTestAfterExecution(ITestResult result, WebDriver driver) throws IOException {
		String methodName = result.getMethod().getMethodName();

		if (result.getStatus() == ITestResult.SUCCESS) {
			parentTest.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String res = result.getThrowable().getMessage();
			parentTest.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed", ExtentColor.RED));
			logScreenshot(driver, methodName, res);
		} else if (result.getStatus() == ITestResult.SKIP) {
			String res = result.getThrowable().getMessage();
			parentTest.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed", ExtentColor.YELLOW));
			logScreenshot(driver, methodName, res);
		}
	}

	public static void tearDown() {
		extentReport.flush();
	}

	public static void logScreenshot(WebDriver screenDriver, String testCaseName, String res) throws IOException {
		File file = ((TakesScreenshot) screenDriver).getScreenshotAs(OutputType.FILE);
		String workspace = ((new File(".").getAbsolutePath()).replace("\\", "/")).replace(".", "");
		String fileName = workspace + "/" + testCaseName + ".png";
		FileUtils.copyFile(file, new File(fileName));
		childTest.fail(res.toString());
		childTest.fail("Attached screen shot below:").addScreenCaptureFromPath(fileName);
	}

}
