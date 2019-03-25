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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mst.automation.asld.excelutility.DataUtils;
import com.mst.automation.asld.extentreport.Report;

public class AsldApplicationPage {

	@FindBy(xpath = ".//a[1][text()='Switch to Lightning Experience']") // .//a[@class='switch-to-lightning']
	public WebElement switchtolightning;

	@FindBy(how = How.XPATH, using = ".//a/span[text()='ASLD Applications']")
	public WebElement asldappobject;

	@FindBy(how = How.XPATH, using = ".//a/div[text()='New']")
	public WebElement newbutton;

	@FindBy(how = How.XPATH, using = ".//label[13]/span[1][@class='slds-radio--faux topdown-radio--faux']")
	public WebElement selectrecordtype;

	@FindBy(how = How.XPATH, using = ".//button[2][@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']")
	public WebElement clicknextbutton;

	@FindBy(how = How.XPATH, using = ".//label/span[1][text()='Account Name']//following::div[3]/div[1]/input")
	public WebElement accountnamefield;

	@FindBy(how = How.XPATH, using = ".//label/span[1][text()='Account Name']//following::div[5]/div[2]")
	public WebElement accountnamefieldvalue;

	@FindBy(how = How.XPATH, using = ".//label/span[1][text()='Contact Name']//following::div[3]/div[1]/input")
	public WebElement contactnamefield;

	@FindBy(how = How.XPATH, using = ".//label/span[1][text()='Contact Name']//following::div[5]/div[2]")
	public WebElement contactnamefieldvalue;

	@FindBy(how = How.XPATH, using = ".//div/button[2][@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")
	public WebElement savebutton;

	@FindBy(how = How.XPATH, using = ".//span[text()='ASLD Application Owner']//following::div/div[1]/div[1]/button")
	public WebElement changeownericon;

	@FindBy(how = How.CSS, using = "input[placeholder='Search People...']")
	public WebElement searchname;

	@FindBy(how = How.XPATH, using = ".//div[1][@title='Nanthini P']")
	public WebElement entername;

	@FindBy(how = How.XPATH, using = ".//button[2]/span[text()='Change Owner']")
	public WebElement changeownerbutton;

	@FindBy(how = How.CSS, using = "button[title='Edit Commissioner Approval']")
	public WebElement commissionapprovaledit;

	@FindBy(how = How.XPATH, using = ".//span/span[1][text()='Commissioner Approval']//following::div[1]/div/div/div/a")
	public WebElement selectpicklist;

	@FindBy(how = How.XPATH, using = ".//div/ul/li[3]/a[text()='In-Progress']")
	public WebElement choosevalue;

	@FindBy(how = How.XPATH, using = ".//button[2][@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']")
	public WebElement editpagesavebutton;

	@FindBy(how = How.XPATH, using = ".//div/input[@class='slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']")
	public WebElement globalsearch;

	@FindBy(how = How.XPATH, using = ".//div[2]/div/a[text()='Aaron Magezi']")
	public WebElement clickname;

	@FindBy(how = How.XPATH, using = ".//a/div[text()='User Detail']")
	public WebElement userdetails;

	@FindBy(how = How.XPATH, using = "html/body/div[4]/div[1]/table/tbody/tr/td[2]/input[4]")
	public WebElement loginbutton;

	@FindBy(how = How.XPATH, using = ".//span[2][@class='triggerLinkText selectedListView uiOutputText']")
	public WebElement searchdropdown;

	@FindBy(how = How.XPATH, using = ".//*[@class='slds-input default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input']")
	public WebElement typesearchdropdown;

	@FindBy(how = How.XPATH, using = ".//mark[text()='My Views']")
	public WebElement selectmyviews;

	@FindBy(how = How.XPATH, using = ".//tr[1]/th/span/a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
	public WebElement openasldapplicationrecord;

	@FindBy(how = How.XPATH, using = ".//span[2][text()='Related']")
	public WebElement accessrelatedlist;

	@FindBy(how = How.XPATH, using = ".//a/div[text()='Approve']")
	public WebElement approverecord;

	@FindBy(how = How.XPATH, using = ".//span[text()='Comments']//following::textarea")
	public WebElement entercomments;

	@FindBy(how = How.XPATH, using = ".//span[text()='Approve']")
	public WebElement accessapprovebutton;

	@FindBy(how = How.XPATH, using = ".//span[2][text()='Details']")
	public WebElement accessdetailstab;

	@FindBy(how = How.XPATH, using = ".//div[1]/span[text()='Commissioner Approval']//following::div[1]/span[1]/span")
	public WebElement cafieldstatus;

	@FindBy(how = How.XPATH, using = ".//span[text()='Users']/following::iframe")
	public WebElement iframe;

	public static void asldApplicationObject(WebDriver driver, String sheetName, String tcID) throws Exception {
		AsldApplicationPage page = PageFactory.initElements(driver, AsldApplicationPage.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean isPresent = driver.findElements(By.xpath(".//*[@id='createNewButton']")).size()> 0;
        if(isPresent==true) {
			page.switchtolightning.click();
			Thread.sleep(10000);
			page.asldappobject.click();
		} 
        else if(isPresent ==false) {
			page.asldappobject.click();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page.newbutton.click();
		Thread.sleep(6000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.selectrecordtype.click();
		page.clicknextbutton.click();
		Thread.sleep(6000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,500)", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.accountnamefield.click();
		page.accountnamefield.sendKeys(DataUtils.readExcel(sheetName, tcID, "Account Name"));
		page.accountnamefieldvalue.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.contactnamefield.click();
		page.contactnamefield.sendKeys(DataUtils.readExcel(sheetName, tcID, "Contact Name"));
		page.contactnamefieldvalue.click();
		page.savebutton.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[text()='ASLD Application Owner']//following::div/div[1]/div[1]/button")));
		page.changeownericon.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.searchname.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.searchname.sendKeys(DataUtils.readExcel(sheetName, tcID, "Search Name"));
		Thread.sleep(3000);
		page.entername.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.changeownerbutton.click();
		Thread.sleep(7000);
		page.commissionapprovaledit.click();
		Thread.sleep(3000);
		page.selectpicklist.click();
		Thread.sleep(3000);
		page.choosevalue.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.editpagesavebutton.click();
		Thread.sleep(12000);
		page.globalsearch.sendKeys(DataUtils.readExcel(sheetName, tcID, "Global Search"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page.globalsearch.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page.clickname.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.userdetails.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page.switchframe(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page.loginbutton.click();
		Thread.sleep(15000);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page.asldappobject.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		page.searchdropdown.click();
		Thread.sleep(3000);
		page.typesearchdropdown.sendKeys(DataUtils.readExcel(sheetName, tcID, "Search Dropdown"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		page.selectmyviews.click();
		Thread.sleep(4000);
		page.openasldapplicationrecord.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		page.accessrelatedlist.click();
		Thread.sleep(4000);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,500)", "");
		page.approverecord.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.entercomments.sendKeys(DataUtils.readExcel(sheetName, tcID, "Enter comments"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.accessapprovebutton.click();
		Thread.sleep(5000);
		JavascriptExecutor jse3 = (JavascriptExecutor) driver;
		jse3.executeScript("window.scrollBy(0,-500)", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.accessdetailstab.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		verifyApplication(page.cafieldstatus, DataUtils.readExcel(sheetName, tcID, "Field value"));
	}

	public void switchframe(WebDriver driver) {
		WebElement frame = driver.findElement(By.xpath(".//span[text()='Users']/following::iframe"));
		driver.switchTo().frame(frame);
	}

	public static void verifyApplication(WebElement ElementID, String value) throws Exception {
		String ExpectedData = value;
		String portaldata = ElementID.getText();
		if (portaldata.equals(ExpectedData)) {
			Report.testStepStatus("Value updated correctly", "Pass", "The Commissioner Approval field value is "
					+ ExpectedData + " and Record value is " + portaldata + " both are same verified");
		} else {
			Report.testStepStatus("Value notupdated correctly", "Fail", "The Commissioner Approval field given value"
					+ ExpectedData + "and record value is" + portaldata + "both are different not verified");
		}
	}
}
