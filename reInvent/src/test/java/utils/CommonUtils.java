package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {
	
	public static String DEVICE_NAME;
	public static String APP_PACKAGE;
	public static String APP_ACTIVITY;
	public static String AUTOMATION_NAME;
	public static String PLATFOR_VERSION;
	public static Properties prop = new Properties();
	public static DesiredCapabilities capability = new DesiredCapabilities();
	public static File apkfile;
	
	
	public static void loadAndroidConfigProp(String propertyFileName) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/properties/"+propertyFileName);
		prop.load(fis);
		DEVICE_NAME = prop.getProperty("device.name");
		APP_PACKAGE = prop.getProperty("appPackage");
		APP_ACTIVITY = prop.getProperty("appActivity");
		AUTOMATION_NAME = prop.getProperty("automationName");
		PLATFOR_VERSION = prop.getProperty("platfornVersion");	
	}

	public static void loadIOSConfigProp(String propertyFileName) {

	}

	public static void setAndroidCapability() {
		
		apkfile = new File(System.getProperty("user.dir") + "/app/reInvent_android.apk");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, CommonUtils.DEVICE_NAME);
		capability.setCapability(MobileCapabilityType.APP, apkfile);
		capability.setCapability("appPackage", CommonUtils.APP_PACKAGE);
		capability.setCapability("appActivity", CommonUtils.APP_ACTIVITY);
		capability.setCapability("platfornVersion", CommonUtils.PLATFOR_VERSION);
		capability.setCapability("automationName", CommonUtils.AUTOMATION_NAME);

	}

	public static void setIOSCapability() {

	}

}
