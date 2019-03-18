package com.mst.automation.asld.basetest;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mst.automation.asld.browserfactory.BrowserFactory;
import com.mst.automation.asld.extentreport.Report;

public class BaseTest {
	public WebDriver driver;

	@BeforeSuite
	// This method is used to begin the Report
	public static void startReport() {
		Report.beginReport();
	}
		
	@BeforeTest
	@Parameters({ "browser" })
	// This method is used to open Browser
	public void login(String browser) {
		driver = BrowserFactory.getDriver(browser);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void checkTestAfterExecution(ITestResult result) throws IOException {
		Report.checkTestAfterExecution(result, driver);
	}

	@AfterTest
	public void logout() throws InterruptedException {
		/*
		 * driver.findElement(By.xpath(
		 * ".//*[@id='oneHeader']/div[2]/span/ul/li[8]/span/button")).click();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * driver.findElement(By.xpath(".//a[2][text()='Log Out']")).click();
		 * Thread.sleep(3000);
		 */
		driver.close();
	}

	@AfterSuite(alwaysRun = true)
	public static void tearDown() {
		Report.tearDown();
	}
}
