package com.mst.automation.asld.regression;

import org.testng.annotations.Test;
import com.mst.automation.asld.basetest.BaseTest;
import com.mst.automation.asld.extentreport.Report;
import com.mst.automation.asld.pages.AsldApplicationPage;
import com.mst.automation.asld.pages.LoginPage;

public class AsldApplication extends BaseTest{
	
	public String tcID;
	public String sheetName;

	@Test
	/* This method is used to Run the all pages */
	public void formExecutionPage() throws Exception {
		Report.beginTest("ASLD Application", "Verify the Commissioner Approval field", "Udhaya", "ASLDTestCase");
		tcID = "TC_001";
		sheetName = "Testsheet";
	    LoginPage.performLogin(driver, sheetName, tcID);
	    AsldApplicationPage.asldApplicationObject(driver, sheetName, tcID);
}
}
