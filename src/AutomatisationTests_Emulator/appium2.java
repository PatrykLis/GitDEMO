package AutomatisationTests_Emulator;
import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType.APP_PACKAGE;

import io.appium.java_client.remote.MobilePlatform;

public class appium2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	File appDir= new File("src");
	
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Andorid device");
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
	cap.setCapability(MobileCapabilityType.APP, value);
	
	AndroidDriver driver= new AndroidDriver(new URL("htpp://127.0.0.1:4723/wd/hub"),cap);
	
	
	
	
	
	
	
	}

}
