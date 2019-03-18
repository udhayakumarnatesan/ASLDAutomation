package com.mst.automation.asld.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mst.automation.asld.constanturl.Constanturl;
import com.mst.automation.asld.excelutility.DataUtils;

public class LoginPage {	
	
	public WebDriver driver;
	
	@FindBy(how = How.ID, using = "username")
	public WebElement username;

	@FindBy(how = How.NAME, using = "pw")
	public WebElement pw;

	@FindBy(how = How.NAME, using = "Login")
	public WebElement Login;	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	//This method is used to access the Salesforce Login page
	public static void performLogin(WebDriver driver, String sheetName, String tcID) throws Exception {
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		driver.get(Constanturl.browserurl);
		login.username.sendKeys(DataUtils.readExcel(sheetName, tcID, "UserName"));
		login.pw.sendKeys(DataUtils.readExcel(sheetName, tcID, "Password"));
		login.Login.click();
		Thread.sleep(3000);
	}


}
