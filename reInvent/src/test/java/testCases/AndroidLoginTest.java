package testCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import android_screens.loginPageObject;
import base.TestBase;

public class AndroidLoginTest extends TestBase{

	loginPageObject lg;
	ExtentReports report;
	ExtentTest test;
	
	@Test
	public void LoginWithValidCredentials() throws InterruptedException {
		report = TestBase.getReportInstance();
		test = report.startTest("Login Test with valid Credentils");
		lg = new loginPageObject(driver, test);
		lg.enterUsername("kradkaradmin");
		lg.enterPassword("MobTest@123!");
		lg.clickOnSignInButton();
		Thread.sleep(15000);
	}
}
