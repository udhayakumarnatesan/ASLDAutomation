/*
 * @author Udhayakumar N
 * Created date: Mar 08,2019
 * Last Edited by: Udhayakumar N
 * Last Edited date: 
 * Description: 
 */

package com.mst.automation.asld.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mst.automation.asld.excelutility.DataUtils;
import com.mst.automation.asld.extentreport.Report;

public class PaymentInformation {

	@FindBy(xpath = ".//a[1][text()='Switch to Lightning Experience']")
	public WebElement switchtolightning;

	@FindBy(how = How.XPATH, using = ".//nav/button[@type='button']")
	public WebElement appLauncherIcon;

	@FindBy(how = How.CSS, using = "input[placeholder='Search apps or items...']")
	public WebElement appLauncherSearch;

	@FindBy(how = How.XPATH, using = ".//span/mark[text()='Payment Information']")
	public WebElement accessPaymentInformation;

	@FindBy(how = How.XPATH, using = ".//a/div[text()='New']")
	public WebElement newbutton;

	@FindBy(how = How.XPATH, using = ".//span[text()='Payment Type']//following::div[1]/div/div/div/a")
	public WebElement Paymenttypefield;

	@FindBy(how = How.XPATH, using = ".//div[@class='select-options popupTargetContainer uiPopupTarget uiMenuList uiMenuList--default uiMenuList--left uiMenuList--short visible positioned']")
	public WebElement Paymenttypefieldvalue;

	public static void paymentInformationObject(WebDriver driver, String sheetName, String tcID) throws Exception {
		PaymentInformation page = PageFactory.initElements(driver, PaymentInformation.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean isPresent = driver.findElements(By.xpath(".//*[@id='createNewButton']")).size() > 0;
		if (isPresent == true) {
			page.switchtolightning.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			page.appLauncherIcon.click();
		} else if (isPresent == false) {
			page.appLauncherIcon.click();
		}
		page.appLauncherSearch.sendKeys(DataUtils.readExcel(sheetName, tcID, "Object Name"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		page.accessPaymentInformation.click();
		Thread.sleep(3000);
		page.newbutton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		page.Paymenttypefield.click();
		verifyValue(page.Paymenttypefieldvalue, DataUtils.readExcel(sheetName, tcID, "Picklist value"));
	}
	//This method is used to generate the Report
	public static void verifyValue(WebElement ElementID, String value) throws Exception {
		String ExpectedData = value;
		String portaldata = ElementID.getText();
		if (portaldata.equals(ExpectedData)) {
			Report.testStepStatus("Value mached", "Pass", "Payment field value is " + ExpectedData
					+ " and Record value is " + portaldata + " both are same verified");
		} else {
			Report.testStepStatus("Value not mached", "Fail", "Payment field value is " + ExpectedData
					+ " and Record value is " + portaldata + "both are different not verified");
		}
	}
}
