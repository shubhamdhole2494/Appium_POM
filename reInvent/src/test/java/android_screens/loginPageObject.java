package android_screens;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPageObject {

	ExtentTest test;
	AndroidDriver<MobileElement> driver;

	public loginPageObject(AppiumDriver<MobileElement> driver,ExtentTest test) {
		this.test = test;
		this.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement username;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement password;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.Button")
	public WebElement signInButton;
	public void enterUsername(String usr) {

		username.sendKeys(usr);
		test.log(LogStatus.INFO, "Enter Username");
	}

	public void enterPassword(String pass) {

		password.sendKeys(pass);
		test.log(LogStatus.INFO, "Enter Password");
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
		test.log(LogStatus.INFO, "Clicked on SIGN IN Button");
	}
	
	public boolean isSkipButtonPresent() {
		AndroidElement skipButton = null;
		try {
			skipButton = (AndroidElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View");
			if (skipButton != null) {
				return true;
			}
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
	
	

}
