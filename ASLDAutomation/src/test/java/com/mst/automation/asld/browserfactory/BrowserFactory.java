package com.mst.automation.asld.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.mst.automation.asld.constanturl.Constanturl;

public class BrowserFactory {

	public static WebDriver driver;

	/* This method is used to select Browser */
	public static WebDriver getDriver(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constanturl.chromedriverexepath);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constanturl.firefoxdriverexepath);
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser is not correct");
		}
		return driver;
	}

}
