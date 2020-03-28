package AutomatisationTests_Emulator;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrolling extends base{

	public static void main(String[] args) throws MalformedURLException  {
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement buziak= driver.findElementByXPath("//android.widget.TextView[@text='Views']");
	    new TouchAction(driver).tap(tapOptions().withElement(element(buziak))).waitAction(waitOptions(Duration.ofMillis(250))).perform();
	//w appium nie ma opcji scrolla, trzeba sie posi³kowac uiatomator
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));");
	
	
	
	
	
	
	}

}
