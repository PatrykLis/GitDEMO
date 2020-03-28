package AutomatisationTests_Emulator;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;


import static io.appium.java_client.touch.offset.ElementOption.element;

public class gestures extends base{

	public static void main(String[] args) throws MalformedURLException  {
	
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement views= driver.findElementByXPath("//android.widget.TextView[@text='Views']");
	    new TouchAction(driver).tap(tapOptions().withElement(element(views)))
	    .waitAction(waitOptions(Duration.ofMillis(250))).perform();
		//Tap=click
		WebElement buziak= driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
	    new TouchAction(driver).tap(tapOptions().withElement(element(buziak)))
	    .waitAction(waitOptions(Duration.ofMillis(250))).perform();
	    	WebElement custom= driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
	    new TouchAction(driver).tap(tapOptions().withElement(element(custom)))
	    .waitAction(waitOptions(Duration.ofMillis(250))).perform();
	    	WebElement longing= driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
	   	new TouchAction(driver).longPress(longPressOptions().withElement(element(longing))).release().perform();
	   	//thread.sleep(2000)
	   	System.out.println(driver.findElementById("android:id/title").isDisplayed());
	   	

	}



	}

