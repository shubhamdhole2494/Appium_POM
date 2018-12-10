package base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import utils.CommonUtils;

public class TestBase {

	public static AppiumDriver<MobileElement> driver;
	//public static IOSDriver<MobileElement> iOS_driver;
	public static String loadPropertyFile = "Android_reInvent.properties";

	public static AndroidDriver<MobileElement> getAndroidDriver() throws MalformedURLException, InterruptedException {

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), CommonUtils.capability);
		driver.manage().timeouts().implicitlyWait(35000, TimeUnit.SECONDS);
		Thread.sleep(35000);
		TouchAction tapAt = new TouchAction(driver);
        tapAt.press(510, 1097).release().perform();
		return (AndroidDriver<MobileElement>) driver;
	}

	public static IOSDriver<MobileElement> getIOSDriver() throws MalformedURLException {

		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), CommonUtils.capability);
		driver.manage().timeouts().implicitlyWait(35000, TimeUnit.SECONDS);
		return (IOSDriver<MobileElement>) driver;
	}
	
	public static ExtentReports getReportInstance() {
		ExtentReports extent;
		String Path = System.getProperty("user.dir") + "/Reports/report.html";
		extent = new ExtentReports(Path, false);
		//extent.addSystemInfo("Selenium Version", "2.52").addSystemInfo("Platform", "Mac");
		return extent;
}
	@BeforeSuite
	public void setup() throws IOException, InterruptedException {
		
		if(driver==null) {
			if(loadPropertyFile.startsWith("Android")) {
				CommonUtils.loadAndroidConfigProp(loadPropertyFile);
				CommonUtils.setAndroidCapability();
				getAndroidDriver();
			}else if(loadPropertyFile.startsWith("IOS")){
				CommonUtils.loadAndroidConfigProp(loadPropertyFile);
				CommonUtils.setIOSCapability();
				getIOSDriver();
			}
		}
	}

}
