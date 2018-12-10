package rough;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.WebWindowListener;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class rough_android {

	public static void main(String[] args) throws Exception {
		
		File appdir = new File(System.getProperty("user.dir") + "/app/reInvent_android.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 26");//Nexus 5X API 26
		cap.setCapability(MobileCapabilityType.APP, appdir);
		cap.setCapability("appPackage", "com.mobiquityinc.reinvent");
		cap.setCapability("appActivity", "com.mobiquityinc.reinvent.MainActivity");
		cap.setCapability("platfornVersion", "8.0.0");
		cap.setCapability("automationName", "UiAutomator2");
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		//WebDriverWait wait = new WebDriverWait(driver, 120);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='OK, THANKS']")));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("wait for 500 secends");
		//driver.findElementByXPath("//android.widget.Button[@text='OK, THANKS']").click();
		//android.widget.TextView[@text='Preference
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.widget.Button").click();
		Thread.sleep(35000);
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.widget.Button").click();

		TouchAction tapAt = new TouchAction(driver);
        tapAt.press(510, 1097).release().perform();
        
		//driver.findElementByXPath("//android.widget.Button[@text='OK, THANKS']").click();
        System.out.println("Clicked");
        Thread.sleep(5000);
       //MobileElement username = (MobileElement) driver.findElementsByClassName("android.widget.EditText");
       //driver.findElementsByClassName("android.widget.EditText").get(0);
       //System.out.println();
        
//        if(username.isDisplayed()) {
//        	System.out.println("Yes");
//        }
//        else {
//        	System.out.println("No");
//        }
//        List<MobileElement> elements = (List<MobileElement>) driver.findElementByClassName("android.widget.EditText");
//        for (MobileElement e1 : elements) {
//        	System.out.println(e1.getText());
//        }
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText").sendKeys("kradkar");
        //driver.findElement(By.xpath("//android.view.View[@text='Forgot Password']")).click();
        System.out.println("Username Entered");
        Thread.sleep(5000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText").sendKeys("MobTest@123!");
        Thread.sleep(5000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.Button").click();
        Thread.sleep(10000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View").click();
	}

}
