/*
 * @author Udhayakumar N
 * Created date: Apr 04,2019
 * Last Edited by: Udhayakumar N
 * Last Edited date: 
 * Description: 
 */

package com.mst.automation.asld.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mst.automation.asld.excelutility.DataUtils;

public class AsldApplicationCase {
	@FindBy(xpath = ".//a[1][text()='Switch to Lightning Experience']") // .//a[@class='switch-to-lightning']
	public WebElement switchtolightning;

	@FindBy(how = How.XPATH, using = ".//a/span[text()='ASLD Applications']")
	public WebElement asldappobject;
	
	@FindBy(how = How.XPATH, using = ".//tr[1]/th/span/a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup']")
	public WebElement openasldapplicationrecord;
	
	@FindBy(how = How.XPATH, using = ".//span[2][text()='Related']")
	public WebElement accessrelatedlist;
	
	@FindBy(how = How.XPATH, using = ".//a/span[1][@title='Payment Information']//following::li/a/div")
	public WebElement pinewbutton;
	
	@FindBy(how = How.XPATH, using = ".//span[1][text()='Amount']/following::input[@required=''][@step='1']")
	public WebElement amountfield;
	
	@FindBy(how = How.XPATH, using = ".//span[1][text()='Payment Subcode']/following::input[@required='']")
	public WebElement paymentsubcode;
	
	@FindBy(how = How.XPATH, using = ".//button[3][@title='Save']")
	public WebElement savebutton;
	
	@FindBy(how = How.XPATH, using = ".//div[2]/button[@title='Edit Payment Returned']")
	public WebElement paymentreturnededit;
	
	@FindBy(how = How.XPATH, using = ".//label/span[text()='Payment Returned']//following::input[@type='checkbox']")
	public WebElement paymentreturnedcheckbox;
	
	@FindBy(how = How.XPATH, using = ".//button[2][@title='Save']")
	public WebElement pisavebutton;
	
	@FindBy(how = How.XPATH, using = ".//div/ul/li[text()='Payment Returned is checked, so the Payment Returned Amount and Payment Returned Reason fields are mandatory.']")
	public WebElement errormessage;
	
	@FindBy(how = How.XPATH, using = ".//button[@title='Error']")
	public WebElement errormessageclose;
	
	@FindBy(how = How.XPATH, using = ".//label/span[text()='Payment Returned Amount']//following::input[@placeholder='']")
	public WebElement paymentreturnedamountfield;
	
	@FindBy(how = How.XPATH, using = ".//label/span[text()='Payment Returned']/following::div/div/div/div/div/div/div/div/div/a")
	public WebElement paymentreturnedreasonfield;
	
	@FindBy(how = How.XPATH, using = ".//div/ul/li[3]/a[@title='Duplicate Payment']")
	public WebElement paymentreturnedreasonfieldedit;
	
	@FindBy(how = How.XPATH, using = ".//li[text()='Payment Returned Amount should not exceed the value in the Amount field.']")
	public WebElement paymentreturnedamountfielderror;
			
	public static void asldApplicationObject(WebDriver driver, String sheetName, String tcID) throws Exception {
		AsldApplicationCase record = PageFactory.initElements(driver, AsldApplicationCase.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean isPresent = driver.findElements(By.xpath(".//*[@id='createNewButton']")).size()> 0;
        if(isPresent==true) {
			record.switchtolightning.click();
			Thread.sleep(10000);
			record.asldappobject.click();
		} 
        else if(isPresent ==false) {
			record.asldappobject.click();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		record.openasldapplicationrecord.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		record.accessrelatedlist.click();
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		record.pinewbutton.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		record.amountfield.sendKeys(DataUtils.readExcel(sheetName, tcID, "Amount field"));
		record.paymentsubcode.sendKeys(DataUtils.readExcel(sheetName, tcID, "Payment subcode"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		record.savebutton.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		record.paymentreturnededit.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		record.paymentreturnedcheckbox.click();
		record.pisavebutton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String error1 = record.errormessage.getText();
		System.out.println(error1);
		Thread.sleep(4000);
		record.errormessageclose.click();
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,400)", "");
		record.paymentreturnedamountfield.sendKeys(DataUtils.readExcel(sheetName, tcID, "Payment Return Amount"));
		Thread.sleep(4000);
		record.paymentreturnedreasonfield.click();
		Thread.sleep(4000);
		record.paymentreturnedreasonfieldedit.click();
		record.pisavebutton.click();
		String error2 = record.paymentreturnedamountfielderror.getText();
		System.out.println(error2);
}}
