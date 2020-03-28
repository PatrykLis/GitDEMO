package Hybrid_APP;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class baseHybrid_WebViewHYBRIDA extends baseHybrid  {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver=Capabilities();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		WebElement lista= driver.findElementByClassName("android.widget.Spinner");
	    new TouchAction(driver).tap(tapOptions().withElement(element(lista))).waitAction(waitOptions(Duration.ofMillis(250))).perform();
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"));").click();
	    driver.findElementByClassName("android.widget.EditText").sendKeys("Piotrunia");
	    driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
	    driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	    
	    driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
	    driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
	    driver.findElementsByClassName("android.widget.ImageButton").get(1).click();
	 	
	    Thread.sleep(4000);
	
	    driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	    
	    //Going to WEBVIEW
	    Thread.sleep(3000);	   
	    Set<String> contexts=driver.getContextHandles();
	    for(String contextName :contexts)
	    {
	    	System.out.println(contextName);
	    }
	    driver.context("WEBVIEW_com.androidsample.generalstore");
	    driver.findElementByName("q").sendKeys("czasem to jest pojebane");
	    driver.findElementByName("q").sendKeys(Keys.ENTER);
	    Thread.sleep(2000); //czeka 2 sekuny (2000 milisekund)
	    driver.longPressKey(new KeyEvent(AndroidKey.BACK));
	    
		}

		}