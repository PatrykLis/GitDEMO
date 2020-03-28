package AutomatisationTests_Emulator;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
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

public class swipe extends base{

	public static void main(String[] args) throws MalformedURLException  {
		
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement buziak= driver.findElementByXPath("//android.widget.TextView[@text='Views']");
	    new TouchAction(driver).tap(tapOptions().withElement(element(buziak))).waitAction(waitOptions(Duration.ofMillis(250))).perform();
	    WebElement muziak= driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']");
	    new TouchAction(driver).tap(tapOptions().withElement(element(muziak))).waitAction(waitOptions(Duration.ofMillis(250))).perform();
	    WebElement kuziak= driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']");
	    new TouchAction(driver).tap(tapOptions().withElement(element(kuziak))).waitAction(waitOptions(Duration.ofMillis(250))).perform();
//driver.findElementByXPath("//*[@content-desc='9']").click(); * znaczy, ¿e szuka we wszystkich elementach i wybierze ten gdzie bêdzie [@attribute='value']
	    driver.findElementByXPath("//*[@content-desc='9']").click();
	    	    //swiping
	    //long press on element //2 sec // move to another element and your release 
	    WebElement dates= driver.findElementByXPath(("//*[@content-desc='15']"));
	    WebElement hour= driver.findElementByXPath(("//*[@content-desc='45']"));
	   	new TouchAction(driver).longPress(longPressOptions().withElement(element(dates))).waitAction(waitOptions(Duration.ofMillis(2000)))
	   	.moveTo(element(hour)).release().perform();
	    
	}
	
}
