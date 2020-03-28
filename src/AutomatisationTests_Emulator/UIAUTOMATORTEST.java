package AutomatisationTests_Emulator;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAUTOMATORTEST extends base {

	public static void main(String[] args) throws MalformedURLException  {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//driver.findElementByAndroidUIAutomator ("attribute("value")"); tekst w nawiasie to SYNTAX
		driver.findElementByAndroidUIAutomator ("text(\"Views\")").click();
//driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
// validate clickable feature for all options
//driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)") - trzeba uzyc tego nowa UI Selectora aby uzyc jakichs opcji
	System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	
	
	
	}

}
